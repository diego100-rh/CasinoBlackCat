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
        String nombreReal = gestor.validarCredenciales("admin", "676767");

        // Exigimos que el método retorne exactamente "Don Donnie"
        assertEquals("Don Donnie", nombreReal, "Las credenciales del admin deberían retornar su nombre real");
    }

    @Test
    public void testValidarCredencialesIncorrectas() {
        // Simulamos un intento de error de tipeo
        String nombreReal = gestor.validarCredenciales("admin", "clave_falsa");

        // Exigimos que el método retorne un texto vacío, bloqueando el acceso
        assertEquals("", nombreReal, "Una contraseña incorrecta debe retornar un String vacío");
    }

    @Test
    public void testRegistrarNuevoUsuario() {
        // 1. Creamos un usuario nuevo que no existe en el constructor
        Usuario nuevo = new Usuario("lulu", "1234", "Patricio");

        // 2. Lo registramos en la lista
        gestor.registrarUsuario(nuevo);

        // 3. Intentamos iniciar sesión con ese nuevo usuario
        String nombreRecuperado = gestor.validarCredenciales("lulu", "1234");

        // 4. Verificamos que el sistema lo haya guardado y lo reconozca
        assertEquals("Patricio", nombreRecuperado, "El sistema debe permitir el login del usuario recién registrado");
    }
} ////sin problemas corregido errores de tipeo