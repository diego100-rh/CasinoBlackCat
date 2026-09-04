import java.util.Scanner;

public class leerOpcion {
    public static int leerOpcion(Scanner in) {
        int opcion = 0;
        boolean esValido = false;

        do {
            System.out.print("Elige una opción: ");
            // preventivo contra letras
            if (in.hasNextInt()) {
                opcion = in.nextInt();
                // Validación (solo 1, 2 o 3)
                if (opcion == 1 || opcion == 2 || opcion == 3) {
                    esValido = true;
                } else {
                    System.out.println("Opción inválida. Ingrese 1, 2 o 3.");
                }
            } else {
                System.out.println("Error: Ingrese solo números enteros.");
            }
            in.nextLine(); //cerramos

        } while (!esValido);

        return opcion;
    }
}
