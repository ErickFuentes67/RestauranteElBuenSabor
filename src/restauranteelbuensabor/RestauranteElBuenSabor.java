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
                break;

            } else if (opcionMenu == 0) {
                ejecutando = false;
                System.out.println("Hasta luego!");
            } else {
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

}
