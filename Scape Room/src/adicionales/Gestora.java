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
	
	public static void crearGuardarObjetos(String path) {
		
		ObjectOutputStream  oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(path));

			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
			oos.writeObject(new Objeto("Llave", 0, "Puede abrir algo interesante"));
						
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
	 * 
	 * Prototipo: public Objeto obtenerObjeto(String path, String nombre)
	 * 
	 * Comentario: Este metodo se encarga de buscar y coger todos objeto de tipo Objeto en un fichero y almacenarlos en un ArrayList.
	 * 			   (Se carga un fichero de Objeto en memoria)
	 * 
	 * Entradas: String path, String nombre
	 * 
	 * Salidas: ArrayList<Objeto> solicitados
	 * 
	 * Precondiciones: Path es la ruta del fichero por que debera de estar bien especificada
	 * 
	 * Postcondiciones: 
	 *  
	 */
	public static ArrayList<Objeto> obtenerObjetos(String path) {
		
		ArrayList<Objeto> solicitados = new ArrayList<Objeto>();
		Objeto objeto = null;
		ObjectInputStream  ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(path));
			
			while( (objeto = (Objeto)ois.readObject() ) != null ) {
				solicitados.add(objeto);
			}
	
		}catch(EOFException e){
			
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
	
	public static Objeto obtenerObjeto(ArrayList<Objeto> objetos, String nombre) {
		
		Objeto solicitado = null; 
		
		for(int i = 0; i < objetos.size() && solicitado == null; i++ ) {
			
			if(objetos.get(i).getNombre().equals(nombre) && objetos.get(i).getCogido() == false) {
				objetos.get(i).setCogido(true);
				solicitado = objetos.get(i);
			}
		}
		return solicitado;
	}
}
