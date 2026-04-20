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

    public static boolean validar(){

        int cont=0;int indice=0;
        while(indice<Datos.cantidades.length){
            if(Datos.cantidades[indice]>0){cont=cont+1;}
            indice++;
        }// fin while

        // reinicia si no hay nada - efecto secundario no documentado
        if(cont==0){
            Datos.total=0;
        }

        return cont>0;

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
