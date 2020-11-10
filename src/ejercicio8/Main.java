/*
 * 
 * Construye un programa que lea una serie de caracteres hasta que se introduzca un *, 
 * que indicará el fin de la entrada de datos (centinela). Una vez finalizada la entrada, emitirá un informe que nos diga cuántas 
 * letras mayúsculas se han introducido, cuantos signos de puntuación (.,;:-¿?¡!'), y cuantas veces se ha introducido el mismo carácter 
 * de forma consecutiva. El informe nos dirá el total de veces y el tanto por ciento. 
 * 
 */
package ejercicio8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		char caracter = ' ';
		String linea="";
		int contadorMayusculas = 0, contadorSignosPuntuacion = 0, contadorConsecutivo = 0, contadorRepetido = 1;
		
		//Leer y Validar caracter
		do{
			
			System.out.println("Ingrese un caracter(Para terminar * )");
			caracter = teclado.next().charAt(0);
			
			if(caracter!='*') {
				linea += caracter;
			}
			
		}while(caracter != '*');

		for(int i = 0; i < linea.length(); i++) {
		
			contadorRepetido = 1;
			
			if(linea.charAt(i) >= 'A' && linea.charAt(i) <= 'Z') {
				contadorMayusculas++;
			} else {
				
				if(linea.charAt(i) == '?' || linea.charAt(i) == '¿' || linea.charAt(i) == '-' || linea.charAt(i) == ':'
				   || linea.charAt(i) == ';' || linea.charAt(i) == ',' || linea.charAt(i) == '.'  || linea.charAt(i) == '!'
				   || linea.charAt(i) == '¡' || linea.charAt(i) == '\'') {
					contadorSignosPuntuacion++;
				}
				
			}
			
			for(int k = i+1; k < linea.length(); k++) {
				
				if(linea.charAt(i) == linea.charAt(k)) {
					contadorRepetido++;
				}
				
			}
			
			System.out.println("El caracter "+linea.charAt(i)+" se introdujo un total de "+contadorRepetido+10+"%");
			
			for(int j = i+1; j < linea.length() && linea.charAt(i) == linea.charAt(j); j++) {
				contadorConsecutivo++;
			}
			
			if(contadorConsecutivo > 0) {
				//MostrarResultado
				System.out.println("El caracter "+linea.charAt(i)+" se introdujo de forma seguida "+contadorConsecutivo);
				contadorConsecutivo = 0;
			}
			
		}
		//MostrarResultado
		System.out.println("Has introducido un total de "+linea.length()+" de caracteres");
		System.out.println("Has introducido un total de "+contadorMayusculas+" de letras mayusculas");
		System.out.println("Has introducido un total de "+contadorSignosPuntuacion+" de signos de puntuacion");
		
		teclado.close();
	}

}
