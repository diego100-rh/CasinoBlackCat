package Controlador;
import modelo.ApuestaBase;
import modelo.Ruleta;

public class RuletaController {
    private Ruleta motorRuleta;
    private SessionController sesion;
    public RuletaController(Ruleta ruleta, SessionController sesion){
        this.motorRuleta = ruleta;
        this.sesion = sesion;
        this.motorRuleta = ruleta;
    }
    public String procesarApuesta(ApuestaBase apuesta) {
        int numeroGanador = motorRuleta.girarRuleta();


        // Puedes delegar esto a tu clase Ruleta o calcularlo directamente
        String colorGanador = motorRuleta.obtenerColor(numeroGanador);

        // El controlador valúe a sí misma
        boolean victoria = apuesta.acierta(numeroGanador, colorGanador);

        // Extraemos los datos del objeto para los registros y el saldo
        int monto = apuesta.getMonto();

        // (Opcional) Si tus métodos de registro aún piden el enum TipoApuesta,
        // deberás actualizarlos para que reciban un String (apuesta.getEtiqueta()) o el objeto ApuestaBase
        motorRuleta.registrarResultado(numeroGanador, monto, victoria, apuesta.getEtiqueta());
        sesion.registrarJugadaPersonal(numeroGanador, monto, victoria, apuesta.getEtiqueta());

        if (victoria) {
            sesion.pagarPremio(monto);
            return "Número ganador: " + numeroGanador + " - ¡GANASTE $" + monto + "!";
        } else {
            sesion.cobrarApuesta(monto);
            return "Número ganador: " + numeroGanador + " - Perdiste $" + monto + ".";
        }
    }

    public int obtenerSaldo() {
        return this.sesion.getSaldoUsuario();
    }
}