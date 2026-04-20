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

    private static final String NOMBRE_RESTAURANTE = "     El Buen Sabor    ";
    private static final String DIRECCION          = "Calle 15 #8-32, Valledupar";
    private static final String NIT                = "900.123.456-7";
    public  static final String SEPARADOR          = "========================================";

    public static void imprimirEncabezado() {
        System.out.println(SEPARADOR);
        System.out.println(NOMBRE_RESTAURANTE);
        System.out.println(DIRECCION);
        System.out.println("NIT: " + NIT);
        System.out.println(SEPARADOR);
    }

    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR);

        int numero = 1;
        for (Producto producto : Carta.getProductos()) {
            System.out.printf("%d. %-22s $%,.0f%n",
                    numero++,
                    producto.getNombre(),
                    producto.getPrecio());
        }
        System.out.println(SEPARADOR);
    }

    public static void mostrarPedido() {
        System.out.println("--- PEDIDO ACTUAL ---");

        for (ItemPedido item : Datos.pedidoActual.getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }

        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", Datos.pedidoActual.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta() {
        Factura factura = new Factura(Datos.pedidoActual, Datos.numeroFactura);

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");
        imprimirItems();
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:",      factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):",     factura.calcularIVA());

        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR);
        System.out.println("Gracias por su visita!");
        System.out.println(NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println(SEPARADOR);

        Datos.numeroFactura++;
        Mesa.reiniciar();
    }

    public static void imprimirFacturaResumen() {
        Factura factura = new Factura(Datos.pedidoActual, Datos.numeroFactura);

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:",      factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):",     factura.calcularIVA());

        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR);
    }

    private static void imprimirItems() {
        for (ItemPedido item : Datos.pedidoActual.getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }
    }
}
