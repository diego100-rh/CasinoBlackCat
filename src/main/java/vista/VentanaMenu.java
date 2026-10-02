package vista;
import Controlador.ResultadosController;
import Controlador.SessionController;
import modelo.Ruleta;
import modelo.Usuario;
import javax.swing.*;

public class VentanaMenu {
    private JFrame frame;
    private Ruleta motorCentral;
    private Usuario usuarioActual;
    private SessionController sesion;

    public VentanaMenu(Usuario usuarioActual, SessionController controladorSesion) {
        this.usuarioActual = usuarioActual; // Guardas todo el objeto (nombre, saldo, etc.)
        this.motorCentral = new Ruleta();
        this.sesion = controladorSesion;
        configurarVentana();

    }
    public void configurarVentana(){

        frame = new JFrame("RULETA - Casino Black Cat");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

       // ... (justo debajo de frame.setLocationRelativeTo(null);)

      JLabel lblBienvenida = new JLabel();
      lblBienvenida.setBounds(30, 20, 400, 30);
      frame.add(lblBienvenida);

        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent e) {
                // Consulta el saldo cada vez que la ventana pasa a primer plano
                lblBienvenida.setText("Jugador: " + usuarioActual.getNombre() +
                        " | Saldo: $" + usuarioActual.getSaldo());
            }
        });

        JButton btnJugar = new JButton("Jugar");
        btnJugar.setBounds(30, 70, 120, 30);
        frame.add(btnJugar);

        JButton btnHistorial = new JButton("Historial");
        btnHistorial.setBounds(30, 115, 120, 30);
        frame.add(btnHistorial);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(30, 160, 120, 30);
        frame.add(btnSalir);

        JButton btnrperfilUsuario = new JButton("Perfil");
        btnrperfilUsuario.setBounds(30, 205, 120, 30);
        frame.add(btnrperfilUsuario);


        // Acción del botón Salir: Destruye el menú y revive el Login
        btnSalir.addActionListener(e -> {
            frame.dispose();
            VentanaLogin login = new VentanaLogin();
            login.mostrarVentana();
        });

        btnrperfilUsuario.addActionListener(e -> {
            // 1. Instancias el controlador envolviendo al usuario que tienes en el menú
            SessionController controladorSesion = new SessionController(this.usuarioActual);

            // 2. Instancias la vista y le pasas el controlador
            VistaPerfil perfil = new VistaPerfil(usuarioActual);
            perfil.mostrarVentana(controladorSesion);
        });

        btnJugar.addActionListener(e -> {
            VentanaRuleta ruleta = new VentanaRuleta(motorCentral,sesion);
            ruleta.mostrarVentana();
        });
        // Al botón historial le pasas el mismo motor
        btnHistorial.addActionListener(e -> {
            // 1. Creamos el controlador pasándole el motor central
            ResultadosController controlHistorial = new ResultadosController(this.motorCentral);

            VistaHistorial historial = new VistaHistorial(this.usuarioActual.getNombre(), controlHistorial);
            historial.mostrarVentana();
        });
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
