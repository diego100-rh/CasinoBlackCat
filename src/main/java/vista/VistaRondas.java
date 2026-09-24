package vista;

import modelo.*;

import java.util.Scanner;

public class VistaRondas {

    public static void iniciarRonda(Scanner in, RevicionDecondiciones memoriaMaestra) {
        System.out.println("\n Ronda seleccionada preparando... ");

        char apuestaElegida = Tipodeapuesta.leerTipoApuesta(in);
        int montoApostado = Monto.leerMontoApostado(in);
        int numeroGanador = MecanismoRuleta.girarRuleta();
        boolean posibleVictoria = EvaluadorApuesta.evaluarResultado(numeroGanador,apuestaElegida);

        memoriaMaestra.registraResultado(numeroGanador,montoApostado,posibleVictoria);
        VistaResultados pantallaResultados = new VistaResultados();
        pantallaResultados.mostrarResultado(numeroGanador,apuestaElegida,montoApostado,posibleVictoria);
    }
}
