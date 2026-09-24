package launcher;
import vista.VistaEstadisticas;
import vista.VistaMenuGeneral;
import vista.VistaRondas;
import modelo.RevicionDecondiciones;

import java.util.Scanner;


public class ControladorDeJuego {
    public void arrancarMenu(){
        Scanner lec = new Scanner(System.in);
        int op =0;
        VistaMenuGeneral consola = new VistaMenuGeneral();
        RevicionDecondiciones memoria = new RevicionDecondiciones();
        VistaEstadisticas estadisticas = new VistaEstadisticas();
        VistaRondas jugar = new VistaRondas();
        System.out.println("\n==== Bienvenido al casino ==== ");

        do {
           consola.mostrarMenu();
            System.out.print("\nElige una opción: ");
            op = lec.nextInt();
            lec.nextLine();

            switch (op){
                case 1:
                    System.out.println("Iniciando...");
                    jugar.iniciarRonda(lec, memoria);
                    break;

                case 2:
                    estadisticas.mostrarEstadisticas(memoria);
                    break;

                case 3:
                    System.out.println("Saliendo del juego...");
                    break;
            }
        }while (op !=3);
        lec.close();



    }
}
