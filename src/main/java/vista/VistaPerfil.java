package vista;
import javax.swing.*;

import Controlador.SessionController; // Importamos el controlador, NO el modelo
import javax.swing.*;

public class VistaPerfil {
    private SessionController sesion;

    // 2. El constructor ahora exige la sesión
    public VistaPerfil(SessionController sesion) {
        this.sesion = sesion;
    }

    public void mostrarVentana() {

        JFrame fr = new JFrame("Ruleta - Pefil");
        fr.setSize(400, 300);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




        //código de dibujar la ventana ...

        // Cuando necesites mostrar los datos en pantalla, se los pides a la sesión:
        // lblNombre.setText(this.sesion.getNombreUsuario());
        // lblSaldo.setText(String.valueOf(this.sesion.getSaldoUsuario()));

        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }
}