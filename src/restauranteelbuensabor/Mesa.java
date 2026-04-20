package restauranteelbuensabor;

/**
 * Representa el estado de la mesa actual del restaurante.
 */

public class Mesa {

    private static int  numeroMesaActual = 0;
    private static boolean activa        = false;

    public static int  getNumero()   { return numeroMesaActual; }
    public static boolean estaActiva() { return activa; }

    // Mesa inválida (0 o negativa) se asigna como mesa 1 para no bloquear el flujo
    public static void activar(int numero) {
        numeroMesaActual = numero > 0 ? numero : 1;
        activa = true;
    }

    public static void reiniciar() {
        numeroMesaActual = 0;
        activa = false;
    }
}
