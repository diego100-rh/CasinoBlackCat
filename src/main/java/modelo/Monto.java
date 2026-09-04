package modelo;

import java.util.Scanner;

public class Monto {

    public static int leerMontoApostado(Scanner in) {
        int monto =  0;
        boolean esValido = false;
        do {
            System.out.print("Ingrese el monto de la apuesta $: ");

            if (in.hasNextInt()){
                monto = in.nextInt();
                if (monto > 0){
                    esValido = true;
                } else {
                    System.out.println("Error: La apuesta debe ser mayor a $0.");
                }
            } else{
                // Si escribió letras o símbolos, cae aquí y evitamos que el programa colapse
                System.out.println("Error: Por favor ingrese solo números enteros.");
            }
            in.nextLine();
        }while (!esValido);
        return monto;
    }
}
