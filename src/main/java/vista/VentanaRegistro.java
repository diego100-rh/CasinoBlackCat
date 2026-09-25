package vista;
import javax.swing.*;
import java.awt.*;

import modelo.GestorUsuario;
import modelo.Usuario;

public class VentanaRegistro {
    private GestorUsuario gestor;

    public void mostrarVentana(GestorUsuario gestorCompartido){
            this.gestor = gestorCompartido;

            JFrame ventana = new JFrame("Casino BlackCat - Registro");
            ventana.setSize(350, 450);
            // Usamos DISPOSE_ON_CLOSE para que si cierran esta ventana con la X, no se apague todo el programa
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Ajustamos la cuadrícula a 8 filas y 1 columna para que quepan todos tus elementos con holgura
            ventana.setLayout(new GridLayout(8, 1, 10, 10));

            JLabel titulo = new JLabel("Bienvenido", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            ventana.add(titulo); // Ahora sí agregamos el componente a la ventana

            ventana.add(new JLabel("Nombre:"));
            JTextField cajaNombre = new JTextField(20);
            ventana.add(cajaNombre);

            ventana.add(new JLabel("Nombre de usuario:"));
            JTextField cajauser = new JTextField(20);
            ventana.add(cajauser);

            ventana.add(new JLabel("Contraseña:"));
            JTextField cajacontraseña = new JTextField(20);
            ventana.add(cajacontraseña);

            JButton btnregistro = new JButton("Registrar");
            ventana.add(btnregistro);

            btnregistro.addActionListener(e -> {
                // Tu lógica original de captura de datos
                String textNombre = cajaNombre.getText().trim();
                String textouser = cajauser.getText().trim();
                String textpassword = cajacontraseña.getText().trim();

                // Validar que no envíen campos vacíos
                if (textNombre.isEmpty() || textouser.isEmpty() || textpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "Por favor, complete todos los campos.");
                    return;
                }

                Usuario nuevojugador = new Usuario(textouser, textpassword, textNombre);
                gestor.registrarUsuario(nuevojugador);

                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                ventana.dispose(); // Destruye la ventana de registro

                // Vuelve a abrir el login con la base de datos actualizada
                VentanaLogin ventanaLog = new VentanaLogin(this.gestor);
                ventanaLog.mostrarVentana();
            });

            // Estas dos instrucciones finales son obligatorias para que la ventana aparezca en el centro de tu monitor
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

    }
}