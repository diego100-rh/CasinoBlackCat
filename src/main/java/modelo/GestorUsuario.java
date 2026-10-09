package modelo;
import java.util.List;
import java.util.ArrayList;

public class GestorUsuario {
    private final List<Usuario> usuarios = new ArrayList<>();

    public GestorUsuario(){
        usuarios.add(new Usuario("admin","676767","Don Donnie"));
        usuarios.add(new Usuario("diego","lia","Diego Rifo"));
        usuarios.add(new Usuario("lia", "pollo", "lia Rifo"));

    }

    public Usuario validarCredenciales(String a, String b){
        for (Usuario u : usuarios) {
            // Llama al método de la clase Usuario para verificar
            if (u.validarCredenciales(a, b)) {
                return u; // Retorna el objeto Usuario si hay coincidencia
            }
        }
        return null;
    }
    public void registrarUsuario(Usuario nuevo) {
        usuarios.add(nuevo);
    }

}
