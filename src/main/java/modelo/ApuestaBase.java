package modelo;

public abstract class ApuestaBase {

    // Atributos comunes (usamos protected para que las subclases tengan acceso directo)
    protected int monto;
    protected String etiqueta;

    public ApuestaBase(int monto, String etiqueta) {
        this.monto = monto;
        this.etiqueta = etiqueta;
    }

    // Método Polimórfico abstracto: no tiene llaves {}, obliga a las hijas a implementarlo
    public abstract boolean acierta(int numero, String color);

    public int getMonto() { return monto; }
    public String getEtiqueta() { return etiqueta; }
}