package modelo;

public class validarHistorial{
    private final int MAX_HISTORIAL = 100;

    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;

    public boolean registraResultado(int numero, int apuesta, boolean acierto) {

        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
            return true;
        }
        return false;
    }

}
