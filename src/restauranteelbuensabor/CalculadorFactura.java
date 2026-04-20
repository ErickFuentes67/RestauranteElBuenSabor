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

    private static final double TASA_IVA          = 0.19;
    private static final double TASA_PROPINA       = 0.10;
    private static final double TASA_DESCUENTO     = 0.05;
    private static final double UMBRAL_PROPINA     = 50000;
    private static final int    MIN_ITEMS_DESCUENTO = 3;

    public static ResultadoFactura calcularTotalFactura() {
        double subtotal      = Datos.pedidoActual.calcularSubtotal();
        int    items         = Datos.pedidoActual.contarItemsDiferentes();
        double conDescuento  = aplicarDescuento(subtotal, items);
        double iva           = calcularIVA(conDescuento);
        double propina       = calcularPropina(conDescuento);

        Datos.total      = conDescuento + iva + propina;
        Datos.estadoMesa = 1;

        return new ResultadoFactura(conDescuento, iva, propina);
    }

    private static double aplicarDescuento(double subtotal, int cantidadItems) {
        if (cantidadItems > MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * TASA_DESCUENTO);
        }
        return subtotal;
    }

    private static double calcularIVA(double base) {
        return base * TASA_IVA;
    }

    private static double calcularPropina(double base) {
        if (base > UMBRAL_PROPINA) {
            return base * TASA_PROPINA;
        }
        return 0;
    }
}
