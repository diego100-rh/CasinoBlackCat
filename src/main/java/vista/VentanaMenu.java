package vista;
import modelo.Ruleta;
import modelo.Usuario;
import javax.swing.*;

public class VentanaMenu {
    private JFrame frame;
    private Ruleta motorCentral;
    private Usuario usuarioActual;

    public VentanaMenu(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual; // Guardas todo el objeto (nombre, saldo, etc.)
        this.motorCentral = new Ruleta();
        configurarVentana();

    }
    public void configurarVentana(){

        frame = new JFrame("RULETA - Casino Black Cat");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JLabel lblBienvenida = new JLabel("Bienvenido/a al menú principal, " + usuarioActual.getNombre());
        lblBienvenida.setBounds(30, 20, 400, 30);
        frame.add(lblBienvenida);

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
            VistaPerfil perfil$ = new VistaPerfil(usuarioActual);
            perfil$.mostrarVentana(frame,usuarioActual);
        });


        // Acciones temporales para conectar en el siguiente paso
        btnJugar.addActionListener(e -> {
            VentanaRuleta ruleta = new VentanaRuleta(motorCentral);
            ruleta.mostrarVentana();
        });
        // Al botón historial le pasas el mismo motor
        btnHistorial.addActionListener(e -> {
            VistaHistorial historial = new VistaHistorial(usuarioActual, motorCentral);
            historial.mostrarVentana();
        });
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
