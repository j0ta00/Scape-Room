package Ejercicio6;
import java.util.Scanner;
public class Ejercicio6 {

    public static void main(String[] args){
        //Declaración de variables
        int numero=0, numero2=0;
        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce el primer número recuerda que deberá ser menor que el siguiente que introducirás");
            numero = teclado.nextInt();
            System.out.println("Introduce el segundo número recuerda que deberá ser mayor que el anterior");
            numero2 = teclado.nextInt();
        }while(numero>=numero2);
        System.out.println("El número combinativo sería "+numeroCombinativo(numero,numero2));

    }
    /*Método para conocer el núemro combinativo de dos números
     *
     *Cabecera/Signatura: public static int numeroCombinativo(int numero, int numero2)
     *Descripción:Se trata de un método que nos devolverá el número combinativo de dos números introducidos por el usuario
     *Entrada:int numero, numero2
     *Salida:int numeroCombinativo
     *Precondiciones:
     *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato entero
     *
     * */

    public static int numeroCombinativo(int numero, int numero2){
        //Declaración de variables locales
        int numeroCombinativo=1,numeroFinal=0,numeroFinal2=0;
        numeroFinal=enteroFactorial(numero);
        numeroFinal2=enteroFactorial(numero2);
        if(numeroFinal==1){

            numeroCombinativo=numero2;

        }else if((numeroFinal*(numeroFinal2-numeroFinal)!=0)){

            numeroCombinativo = numeroFinal2/(numeroFinal*(enteroFactorial((numero2-numero))));
        }
        return numeroCombinativo;
    }

    /*Método para conocer el Factorial de un número
     *
     *Cabecera/Signatura: public static int enteroFactorial(int numero)
     *Descripción:Se trata de un método que nos devolverá el número factorial de un número introducido por el usuario
     *Entrada:int numero
     *Salida:int numeroFactorial
     *Precondiciones:
     *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato entero
     *
     * */

    public static int enteroFactorial(int numero){
        //Declaración de variables locales
        int numeroFactorial=numero;

        for (int i = 1; i < numero; i++) {

            numeroFactorial *= i;

        }
        return numeroFactorial;
    }

}

