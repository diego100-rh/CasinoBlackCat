package Controlador;
import modelo.Ruleta;

public class ResultadosController {

    // El controlador protege al modelo
    private Ruleta motorRuleta;

    // Constructor que recibe el motor central del casino
    public ResultadosController(Ruleta motorCentral) {
        this.motorRuleta = motorCentral;
    }

    // La vista llamará a estos métodos, y el controlador le preguntará al modelo

    public int obtenerGastosTotales() {
        return this.motorRuleta.calcularDineroGastado();
    }

    public int obtenerTotalVictorias() {
        return this.motorRuleta.calcularVictoria();
    }

//    public int obtenerTotalJugadas() {
//        return this.motorRuleta.geths();
//    }
}