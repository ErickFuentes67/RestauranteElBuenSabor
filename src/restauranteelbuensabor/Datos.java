/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteelbuensabor;

/**
 *
 * @author alfre
 *
 * Clase datos, almacena todos los datos del sistema
 */

public class Datos {

    public static String[] nombres = {
            "Bandeja Paisa",
            "Sancocho de Gallina",
            "Arepa con Huevo",
            "Jugo Natural",
            "Gaseosa",
            "Cerveza Poker",
            "Agua Panela",
            "Arroz con Pollo"
    };

    public static double[] precios = {
            32000, 28000, 8000, 7000,
            4500,  6000,  3500, 25000
    };

    public static int[] cantidades = {0, 0, 0, 0, 0, 0, 0, 0};

    // --- Estado de la mesa ---
    public static int numeroMesaActual = 0;
    public static int estadoMesa = 0;

    // --- Datos de facturación ---
    public static double total = 0;
    public static int numeroFactura = 1;
}
