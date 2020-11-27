package Ejercicio8;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args){
        //Declaraciónde variables
        int numeroDeFilas=0;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la cantidad de filas que quieres que tenga la piramide");
        numeroDeFilas=teclado.nextInt();
        PiramideDeTartaglia(numeroDeFilas);

    }

    /*Método para pintar la piramide de tartaglia
     *
     *Cabecera/Signatura:
     *
     *Descripción:Se trata de un método que nos devolverá el número combinativo de dos números introducidos por el usuario
     *Entrada:int numeroDeFilas
     *Salida:
     *Precondiciones:
     *Postcondiciones:Se trata de un procedimiento y nos imprimirá en pantalla un triangulo de Tartaglia/Pascal
     *
     * */

    public static void PiramideDeTartaglia(int numeroDeFilas){

        for(int espaciosEnBlanco = numeroDeFilas-1,numerosPorFila=0; espaciosEnBlanco>=1; espaciosEnBlanco--, numerosPorFila += 1){
            //Para colocar los espacios en blanco
            for(int i=1;i<=espaciosEnBlanco;i++){
                System.out.print(" ");
            }

            //Para imprimir los numerosCombinativos por filas
            for(int j=0;j<=numerosPorFila;j++){
                System.out.print(numeroCombinativo(j,numerosPorFila)+" ");

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
