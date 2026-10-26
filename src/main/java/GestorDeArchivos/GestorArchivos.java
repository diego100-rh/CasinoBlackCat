package GestorDeArchivos;
import modelo.Resultado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Resultado> cargarHistorial() {
        List<Resultado> historial = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);

        // Si el archivo aún no existe retornamos la lista vacía
        if (!archivo.exists()) {
            return historial;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int numero = Integer.parseInt(datos[0]);
                    int monto = Integer.parseInt(datos[1]);
                    boolean victoria = Boolean.parseBoolean(datos[2]);
                    String etiqueta = datos[3];

                    // Reconstruimos el objeto Resultado a partir del texto del CSV
                    historial.add(new Resultado(numero, monto, victoria, etiqueta));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return historial;
    }

}
