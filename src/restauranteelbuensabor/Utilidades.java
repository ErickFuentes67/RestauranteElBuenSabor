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

    public static double calcular(double pr,double cn,double dc,double iv,double pp,int ni,boolean ap){

        double res=0;double tmp=0;double aux2=0;

        // calcula el resultado
        res=pr*cn;

        if(dc>0){res=res-(res*dc);}
        tmp=res*iv;res=res+tmp;
        if(ap){res=res+(res*pp);}

        // imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        aux2=res;
        return aux2;

    }

    public static boolean validar(){

        int cont=0;int indice=0;
        while(indice<Datos.cantidades.length){
            if(Datos.cantidades[indice]>0){cont=cont+1;}
            indice++;
        }// fin while

        // reinicia si no hay nada - efecto secundario no documentado
        if(cont==0){
            Datos.total=0;Datos.tmp="";
        }

        return cont>0;

    }

    public static void reiniciar(){

        int indice=0;while(indice<Datos.cantidades.length){
            Datos.cantidades[indice]=0;indice++;
        }

        Datos.total=0;Datos.estadoMesa=0;Datos.numeroMesaActual=0;Datos.tmp="";
    }
}
