package modelo;

public class RegistroResultado {

    // 1. Atributos privados (El estado de la clase)
    private final int MAX_HISTORIAL = 100; // Ajusta este número según tu requerimiento
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;

    // 2. Método lógico (Sin 'static' y sin 'System.out.println')
    public boolean registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
            return true; // Indica que se guardó exitosamente
        } else {
            return false; // Indica que el historial está lleno
        }
    }
}

