package vista;
import Controlador.SessionController;
import modelo.Ruleta;
import javax.swing.*;
import modelo.TipoApuesta;
import Controlador.RuletaController;

public class VentanaRuleta {
    private JFrame frame;
    private SessionController sesion;
    private Ruleta motorRuleta;// Conexión directa con lógica matemática
    private RuletaController ruletaController;
    private TipoApuesta evaluarTipoApuesta;

    public VentanaRuleta(Ruleta motorCompartido, SessionController controladorSesion) {
        this.motorRuleta = motorCompartido; // Instanciamos el motor al abrir la ventana
        this.sesion = controladorSesion;
        this.ruletaController = new RuletaController(this.motorRuleta, this.sesion);
        configurarVentana();
    }

    public void configurarVentana() {
        frame = new JFrame("Mesa de Ruleta - Casino Black cat");
        frame.setSize(550, 400);
        // DISPOSE_ON_CLOSE asegura que al cerrar la ruleta, volvamos al menú sin matar el programa
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        // --- COMPONENTES VISUALES ---
        JLabel lblTipo = new JLabel("Tipo de apuesta:");
        lblTipo.setBounds(50, 30, 150, 25);
        frame.add(lblTipo);

        // El JComboBox reemplaza a Tipodeapuesta.java.
        JComboBox<TipoApuesta> comboApuesta = new JComboBox<>(TipoApuesta.values());
        comboApuesta.setBounds(200, 30, 150, 25);
        frame.add(comboApuesta);

        JLabel lblMonto = new JLabel("Monto ($):");
        lblMonto.setBounds(50, 80, 100, 25);
        frame.add(lblMonto);

        JTextField txtMonto = new JTextField();
        txtMonto.setBounds(200, 80, 150, 25);
        frame.add(txtMonto);

        JButton btnGirar = new JButton("Girar Ruleta");
        btnGirar.setBounds(200, 130, 150, 30);
        frame.add(btnGirar);

        JLabel lblResultado = new JLabel("Esperando tu apuesta...");
        lblResultado.setBounds(50, 190, 450, 25);
        frame.add(lblResultado);

        btnGirar.addActionListener(e -> {
            String texto = txtMonto.getText().trim();

            // 1. Primero verificar que no esté vacío
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "El monto de la apuesta debe ser mayor a $0.");
                return;
            }
            int monto;
            try {
                monto = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Ingrese solo números enteros para el monto.");
                return;
            }
            // 3. Verificar que sea mayor a 0
            if (monto <= 0) {
                JOptionPane.showMessageDialog(frame, "El monto de la apuesta debe ser mayor a $0.");
                return;
            }
            int saldoActual = sesion.getSaldoUsuario();

            if (monto > saldoActual) {
                JOptionPane.showMessageDialog(frame, "Saldo insuficiente. Tienes $" + saldoActual);
                return;
            }
            sesion.cobrarApuesta(monto);

            TipoApuesta tipoSeleccionado = (TipoApuesta) comboApuesta.getSelectedItem();
            String resultadoMensaje = this.ruletaController.procesarApuesta(monto, tipoSeleccionado);
            lblResultado.setText(resultadoMensaje);

            if (resultadoMensaje.contains("GANASTE")) {
                // Si gana una apuesta simple (rojo/negro/par/impar), recupera su apuesta y gana otro tanto igual
                int premio = monto * 2;
                sesion.pagarPremio(premio);
            }
        });
    }

    public void mostrarVentana() {

        frame.setVisible(true);
    }
}
