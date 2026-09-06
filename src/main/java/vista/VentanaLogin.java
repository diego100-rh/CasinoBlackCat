package vista;

import javax.swing.*;
import modelo.GestorUsuario;
import launcher.ControladorDeJuego;

import java.awt.*;

public class VentanaLogin {
    private GestorUsuario gestor;
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrarse");

    public VentanaLogin(GestorUsuario gestorExistente){
        this.gestor = gestorExistente;
        configurarVentana();

    }
    public void VentanaLogin() {
       this.gestor = new GestorUsuario();
       configurarVentana();
    }
    private void configurarVentana() {
        frame.setSize(350,200); // (ancho x alto)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // terminar completamente y liberar la memoria cuando se haga click en el
        // botón de cierre (X)
        frame.setLayout(new java.awt.GridLayout(4,2,15,15));
        // filas - columnas - separacion horizontal - separacion vertical

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);
        frame.add(new JLabel("")); // Espacio
        frame.add(btnIngresar);

        frame.add(btnRegistrar);
        btnIngresar.addActionListener(e -> login());

        }
    }




}
