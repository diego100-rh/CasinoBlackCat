package modelo;

public class ApuestaPar extends ApuestaBase{

    public ApuestaPar(int monto){
        super(monto,"Par");
    }

    @Override
    public boolean acierta(int numero, String color) {
        // Gana si el número no es 0 Y el resto de dividirlo por 2 es par
        return numero != 0 && numero % 2 == 0;
    }
}
