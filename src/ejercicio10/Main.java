/*
 *   Construye un programa que lea un número entero positivo y dibuje un triángulo empezando por un *, 
 *   la línea siguiente dos, y así sucesivamente hasta llegar al número leído. Por ejemplo, con 4 sería
 *
 *			*
 *			**
 *			***
 *			****
 *
 */
package ejercicio10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);

		int numero = 0;
		
		//Leer y Validar numero
		do {
			
			System.out.println("Ingrese cuantas filas quieres que tenga el triangulo");
			numero = teclado.nextInt();
			
			if(numero < 1) {
				System.out.println("El numero de filas tiene que ser mayor que 0");
			}
			
		}while(numero < 1);
		
		for(int i = 1; i <= numero; i++) {
			
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		teclado.close();
	}

}
