package modelo;

public class Resultado {

    private int numero;
    private int apuesta;
    private boolean victoria;


    public Resultado(int numero, int apuesta, boolean victoria) {
        this.numero = numero;
        this.apuesta = apuesta;
        this.victoria = victoria;
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


}
