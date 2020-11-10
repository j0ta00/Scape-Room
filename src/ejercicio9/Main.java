/*
 * 
 * Un ordenador se deprecia cada año un 40% sobre el valor del año anterior. 
 * Obtener un listado de la depreciación a lo largo de los años, suponiendo que por debajo de 300 
 * euros no se deprecia. La salida podría ser:
 * PRECIO ADQUISICIÓN 2000
 *	AÑOS VALOR_ORDENADOR
 *	1 1200
 *	2 720
 *	3 432
 *	4 259,2
 *	El ordenador se depreció en 4 años.
 *
 * 
 */
package ejercicio9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		final double DEPRECIO = 0.4;
		int precioOrdenador = 0, anho = 0;

		//Leer y Validar precio
		do {
			System.out.println("Ingrese el precio del ordenador");
			precioOrdenador = teclado.nextInt();
			
			if(precioOrdenador < 1) {
				System.out.println("El precio tiene que ser mayor que 0");
			}
			
		}while(precioOrdenador < 1);
		
		System.out.println("Precio Aquirido --> "+precioOrdenador);
		
		if(precioOrdenador <= 300) {
			
			System.out.println("El precio de su ordenador no bajara mas durante los proximos años");
			
		} else {
			
			while(precioOrdenador>300) {
				anho++;
				
				System.out.print("Año "+anho);
				precioOrdenador -= (precioOrdenador*DEPRECIO);
				
				System.out.println("   "+precioOrdenador);
				
			}
			System.out.println("El ordenador se depreció en "+anho+" años");
		}
		
		teclado.close();
	}

}
