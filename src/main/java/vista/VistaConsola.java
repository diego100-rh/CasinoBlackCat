package vista;

import modelo.RegistroResultado;

public class VistaConsola {
    public void mostrarEstadisticas(RegistroResultado historial){
        System.out.println("Mostrando estadisticas nuevas...");

        if (historial.getHistorialSize() == 0){
            System.out.println("Historial sin jugadas en esta sesion... ");
            System.out.println("¡Juegue para añadir victorias al historia! ");
            return;
        }

        int victroias =  historial.calcularVictoria();
        int derrotas = historial.getHistorialSize() - victroias;
        int dineroUsado = historial.calcularDineroGastado();

        System.out.println("Total de rondas jugadas: " + historial.getHistorialSize());
        System.out.println("Rondas ganadas: " + victroias);
        System.out.println("Rondas perdidas: " + derrotas);
        System.out.println("Dinero total apostado: $" + dineroUsado);





    }
}
