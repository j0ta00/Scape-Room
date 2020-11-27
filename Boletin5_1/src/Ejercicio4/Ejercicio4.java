package Ejercicio4;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args){
        //Declaración de variables
        int numero=0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número y te dire el siguiente número primo");
        numero=teclado.nextInt();
        //Repetir mientras el numero no sea primo y aumentarlo si no lo es
        do {

            numero++;

        }while(siPrimo(numero)==false);
        //Imprimir el número primo
        System.out.println(numero);
        teclado.close();

    }
    /*Método para conocer si un numero es primo
    *
    *Cabecera/Signatura: public static boolean siPrimo(int numero)
    *Descripción:Se trata de un método que nos devolverá si un número es o no primo
    *Entrada:int numero
    *Salida:boolean primo
    *Precondiciones:
    *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato booleano
    *
    * */
    public static boolean siPrimo(int numero){
        //Declarar variables locales
        boolean primo=false;
            for (int i = 2; i <= (numero/ 2); i++) {

                if (numero % i != 0 && i != 1) {

                    primo = true;

                }
            };
        return primo;


    }
}
