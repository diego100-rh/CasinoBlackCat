//package modelo;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class RuletaTest {
//
//    private Ruleta ruleta;
//
//    // @BeforeEach ejecuta este bloque antes de CADA prueba, asegurando una ruleta en blanco
//    @BeforeEach
//    public void setUp() {
//        ruleta = new Ruleta();
//    }
//
//    @Test
//    public void testEsRojo() {
//        // Verificamos que el motor reconozca correctamente los colores
//        assertTrue(ruleta.esRojo(1), "El 1 debería ser detectado como Rojo");
//        assertFalse(ruleta.esRojo(2), "El 2 debería ser detectado como Negro (False)");
//    }
//
//    @Test
//    public void testEvaluarResultado() {
//        // Verificamos la lógica de evaluación de victorias
//        assertTrue(ruleta.evaluarResultado(1, 'R'), "Si sale 1 y apuesto Rojo, debo ganar");
//        assertFalse(ruleta.evaluarResultado(1, 'N'), "Si sale 1 y apuesto Negro, debo perder");
//
//        // Verificamos el caso especial del Cero
//        assertFalse(ruleta.evaluarResultado(0, 'R'), "El 0 siempre hace perder apuestas de color");
//        assertFalse(ruleta.evaluarResultado(0, 'P'), "El 0 siempre hace perder apuestas de paridad");
//    }
//
//    @Test
//    public void testRegistroYEstadisticas() {
//        // Simulamos 3 partidas jugadas por debajo de la interfaz
//        ruleta.registrarResultado(7, 1000, true);
//        ruleta.registrarResultado(14, 2000, true);
//        ruleta.registrarResultado(0, 500, false);
//
//        // Verificamos que el historial almacenó los datos correctamente
//        assertEquals(3, ruleta.getHistorialSize(), "El historial debería tener 3 registros");
//        assertEquals(2, ruleta.calcularVictoria(), "Deberían registrarse exactamente 2 victorias");
//        assertEquals(3500, ruleta.calcularDineroGastado(), "El dinero total gastado debería ser 3500");
//    }
//}