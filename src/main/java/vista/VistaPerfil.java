package vista;
import modelo.Usuario;


import javax.swing.*;

public class VistaPerfil {
    private Usuario usuarioActual;
    private final JButton btnfconfirmar = new JButton("Confirmar $");
    private final JPasswordField txtmontoNv = new JPasswordField(); // Nota: Usualmente los montos no se ocultan con JPasswordField, un JTextField es mejor a menos que sea un PIN.


    public VistaPerfil(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    public void mostrarVentana(JFrame frame, Usuario usuarioActual) {

        frame = new JFrame("Mi Perfil");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Usamos los métodos 'get' del objeto en lugar de variables sueltas
        JLabel lblBienvenida = new JLabel("Saldo: " + this.usuarioActual.getSaldo());
        lblBienvenida.setBounds(30, 20, 400, 30);
        frame.add(lblBienvenida);

        // Obtenemos el nombre directamente del objeto
        frame.add(new JLabel("Usuario:" + usuarioActual.getNombre()));
        frame.add(new JLabel(""));
        frame.add(new JLabel("Ingrese Monto a recargar $:"));
        frame.add(txtmontoNv);
        frame.add(new JLabel(""));
        frame.add(btnfconfirmar);

        // Aquí iría Action Listener para el botón
        /*
        btnfconfirmar.addActionListener(e -> {
            int montoRecarga = Integer.parseInt(txtmontoNv.getText());
            int nuevoSaldo = usuarioActual.getSaldo() + montoRecarga;
            usuarioActual.setSaldo(nuevoSaldo); // Modificas el atributo del objeto
        });
        */
    }
}