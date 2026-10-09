package vista;
import javax.swing.*;

import Controlador.SessionController; // Importamos el controlador, NO el modelo
import javax.swing.*;
import java.awt.*;

public class VistaPerfil {
    private SessionController sesion;

    // 2. El constructor ahora exige la sesión
    public VistaPerfil(SessionController sesion) {
        this.sesion = sesion;
    }

    public void mostrarVentana() {
            JFrame fr = new JFrame("Ruleta - Perfil");
            fr.setSize(400, 350); // Lo hacemos un poco más alto
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLayout(new GridLayout(6, 1, 10, 10));
            fr.add(new JLabel("Nuevo Nombre de usuario:"));
            JTextField cajanvNombre = new JTextField();
            JButton btnCambiarNombre = new JButton("Actualizar Nombre");

            fr.add(cajanvNombre);
            fr.add(btnCambiarNombre);
            fr.add(new JLabel("Ingresar monto a recargar $:"));
            JTextField cajasaldo = new JTextField();
            JButton btnRecargar = new JButton("Recargar Saldo");

            fr.add(cajasaldo);
            fr.add(btnRecargar);

            btnCambiarNombre.addActionListener(e -> {
                // Leemos el texto JUSTO CUANDO HACEN CLIC, esto fue lo que me salte antes
                String nuevoNombre = cajanvNombre.getText().trim();

                if (nuevoNombre.isEmpty()) {
                    JOptionPane.showMessageDialog(fr, "El nombre no puede estar vacío.");
                    return;
                }
                sesion.actualizarNombreUsuario(nuevoNombre);
                JOptionPane.showMessageDialog(fr, "¡Nombre actualizado con éxito a: " + nuevoNombre + "!");
                cajanvNombre.setText("");
            });

            btnRecargar.addActionListener(e -> {
                // Extraemos el texto de cajasaldo
                String texto = cajasaldo.getText().trim();

                if (texto.isEmpty()) {
                    JOptionPane.showMessageDialog(fr, "Por favor, ingresa un monto a recargar.");
                    return;
                }

                try {
                    int monto = Integer.parseInt(texto);

                    if (monto <= 0) {
                        JOptionPane.showMessageDialog(fr, "El monto a recargar debe ser mayor a $0.");
                        return;
                    }
                    sesion.recargarSaldo(monto);
                    JOptionPane.showMessageDialog(fr, "¡Recarga exitosa! Se han añadido $" + monto);
                    cajasaldo.setText(""); // Limpiamos la caja

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fr, "Error: Ingresa solo números enteros.");
                }
            });

            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
    }
}