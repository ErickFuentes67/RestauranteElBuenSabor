/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteelbuensabor;
/**
 *GI
 * @author alfre
 *
 * Clase CalculadorFactura, contiene la logica del calculo total de facura
 *
 */

public class CalculadorFactura {

    private static final double Tasa_IVA = 0.19;
    private static final double Tasa_Propina   = 0.10;
    private static final double Tasa_Descuento = 0.05;
    private static final double Umbral_Propina = 50000;
    private static final int    Min_Items_Descuento = 3;



    public static double CalcularTotalFactura(){

        double subtotal = calcularSubtotal();
        int cantidadItems = contarItems();

        double subtotalConDescuento = aplicarDescuento(subtotal, cantidadItems);
        double iva = calcularIVA(subtotalConDescuento);
        double propina = calcularPropina(subtotalConDescuento);

        double total = subtotalConDescuento + iva + propina;

        // ⚠️ esto idealmente debería salir de aquí (Nivel 4)
        Datos.estadoMesa = 1;
        Datos.total = total;

        return total;

    }

    private static double calcularSubtotal() {
        double subtotal = 0;

        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                subtotal += Datos.precios[i] * Datos.cantidades[i];
            }
        }

        return subtotal;
    }

    private static int contarItems() {
        int contador = 0;

        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                contador++;
            }
        }

        return contador;
    }

    private static double aplicarDescuento(double subtotal, int cantidadItems) {
        if (cantidadItems > Min_Items_Descuento) {
            return subtotal - (subtotal * Tasa_Descuento);
        }
        return subtotal;
    }

    private static double calcularIVA(double base) {
        return base * Tasa_IVA;
    }

    private static double calcularPropina(double base) {
        if (base > Umbral_Propina) {
            return base * Tasa_Propina;
        }
        return 0;
    }

}
