package validaciones;

import java.util.Scanner;

public class Validaciones {
	
	public char leerValidarRespuesta() {
			
			Scanner teclado = new Scanner (System.in);
			char respuesta = ' ';
			
			do {
				respuesta = Character.toLowerCase(teclado.next().charAt(0));
				
				if(respuesta != 'S' && respuesta != 'N') {
					System.out.println("Error respuesta no valida, por favor introduzca una valida(S-N)");
				}
			
			}while(respuesta != 'S' && respuesta != 'N');
			
			teclado.close();
			return respuesta;
	}

	public int mostrarLeerValidarOpcionInicial() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en tu departamento tienes 4 sitios a donde ir: ");
			System.out.println("0)Terminar la partida");
			System.out.println("1)Ir al garaje");
			System.out.println("2)Ir al cementerio");
			System.out.println("3)Ir a la mansion abandonada");
			System.out.println("4)Ir a la gasolinera");
			System.out.println("5)Mirar contenido mochila");
			System.out.println("6)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 1 || opcion > 4) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(1-4)");
			}
			
			}while(opcion < 1 || opcion > 4);
		
		teclado.close();
		return opcion;
	}
	public int leerValidarPosicionMochila(){
		
		Scanner teclado = new Scanner(System.in);
		int posicionMochila=0;
		
		do{
			posicionMochila = teclado.nextInt();

			if(posicionMochila<0 || posicionMochila> 4) {
				
				System.out.println("Error respuesta no valida, por favor introduzca una valida(S-N)");
				
			}
		}while(posicionMochila<0 || posicionMochila>4);

		return posicionMochila;
	}
	
	public int mostrarLeerValidarOpcionesCementario() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Te encuentras en el cementerio y tienes : ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar tumba");
			System.out.println("2)Leer nota");
			System.out.println("3)Visita casetilla");
			System.out.println("4)Mirar contenido mochila");
			System.out.println("5)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 3) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
			}
		
		}while(opcion < 0 || opcion > 3);
		
		teclado.close();
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesRegistrarTumba() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Ves enfrente 3 tumbas cual deseas inspeccionar: ");
			System.out.println("0)Volver atras");
			System.out.println("1)Tumba 1. Antonio Perez");
			System.out.println("2)Tumba 2.  Perez"); 
			System.out.println("3)Tumba 3. Antonio ");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 3) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
			}
		
		}while(opcion < 0 || opcion > 3);
		
		teclado.close();
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesMansion() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Te encuentras en la mansion abandonada y tienes : ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar cocina");
			System.out.println("2)Registrar dormitorio");
			System.out.println("3)Salir al jardin");
			System.out.println("4)Bajar al sotano");
			System.out.println("5)Mirar contenido mochila");
			System.out.println("6)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 3) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
			}
		
		}while(opcion < 0 || opcion > 3);
		
		teclado.close();
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesRegistrarDormitorio() {
			
			Scanner teclado = new Scanner (System.in);
			int opcion = 0;
			
			do {
				System.out.println("Estas en el dormitorio : ");
				System.out.println("0)Volver a la entrada de la casa");
				System.out.println("1)Registrar armario");
				System.out.println("2)Registrar mesita de noche");
				System.out.println("3)Registrar cama");
				opcion = teclado.nextInt();
				
				if(opcion < 0 || opcion > 3) {
					System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
				}
			
			}while(opcion < 0 || opcion > 3);
			
			teclado.close();
			return opcion;
	}
	
	public int mostrarLeerValidarOpcionesRegistrarJardin() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en el jardin: ");
			System.out.println("0)Volver a la entrada de la casa");
			System.out.println("1)Registrar cuartillo"); //Regadera
			System.out.println("2)Observar plantas"); //Planta con regadera te ataca 
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 2) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-2)");
			}
		
		}while(opcion < 0 || opcion > 2);
		
		teclado.close();
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesGasolinera() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en la gasolinera que deseas hacer: ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar caja registradora"); 
			System.out.println("2)Inspeccionar interior de la gasolinera");
			System.out.println("3)Revisar surtidores");
			System.out.println("4)Mirar contenido mochila");
			System.out.println("5)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 3) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
			}
		
		}while(opcion < 0 || opcion > 3);
		
		teclado.close();
		return opcion;
	}
}
