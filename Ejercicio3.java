package clase3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main (String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int num1 = input.nextInt();

        System.out.println("Ingrese el segundo numero");
        int num2 = input.nextInt();

        int multiplicacion = retornarMultiplicacion(num1, num2);
        System.out.println("La multiplicacion de los numeros es " + multiplicacion);
    }

    public static int retornarMultiplicacion(int numero1,int numero2){
        return numero1 * numero2;
    }
}
