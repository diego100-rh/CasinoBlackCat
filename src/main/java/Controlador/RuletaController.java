package Controlador;
import modelo.Ruleta;
import modelo.TipoApuesta;

public class RuletaController {
    private Ruleta motorRuleta;
    private SessionController sesion;
    public RuletaController(Ruleta ruleta, SessionController sesion){
        this.motorRuleta = ruleta;
        this.sesion = sesion;
        this.motorRuleta = ruleta;
    }
    public String procesarApuesta(int monto, TipoApuesta tipo) {
        int numeroGanador = motorRuleta.girarRuleta();
        boolean victoria = tipo.evaluarResultado(numeroGanador);

        motorRuleta.registrarResultado(numeroGanador, monto, victoria, tipo);
        if (victoria) {

            sesion.pagarPremio(monto);
            return "Número ganador: " + numeroGanador + " - ¡GANASTE $" + monto + "!";
        } else {
            // Si pierde, se descuenta el monto de su cuenta
            sesion.cobrarApuesta(monto);
            return "Número ganador: " + numeroGanador + " - Perdiste $" + monto + ".";
        }
    }

    public int obtenerSaldo() {
        return this.sesion.getSaldoUsuario();
    }
}