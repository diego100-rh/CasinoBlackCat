package modelo;

import java.util.Random;
import java.util.Scanner;

public class Ruleta {

    private static final int MAX_HISTORIAL = 100;
    private static int[] historialNumeros = new int[MAX_HISTORIAL];
    private static int[] historialApuestas = new int[MAX_HISTORIAL];
    private static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private static int historialSize = 0;
    private static final int CANTIDAD_NUMEROS = 37;
    private static Random rng = new Random();
    private static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public int girarRuleta() {
        // Genera y retorna un número aleatorio entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }

    public boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
        switch (tipo) {
            case 'R':
                return esRojo(numero);
            case 'N':
                return !esRojo(numero); // recordar que "!" significa "NO". Gana si NO es rojo.
            case 'P':
                return (numero % 2 == 0); // Gana si es par
            case 'I':
                return (numero % 2 != 0); // Gana si es impar
            default:
                return false; // letra rara false
        }
    }

    public boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) ;
            {
                return true;
            }
        }
        return false;
    }

    public void registrarResultado(int numero, int apuesta, boolean acierto) {
        // TODO: Guardar los datos sin superar MAX_HISTORIAL.
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            System.out.println(historialSize++);
        } else {
            System.out.println("El historial está lleno, no ya no se registraran resultados...");
        }
    }
}

