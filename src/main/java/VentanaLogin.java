import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List<Usuario> USUARIOS = new ArrayList<>();
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
    private String validarCredenciales(String u, String p) {
        // TODO: Recorrer la lista y validar las credenciales
       for (Usuario jugador : USUARIOS){
           if (jugador.validarCredenciales(u,p)){
               return jugador.getNombre();
           }
       }
     return "";
    }

    private void abrirRegistro() {
// TODO: Cerrar la ventana actual y abrir la ventana de registro
        frame.dispose();
        VentanaRegistro ventanaReg = new VentanaRegistro();
        ventanaReg.mostrarVentana();

    }

}