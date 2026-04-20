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

    public static boolean hayProductosEnPedido(){

        for (int i = 0; i < Datos.cantidades.length; i++) {
            if (Datos.cantidades[i] > 0) {
                return true;
            }
        }
        return false;

    }

    public static void reiniciar() {
        for (int i = 0; i < Datos.cantidades.length; i++) {
            Datos.cantidades[i] = 0;
        }
        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesaActual = 0;

    }
}
