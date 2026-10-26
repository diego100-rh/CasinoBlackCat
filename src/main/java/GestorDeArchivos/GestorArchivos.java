package GestorDeArchivos;
import modelo.Resultado;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class GestorArchivos {
    // Nombre del archivo que se creará en la carpeta del proyecto
    private final String RUTA_ARCHIVO = "historial_jugadas.csv";

    // Método para guardar UNA jugada nueva al final del archivo
    public void guardarJugada(Resultado resultado) {
        // El "true" en FileWriter significa "Append" (añadir al final sin borrar lo anterior)
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            // Armamos la línea separada por coma para numero,monto,victoria,etiqueta
            String linea = resultado.getNumero() + "," +
                    resultado.getApuesta() + "," +
                    resultado.isVictoria() + "," +
                    resultado.getTipoApuesta();

            pw.println(linea); // Escribe la línea y da un salto de carro

        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

}
