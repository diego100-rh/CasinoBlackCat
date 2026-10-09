package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorDeUsuarioTest {

    private GestorUsuario gestor;

    // Instanciamos el gestor antes de cada prueba.
    // Esto carga automáticamente a "admis" para el constructor.
    @BeforeEach
    public void setUp() {
        gestor = new GestorUsuario();
    }

    @Test
    public void testValidarCredencialesCorrectas() {
        // Simulamos un login exitoso con los datos quemados en tu constructor
        Usuario usuarioReal = gestor.validarCredenciales("admin", "676767");

        // Exigimos que el método retorne exactamente "Don Donnie"
        assertNotNull(usuarioReal, "El usuario no debería ser nulo");
        assertEquals("Don Donnie", usuarioReal.getNombre(), "Las credenciales del admin deben retornar a Don Donnie");
    }

    @Test
    public void testValidarCredencialesIncorrectas() {
        // Simulamos el error
        Usuario usuarioFalso = gestor.validarCredenciales("admin", "clave_falsa");

        // Como la clave es falsa, ahora exigimos que retorne null (no un texto vacío)
        assertNull(usuarioFalso, "Una contraseña incorrecta debe retornar null");
    }

    @Test
    public void testRegistrarNuevoUsuario() {
        // 1. Creamos un usuario nuevo que no existe en el constructor
        Usuario usuarioRecuperado = gestor.validarCredenciales("lulu", "1234");
        assertNotNull(usuarioRecuperado, "El sistema debe reconocer al nuevo usuario");
        assertEquals("Patricio", usuarioRecuperado.getNombre(), "El nombre debe coincidir");
    }
} ////sin problemas corregido errores de tipeo