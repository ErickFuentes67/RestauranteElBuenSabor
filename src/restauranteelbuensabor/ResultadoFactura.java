package restauranteelbuensabor;

public class ResultadoFactura {
    public final double subtotal;
    public final double iva;
    public final double propina;
    public final double total;

    public ResultadoFactura(double subtotal, double iva, double propina) {
        this.subtotal = subtotal;
        this.iva = iva;
        this.propina = propina;
        this.total = subtotal + iva + propina;
    }
}
