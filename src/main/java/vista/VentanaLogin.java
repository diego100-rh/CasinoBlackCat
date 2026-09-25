package vista;

import javax.swing.*;

import modelo.GestorUsuario;

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
            ventanaReg.mostrarVentana(this.gestor);// Abre el registro compartiendo la base de datos
        });

        }
      public void login() {
          String user = txtUsuario.getText();
           String password = new String(txtClave.getPassword());

    // Delegamos la validación matemática al modelo
          String nombreJugador = gestor.validarCredenciales(user, password);

          if (!nombreJugador.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login exitoso, Bienvenido " + nombreJugador);
             frame.dispose(); // Destruye la ventana de login
              VentanaMenu menu = new VentanaMenu(nombreJugador);
              menu.mostrarVentana();
          } else {
             JOptionPane.showMessageDialog(null, "Error: Credenciales incorrectas");
             }
      }
}
