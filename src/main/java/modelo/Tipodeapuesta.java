package modelo;

import java.util.Scanner;

public class Tipodeapuesta {

    public static char leerTipoApuesta(Scanner in) {
        boolean esValido = false;
        char op = ' ';

        do {
            System.out.println("==============================");
            System.out.println("Seleccione apuesta");
            System.out.println("\n'R' para Rojo.\n" +
                    "\n" +
                    "'N' para Negro.\n" +
                    "\n" +
                    "'P' para Par.\n" +
                    "\n" +
                    "'I' para Impar.");
            System.out.println("==============================");
            System.out.print(" Seleccione: ");
            // leemos palabra, mayúscula, y extraemos la letra 0
            op = in.next().toUpperCase().charAt(0);
            if (op == 'R' || op == 'N' || op == 'P' || op == 'I') {
                esValido = true;
                System.out.println("Opción aceptada.");
            } else {
                System.out.println("Opción inválida. Intente nuevamente por favor.");
            }
        }while (!esValido);
        return op;
    }
}
