package Controlador;
import modelo.Resultado;
import modelo.Ruleta;
import modelo.Usuario;

import java.util.List;

public class ResultadosController {
    private SessionController sesion;

    public ResultadosController(SessionController sesion) {
        this.sesion = sesion;
    }
    public String obtenerDetalleHistorial(){
        List<Resultado> historial = sesion.getHistorialUsuario();

        if (historial.isEmpty()) {
            return "Aún no hay jugadas registradas en esta cuenta.";
        }

        int totalPartidas = historial.size();
        int totalVictorias = 0;
        int totalDinero = 0;
        StringBuilder detalle = new StringBuilder();

        for (Resultado r : historial) {
            totalDinero += r.getApuesta(); // Sumamos el dinero gastado

            detalle.append("Apostaste $").append(r.getApuesta())
                    .append(" al ").append(r.getTipoApuesta())
                    .append(" | Salió el número: ").append(r.getNumero());

            if (r.isVictoria()) {
                totalVictorias++; // Contamos la victoria
                detalle.append(" -> ¡GANASTE!\n");
            } else {
                detalle.append(" -> Perdiste\n");
            }
        }

        // Ahora armamos el Texto Final
        StringBuilder reporteFinal = new StringBuilder();
        reporteFinal.append("Partidas jugadas: ").append(totalPartidas).append("\n")
                .append("Victorias obtenidas: ").append(totalVictorias).append("\n")
                .append("Dinero total apostado: $").append(totalDinero).append("\n")
                .append("--------------------------------------------------\n")
                .append("DETALLE DE TUS JUGADAS:\n")
                .append(detalle.toString());

        return reporteFinal.toString();
    }

}