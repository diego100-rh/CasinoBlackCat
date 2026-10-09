package vista;
import Controlador.ResultadosController;
import javax.swing.*;

public class VistaHistorial {
    private JFrame frame;
    private ResultadosController controlador; // Usamos el controlador, no la ruleta
    private String nombreJugador;

    // El constructor ahora exige recibir el motor que ya tiene los datos, para no crear uno NEW DESDE 0
    public VistaHistorial(String nombreJugador, ResultadosController controlador) {
        this.nombreJugador = nombreJugador;
        this.controlador = controlador;
        configurarVentanaHistorial();
    }

    public void configurarVentanaHistorial(){
        frame = new JFrame("Ruleta - Historial ");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JLabel lblTitulo = new JLabel("Estadísticas de la sesión actual:");
        lblTitulo.setBounds(30, 20, 300, 25);
        frame.add(lblTitulo);

        // Componente multilinea para mostrar los datos
        JTextArea txtReporte = new JTextArea();
        txtReporte.setEditable(false); // Evita que el usuario borre texto

        // En tu VistaHistorial.java
        String reporteCompleto = this.controlador.obtenerDetalleHistorial();
        txtReporte.setText("Usuario: " + this.nombreJugador + "\n\n" + reporteCompleto);

        // Le añadimos scroll por si el texto crece mucho
        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBounds(30, 60, 320, 150);
        frame.add(scroll);
    }
    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
