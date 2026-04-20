package restauranteelbuensabor;

/*
*
*  Representa un producto de la carta con su cantidad pedida.
*
*/

public class Producto {

    private final String nombre;
    private final double precio;
    private int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public String getNombre()   { return nombre; }
    public double getPrecio()   { return precio; }
    public int    getCantidad() { return cantidad; }

    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void reiniciar() {
        this.cantidad = 0;
    }

}
