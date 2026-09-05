package modelo;

public class revicionDecondiciones {

    // 1. Atributos privados (El estado de la clase)
    private final int MAX_HISTORIAL = 100; // Ajusta este número según tu requerimiento
    private int[] historialApuestas = new int[MAX_HISTORIAL];
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

}

