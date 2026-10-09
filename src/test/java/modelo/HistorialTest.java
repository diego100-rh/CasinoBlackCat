package modelo;

import Controlador.ResultadosController;
import Controlador.RuletaController;
import Controlador.SessionController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HistorialTest {
    @Test
    public void verificarRegistroDeHistorial() {
        Usuario jugadorSimulado = new Usuario("prueba","1234", "bot");
        jugadorSimulado.depositar(1000);

        SessionController sesion = new SessionController(jugadorSimulado);
        Ruleta motorCentral = new Ruleta();

        RuletaController ruletaController = new RuletaController(motorCentral, sesion);
        ResultadosController resultadosController = new ResultadosController(sesion);

        // 2. Simulamos que el jugador hace una apuesta real
        ruletaController.procesarApuesta(100, TipoApuesta.ROJO);

        // 3. Verificamos la lista interna del usuario
        int cantidadJugadas = sesion.getHistorialUsuario().size();

        // Afirmamos que el historial debe tener 1 jugada. con 0 falla
        assertEquals(1, cantidadJugadas, "El historial personal del usuario no está guardando las jugadas.");

        // 4. Verificamos el texto que genera el controlador
        String reporte = resultadosController.obtenerDetalleHistorial();
        assertNotEquals("Aún no hay jugadas registradas en esta cuenta.", reporte, "El reporte dice que está vacío.");
    }

}
