package vista;

import javax.swing.*;
import modelo.GestorUsuario;
import launcher.ControladorDeJuego;

import java.awt.*;

public class VentanaLogin {
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");

    private final GestorUsuario gestor = new GestorUsuario();

    public VentanaLogin(){
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.GridLayout(3,2,15,15));

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);
        frame.add(new JLabel("")); // para el espcio visual del frame
        frame.add(btnIngresar);
        btnIngresar.addActionListener(e -> login());

    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




}
