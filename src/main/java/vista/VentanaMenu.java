package vista;
import Controlador.ResultadosController;
import Controlador.RuletaController;
import Controlador.SessionController;
import modelo.Ruleta;
import modelo.Usuario;
import javax.swing.*;

public class VentanaMenu {
    private JFrame frame;
    private Ruleta motorCentral;
    private SessionController sesion;

    public VentanaMenu(SessionController sesion) {
        this.motorCentral = new Ruleta();
        this.sesion = sesion;
        configurarVentana();
    }
    public void configurarVentana(){

        frame = new JFrame("RULETA - Casino Black Cat");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

      JLabel lblBienvenida = new JLabel();
      lblBienvenida.setBounds(30, 20, 400, 30);
      frame.add(lblBienvenida);

        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowGainedFocus(java.awt.event.WindowEvent e) {

                lblBienvenida.setText("Jugador: " + VentanaMenu.this.sesion.getNombreUsuario() +
                        " | Saldo: $" + VentanaMenu.this.sesion.getSaldoUsuario());
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
            // Le pasas la sesión única que ya existe en el menú
            VistaPerfil perfil = new VistaPerfil(this.sesion);
            perfil.mostrarVentana();
        });

        btnJugar.addActionListener(e -> {
            RuletaController controladorRuleta = new RuletaController(this.motorCentral, this.sesion);
            VentanaRuleta ventanaJuego = new VentanaRuleta(controladorRuleta);
            ventanaJuego.mostrarVentana();
        });
        // Al botón historial le pasamos el mismo motor
        btnHistorial.addActionListener(e -> {
            // Le pasamos SOLO LA SESIÓN al controlador del historial
            ResultadosController controladorHistorial = new ResultadosController(this.sesion);
            String nombreJugador = this.sesion.getNombreUsuario();
            VistaHistorial ventanaHistorial = new VistaHistorial(nombreJugador, controladorHistorial);
            ventanaHistorial.mostrarVentana();
        });
    }
    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
