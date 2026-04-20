/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteelbuensabor;

/**
 *
 * @author alfre
 *
 * Clase imprimir, contiene todos los metodo de impresion de consola
 *
 */

public class ImpresionFactura {

    private static void imprimirEncabezado() {
        System.out.println(Separador);
        System.out.println(Nombre_Restaurante);
        System.out.println(Direccion);
        System.out.println("NIT: " + Nit);
        System.out.println(Separador);
    }

    private static void imprimirItems() {
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        Datos.precios[i] * Datos.cantidades[i]);
            }
        }
    }


    private static final String Nombre_Restaurante  = "     El Buen Sabor    ";
    private static final String Direccion           = "Calle 15 #8-32, Valledupar";
    private static final String Nit                 = "900.123.456-7";
    public static final String Separador           = "========================================";


    public static void mostrarCarta(){

        System.out.println(Separador);
        System.out.println(Nombre_Restaurante);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(Separador);
        int indice=0;

        for (int i = 0; i < Datos.nombres.length; i++) {
            System.out.printf("%d. %-22s $%,.0f%n",
                    (i + 1),
                    Datos.nombres[i],
                    Datos.precios[i]);
        }

        System.out.println(Separador);

    }

    public static void mostrarPedido(){

        double subtotal=0;

        System.out.println("--- PEDIDO ACTUAL ---");

        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                double subtotalItem = Datos.precios[i] * Datos.cantidades[i];

                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        subtotalItem);

                subtotal += subtotalItem;
            }
        }

        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);

    }


    public static void imprimirFacturaCompleta() {
        ResultadoFactura resultado = CalculadorFactura.calcularTotalFactura();

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        imprimirItems();
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", resultado.subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", resultado.iva);

        if (resultado.propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", resultado.propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", resultado.total);
        System.out.println(Separador);
        System.out.println("Gracias por su visita!");
        System.out.println(Nombre_Restaurante + " - Valledupar");
        System.out.println(Separador);

        Datos.numeroFactura++;
        Datos.estadoMesa = 0;
    }

    public static void imprimirFacturaResumen() {
        ResultadoFactura resultado = CalculadorFactura.calcularTotalFactura();

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", resultado.subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", resultado.iva);

        if (resultado.propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", resultado.propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", resultado.total);
        System.out.println(Separador);
    }
}
