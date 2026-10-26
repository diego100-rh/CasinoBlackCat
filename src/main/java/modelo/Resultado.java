package modelo;

import GestorDeArchivos.GestorArchivos;

public class Resultado {
    private int numero;
    private int apuesta;
    private boolean victoria;
    private String etiquetaApuesta;
    private GestorArchivos archivos;



    public Resultado(int numero, int apuesta, boolean victoria, String etiquetaApuesta) {
        this.numero = numero;
        this.apuesta = apuesta;
        this.victoria = victoria;
        this.etiquetaApuesta = etiquetaApuesta;
        this.archivos = new GestorArchivos();
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
