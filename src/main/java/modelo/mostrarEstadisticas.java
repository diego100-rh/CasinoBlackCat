package modelo;

public class mostrarEstadisticas {
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
