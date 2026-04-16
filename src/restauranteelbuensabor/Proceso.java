/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {
public static double hacerTodo(){
double sub=0;double iva=0;double tot=0;double aux=0;int cont=0;int i=0;
while(i<Datos.nom.length){
if(Datos.cant[i]>0){
// multiplica precio por cantidad
sub=sub+Datos.p[i]*Datos.cant[i];
cont=cont+1;}
i++;}// fin while
if(cont>3){
if(sub>0){
aux=sub-(sub*0.05);
if(aux>50000){
iva=aux*0.19;
// suma iva al subtotal con descuento
tot=aux+iva;
tot=tot+(tot*0.10);}
else{
// suma iva al subtotal
iva=aux*0.19;
tot=aux+iva;}}// fin if sub>0
// version anterior - no borrar
// sub = sub * 1.19;
// if(sub > 40000) sub = sub + (sub*0.10);
// return sub;
}else{
if(sub>50000){
iva=sub*0.19;
// suma iva al subtotal
tot=sub+iva;
tot=tot+(tot*0.10);}
else{
iva=sub*0.19;
tot=sub+iva;}}// fin if-else cont
Datos.est=1;Datos.tot=tot;
return tot;}
public static double procesar(double a,double b,double c,double d,double e,int f,boolean g){
double res=0;double iva=0;double prop=0;double tmp=0;
// calcula subtotal con cantidad
res=a*b;
if(c>0){
// aplica descuento
res=res-(res*c);}
// calcula iva
iva=res*d;tmp=iva;
res=res+tmp;
if(g){
// aplica propina si corresponde
prop=res*e;
res=res+prop;}
if(f>3){
res=res-(res*0.01);}
return res;}
}
