package adicionales;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objetos.Objeto;
import personajes.Jugador;
import personajes.Personaje;
import validaciones.Validaciones;

public class Gestora {
	
	/*
	 * Prototipo: public static void crearGuardarObjetos(String path)
	 * 
	 * Comentario: Este metodo se encarga de crear y guardar en un fichero una lista de objetos de tipo Objeto.
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Path es la ruta del fichero por que debera de estar bien especificada
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento por lo que no devolvera ningun tipo de dato,
	 * 					solo creara una serie de objetos de tipo Objeto y los escribira en un fichero
	 * 
	 */
	public static void crearGuardarObjetos(String path) {
		
		ObjectOutputStream  oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(path));

			//Creacion de los objetos, que van ha salir en el juego
			oos.writeObject(new Objeto("Llave puerta", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Pala", 15, "Quizas puedas desenterrar algo con ella o defenderte"));
			oos.writeObject(new Objeto("Gasolina", 0, "Igual puede servir como combustible"));
			oos.writeObject(new Objeto("Llave coche", 0, "Vinculado con Audi R8"));
			oos.writeObject(new Objeto("Bateria", 0, "Tiene el tama�o perfecto para encajar en un automovil"));
			oos.writeObject(new Objeto("Pistola", 50, "Ideal para defenderte en medio de un apocalipsis"));
			oos.writeObject(new Objeto("Navaja", 20, "A pesar de estar en malas condiciones aun conserva su filo"));
			oos.writeObject(new Objeto("Hacha", 30, "Te permitira cotar y despedazar"));
			oos.writeObject(new Objeto("Regadera", 0, "Aun contiene agua"));
			oos.writeObject(new Objeto("Dolares", 0, "La moneda de cambio mas popular, aunque no te serviara de mucho en un apocalipsis"));
			oos.writeObject(new Objeto("Llave laboratorio", 0, "Te permitira acceder al laboratorio"));
			oos.writeObject(new Objeto("Llave vieja", 0, "Esta vieja pero todavia funciona"));
			oos.writeObject(new Objeto("Zapato usado", 0, "No huele muy bien pero �Donde esta el otro?"));
			oos.writeObject(new Objeto("Taza", 1, "Perfecta para hacerte un ColaCao"));
		
		}catch(IOException i) {
			i.printStackTrace();
		}finally {
			
			try {
				oos.close();//Se cierra fichero de escritura
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
	}
	
	/*
	 * Prototipo: public static ArrayList<Objeto> obtenerObjetos(String path)
	 * 
	 * Comentario: Este metodo se encarga de buscar y coger todos objeto de tipo Objeto de un fichero y almacenarlos en un ArrayList.
	 * 			   (Se carga un fichero de Objeto en memoria)
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: ArrayList<Objeto> solicitados
	 * 
	 * Precondiciones: Path es la ruta del fichero por que debera de estar bien especificada
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion por lo que devolvera un tipo de dato, en este caso un ArrayList<Objeto>
	 * 					que contendra todos los objetos de tipo Objeto que hay en un fichero
	 *  
	 */
	public static ArrayList<Objeto> obtenerObjetos(String path) {
		
		ArrayList<Objeto> solicitados = new ArrayList<Objeto>();
		Objeto objeto = null;
		ObjectInputStream  ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(path));
			
			while( (objeto = (Objeto)ois.readObject() ) != null ) { //Mientras no se ha fin de fichero
				solicitados.add(objeto); //Se guarda el objeto en
			}
	
		}catch(EOFException e){
			//Cuando se lee un fichero con ObjectInputStream y se llega a fin de fichero se lanza una excepcion EOFException
		}catch(IOException | ClassNotFoundException i ) {
			i.printStackTrace();
		}finally {
			
			try {
				ois.close();//Se cierra el fichero de lectura
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
		return solicitados;
	}
	
	/*
	 * 
	 * Prototipo: public static Objeto obtenerObjeto(ArrayList<Objeto> objetos, String nombre)
	 * 
	 * Comentario: Este metodo se encarga de coger un objeto de tipo Objeto de un ArrayList de Objeto
	 * 
	 * Entradas: ArrayList<Objeto> objetos, String nombre
	 * 
	 * Salidas: Objeto solicitado
	 * 
	 * Precondiciones: Nombre debe ser el de un objeto que haya en el ArrayList sino se devolvera Null(Vacio)
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion por lo que devolvera un tipo de dato, en este caso un Objeto que sera 
	 * 					uno segun el nombre especificado como parametro formal
	 *  
	 */
	public static Objeto obtenerObjeto(ArrayList<Objeto> objetos, String nombre) {
		
		Objeto solicitado = null; 
		
		for(int i = 0; i < objetos.size() && solicitado == null; i++ ) { //Mientras haya objetos que mirar en el ArrayList y no se haya encontrado el objeto deseado
			
			if(objetos.get(i).getNombre().equals(nombre)) { //Si el nombre del objeto en la posicion i del ArrayList es igual al nombre recibido como parametro
				solicitado = objetos.get(i);
			}
		}
		return solicitado;
	}

	/*
	 * Prototipo: public static void iteracionUsuarioConObjeto(Objeto objeto, Jugador usuario)
	 * 
	 * Comentario: Este metodo se encarga de preguntar al usuario si desea coger un objeto y si es asi se guardara en el inventario y si 
     * 			   si este esta lleno se podra tirar otro objeto para hacer sitio al nuevo objeto
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: Ninguna 
	 * 
	 * Entradas/Salidas: Objeto objeto, Jugador usuario(El atributo equipado del objeto puede variar y la mochila del usuario tambien)
	 * 
	 * Precondiciones: Ninguna
	 * 
	 * Postcondiciones:Este metodo se trata de un procedimiento, en el cual se guardara un objeto en la mochila del usuario si este lo desea.
	 * 
	 */
	public static void iteracionUsuarioConObjeto(Objeto objeto, Jugador usuario) {
		char respuesta = ' ';
		int posicionMochila = 0;
		Validaciones validacion = new Validaciones();
	
		System.out.println("Has encontrado el siguiente objeto: "+objeto.getNombre());
		System.out.println("�Quieres cogerlo?");
		respuesta = validacion.leerValidarRespuesta();
		
		if(respuesta == 'S') {
			if (usuario.cogerObjeto(objeto)) { //Si se puede coger el objeto porque se tiene sitio en la mochila
				System.out.println("El objeto ha sido equipado");
	
			} else {
				System.out.println("Tienes el inventario lleno");
				System.out.println("�Quieres tirar algun objeto? Introduce 'S' para tirarlo o 'N' para no hacerlo");
				respuesta = validacion.leerValidarRespuesta();
				
				if (respuesta == 'S') {
					System.out.println("Estos son los objetos que tienes en tu inventario: ");
					usuario.mirarContenidoMochila(); //Muestra el contenido de la mochila del jugador
					posicionMochila = validacion.obtenerPosicionMochila(); //Lee la posicion del objeto a tirar
					System.out.println("Has tirado el objeto, puede ser que haya vuelto al lugar de origen");
					usuario.tirarObjeto(posicionMochila); //Se tira dicho objeto
					usuario.cogerObjeto(objeto); //Se guarda el nuevo objeto
				}
			}
		}else {
			System.out.println("Has dejado el objeto donde estaba");
		}
	}
	
	/*
	 * Prototipo: public static void combateJugadorEnemigo(Personaje enemigo,Jugador usuario )
	 * 
	 * Comentario: Este metodo se encarga de realizar un combate entre el usuario y un enemigo que solo acabara cuando
	 *			   la vida de alguno de los dos llegue a 0
	 * 
	 * Entradas: Ninguna 
	 * 
	 * Salidas: Ninguna
	 * 
	 * Entradas/Salida: Personaje enemigo, Jugador usuario(Se modificara la vida tanto del usuario como del enemigo)
	 * 
	 * Precondiciones: Tanto el enemigo como el usuario no pueden estar a vacios(null), sino se producira una excepcion
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento, solo se modificara la vida del enemigo y el usuario
	 * 
	 */
	public static void combateJugadorEnemigo(Personaje enemigo,Jugador usuario ) {
		Validaciones validacion = new Validaciones();
		
		int ataqueUsuario = 0, ataqueEnemigo = 0, posicionMochila = 0;
		char respuesta = ' ';
		do {
			//LeerValidar respuesta(En este caso sera la forma de atacar al enemigo)
			System.out.println("Quieres usar un objeto de tu mochila para atacar al enemigo(S), si dices que no prepara tus pu�os(N)");
			respuesta = validacion.leerValidarRespuesta();
			
			if(respuesta == 'S') {
				
				System.out.println("Miras rapido el contenido de tu mochila a ver si tienes algo util");
				usuario.mirarContenidoMochila(); //Mostrar contenido de la mochila del usuairo
				posicionMochila = validacion.obtenerPosicionMochila();//Se selecciona el lugar en la mochila donde esta el objeto que quiere usar
				ataqueUsuario = usuario.realizarAtaque(posicionMochila);//Usuario realiza un ataque en funcion del objeto que ha seleccionado, si no hay nada en esa posicion se tendra en cuenta y se atacara solo con el da�o base
				
			}else {
				ataqueUsuario = usuario.realizarAtaque();//Ataque sin usar ningun objeto, solo con su da�o base
			}
			
			//Resultado ataque usuario
			System.out.println("Has realizado un ataque de "+ataqueUsuario);
			enemigo.recibirDanho(ataqueUsuario);
			
			if(enemigo.getVida() > 0) { //Si el enemigo esta vivo
				
				//Resultado ataque enemigo
				ataqueEnemigo = enemigo.realizarAtaque();
				System.out.println("Has recibido un ataque de "+enemigo.getNombre()+" de "+ataqueEnemigo);
				usuario.recibirDanho(ataqueEnemigo);
			}
			
			System.out.println(usuario.getNombre()+" tu vida es de: "+usuario.getVida());
			System.out.println("La vida de "+enemigo.getNombre()+" es de: "+enemigo.getVida()+"\n");
			
		}while(enemigo.getVida() > 0 && usuario.getVida() > 0);
	}
}
