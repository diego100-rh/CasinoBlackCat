package vista;

import Controlador.ResultadosController;
import modelo.Estadistica;

import javax.swing.*;

public class VentanaEstadisticas extends JFrame {
    private ResultadosController controlador; // Usamos el controlador, no la ruleta

    private Estadistica estadistica;

    // El constructor ahora exige recibir el motor que ya tiene los datos, para no crear uno NEW DESDE 0
    public VentanaEstadisticas(ResultadosController controlador) {
        this.estadistica = this.controlador.obtenerEstadisticas();
        this.controlador = controlador;
        configurarVentanaEstadisticas();

    }
    public void configurarVentanaEstadisticas() {
        setTitle("Detalles de tu sesion ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Estadísticas de la sesión actual:");
        lblTitulo.setBounds(30, 20, 300, 25);
        add(lblTitulo);
        JTextArea txtReporte = new JTextArea();
        txtReporte.setEditable(false);

        // 1. Verificamos que tengamos datos para evitar errores si no ha jugado
        if (this.estadistica.getTotalJugadas() == 0) {
            txtReporte.setText("Aún no hay jugadas registradas para mostrar estadísticas.");
        } else {
            // 2. Armamos el formato visual
            String textoVisual = "=== ESTADÍSTICAS DE LA SESIÓN ===\n\n"
                    + "Total de Partidas Jugadas: " + this.estadistica.getTotalJugadas() + "\n"
                    + "Victorias Obtenidas: " + this.estadistica.getVictorias() + "\n"
                    + "Porcentaje de Éxito: " + String.format("%.1f", this.estadistica.getPorcentajeVictorias()) + "%\n"
                    + "Racha Máxima de Victorias: " + this.estadistica.getRachaMaxima() + "\n\n";

            // 3. Agregamos apuesta favorita
            if (this.estadistica.getTipoMasJugado() != null) {
                textoVisual += "Apuesta Favorita: " + this.estadistica.getTipoMasJugado() + "\n";
            }

            txtReporte.setText(textoVisual);
        }

        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBounds(30, 60, 320, 180);

        add(scroll);
    }
     public void mostrarVentana() {
        setVisible(true);
    }


}
