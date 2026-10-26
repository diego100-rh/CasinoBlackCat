package modelo;

public class Resultado {
    private int numero;
    private int apuesta;
    private boolean victoria;
    private String etiquetaApuesta;



    public Resultado(int numero, int apuesta, boolean victoria, String etiquetaApuesta) {
        this.numero = numero;
        this.apuesta = apuesta;
        this.victoria = victoria;
        this.etiquetaApuesta = etiquetaApuesta;
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

    public String getTipoApuesta() {
        return etiquetaApuesta;
    }


}
