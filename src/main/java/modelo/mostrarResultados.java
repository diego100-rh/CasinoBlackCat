package modelo;

public class mostrarResultados {
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
}
