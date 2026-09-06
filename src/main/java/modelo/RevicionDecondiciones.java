package modelo;

public class RevicionDecondiciones {

    // 1. Atributos privados (El estado de la clase)
    private final int MAX_HISTORIAL = 100; // Ajusta este número según tu requerimiento
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;

    public int getHistorialSize() {
        return historialSize;
    }

    public int calcularDineroGastado() {
        int dinero = 0;
        for (int i = 0; i < historialSize; i++) {
            dinero = dinero + historialApuestas[i];
        }
        return dinero;
    }

    public int calcularVictoria() {
        int victorias = 0;
        for (int i = 0; i < historialSize; i++) {
            if (historialAciertos[i]) {
                victorias++;
            }
        }
        return victorias;
    }
    public boolean registraResultado(int numero, int apuesta, boolean acierto){
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
            return true;
        }
        return false;
            //pude ser un msj pero daremos un valor falso
        }


}

