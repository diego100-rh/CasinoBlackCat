package vista;
import Controlador.SessionController;
import modelo.Usuario;


import javax.swing.*;

public class VistaPerfil {
    private Usuario usuarioActual;
    private final JButton btnfconfirmar = new JButton("Confirmar $");
    private final JPasswordField txtmontoNv = new JPasswordField(); // Nota: Usualmente los montos no se ocultan con JPasswordField, un JTextField es mejor a menos que sea un PIN.


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
            //captura de datos
            String textNombre = cajaNombrenv.getText().trim();
            String textosaldo = cajasaldonv.getText().trim();

            // Validar que no envíen campos vacíos
            if (textNombre.isEmpty() || textosaldo.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
                return;
            }
             try {
                 // Convertimos el texto del saldo a un número entero
                 int monto = Integer.parseInt(textosaldo);

                 controlador.gestionarRecargaYPerfil(textNombre, monto);

                 // 5. Actualizamos el JLabel para que el usuario vea el cambio
                 lblslado.setText("Saldo: " + controlador.getSaldoUsuario());
                 JOptionPane.showMessageDialog(frame, "Perfil actualizado correctamente.");

             } catch (NumberFormatException ex) {
            // atrapa el error si el usuario escribe letras en la caja de saldo
                 JOptionPane.showMessageDialog(frame, "Error: El saldo debe ser un número válido.");

             }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}