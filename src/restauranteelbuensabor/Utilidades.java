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
        return Datos.pedidoActual.tieneProductos(); // Pedido ya sabe si tiene items
    }

    public static void reiniciar() {
        Datos.pedidoActual.limpiar();               // Pedido sabe limpiarse solo
        Datos.estadoMesa       = 0;
        Datos.numeroMesaActual = 0;
    }
}
