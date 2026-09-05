package vista;

import modelo.RevicionDecondiciones;

public class VistaEstadisticas {
    public void mostrarEstadisticas(RevicionDecondiciones historial){
        System.out.println("Mostrando estadisticas nuevas...");

        if (historial.getHistorialSize() == 0){
            System.out.println("Historial sin jugadas en esta sesion... ");
            System.out.println("¡Juegue para añadir victorias al historia! ");
            return;
        }

        int victorias =  historial.calcularVictoria();
        int derrotas = historial.getHistorialSize() - victorias;
        int dineroUsado = historial.calcularDineroGastado();

        System.out.println("Total de rondas jugadas: " + historial.getHistorialSize());
        System.out.println("Rondas ganadas: " + victorias);
        System.out.println("Rondas perdidas: " + derrotas);
        System.out.println("Dinero total apostado: $" + dineroUsado);





    }
}
