/*
 * 
 * Escribe un programa que muestre tu nombre por pantalla
 * 
 */
package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String nombre="";
		
		//LeerNombre
		System.out.println("Ingrese su nombre");
		nombre=teclado.nextLine();
		
		//MostrarResultado
		System.out.println("Tu nombres es: "+nombre);


	}

}
