package modelo;

import java.util.Random;

public class MecanismoRuleta {
    public static Random rng = new Random();
    public static final int CANTIDAD_NUMEROS = 37;
    public static int girarRuleta() {
        // Genera y retorna un número aleatorio entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }
}
