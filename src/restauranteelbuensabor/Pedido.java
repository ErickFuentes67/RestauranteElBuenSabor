package restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
        for (ItemPedido item : items) {
            if (item.getProducto() == producto) {
                item.agregarCantidad(cantidad);  // si ya existe, suma la cantidad
                return;
            }
        }
        items.add(new ItemPedido(producto, cantidad)); // si no existe, lo agrega
    }



}
