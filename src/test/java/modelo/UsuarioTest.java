package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuarioPrueba;

    @BeforeEach
    public void setUp() {
        // Utilizamos constructor para crear un usuario ficticio
        usuarioPrueba = new Usuario("jugador1", "secreta123", "Juan re");
    }
    // PASO 2: Verificar que devuelve el nombre correcto
    @Test
    public void testGetNombre() {
        String nombreObtenido = usuarioPrueba.getNombre();
        assertEquals("Juan re", nombreObtenido, "El método debe retornar exactamente 'Juan re'");
    }

    // PASO 3: Verificar el "camino feliz" (credenciales correctas)
    @Test
    public void testValidarCredencialesCorrectas() {
        // Ingresamos exactamente los mismos datos del constructor
        boolean resultado = usuarioPrueba.validarCredenciales("jugador1", "secreta123");
        assertTrue(resultado, "Si el usuario y clave coinciden, debe retornar true");
    }

    // PASO 4: Verificar los "caminos tristes" (intentos de hackeo o errores)
    @Test
    public void testValidarCredencialesIncorrectas() {
        // Prueba A: Clave incorrecta
        boolean resultadoClaveMala = usuarioPrueba.validarCredenciales("jugador1", "claveErronea");
        assertFalse(resultadoClaveMala, "Si la clave es incorrecta, debe retornar false");

        // Prueba B: Usuario incorrecto
        boolean resultadoUsuarioMalo = usuarioPrueba.validarCredenciales("intruso", "secreta123");
        assertFalse(resultadoUsuarioMalo, "Si el nombre de usuario es incorrecto, debe retornar false");
    }


}
