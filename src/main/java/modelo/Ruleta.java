package modelo;

import GestorDeArchivos.GestorArchivos;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Ruleta {

    private Random rng;

    private List<Resultado> historialGeneral;
    private GestorArchivos archivos;

    public Ruleta() {
        this.rng = new Random();
        this.archivos = new GestorArchivos();
        this.historialGeneral = new ArrayList<>(); // Nace vacía
    }

    public int girarRuleta() {
        return rng.nextInt(37);
    }
    public boolean registrarResultado(int numero, int monto, boolean acierto, String etiquetaApuesta) {

        // 1. "cada giro de la ruleta deberá generar un objeto Resultado..."
        Resultado nuevoResultado = new Resultado(numero, monto, acierto, etiquetaApuesta);
        this.historialGeneral.add(nuevoResultado);


        archivos.guardarJugada(nuevoResultado);

        return true;
    }
    public int calcularDineroGastado() {
        int dinero = 0;
        // Leemos: "Por cada objeto Resultado"
        for (Resultado r : this.historialGeneral) {
            // Le pedimos la apuesta al objeto directamente
            dinero += r.getApuesta();
        }
        return dinero;
    }
    public int calcularVictoria() {
        int victorias = 0;
        for (Resultado r : this.historialGeneral) {
            if (r.isVictoria()) {
                victorias++;
            }
        }
        return victorias;
    }
    public String obtenerColor(int numero) {
        if (numero == 0) {
            return "Verde";
        }
        if (numero % 2 == 0) {
            return "Negro";
        } else {
            return "Rojo";
        }
    }


}

