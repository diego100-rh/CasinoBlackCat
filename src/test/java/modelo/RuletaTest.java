package modelo;

import Controlador.RuletaController;
import Controlador.SessionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RuletaTest {

    private Usuario jugadorPrueba;
    private SessionController sesion;
    private Ruleta motorCentral;
    private RuletaController controlador;

    // Se ejecuta antes de CADA prueba para asegurar que empezamos desde cero
    @BeforeEach
    public void setUp() {
        jugadorPrueba = new Usuario("bot","123", "test");
        jugadorPrueba.depositar(5000); // Le damos $5000 de saldo inicial

        sesion = new SessionController(jugadorPrueba);
        motorCentral = new Ruleta();
        controlador = new RuletaController(motorCentral, sesion);
    }

    // ==========================================
    // PRUEBA 1: LÓGICA DEL ENUM (Reglas de Juego)

    @Test
    public void testLogicaTipoApuesta() {

        assertTrue(TipoApuesta.PAR.evaluarResultado(2), "El número 2 debe ser evaluado como PAR y ganar.");
        assertFalse(TipoApuesta.PAR.evaluarResultado(3), "El número 3 NO es PAR, debe perder.");

        // Probamos que la lógica de IMPAR funcione correctamente
        assertTrue(TipoApuesta.IMPAR.evaluarResultado(7), "El número 7 debe ser evaluado como IMPAR y ganar.");
        assertFalse(TipoApuesta.IMPAR.evaluarResultado(8), "El número 8 NO es IMPAR, debe perder.");

        // El 0 usualmente no es ni par ni impar ni rojo ni negro en la ruleta tradicional, hace perder a las apuestas simples
        assertFalse(TipoApuesta.PAR.evaluarResultado(0), "El número 0 hace perder la apuesta PAR.");
        assertFalse(TipoApuesta.IMPAR.evaluarResultado(0), "El número 0 hace perder la apuesta IMPAR.");

        /*
         *para OJO y NEGRO,
         * assertTrue(TipoApuesta.ROJO.evaluarResultado(1), "El 1 debería ser rojo");
         */
    }
    // PRUEBA 2: FLUJO DEL CONTROLADOR (MVC)

    @Test
    public void testProcesarApuestaFlujoCompleto() {
        int saldoAntes = sesion.getSaldoUsuario(); // 5000

        // 1. Ejecutamos la acción a través del Controlador (como lo haría el botón Jugar)
        String mensajeResultado = controlador.procesarApuesta(1000, TipoApuesta.PAR);

        // 2. Verificaciones de Arquitectura
        assertNotNull(mensajeResultado, "El controlador debe devolver un mensaje con el resultado de la jugada.");
        assertFalse(mensajeResultado.isEmpty(), "El mensaje de resultado no puede estar vacío.");

        // b) El historial personal del usuario debió aumentar en 1 jugada
        assertEquals(1, sesion.getHistorialUsuario().size(), "El historial del SessionController debe tener 1 jugada registrada.");

        // c) El saldo del jugador debe haber cambiado (Ya sea que bajó a 4000 por perder, o subió a 6000 por ganar)
        int saldoDespues = sesion.getSaldoUsuario();
        assertNotEquals(saldoAntes, saldoDespues, "El saldo del jugador debió cambiar tras procesar la apuesta.");
    }
}

// evaluacion de dependecia aprobada flujo de ruleta completo