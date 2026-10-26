package modelo;

public class ApuestaRojo extends ApuestaBase{

    public ApuestaRojo(int monto) {
        // Usamos super() para enviarle los datos al constructor de la madre
        super(monto, "Rojo");
    }
    // sobrescribiendo el método
    @Override
    public boolean acierta(int numero, String color) {
        //LA LOGICA DE VICTORIA DE ROJO
        return color.equalsIgnoreCase("Rojo");
    }
}
