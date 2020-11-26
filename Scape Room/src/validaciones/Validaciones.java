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
	
	public int obtenerPosicionMochila() {

			int opcion = 0;
		
			System.out.println("\nIngrese una posicion de la mochila donde esta el objeto que desea(Si no hay nada en esa posicion atacaras con tus puños)");
			opcion = leerValidarOpcion(0,4);
			
			return opcion;
	}

	public int mostrarObtenerOpcionInicial() {

		int opcion = 0;

		System.out.println("\nEstas en tu departamento que accion deseas realizar: ");
		System.out.println("0)Terminar la partida");
		System.out.println("1)Bajar al garaje");
		System.out.println("2)Ir al cementerio");
		System.out.println("3)Ir a la mansion abandonada");
		System.out.println("4)Ir a la gasolinera");
		System.out.println("5)Mirar contenido mochila");
		System.out.println("6)Ver tu estado");
		opcion = leerValidarOpcion(0,6);
		
		return opcion;
	}
	
	public int mostrarObtenerOpcionesGaraje() {

		int opcion = 0;

		System.out.println("\nEstas en el garaje huele un poco a goma todavia.¿Que quieres hacer? ");
		System.out.println("0)Subir al departamento");
		System.out.println("1)Inspeccionar coche");
		System.out.println("2)Registrar caja de herramientas");
		System.out.println("3)Mirar contenido mochila");
		System.out.println("4)Ver tu estado");
		opcion = leerValidarOpcion(0,4);
	
		return opcion;
	}
	
	public int mostrarObtenerOpcionesCementario() {

		int opcion = 0;
	
		System.out.println("\nTe encuentras en el cementerio y puedes realizar las siguietes acciones: ");
		System.out.println("0)Volver al departamento");
		System.out.println("1)Registrar tumba");
		System.out.println("2)Visita casetilla");
		System.out.println("3)Mirar contenido mochila");
		System.out.println("4)Ver tu estado");
		opcion = leerValidarOpcion(0,4);
		
		return opcion;
	}
	
	public int mostrarObtenerOpcionesRegistrarTumba() {

		int opcion = 0;
		
		System.out.println("\nVes enfrente 3 tumbas cual deseas inspeccionar: ");
		System.out.println("0)Volver atras");
		System.out.println("1)Tumba 1. Antonio Perez");
		System.out.println("2)Tumba 2. Ma u l Cor ez"); 
		System.out.println("3)Tumba 3. Romancio Gutierrez");
		opcion = leerValidarOpcion(0,3);
		
		return opcion;
	}
	
	public int mostrarObtenerOpcionesMansion() {

		int opcion = 0;

		System.out.println("\nTe encuentras en la mansion abandonada. ¿Qué quieres hacer? ");
		System.out.println("0)Volver al departamento");
		System.out.println("1)Registrar cocina");
		System.out.println("2)Subir al dormitorio");
		System.out.println("3)Salir al jardin");
		System.out.println("4)Bajar al sotano");
		System.out.println("5)Mirar contenido mochila");
		System.out.println("6)Ver tu estado");
		opcion = leerValidarOpcion(0,6);

		return opcion;
	}
	
	public int mostrarObtenerOpcionesDormitorio() {

		int opcion = 0;
		
		System.out.println("\nEstas en el dormitorio : ");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar armario");
		System.out.println("2)Registrar mesita de noche");
		System.out.println("3)Registrar cama");
		opcion = leerValidarOpcion(0,3);
		

		return opcion;
	}
	
	public int mostrarObtenerOpcionesJardin() {

		int opcion = 0;
	
		System.out.println("\nEstas en el jardin: ");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar cuartillo"); 
		System.out.println("2)Interactuar con planta"); 
		opcion = leerValidarOpcion(0,2);


		return opcion;
	}
	public int mostrarObtenerOpcionesSotano() {

		int opcion = 0;
		
		System.out.println("\nEstas en el sotano de la mansión, se respira un aire denso aquí dentro...");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar estanterías");
		System.out.println("2)Investigar pared desgastada");
		System.out.println("3)Investigar grifo goteando");
		System.out.println("4)Mirar contenido mochila");
		System.out.println("5)Ver tu estado");
		opcion = leerValidarOpcion(0,5);
		

		return opcion;
	}
	
	public int mostrarObtenerOpcionesGasolinera() {
		int opcion = 0;
		
		System.out.println("\nEstas en la gasolinera que deseas hacer: ");
		System.out.println("0)Volver al departamento");
		System.out.println("1)Registrar caja registradora"); 
		System.out.println("2)Revisar surtidores");
		System.out.println("3)Mirar coche en mal estado");
		System.out.println("4)Mirar Almacen de la gasolinera"); 
		System.out.println("5)Mirar contenido mochila");
		System.out.println("6)Ver tu estado");
		opcion = leerValidarOpcion(0,6);

		return opcion;
	}
	
	public int mostrarObtenerOpcionesAlmacenGasolinera() {

		int opcion = 0;

		System.out.println("\nEstas en el almacen de la gasolinera que deseas hacer: ");
		System.out.println("0)Volver al principio de la Gasolinera");
		System.out.println("1)Registrar zona"); 
		System.out.println("2)Revisar puerta extraña");
		System.out.println("3)Mirar contenido mochila");
		System.out.println("4)Ver tu estado");
		opcion = leerValidarOpcion(0,4);

		return opcion;
	}
	
	public int leerValidarOpcion(int rangoValido1, int rangoValido2) {
		
		Scanner teclado = new Scanner (System.in);
		int opcion = 0;
		
		do {
			opcion = teclado.nextInt();
			if(opcion < rangoValido1 || opcion > rangoValido2) {
				System.out.println("Error opcion no valida, por favor introduzca una valida("+rangoValido1+"-"+rangoValido2+")");
			}
		
		}while(opcion < rangoValido1 || opcion > rangoValido2);
		
		return opcion;
	}
}
