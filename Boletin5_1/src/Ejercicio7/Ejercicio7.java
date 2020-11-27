package Ejercicio7;
/*
*Nombre:Ejercicio7
* Declaración de variables:Tipo cadena: palabra=""
* PROGRAMA PRINCIPAL:
* INICIO
* Escribir("Introduce una palabra para ver si es un palíndromo")
* Leer Palabra
* Si (siPalindromo(cadena palabra==true))
*   Escribir("Si es un palíndromo")
* Fin_Si
* Si_No
*   Escribir("No es un palíndromo")
* Fin Si_No
*
* */
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args){
        String palabra="";
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce una palabra para ver si es un palíndromo");
        palabra=teclado.next();
        if(siPalindromo(palabra)){

            System.out.println("Si es un palindromo");

        }else{

            System.out.println("No es un palindromo");
        }

        /*Método para conocer si una palabra es un palíndromo
         *
         *Cabecera/Signatura:public static boolean siPalindromo(String palabra)
         *Descripción:Se trata de un método que nos devolverá si una palabra es un palíndromo o no
         *Entrada:String palabra
         *Salida:boolean siPalindromo
         *Precondiciones:
         *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato booleano
         *
         * */

    }
    public static boolean siPalindromo(String palabra){
        //Declaración de variables locales
        boolean siPalindromo=true;
        //Para que compara las letras para ver si se cumple que sean o no iguales
        for(int i=0;i<palabra.length()/2 && siPalindromo==true;i++){
            if(palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)){
                siPalindromo=false;

            }

        }
        return siPalindromo;
    }
}
