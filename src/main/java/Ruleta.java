import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static final int CANTIDAD_NUMEROS = 37;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public static void main(String[] args) {
        menu();


    }

//    public static void menu() {
//        Scanner in = new Scanner(System.in);
//        int opcionElegida = 0;
//        do {
//            mostrarMenu();
//            opcionElegida = leerOpcion(in);
//            ejecutarOpcion(opcionElegida, in);
//        } while (opcionElegida != 3);
//
//    }

//    public static void mostrarMenu() {
//         System.out.println("\n=== Bienveido al casino Black Cat ===");
//         System.out.println("    === Jugue con moderacion ===    ");
//
//         System.out.println("\n1. Iniciar juego");
//         System.out.println("2. Ver Estadisticas ");
//         System.out.println("3. Salir");
//    }

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

    public static int leerMontoApostado(Scanner in) {
        int monto =  0;
        boolean esValido = false;
        do {
            System.out.print("Ingrese el monto de la apuesta $: ");

            if (in.hasNextInt()){
                monto = in.nextInt();
               if (monto > 0){
                 esValido = true;
               } else {
                 System.out.println("Error: La apuesta debe ser mayor a $0.");
               }
            } else{
            // Si escribió letras o símbolos, cae aquí y evitamos que el programa colapse
            System.out.println("Error: Por favor ingrese solo números enteros.");
            }
            in.nextLine();
        }while (!esValido);
        return monto;
    }

    public static void iniciarRonda(Scanner in) {
        System.out.println("\n Ronda seleccionada preparando... ");

        char apuestaElegida = leerTipoApuesta(in);
        int montoApostado = leerMontoApostado(in); // Llamamos

        int numeroGanador = girarRuleta();
        boolean posibleVictoria = evaluarResultado(numeroGanador, apuestaElegida);

        registrarResultado(numeroGanador, montoApostado, posibleVictoria);
        mostrarResultado(numeroGanador, apuestaElegida, montoApostado, posibleVictoria);
    }

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

    public static int girarRuleta() {
        // Genera y retorna un número aleatorio entre 0 y 36
        return rng.nextInt(CANTIDAD_NUMEROS);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
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

    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) ;
            {
                return true;
            }
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
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

/**
 * Muestra en consola el resultado de la ronda.
 *
 * @param numero  número obtenido en la ruleta.
 * @param tipo    tipo de apuesta realizada.
 * @param monto   monto apostado.
 * @param acierto si el jugador ganó o perdió.
 */
   public static void mostrarResultado(int numero, char tipo, int monto, boolean
        acierto) {
       {
       System.out.println("\n==============================");
       System.out.print(" -Mostrando Resultado de juego:" + tipo);

       System.out.println("\n La ruleta se detubo en el número: " + numero);
        if (acierto) {
            int premio = monto * 2;
            System.out.println("SIIII HAS GANDO CON TU MONTO DE: " +monto+ " OPTUBISTE UN MONTO EXTRA DE:" + premio);
        } else {
            System.out.println("Lo siento tu apuesta de " + monto + " fue rechazada");
            System.out.println("Monto perdido: -" +monto);
            }
        }
   }
    // TODO: Mostrar los datos y el resultado de la ronda.

/**
 * Muestra estadísticas generales de todas las
 * rondas jugadas.
 */
    public static void mostrarEstadisticas(){

        System.out.println("Mostrando estadisticas actuales...");
        if (historialSize == 0) {
            System.out.println("Aún no hay jugadas registradas en esta sesión.");
            return;
        }
        int victorias = 0;
        int derrotas = 0;
        int dineroUsado = 0;

        for (int i = 0; i < historialSize; i++) {
            dineroUsado = dineroUsado + historialApuestas[i];

            if (historialAciertos[i]) {
                victorias++;
            } else {
                derrotas++;
            }
            System.out.println("Total de rondas jugadas: " + historialSize);
            System.out.println("Rondas ganadas: " + victorias);
            System.out.println("Rondas perdidas: " + derrotas);
            System.out.println("Dinero total apostado: $" + dineroUsado);
        }
    }



}


