/*
 * 
 * Ejercicio 4:  Realiza un minicuestionario con 3 preguntas tipo test sobre la asignatura de programación.
 *  Cada pregunta tiene 3 respuestas, pero solo una válida. Cada pregunta acertada sumará un punto. El programa mostrará al
 *   final la calificación obtenida.
 *	Ejemplo de pregunta tipo test.
 *	Cúal de estas sentencias genera un error:
 *	1 – int i = “1”;
 *	2 – int i = -1;
 *	3 – int i = (int)2.2;
 *	Respuesta: (el usuario tendría que responder aquí)
 * 
 */
package ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int correcta = 0,aciertos = 0, respuesta = 0;
		
		for(int i = 1; i < 4; i++) {
			
			switch(i) { 
			
			case 1:
				System.out.println("		---Primera pregunta---");
				System.out.println("¿Qué resultado se espera obtener al final?");
				System.out.println("int a=1\na=a++\nEscribir(a)\n");
				System.out.println("1)1");
				System.out.println("2)2");
				System.out.println("3)No compila");
				correcta=1;
			break;
			
			case 2:
				System.out.println("		---Segunda pregunta---");
				System.out.println("¿Es correcto el siguiente codigo?");
				System.out.println("int golesFavor = 1, golesContra = 4, diferenciaGoles\ndiferenciaGoles==golesFavor-golesContra");
				System.out.println("1)Si");
				System.out.println("2)No, hay que inicializar diferenciaGoles");
				System.out.println("3)No, se produce un error");
				correcta=3;
			break;
			
			case 3:
				System.out.println("		---Tercera pregunta---");
				System.out.println("¿Cuantas veces se repite el bucle?");
				System.out.println("for(int i = 0, i<10; i--)");
				System.out.println("1)10");
				System.out.println("2)Bucle infinito");
				System.out.println("3)9");
				correcta=2;
			break;
			}
			
			//Leer y Validar Respuesta
			do { 
				System.out.println("Seleccione una opcion(1-3)");
				respuesta=teclado.nextInt();
				
				if(respuesta<1 || respuesta>3) {
					System.out.println("Seleccione una opcion dentro del rango valido(1-3)");
				}
			}while(respuesta<1 || respuesta>3);
			
			if(correcta==respuesta) { //Se comprueba si la respuesta es correcta
				aciertos++;
			} else {
				System.out.println("Vaya la opcion correcta era "+correcta);
			}
		}
		
		System.out.println("Has acertado "+aciertos+"/3");
		teclado.close();
	}
}
