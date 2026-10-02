package Controlador;
import modelo.Usuario;

public class SessionController {
    private Usuario usuarioActual;

    public SessionController(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    // 1. Operación : La vista llamará a este método para modificar datos
    public void gestionarRecargaYPerfil(String nuevoNombre, int monto) {
        if (!nuevoNombre.isEmpty()) {
            this.usuarioActual.setNombre(nuevoNombre);
        }
        if (monto > 0) {
            this.usuarioActual.depositar(monto);
        }
    }
    // 2. Operaciones lectura: La vista pide los datos a través del controlador
    public int getSaldoUsuario() {
        return this.usuarioActual.getSaldo();
    }

    public int recargarSaldo(int montoRecarga){
        return this.usuarioActual.depositar(montoRecarga);

    }

    public String getNombreUsuario() {
        return this.usuarioActual.getNombre();
    }

    // Método para que la ruleta cobre la apuesta
    public void cobrarApuesta(int monto) {
        this.usuarioActual.descontarSaldo(monto);
    }

    // Método para que la ruleta de el premio
    public void pagarPremio(int montoGanado) {
        this.usuarioActual.depositar(montoGanado);
    }
    public void actualizarNombreUsuario(String nuevoNombre) {
        // Validamos que no envíen un texto vacío antes de molestar al Modelo
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.usuarioActual.setNombre(nuevoNombre);
        }
    }

}
