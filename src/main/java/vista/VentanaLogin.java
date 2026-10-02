package vista;

import javax.swing.*;

import modelo.GestorUsuario;
import modelo.Usuario;

public class VentanaLogin {
    private GestorUsuario gestor;
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrarse");

    public VentanaLogin(GestorUsuario gestorExistente){
        this.gestor = gestorExistente;
        configurarVentana();
    }
    public VentanaLogin() {
       this.gestor = new GestorUsuario();
       configurarVentana();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null); // Centra la ventana exactamente en medio de la pantalla
        frame.setVisible(true);            // La dibuja y la hace visible
    }

    private void configurarVentana() {
        frame.setSize(350,200); // (ancho x alto)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // terminar completamente y liberar la memoria cuando se haga click en el
        // botón de cierre (X)
        frame.setLayout(new java.awt.GridLayout(4,2,15,15));
        // filas - columnas - separacion horizontal - separacion vertical

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);
        frame.add(new JLabel("")); // Espacio
        frame.add(btnIngresar);

        frame.add(btnRegistrar);
        btnIngresar.addActionListener(e ->login());
        btnRegistrar.addActionListener(actionEvent -> {
            frame.dispose();// matar la ventana login actual
            VentanaRegistro ventanaReg = new VentanaRegistro();
            ventanaReg.mostrarVentana(gestor);// Abre el registro compartiendo la base de datos
        });

        }

      public void login() {
          String user = txtUsuario.getText();
           String password = new String(txtClave.getPassword());

          // Asumiendo que validarCredenciales ahora devuelve un objeto Usuario (o null si falla)
          Usuario usuarioLogueado = gestor.validarCredenciales(user, password);

          if (usuarioLogueado != null) {
              JOptionPane.showMessageDialog(null, "Login exitoso, Bienvenido " + usuarioLogueado.getNombre());
              frame.dispose();
              VentanaMenu menu = new VentanaMenu(usuarioLogueado); // Pasamos el objeto completo
              menu.mostrarVentana();
          } else {
              JOptionPane.showMessageDialog(null, "Error: Credenciales incorrectas");
          }
      }

}
