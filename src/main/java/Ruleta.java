import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static final int CANTIDAD_NUMEROS = 37;
    int numeroGanador = rng.nextInt(CANTIDAD_NUMEROS);
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int opcionElegida = 0;
        do {
            mostrarMenu();
            opcionElegida = leerOpcion(in);
            ejecutarOpcion(opcionElegida, in);
        } while (opcionElegida != 3);

     }

    public static void mostrarMenu() {
        System.out.println("\n=== Bienveido al casino Black Cat ===");
        System.out.println("    === Jugue con moderacion ===    ");

        System.out.println("\n1. Iniciar juego");
        System.out.println("2. Ver Estadisticas ");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int leerOpcion(Scanner in) {
        Scanner lector = new Scanner(System.in);
        int opcion = lector.nextInt();
        lector.nextLine();
        return opcion;
    }

public static void ejecutarOpcion(int opcion, Scanner in) {
    switch (opcion) {
        case 1:
            iniciarRonda(in);
            break;
        case 2:
            mostrarEstadisticas();
            break;
        case 3:
            System.out.println("Gracias por visitar el Casino Black Cat. ¡Vuelva pronto!");
            break;
        default:
            System.out.println("Opcion invalida. Por favor, intente nuevamente.");
            break;
    }
}
    /**
     * Inicia una ronda de la ruleta: leer apuesta, girar,
     * evaluar y mostrar resultado.
     *
     * @param in Scanner para entrada por consola.
     */
    public static void iniciarRonda(Scanner in) {
        System.out.println("\n Ronda selccionada preparando... ");
        char apuestaelegida = leerTipoApuesta(in);
        int numeroganador = girarRuleta();
       boolean posiblevictoria = evaluarResultado(numeroganador, apuestaelegida);
        // mostrarResultado();
    }

    public static char leerTipoApuesta(Scanner in) {
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
        System.out.print(" Seleccione:");
       // leemos palabra, mayúscula, y extraemos la letra 0
        char op = in.next().toUpperCase().charAt(0);
        in.nextLine();
        return op;
    }
    public static int girarRuleta() {
        // Genera y retorna un número aleatorio entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }
    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
         switch (tipo){
            case 'R':
                return esRojo(numero);
             case 'N':
                 return !esRojo(numero); // El signo "!" significa "NO". Gana si NO es rojo.
             case 'P':
                 return (numero % 2 == 0); // Gana si es par
             case 'I':
                 return (numero % 2 != 0); // Gana si es impar
             default:
                 return false; // Por seguridad, si llega una letra extraña, pierde.
         }

    }
/**
 * Determina si un número corresponde a color rojo.
 * @param n número de la ruleta.
 * @return true si es rojo, false en caso contrario.
 */
public static boolean esRojo(int n) {
    for (int i = 0; i < numerosRojos.length; i++){
        if (numerosRojos[i] == n);{
            return true;
        }
    }
    return false;
}
    /**
     * Registra los resultados de la ronda en los arreglos
     * de historial.
     *
     * @param numero número obtenido en la ruleta.
     * @param apuesta monto apostado.
     * @param acierto si el jugador acertó o no.
     */
    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
// TODO: Guardar los datos sin superar MAX_HISTORIAL.
    }
    /**
     * Muestra en consola el resultado de la ronda.
     *
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta realizada.
     * @param monto monto apostado.
     * @param acierto si el jugador ganó o perdió.
     */
    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {
// TODO: Mostrar los datos y el resultado de la ronda.
    }
    /**
     * Muestra estadísticas generales de todas las
     * rondas jugadas.
     */
    public static void mostrarEstadisticas() {
// TODO: Calcular y mostrar las estadísticas acumuladas.
    }
}