package modelo;

import java.util.Random;

public class Ruleta {

    private Resultado resultado;

    private final int MAX_HISTORIAL = 100;
    private Resultado[] historial = new Resultado[MAX_HISTORIAL];
    private int historialSize = 0;
    private Random rng = new Random();


    public Ruleta (Resultado resultado){
        this.resultado = resultado; //nv
    }

    public int girarRuleta() {
        //nota: nextInt(37) genera números desde el 0 hasta el 36 inclusive
        return rng.nextInt(37);
    }
    public int getHistorialSize() {
        return historialSize;
    }

    public boolean registrarResultado(int numero, int apuesta, boolean acierto) {
        // Verificamos que aún haya espacio en el arreglo
        if (historialSize < MAX_HISTORIAL) {
            // 1. Creamos el objeto "boleta" con los datos que llegaron
            Resultado nuevoResultado = new Resultado(numero, apuesta, acierto);

            // 2. Guardamos ese objeto en nuestro nuevo arreglo
            historial[historialSize] = nuevoResultado;

            // 3. Aumentamos el contador
            historialSize++;
            return true;
        }
        return false; // historial lleno

    }
    public int calcularDineroGastado() {
        int dinero = 0;
        for (int i = 0; i < historialSize; i++) {
            // Le pedimos la apuesta al objeto Resultado usando su Getter
            dinero = dinero + historial[i].getApuesta();
        }
        return dinero;
    }
    public int calcularVictoria() {
        int victorias = 0;
        for (int i = 0; i < historialSize; i++) {

            if (historial[i].isVictoria()) {
                victorias++;
            }
        }
        return victorias;
    }

}

