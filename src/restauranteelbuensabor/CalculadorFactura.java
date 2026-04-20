/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteelbuensabor;
/**
 *GI
 * @author alfre
 *
 * Clase CalculadorFactura, contiene la logica del calculo total de facura
 *
 */

public class CalculadorFactura {

    private static final double Tasa_IVA = 0.19;
    private static final double Tasa_Propina   = 0.10;
    private static final double Tasa_Descuento = 0.05;
    private static final double Umbral_Propina = 50000;
    private static final int    Min_Items_Descuento = 3;




    public static double CalcularTotalFactura(){

        double subtotal=0;double iva=0;double total=0;double aux=0;int cont=0;int indice=0;

        while(indice<Datos.nombres.length){

            if(Datos.cantidades[indice]>0){

                // multiplica precio por cantidad
                subtotal=subtotal+Datos.precios[indice]*Datos.cantidades[indice];
                cont=cont+1;
            }
            indice++;
        }// fin while

        if(cont>Min_Items_Descuento){
            if(subtotal>0){
                aux=subtotal-(subtotal*Tasa_Descuento);

                if(aux>Umbral_Propina){
                    iva=aux*Tasa_IVA;
                    // suma iva al subtotal con descuento
                    total=aux+iva;
                    total=total+(total*Tasa_Propina );
                }
                else{
                    // suma iva al subtotal
                    iva=aux*Tasa_IVA;
                    total=aux+iva;
                }
            }// fin if sub>0


        }
        else{
            if(subtotal>Umbral_Propina){
                iva=subtotal*Tasa_IVA;

                // suma iva al subtotal
                total=subtotal+iva;
                total=total+(total*Tasa_Propina );
            }

            else{
                iva=subtotal*Tasa_IVA;
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

        if(f>Min_Items_Descuento){
            res=res-(res*0.01);}
            return res;
    }
}
