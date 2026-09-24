package modelo;

import java.util.Scanner;

public class inciarRondas {
    public static void iniciarRonda(Scanner in) {
        System.out.println("\n Ronda seleccionada preparando... ");

        char apuestaElegida = Tipodeapuesta.leerTipoApuesta(in);
        int montoApostado = Monto.leerMontoApostado(in);
        int numeroGanador = MecanismoRuleta.girarRuleta();
        boolean posibleVictoria = EvaluadorApuesta.evaluarResultado(numeroGanador,apuestaElegida);

        RegistroResultado registro = new RegistroResultado();
        registro.registrarResultado(numeroGanador, montoApostado, posibleVictoria);
    }
}
