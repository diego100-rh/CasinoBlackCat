import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List USUARIOS = new ArrayList<>();
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");

    /**
     * Constructor que inicializa la ventana de inicio de sesión.
     * Configura sus componentes y eventos.
     */
    public VentanaLogin() {
// TODO: Agregar los usuarios iniciales a la lista
// TODO: Inicializar y configurar la ventana
    }
    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
// TODO: Centrar y mostrar la ventana
    }
    private void login(Scanner esc) {

        String user = txtUsuario.getText();
        String password = new String(txtClave.getPassword());
        String nombreJugador = validarCredenciales(user, password);
        if (!nombreJugador.isEmpty()) {
            //empty: verificar si un texto está completamente vacío (es decir, si es igual a "").
            JOptionPane.showMessageDialog(null, "Login existoso, Bienvenido" + nombreJugador);
        } else {
            JOptionPane.showMessageDialog(null, "Error: Credenciales incorrectas para: " + nombreJugador);
        }
    }
    /**
     * Valida las credenciales ingresadas utilizando la lista de usuarios.
     *
     * @param u nombre de usuario ingresado
     * @param p contraseña ingresada
     * @return el nombre del usuario si las credenciales son válidas o una cadena vacía
    si no existe una coincidencia
     */
    private String validarCredenciales(String u, String p) {
// TODO: Recorrer la lista y validar las credenciales
       for (Usuario jugador : USUARIOS){
           if (jugador.validarCredenciales(u,p)){
               return jugador.getNombre();
           }
       }
     return "";
    }
    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    private void abrirRegistro() {
// TODO: Cerrar la ventana actual y abrir la ventana de registro
    }

}