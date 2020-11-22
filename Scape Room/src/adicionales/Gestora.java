package adicionales;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objetos.Objeto;

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
			oos.writeObject(new Objeto("Llave Puerta", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Pala", 15, "Quizás puedas desenterrar algo con ella o defenderte"));
			oos.writeObject(new Objeto("Gasolina", 0, "Igual puede servir como combustible"));
			oos.writeObject(new Objeto("Llave Coche", 0, "Vinculado con Audi R8"));
			oos.writeObject(new Objeto("Bateria", 0, "Tiene el tamaño perfecto para encajar en un automóvil"));
			oos.writeObject(new Objeto("Pistola", 50, "Ideal para defenderte en medio de un apocalipsis"));
			oos.writeObject(new Objeto("Navaja", 20, "A pesar de estar en malas condiciones aún conserva su filo"));
			oos.writeObject(new Objeto("Hacha", 30, "Te permitirá cotar y despedazar"));
			oos.writeObject(new Objeto("Regadera", 0, "Aún contiene agua"));
			oos.writeObject(new Objeto("Maceta", 5, "No esta en la mejor de las condiciones"));
			oos.writeObject(new Objeto("Dolares", 0, "La moneda de cambio mas popular, aunque no te serviara de mucho en un apocalipsis"));
			oos.writeObject(new Objeto("Llave laboratorio", 0, "Te permitira acceder al laboratorio"));
			oos.writeObject(new Objeto("Llave vieja", 0, "Esta vieja pero todavia funciona"));
			oos.writeObject(new Objeto("Mando TV", 0, "Ni siquiera tiene pilas"));
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
	/* EN CONSTRUCCIÓN*/
	public static void guardarObjetoUsuario(Objeto objeto, Jugador usuario, Validaciones validacion) {
		char respuesta=' ';
		int posicionMochila=0;
		if (usuario.cogerObjeto(objeto)) {

			System.out.println("El objeto ha sido equipado");

		} else {

			System.out.println("¿Quieres tirar algún objeto? Introduce 'S' para tirarlo o 'N' para no hacerlo");
			respuesta = validacion.leerValidarRespuesta();
			if (respuesta == 'S') {
				System.out.println("Estos son los objetos que tienes en tu inventario, introduce la posición del objeto que desea tirar");
				usuario.mirarContenidoMochila();
				posicionMochila = validacion.leerValidarPosicionMochila();
				usuario.tirarObjeto(posicionMochila);
				usuario.cogerObjeto(objeto);
			}

		}
	}
	
	/*
	 * 
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
			
			if(objetos.get(i).getNombre().equals(nombre) && objetos.get(i).getEquipado() == false) { //Si el nombre del objeto en la posicion i del ArrayList es igual al nombre recibido como parametro y ademas ese objeto no se ha cogido ya
				solicitado = objetos.get(i);
			}
		}
		return solicitado;
	}
}
