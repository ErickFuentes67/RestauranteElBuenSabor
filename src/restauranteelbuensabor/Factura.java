package restauranteelbuensabor;

/**
 * Representa una factura generada a partir de un pedido.
 * Aplica las reglas de negocio del restaurante.
 */

public class Factura {

    private static final double TASA_IVA           = 0.19;
    private static final double TASA_PROPINA        = 0.10;
    private static final double TASA_DESCUENTO      = 0.05;
    private static final double UMBRAL_PROPINA      = 50000;
    private static final int    MIN_ITEMS_DESCUENTO = 3;

    private final Pedido pedido;
    private final int    numero;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public int getNumero() { return numero; }
    public Pedido getPedido() { return pedido; }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > MIN_ITEMS_DESCUENTO) {
            return calcularSubtotal() * TASA_DESCUENTO;
        } // El descuento aplica solo si hay más de 3 productos diferentes en el pedido
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        return calcularSubtotal() - calcularDescuento();
    }

    public double calcularIVA() {
        return calcularSubtotalConDescuento() * TASA_IVA;
    }

    public double calcularPropina() {
        if (calcularSubtotalConDescuento() > UMBRAL_PROPINA) {
            return calcularSubtotalConDescuento() * TASA_PROPINA;
        } // La propina aplica sobre el subtotal con descuento, antes del IVA
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotalConDescuento() + calcularIVA() + calcularPropina();
    }
}

