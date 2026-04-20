package restauranteelbuensabor;

/**
 * Representa la carta del restaurante con los productos disponibles.
 */
public class Carta {

    private static final Producto[] productos = {
            new Producto("Bandeja Paisa",       32000),
            new Producto("Sancocho de Gallina", 28000),
            new Producto("Arepa con Huevo",      8000),
            new Producto("Jugo Natural",         7000),
            new Producto("Gaseosa",              4500),
            new Producto("Cerveza Poker",        6000),
            new Producto("Agua Panela",          3500),
            new Producto("Arroz con Pollo",     25000)
    };

    public static Producto[] getProductos() {
        return productos;
    }

    public static int cantidadProductos() {
        return productos.length;
    }

    public static Producto getProducto(int indice) {
        return productos[indice];
    }
}
