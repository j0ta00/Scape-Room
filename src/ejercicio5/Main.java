/*
 * 
 *  Escribe un programa que nos diga el horóscopo a partir del día (número) y el mes de nacimiento (String). 
 *  Por ejemplo: Dime tu mes de nacimiento: enero  hay que trabajar en el programa con la cadena “enero”.
 * 
 */
package ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int dia = 0; 
		String mes = "";
		
		do {
			
			System.out.println("Ingrese su mes de nacimineto");
			mes = teclado.nextLine();
			mes=mes.toLowerCase();
			
		}while(!mes.equals("enero") && !mes.equals("febrero") && !mes.equals("marzo") && !mes.equals("abril") && !mes.equals("mayo")
			  && !mes.equals("junio") && !mes.equals("agosto") && !mes.equals("septiembre") && !mes.equals("octubre") && !mes.equals("noviembre")
			  && !mes.equals("diciembre"));
		
		do {
			
			System.out.println("Ingrese un dia de nacimiento");
			dia=teclado.nextInt();
			
		}while(dia < 1 || dia > 31);
		
		switch(mes) {
		
		case "enero": 
			
			if(dia > 20) {
				
				System.out.println("Acuario");
				
			} else  {
				
				System.out.println("Capricornio");
				
			}
			
		break;

		case "febrero": 
			
			if(dia > 18 && dia < 30) {
				
				System.out.println("Piscis");
				
			} else {
				
				if(dia < 21) {
					
				System.out.println("Acuario");
				
				} else {
					System.out.println("Ese dia no existe en este mes");
				}
				
			}
			
		break;
		
		case "marzo": 
			
			if(dia > 20) {
				
				System.out.println("Aries");
				
			} else {
				
				System.out.println("Piscis");
				
			}
			
		break;
		
		case "abril": 
			
			if(dia > 20 && dia < 31) {
				
				System.out.println("Tauro");
				
			} else {
				
				if(dia < 21) {
					
				System.out.println("Aries");
				
				} else {
					System.out.println("Ese dia no existe en este mes");
				}
				
			}
			
		break;
		
		case "mayo": 
			
			if(dia > 20 ) {
				
				System.out.println("Géminis");
				
			} else {
				
				System.out.println("Tauro");
				
			}
			
		break;
		
		case "junio": 
			
			if(dia > 21 && dia < 31) {
				
				System.out.println("Cancer");
				
			} else {
				
				if(dia < 22) {
					
				System.out.println("Geminis");
				
				} else {
					System.out.println("Ese dia no existe en este mes");
				}
				
			}
			
		break;
		
		case "julio": 
			
			if(dia > 22) {
				
				System.out.println("Leo");
				
			} else {
				
				System.out.println("Cancer");
				
			}
			
		break;
		
		case "agosto": 
			
			if(dia > 22) {
				
				System.out.println("Virgo");
				
			} else {
				
				System.out.println("Leo");
				
			}
			
		break;
		
		case "septiembre": 
			
			if(dia > 22 && dia < 31) {
				
				System.out.println("Libra");
				
			} else {
				
				if(dia < 23) {
					
				System.out.println("Virgo");
				
				} else {
					System.out.println("Ese dia no existe en este mes");
				}
				
			}
			
		break;
		
		case "octubre": 
			
			if(dia > 22) {
				
				System.out.println("Escorpio");
				
			} else {
				
				System.out.println("Libra");
				
			}
			
		break;
		
		case "noviembre": 
			
			if(dia > 22 && dia < 31) {
				
				System.out.println("Sagitario");
				
			} else {
				
				if(dia < 23) {
					
				System.out.println("Escorpio");
				
				} else {
					System.out.println("Ese dia no existe en este mes");
				}
				
			}
			
		break;
		
		case "diciembre": 
			
			if(dia > 21) {
				
				System.out.println("Capricornio");
				
			} else {
				
				System.out.println("Sagitario");
				
			}
			
		break;
		}
		teclado.close();//Se cierra el teclado
	}

}
