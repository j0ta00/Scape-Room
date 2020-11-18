package personajes;
import java.util.ArrayList;
import java.util.Arrays;

import objetos.Objeto;

public class Jugador extends Personaje {

	//Atributos
	private ArrayList<Objeto> mochila;
	private int movimientos;
	
	//Constructor por defecto
	public Jugador() {
		super();
		mochila = new ArrayList<Objeto>(Arrays.asList(null,null,null,null,null));
		movimientos = 0;
	}
	
	//Constructor con parametros
	public Jugador(String nombre, int vida, int danho, int movimientos) {
		super(nombre,vida,danho);
		mochila = new ArrayList<Objeto>(Arrays.asList(null,null,null,null,null));
		this.movimientos = movimientos;
	}
	
	//Metodos fundamentales
		//mochila
		public ArrayList<Objeto> getMochila(){
			ArrayList<Objeto> copia = (ArrayList<Objeto>) mochila.clone();
		return copia;
		}
		//movimientos
		public int getMovimientos() {
			return movimientos;
		}
		public void setMovimientos(int movimientos) {
			this.movimientos = movimientos;
		}
	//Metodos añadidos
		
		/*
		 * Prototipo: public void mirarContenidoMochila()
		 * 
		 * Comentario: Este metodo se encarga de mostrar los objetos de tipo Objetos que tiene un jugador en su mochila.
		 * 
		 * Entradas:
		 * 
		 * Salidas:
		 * 
		 * Precondiciones:
		 * 
		 * Postcondiciones:
		 * 
		 */
		public void mirarContenidoMochila() {
			
			for(Objeto o : mochila) {
				if(o != null) {
				System.out.println(o.toString());
				}
			}
			
		}
		
		/*

		public boolean comprobarEspacioMochila() {
			boolean espacio = false;
			
			for(int i = 0; i < mochila.size() && espacio == false; i++) {
				if(mochila.get(i) == null) {
					espacio = true;
				}
			}
			return espacio;
		}
		*/
		/*
		 * Prototipo:
		 * 
		 * Comentario:
		 * 
		 * Entradas:
		 * 
		 * Salidas:
		 * 
		 * Precondiciones:
		 * 
		 * Postcondiciones:
		 * 
		 */
		public void reducirMovimiento() {
			
			movimientos--;
			
		}
		
		/*
		 * Prototipo:
		 * 
		 * Comentario:
		 * 
		 * Entradas:
		 * 
		 * Salidas:
		 * 
		 * Precondiciones:
		 * 
		 * Postcondiciones:
		 * 
		 */
		public boolean cogerObjeto(Objeto nuevo) {
			boolean guardado = false;
			
			for(int i = 0; i < mochila.size() && guardado == false; i++) {
				if(mochila.get(i) == null) {
					mochila.set(i, nuevo);
					guardado = true;
				}
			}
			return guardado;
		}
		/*
		 * Prototipo: 
		 * 
		 * Comentario: 
		 * 
		 * Entradas:  
		 * 
		 * Salidas:  
		 * 
		 * Precondiciones: 
		 * 
		 * Postcondiciones: 
		 * 
		 */
		public int realizarAtaque(int posicionObjeto) {
			final int BONIFICACION = 2; //Valor que se multiplicara al ataque que realiza un Personaje cuando se produzca un critico
			int danhoFinal = getDanho()+mochila.get(posicionObjeto).getDanho();
			int critico = (int)(Math.random()*10+1);
			
			if(critico < 4){
				danhoFinal *= BONIFICACION;
			}
			return danhoFinal;
		}
	

}










