package modelo;

public class Resultado {
    private int numero;
    private int apuesta;
    private boolean victoria;
    private TipoApuesta tipoApuesta;



    public Resultado(int numero, int apuesta, boolean victoria, TipoApuesta tipoApuesta) {
        this.numero = numero;
        this.apuesta = apuesta;
        this.victoria = victoria;
        this.tipoApuesta = tipoApuesta;
    }
    public int getNumero() {
        return numero;
    }

    public int getApuesta() {
        return apuesta;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public TipoApuesta getTipoApuesta() {
        return this.tipoApuesta;
    }


}
