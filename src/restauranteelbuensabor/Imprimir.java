/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Imprimir {
public static void mostrarCarta(){
System.out.println("========================================");
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    --- NUESTRA CARTA ---");
System.out.println("========================================");
int i=0;
while(i<Datos.nom.length){
System.out.printf("%d. %-22s $%,.0f%n",(i+1),Datos.nom[i],Datos.p[i]);
i++;}// fin while
System.out.println("========================================");}
public static void mostrarPedido(){
double sub=0;int i=0;
System.out.println("--- PEDIDO ACTUAL ---");
while(i<Datos.nom.length){
if(Datos.cant[i]>0){
// imprime producto con cantidad y subtotal parcial
System.out.printf("%-20s x%-6d $%,.0f%n",Datos.nom[i],Datos.cant[i],(Datos.p[i]*Datos.cant[i]));
// suma al subtotal
sub=sub+Datos.p[i]*Datos.cant[i];}
i++;}// fin while
System.out.println("--------------------");
System.out.printf("%-27s $%,.0f%n","Subtotal:",sub);}
public static void imprimirFacturaCompleta(){
double sub=0;double iva=0;double tot=0;double prop=0;int cont=0;double aux=0;
// calcula subtotal otra vez
int i=0;while(i<Datos.nom.length){
if(Datos.cant[i]>0){
sub=sub+Datos.p[i]*Datos.cant[i];cont=cont+1;}
i++;}// fin while
if(cont>3){aux=sub-(sub*0.05);}else{aux=sub;}
if(aux>50000){
iva=aux*0.19;
tot=aux+iva;
prop=tot*0.10;
tot=tot+prop;}
else{
iva=aux*0.19;
tot=aux+iva;
prop=0;}// fin if-else
String sep="========================================";
System.out.println(sep);
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    Calle 15 #8-32, Valledupar");
System.out.println("    NIT: 900.123.456-7");
System.out.println(sep);
System.out.printf("FACTURA No. %03d%n",Datos.nf);
System.out.println("----------------------------------------");
// imprime cada item del pedido
int j=0;while(j<Datos.nom.length){
if(Datos.cant[j]>0){
System.out.printf("%-20s x%-6d $%,.0f%n",Datos.nom[j],Datos.cant[j],(Datos.p[j]*Datos.cant[j]));}
j++;}// fin while
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","Subtotal:",aux);
System.out.printf("%-27s $%,.0f%n","IVA (19%):",iva);
if(prop>0){
System.out.printf("%-27s $%,.0f%n","Propina (10%):",prop);}// fin if prop
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","TOTAL:",tot);
System.out.println(sep);
System.out.println("Gracias por su visita!");
System.out.println("El Buen Sabor - Valledupar");
System.out.println(sep);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
Datos.nf=Datos.nf+1;
Datos.est=0;
Datos.tot=tot;}
public static void imprimirFacturaResumen(){
double sub=0;double iva=0;double tot=0;double prop=0;int cont=0;double aux=0;
// calcula subtotal otra vez igual que en imprimirFacturaCompleta
int i=0;while(i<Datos.nom.length){
if(Datos.cant[i]>0){
sub=sub+Datos.p[i]*Datos.cant[i];cont=cont+1;}
i++;}// fin while
if(cont>3){aux=sub-(sub*0.05);}else{aux=sub;}
if(aux>50000){
iva=aux*0.19;
tot=aux+iva;
prop=tot*0.10;
tot=tot+prop;}
else{
iva=aux*0.19;
tot=aux+iva;
prop=0;}// fin if-else
String sep="========================================";
System.out.println(sep);
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    Calle 15 #8-32, Valledupar");
System.out.println("    NIT: 900.123.456-7");
System.out.println(sep);
System.out.printf("FACTURA No. %03d (RESUMEN)%n",Datos.nf);
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","Subtotal:",aux);
System.out.printf("%-27s $%,.0f%n","IVA (19%):",iva);
if(prop>0){
System.out.printf("%-27s $%,.0f%n","Propina (10%):",prop);}// fin if prop
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","TOTAL:",tot);
System.out.println(sep);}    
}
