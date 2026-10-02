package modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.saldo = saldo;
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

        if(monto>0 )  {
            this.saldo += monto;
        } else {

        }
        return saldo *= monto;
    }

    public int descontarSaldo(int monto){
        if(monto >0){
            this.saldo -= monto;

        }else {}
        return saldo -= monto;
    }


}