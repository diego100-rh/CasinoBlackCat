package vista;
import Controlador.SessionController;
import modelo.Usuario;


import javax.swing.*;

public class VistaPerfil {
    private Usuario usuarioActual;

    public VistaPerfil(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    public void mostrarVentana(SessionController controlador) {

        JFrame frame = new JFrame("Mi Perfil " + usuarioActual.getNombre() + "Bienvenido denuevo!!");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nuevo Nombre:");
        lblNombre.setBounds(30, 70, 200, 30);
        frame.add(lblNombre);

        JTextField cajaNombrenv = new JTextField();
        cajaNombrenv.setBounds(30, 100, 200, 30);
        frame.add(cajaNombrenv);

        JLabel lblSaldoRecargar = new JLabel("Ingrese saldo a recargar $:");
        lblSaldoRecargar.setBounds(30, 140, 200, 30);
        frame.add(lblSaldoRecargar);

        JTextField cajasaldonv = new JTextField();
        cajasaldonv.setBounds(30, 170, 200, 30);
        frame.add(cajasaldonv);

        JButton btnmodificar = new JButton("Modificar");
        btnmodificar.setBounds(30, 220, 120, 30);
        frame.add(btnmodificar);

        JLabel lblslado = new JLabel("Saldo: " + controlador.getSaldoUsuario());

        btnmodificar.addActionListener(e -> {
            // 1. PROCESAR CAMBIO DE NOMBRE
            // Leemos directamente de TU caja de texto
            String nuevoNombre = cajaNombrenv.getText().trim();

            if (!nuevoNombre.isEmpty()) {
                controlador.actualizarNombreUsuario(nuevoNombre);
                JOptionPane.showMessageDialog(frame, "Nombre actualizado con éxito a: " + nuevoNombre);

                // Limpiamos tu caja de texto
                cajaNombrenv.setText("");
            }

            // 2. PROCESAR RECARGA DE SALDO
            // Leemos directamente caja de texto para el saldo
            String textoMonto = cajasaldonv.getText().trim();

            if (!textoMonto.isEmpty()) {
                try {
                    int montoRecarga = Integer.parseInt(textoMonto);
                    if (montoRecarga > 0) {
                        // Delegamos la recarga al controlador
                        controlador.recargarSaldo(montoRecarga);
                        JOptionPane.showMessageDialog(frame, "Recarga exitosa. Nuevo saldo: $" + controlador.getSaldoUsuario());

                        // Limpiamos tu caja de texto
                        cajasaldonv.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "El monto a recargar debe ser mayor a 0.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese un monto numérico válido.");
                }
            }

        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}