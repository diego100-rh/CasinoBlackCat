import java.util.Scanner;

public class menu {
    public static void menu() {
        Scanner in = new Scanner(System.in);
        int opcionElegida = 0;
        do {
            mostrarMenu();
            leerOpcion opcionElegida = new leerOpcion();


        } while (opcionElegida != 3);

    }
}
