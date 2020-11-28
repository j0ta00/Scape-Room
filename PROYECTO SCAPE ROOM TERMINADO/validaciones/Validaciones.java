package validaciones;

import java.util.Scanner;

public class Validaciones {
	
	/*
	 * Prototipo: public char leerValidarRespuesta()
	 * 
	 * Comentario: Este metodo se encarga de leer y validar que la respuesta a una pregunta sea S o N
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: char respuesta
	 * 
	 * Precondiciones: Ninguna
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un caracter
	 * 					el cual a la salida del metodo tomar como valor S o N
	 * 
	 */
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
	
	/*
	 * Prototipo: public int obtenerPosicionMochila()
	 * 
	 * Comentario: Este metodo se encarga de leer una posicion de la mochila de un jugador y 
	 * 			   mediante otro metodo(leerValidarOpcion) validar que dicha posicion exista en la mochila
	 * 			   Ejemplo si el usuaior tiene 5 espacion en la mochila, las posiciones iran de 0-4.
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int posicion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int obtenerPosicionMochila() {

		int posicion = 0;
	
		System.out.println("\nIngrese una posicion de la mochila donde esta el objeto que desea(Si no hay nada en esa posicion se dentra en cuenta)");
		posicion = leerValidarOpcion(0,4);
		
		return posicion;
	}

	/*
	 * Prototipo: public int mostrarObtenerOpcionInicial() 
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones iniciales del juego y obtener una de estas opciones, 
	 *  		   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
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
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesGaraje()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un garaje y de obtener una de estas opciones,  
	 *  		   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesGaraje() {

		int opcion = 0;

		System.out.println("\nEstas en el garaje huele un poco a goma todavia. �Que quieres hacer? ");
		System.out.println("0)Subir al departamento");
		System.out.println("1)Inspeccionar coche Audi R8");
		System.out.println("2)Registrar caja de herramientas");
		System.out.println("3)Mirar contenido mochila");
		System.out.println("4)Ver tu estado");
		opcion = leerValidarOpcion(0,4);
	
		return opcion;
	}
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesCementario() 
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un cementerio y de obtener una de estas opciones,
 	 *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 *  
	 */
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
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesRegistrarTumba()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen de registrar tumbas y de obtener una de estas opciones, 
	 *  		   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran.
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesRegistrarTumba() {

		int opcion = 0;
		
		System.out.println("\nVes enfrente 3 tumbas son muy viejas y sus inscripciones est�n algo desgastadas, cual deseas inspeccionar: ");
		System.out.println("0)Volver atras");
		System.out.println("1)Tumba 1. D N LD TR  P");
		System.out.println("2)Tumba 2. D NIEL H RRIS"); 
		System.out.println("3)Tumba 3. EM LY T YL R");
		opcion = leerValidarOpcion(0,3);
		
		return opcion;
	}
	
	/*
	 * Prototipo: 
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en una mansion y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesMansion() {

		int opcion = 0;

		System.out.println("\nTe encuentras en la mansion abandonada. �Que quieres hacer? ");
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
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesDormitorio()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un dormitorio y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesDormitorio() {

		int opcion = 0;
		
		System.out.println("\nEstas en el dormitorio: ");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar armario");
		System.out.println("2)Registrar mesita de noche");
		System.out.println("3)Registrar cama");
		opcion = leerValidarOpcion(0,3);
		

		return opcion;
	}
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesJardin()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un jardin y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesJardin() {

		int opcion = 0;
	
		System.out.println("\nEstas en el jardin: ");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar cuartillo"); 
		System.out.println("2)Interactuar con planta"); 
		opcion = leerValidarOpcion(0,2);


		return opcion;
	}
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesSotano()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un sotano y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesSotano() {

		int opcion = 0;
		
		System.out.println("\nEstas en el sotano de la mansion, se respira un aire denso aqui dentro...");
		System.out.println("0)Volver a la entrada de la casa");
		System.out.println("1)Registrar estanterias");
		System.out.println("2)Investigar pared desgastada");
		System.out.println("3)Investigar grifo goteando");
		System.out.println("4)Mirar contenido mochila");
		System.out.println("5)Ver tu estado");
		opcion = leerValidarOpcion(0,5);
		

		return opcion;
	}
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesLaboratorio()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un laboratorio y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Niguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesLaboratorio() {

		int opcion = 0;

		System.out.println("\nEstas en una especie de laboratorio, huele como un hospital y las paredes son de un blanco muy pulcro ");
		System.out.println("0)Volver al s�tano de la mansi�n");
		System.out.println("1)Comprobar puerta vieja");
		System.out.println("2)Entrar en sala de desarrollo");
		System.out.println("3)Entrar en sala de espec�menes");
		System.out.println("4)Continuar por el pasillo");
		System.out.println("5)Entrar en oficina");
		System.out.println("6)Mirar contenido mochila");
		System.out.println("7)Ver tu estado");
		opcion = leerValidarOpcion(0,7);

		return opcion;
	}
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesGasolinera()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en una gasolinera y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
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
	
	/*
	 * Prototipo: public int mostrarObtenerOpcionesAlmacenGasolinera()
	 * 
	 * Comentario: Este metodo se encarga de mostrar las opciones que se tienen en un almacen de una gasolinera y de obtener una de estas opciones,  
     *			   ademas mediante el metodo leerValidarOpcion se leera y validara que la opcion a introducir sea una de las que se muestran
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: El metodo leerValidarOpcion debe funcionar de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
	public int mostrarObtenerOpcionesAlmacenGasolinera() {

		int opcion = 0;

		System.out.println("\nEstas en el almacen de la gasolinera que deseas hacer: ");
		System.out.println("0)Volver al principio de la Gasolinera");
		System.out.println("1)Registrar zona"); 
		System.out.println("2)Revisar puerta extra�a");
		System.out.println("3)Mirar contenido mochila");
		System.out.println("4)Ver tu estado");
		opcion = leerValidarOpcion(0,4);

		return opcion;
	}
	
	/*
	 * Prototipo: public int leerValidarOpcion(int rangoValido1, int rangoValido2)
	 * 
	 * Comentario: Este metodo se encarga de leer y validar dos numeros(opciones).
	 * 
	 * Entradas: int rangoValido1, int rangoValido2
	 * 
	 * Salidas: int opcion
	 * 
	 * Precondiciones: Niguna
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuelve un tipo de dato, en este caso un entero
	 * 
	 */
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
