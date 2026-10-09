package modelo;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Ruleta {

    private Random rng;

    private List<Resultado> historialGeneral;

    public Ruleta() {
        this.rng = new Random();
        this.historialGeneral = new ArrayList<>(); // Nace vacía
    }

    public int girarRuleta() {
        return rng.nextInt(37);
    }
    public boolean registrarResultado(int numero, int monto, boolean acierto, TipoApuesta tipoApuesta) {

        // 1. "cada giro de la ruleta deberá generar un objeto Resultado..."
        Resultado nuevoResultado = new Resultado(numero, monto, acierto, tipoApuesta);
        this.historialGeneral.add(nuevoResultado);

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


}

