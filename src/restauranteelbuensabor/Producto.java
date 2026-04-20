package restauranteelbuensabor;

/**
 * Representa un producto de la carta con su cantidad pedida.
 */
public class Producto {

    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    public String getNombre()   { return nombre; }
    public double getPrecio()   { return precio; }

}
