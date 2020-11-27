package Ejercicio8;
import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args){
        int numeroDeFilas=0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica cuantas filas quieres que tenga el triangulo");
        numeroDeFilas=teclado.nextInt();
        int acumuladorAux1=0, acumuladorAux2;
        for (int i = 0; i <= numeroDeFilas; i++) {
            acumuladorAux2 = 1;
            acumuladorAux1 = i + 1;
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    acumuladorAux2 = acumuladorAux2 * (acumuladorAux1 - j) / j;
                }
                System.out.print(acumuladorAux2 + " ");
            }
            System.out.println();
        }

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
        int numeroCombinativo=1;
        numero=enteroFactorial(numero);
        numero2=enteroFactorial(numero2);
        if(numero!=0) {
            numeroCombinativo = numero2 / numero;
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

        for (int i = 1; i <= numero; i++) {

            numeroFactorial *= i;

        }
        return numeroFactorial;
    }

}
