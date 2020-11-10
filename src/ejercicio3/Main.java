/*
 * 
 * Realiza un conversor de bitcoins a euros. La cantidad en bitcoins que se quiere convertir deberá estar almacenada 
 * en una variable. Buscar en internet el valor del euro respecto al bitcoin.
 * 
 */
package ejercicio3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		
		final double VALORBITCOIN=11232.75;
		double bitcoin  = 0, euros = 0;
		
		//Leer y Validar bitcoins
		do {
			
		System.out.println("Ingrese cuantos bitcoins tienes");
		bitcoin=teclado.nextDouble();
		
		}while(bitcoin < 0);
		
		//CalcularEuros
		euros=bitcoin*VALORBITCOIN;
		
		//MostrarResultado
		System.out.println("El valor de "+bitcoin+" bitcoin en euros es de: "+df.format(euros));
		
		teclado.close();//Se cierra el teclado
	}

}
