package validaciones;

import java.util.Scanner;

public class Validaciones {
	
	public char leerValidarRespuesta() {
			
			Scanner teclado = new Scanner (System.in);
			char respuesta = ' ';
			
			do {
				respuesta = Character.toUpperCase(teclado.next().charAt(0));
				
				if(respuesta != 'S' && respuesta != 'N') {
					System.out.println("Error respuesta no valida, por favor introduzca una valida(S-N)");
				}
			
			}while(respuesta != 'S' && respuesta != 'N');
			
			return respuesta;
	}
	
	public int leerValidarPosicionMochila() {
			
			Scanner teclado = new Scanner (System.in);
			int opcion = 0;
			
			do {
				System.out.println("\nIngrese una posicion de la mochila donde esta el objeto que desea(No se tendra encuenta si no hay nada en dicha posicion)");
				opcion = teclado.nextInt();
				
				if(opcion < 0 || opcion > 4) {
					System.out.println("Error opcion no valida, por favor introduzca una valida(1-4)");
				}
				
				}while(opcion < 0 || opcion > 4);
			

			return opcion;
	}

	public int mostrarLeerValidarOpcionInicial() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en tu departamento que accion deseas realizar: ");
			System.out.println("0)Terminar la partida");
			System.out.println("1)Bajar al garaje");
			System.out.println("2)Ir al cementerio");
			System.out.println("3)Ir a la mansion abandonada");
			System.out.println("4)Ir a la gasolinera");
			System.out.println("5)Mirar contenido mochila");
			System.out.println("6)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 6) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-6)");
			}
			
			}while(opcion < 0 || opcion > 6);
		
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesGaraje() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en el garaje huele un poco a goma todavia.¿Que quieres hacer?: ");
			System.out.println("0)Subir al departamento");
			System.out.println("1)Inspeccionar coche");
			System.out.println("2)Registrar caja de herramientas");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 2) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-2)");
			}
		
		}while(opcion < 0 || opcion > 2);
		
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesCementario() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Te encuentras en el cementerio y puedes realizar las siguietes acciones: ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar tumba");
			System.out.println("2)Visita casetilla");
			System.out.println("3)Mirar contenido mochila");
			System.out.println("4)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 4) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-4)");
			}
		
		}while(opcion < 0 || opcion > 4);
		
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesRegistrarTumba() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Ves enfrente 3 tumbas cual deseas inspeccionar: ");
			System.out.println("0)Volver atras");
			System.out.println("1)Tumba 1. Antonio Perez");
			System.out.println("2)Tumba 2. Ma u l Cor ez"); 
			System.out.println("3)Tumba 3. Romancio Gutierrez");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 3) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-3)");
			}
		
		}while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesMansion() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Te encuentras en la mansion abandonada. ¿Qué quieres hacer? ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar cocina");
			System.out.println("2)Subir al dormitorio");
			System.out.println("3)Salir al jardin");
			System.out.println("4)Bajar al sotano");
			System.out.println("5)Mirar contenido mochila");
			System.out.println("6)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 6) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-6)");
			}
		
		}while(opcion < 0 || opcion > 6);

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

		return opcion;
	}
	
public int mostrarLeerValidarOpcionesGasolinera() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en la gasolinera que deseas hacer: ");
			System.out.println("0)Volver al departamento");
			System.out.println("1)Registrar caja registradora"); 
			System.out.println("2)Revisar surtidores");
			System.out.println("3)Mirar Almacen de la gasolinera"); 
			System.out.println("4)Mirar contenido mochila");
			System.out.println("5)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 5) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-5)");
			}
		
		}while(opcion < 0 || opcion > 5);

		return opcion;
	}
	
	public int mostrarLeerValidarOpcionesAlmacenGasolinera() {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Estas en el almacen de la gasolinera que deseas hacer: ");
			System.out.println("0)Volver al principio de la Gasolinera");
			System.out.println("1)Registrar zona"); 
			System.out.println("2)Revisar puerta extraña");
			System.out.println("4)Mirar contenido mochila");
			System.out.println("5)Ver tu estado");
			opcion = teclado.nextInt();
			
			if(opcion < 0 || opcion > 5) {
				System.out.println("Error opcion no valida, por favor introduzca una valida(0-5)");
			}
		
		}while(opcion < 0 || opcion > 5);

		return opcion;
	}
}
