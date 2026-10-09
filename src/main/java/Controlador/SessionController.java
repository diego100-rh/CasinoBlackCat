package Controlador;
import modelo.Resultado;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class SessionController {
    private Usuario usuarioActual;

    public SessionController(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    //  Operaciones lectura: La vista pide los datos a través del controlador
    public int getSaldoUsuario() {
        return this.usuarioActual.getSaldo();
    }

    public int recargarSaldo(int montoRecarga){
        return this.usuarioActual.depositar(montoRecarga);

    }
    // Método para que la ruleta cobre la apuesta
    public void cobrarApuesta(int monto) {
        this.usuarioActual.descontarSaldo(monto);
    }

    // Método para la ruleta de el premio
    public void pagarPremio(int montoGanado) {
        this.usuarioActual.depositar(montoGanado);
    }

    public void actualizarNombreUsuario(String nuevoNombre) {
        // Validamos que no envíen un texto vacío antes de molestar al Modelo
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.usuarioActual.setNombre(nuevoNombre);
        }
    }
    public List<Resultado> getHistorialUsuario() {
        return this.usuarioActual.getHistorialJugadas();
    }

    public String getNombreUsuario() {return this.usuarioActual.getNombre();
    }
}
