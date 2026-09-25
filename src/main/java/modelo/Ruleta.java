package modelo;

import java.util.Random;

public class Ruleta {

    private final int MAX_HISTORIAL = 100;
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;
    private final int CANTIDAD_NUMEROS = 37;
    private Random rng = new Random();
    private int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public int girarRuleta() {
        // Genera y retorna un número aleatorio entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }


    public int getHistorialSize() {
        return historialSize;
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

    public boolean registrarResultado(int numero, int apuesta, boolean acierto) {
        // TODO: Guardar los datos sin superar MAX_HISTORIAL.
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
            return true;
        }
         return false;
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

