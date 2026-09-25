package vista;
import modelo.Ruleta;
import javax.swing.*;

public class VentanaRuleta {
    private JFrame frame;
    private Ruleta motorRuleta; // Conexión directa con tu lógica matemática

    public VentanaRuleta(Ruleta motorCompartido) {
        this.motorRuleta = motorCompartido; // Instanciamos el motor al abrir la ventana
        configurarVentana();
    }

    public void configurarVentana(){
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

        // El JComboBox reemplaza a Tipodeapuesta.java. Imposible ingresar opciones inválidas.
        String[] opciones = {"Rojo (R)", "Negro (N)", "Par (P)", "Impar (I)"};
        JComboBox<String> comboApuesta = new JComboBox<>(opciones);
        comboApuesta.setBounds(200, 30, 150, 25);
        frame.add(comboApuesta);

        JLabel lblMonto = new JLabel("Monto ($):");
        lblMonto.setBounds(50,80,100,25);
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

        // --- EVENTO DEL BOTÓN (El puente entre Vista y Modelo) ---
        btnGirar.addActionListener(e -> {
            try {
                int monto = Integer.parseInt(txtMonto.getText());
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(frame, "El monto de la apuesta debe ser mayor a $0.");
                    return;
                }
                // Extraemos la primera letra de la opción elegida en el menú desplegable (R, N, P, I)
                char tipoApuesta = comboApuesta.getSelectedItem().toString().charAt(0);

                // 1. Delegamos el giro a la clase Ruleta
                int numeroGanador = motorRuleta.girarRuleta();

                // 2. Delegamos la evaluación matemática
                boolean victoria = motorRuleta.evaluarResultado(numeroGanador, tipoApuesta);

                // 3. Delegamos el registro estadístico
                motorRuleta.registrarResultado(numeroGanador, monto, victoria);

                // 4. Actualizamos la vista visualmente
                String mensaje = "Número ganador: " + numeroGanador + ". ";
                if (victoria) {
                    lblResultado.setText(mensaje + "¡GANASTE!");
                } else {
                    lblResultado.setText(mensaje + "Perdiste. Inténtalo de nuevo.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Ingrese solo números enteros para el monto.");
            }
        });

    }
    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
