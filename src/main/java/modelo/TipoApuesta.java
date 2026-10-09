package modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public enum TipoApuesta {

    ROJO, NEGRO, PAR, IMPAR;

    private static final List<Integer> NUMEROS_ROJOS = Arrays.asList(
            1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36
    );

    private static boolean esRojo(int numero){
        return NUMEROS_ROJOS.contains(numero);
    }

    public boolean evaluarResultado(int numero) {
        if (numero == 0) return false;
        return switch (this) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }

}