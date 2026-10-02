package vista;
import modelo.Ruleta;
import modelo.Usuario;

import javax.swing.*;

public class VistaHistorial {
    private JFrame frame;
    private Usuario usuarioActual;
    private Ruleta motorRuleta;
    // El constructor ahora exige recibir el motor que ya tiene los datos, para no crear uno NEW DESDE 0
    public VistaHistorial(Usuario usuarioActual, Ruleta motorOriginal){
        this.motorRuleta=motorOriginal;
        configurarVentanaHistorial(usuarioActual);

    }

    public void configurarVentanaHistorial(Usuario usuarioActual){
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

        int partidas = motorRuleta.getHistorialSize();
        int victoria = motorRuleta.calcularVictoria();
        int dinero = motorRuleta.calcularDineroGastado();

        String textoEstadisticas = "Usuario: " + usuarioActual.getNombre()+ "\n"
                + "-----------------------------------\n"
                + "Partidas jugadas: " + partidas + "\n"
                + "Victorias obtenidas: " + victoria + "\n"
                + "Dinero total apostado: $" + dinero;
        txtReporte.setText(textoEstadisticas);
        // Le añadimos scroll por si el texto crece mucho
        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBounds(30, 60, 320, 150);
        frame.add(scroll);
    }
    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
