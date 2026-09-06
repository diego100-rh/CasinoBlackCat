package vista;
import javax.swing.*;
import java.awt.*;

import modelo.GestorUsuario;
import modelo.Usuario;

public class VentanaRegistro {
    private GestorUsuario gestor;

    public void mostrarVentana(){

        JFrame ventana = new JFrame("Casino BlackCat - Menú Principal");
        ventana.setSize(300, 350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(3, 1, 10, 20));

        JLabel titulo = new JLabel("Bienvenido",SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        JButton btnINombre = new JButton("Nombre: ");
        JTextField cajaNombre = new JTextField(20);

        JButton btnusuario = new JButton("Nombre de usuario: ");
        JTextField cajauser = new JTextField(20);

        JButton btnContraeña = new JButton("Contraseña: ");
        JTextField cajacontraseña = new JTextField(20);

        JButton btnregistro = new JButton("Registrar");

        btnregistro.addActionListener(e -> {
            // 1. Extraemos el texto de las cajas
            String textNombre = cajaNombre.getText().trim();
            String textouser = cajauser.getText().trim();
            String textpassword = cajacontraseña.getText().trim();

            Usuario nuevojugador = new Usuario(textouser,textpassword,textNombre);
            gestor.registrarUsuario(nuevojugador);
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
            //Volver a la ventana de inicio de sesión para ingresar con las nuevas credenciales
            ventana.dispose(); // Destruye la ventana de registro
            VentanaLogin ventanaLog = new VentanaLogin();
            ventanaLog.mostrarVentana();

        });


    }
}