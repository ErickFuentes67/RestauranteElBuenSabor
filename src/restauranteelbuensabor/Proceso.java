/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 *
 * Clase proceso, contiene la logica del calculo total de facura
 *
 */

public class Proceso {

    public static double hacerTodo(){

        double subtotal=0;double iva=0;double total=0;double aux=0;int cont=0;int indice=0;

        while(indice<Datos.nombres.length){

            if(Datos.cant[indice]>0){

                // multiplica precio por cantidad
                subtotal=subtotal+Datos.p[indice]*Datos.cant[indice];
                cont=cont+1;
            }
            indice++;
        }// fin while

        if(cont>3){
            if(subtotal>0){
                aux=subtotal-(subtotal*0.05);

                if(aux>50000){
                    iva=aux*0.19;
                    // suma iva al subtotal con descuento
                    total=aux+iva;
                    total=total+(total*0.10);
                }
                else{
                    // suma iva al subtotal
                    iva=aux*0.19;
                    total=aux+iva;
                }
            }// fin if sub>0


        }
        else{
            if(subtotal>50000){
                iva=subtotal*0.19;

                // suma iva al subtotal
                total=subtotal+iva;
                total=total+(total*0.10);
            }

            else{
                iva=subtotal*0.19;
                total=subtotal+iva;
            }
        }// fin if-else cont

        Datos.estadoMesa=1;Datos.total=total;
        return total;

    }

    public static double procesar(double a,double b,double c,double d,double e,int f,boolean g){

        double res=0;double iva=0;double prop=0;double tmp=0;

        // calcula subtotal con cantidad
        res=a*b;

        if(c>0){
        // aplica descuento
            res=res-(res*c);
        }

        // calcula iva
        iva=res*d;tmp=iva;
        res=res+tmp;

        if(g){
            // aplica propina si corresponde
            prop=res*e;
            res=res+prop;
        }

        if(f>3){
            res=res-(res*0.01);}
            return res;
    }
}
