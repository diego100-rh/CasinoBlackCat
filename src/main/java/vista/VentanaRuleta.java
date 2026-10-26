package vista;
import javax.swing.*;

import Controlador.RuletaController;
import modelo.*;

public class VentanaRuleta {
    private JFrame frame;
    private RuletaController controlador;


    public VentanaRuleta(RuletaController controlador) {
        this.controlador = controlador;
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

        String[] opcionesApuesta = {"Rojo", "Negro", "Par", "Impar"};
        JComboBox<String> comboApuesta = new JComboBox<>(opcionesApuesta);
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
            int saldoActual = this.controlador.obtenerSaldo();

            if (monto > saldoActual) {
                JOptionPane.showMessageDialog(frame, "Saldo insuficiente. Tienes $" + saldoActual);
                return;
            }
// 1. Obtenemos el texto de la opción seleccionada en el JComboBox
            String opcionSeleccionada = (String) comboApuesta.getSelectedItem();

// 2. Declaramos la variable de la superclase que guardará la apuesta
            ApuestaBase miApuesta = null;

// 3. Instanciamos la subclase específica según la opción elegida
            switch (opcionSeleccionada) {
                case "Rojo":
                    miApuesta = new ApuestaRojo(monto);
                    break;
                case "Negro":
                    miApuesta = new ApuestaNegro(monto);
                    break;
                case "Par":
                    miApuesta = new ApuestaPar(monto);
                    break;
                case "Impar":
                    miApuesta = new ApuestaImpar(monto);
                    break;
            }

// 4. Se la pasamos al controlador (que ahora recibe un obj ApuestaBase)
            String resultadoMensaje = this.controlador.procesarApuesta(miApuesta);
            lblResultado.setText(resultadoMensaje);
        });
    }

    public void mostrarVentana() {

        frame.setVisible(true);
    }
}
