package modelo;

public class EvaluadorApuesta {
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
        switch (tipo) {
            case 'R':
                return esRojo(numero);
            case 'N':
                return !esRojo(numero); // recordar que "!" significa "NO". Gana si NO es rojo.
            case 'P':
                return (numero % 2 == 0); // Gana si es par
            case 'I':
                return (numero % 2 != 0); // Gana si es impar
            default:
                return false; // letra rara false
        }
    }
    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) ;
            {
                return true;
            }
        }
        return false;
    }

}
