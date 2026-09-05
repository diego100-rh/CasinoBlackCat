package modelo;
import java.util.List;
import java.util.ArrayList;
public class GestorUsuario {
    private final List<Usuario> usuarios = new ArrayList<>();

    public GestorUsuario(){
        usuarios.add(new Usuario("admin","676767","Don Donnie"));
        usuarios.add(new Usuario("diego","lia","Diego Rifo"));
        usuarios.add(new Usuario("lia", "pollo", "lia"));
    }

    public String validarCredenciales(String a, String b){
        for(Usuario jugadores: usuarios){
            if (jugadores.validarCredenciales(a,b)){
                return jugadores.getNombre();
            }
        }
        return "";

    }

}
