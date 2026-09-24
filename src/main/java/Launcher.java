import javax.swing.SwingUtilities;

public class Launcher {

    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> {
            VentanaLogin ventanaInicial = new VentanaLogin();
            ventanaInicial.mostrarVentana();
        });
    }

}
