/*
 * 
 *   Muestra, utilizando un bucle, los 20 primeros números naturales de la siguiente forma:
 *						1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
 * 
 * 
 */
package ejercicio6;

public class Main {
	
	public static void main (String[] args) {
		
		final int NUMERO = 20;
		
		for(int i = 1; i < NUMERO; i++) {
			
			System.out.print(i+", ");
			
		}
		System.out.print(NUMERO);
	}
}

