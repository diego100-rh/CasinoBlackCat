package Controlador;
import modelo.Ruleta;
import modelo.TipoApuesta;

public class RuletaController {
    private Ruleta motorRuleta;
    public RuletaController(Ruleta ruleta) {
        this.motorRuleta = ruleta;
    }

    // El método central que procesa la lógica
    public String procesarApuesta(int monto, TipoApuesta tipo) {

        // 1. Delegamos el giro a la clase Ruleta
        int numeroGanador = motorRuleta.girarRuleta();

        // 2. Delegamos la evaluación matemática
        boolean victoria = tipo.evaluarResultado(numeroGanador, tipo);

        // 3. Delegamos el registro estadístico
        motorRuleta.registrarResultado(numeroGanador, monto, victoria);

        // 4. Preparamos la respuesta para la Vista
        if (victoria) {
            return "Número ganador: " + numeroGanador + " - ¡GANASTE!";
        } else {
            return "Número ganador: " + numeroGanador + " - Perdiste. Inténtalo de nuevo.";
        }
    }
}