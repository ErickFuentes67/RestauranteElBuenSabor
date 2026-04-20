/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package restauranteelbuensabor;

/**
 *
 * @author alfre
 *
 * Clase utilidades, contiene metodos para calcular, validar y reiniciar pedidos
 */

public class Utilidades {

    public static boolean hayProductosEnPedido() {
        for (Producto producto : Datos.carta) {
            if (producto.getCantidad() > 0) return true;
        }
        return false;
    }

    public static void reiniciar() {
        for (Producto producto : Datos.carta) {
            producto.reiniciar(); // el objeto sabe reiniciarse solo
        }
        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesaActual = 0;
    }
}
