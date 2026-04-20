/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 *
 * clase main, encargada de inicializar el programa
 */

public class RestauranteElBuenSabor {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();
            int opcionMenu = scanner.nextInt();

            if (opcionMenu == 1) {
                opcionVerCarta();
            }

            else if (opcionMenu == 2){
                opcionAgregarProducto();
            }

            else if (opcionMenu == 3){
                opcionVerPedido();
            }

            else if (opcionMenu == 4){
                opcionGenerarFactura();
            }

            else if (opcionMenu == 5) {
               opcionNuevaMesa();
            }

            else if (opcionMenu == 0) {
                ejecutando = false;
                System.out.println("Hasta luego!");
            }

            else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
            }
        }

        scanner.close();

    }

    private static void mostrarMenu() {
        System.out.println(ImpresionFactura.Separador);
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println(ImpresionFactura.Separador);
        System.out.print("Seleccione una opcion: ");
    }

    private static void opcionVerCarta() {
        ImpresionFactura.mostrarCarta();
        System.out.println();
    }

    private static void opcionAgregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Datos.carta.length + "): ");
        int n = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        if (n <= 0 || n > Datos.carta.length) {
            System.out.println("Producto no existe. La carta tiene " + Datos.carta.length + " productos.");
            System.out.println();
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
            System.out.println();
            return;
        }

        activarMesaSiEsNecesario();

        Datos.carta[n - 1].agregarCantidad(cantidad);
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + Datos.carta[n - 1].getNombre() + " x" + cantidad);
        System.out.println();
    }

    private static void activarMesaSiEsNecesario() {
        if (Datos.estadoMesa == 0) {
            System.out.print("Ingrese numero de mesa: ");
            int mesa = scanner.nextInt();
            Datos.numeroMesaActual = mesa > 0 ? mesa : 1;
            Datos.estadoMesa = 1;
        }
    }

    private static void opcionVerPedido() {
        System.out.println();
        if (Utilidades.hayProductosEnPedido()) {
            ImpresionFactura.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
        System.out.println();
    }

    private static void opcionGenerarFactura() {
        System.out.println();
        if (Utilidades.hayProductosEnPedido()) {
            ImpresionFactura.imprimirFacturaCompleta();
            System.out.println();
        } else {
            System.out.println("No se puede generar factura.");
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
        }
    }

    private static void opcionNuevaMesa() {
        System.out.println();
        Utilidades.reiniciar();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
        System.out.println();
    }

}
