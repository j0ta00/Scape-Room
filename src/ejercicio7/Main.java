/*
 * 
 *  Muestra los números múltiplos de 7 de 0 a 100.
 * 
 */

package ejercicio7;

public class Main {

	public static void main(String[] args) {
		
		for(int i = 7; i <= 100; i+=7) {
			
			if(i % 7 == 0) {
				System.out.print(i+"  ");
			}
		}
	}
}
