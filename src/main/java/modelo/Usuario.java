package modelo;
import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;
    private List<Resultado> historialJugadas;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.saldo = 0;
        this.historialJugadas = new ArrayList<>();
    }

    // Método para guardar una nueva jugada historial personal
    public void agregarResultadoAlHistorial(Resultado nuevoResultado) {
        this.historialJugadas.add(nuevoResultado);
    }

    // Getter para que el Controlador leea el historial cuando abra la ventana
    public List<Resultado> getHistorialJugadas() {
        return this.historialJugadas;
    }

    // Verifica si las credenciales ingresadas pertenecen al usuario
    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);

    }
    public String getNombre() {
        return nombre;
    }

    public int getSaldo(){return saldo;}

    public int depositar(int monto){
        if (monto > 0) {
            this.saldo += monto;
        }
        return this.saldo; // Solo devuelve el saldo actualizado
    }

    public int descontarSaldo(int monto){
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
        }
        return this.saldo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}