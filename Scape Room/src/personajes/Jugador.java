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
			@SuppressWarnings("unchecked")
			ArrayList<Objeto> copia = (ArrayList<Objeto>) mochila.clone(); //El compilador marca como Type safety: Unchecked cast from Object to ArrayList<Objeto> poque cree que puede se puede llegar a producir un error por ello, por eso el de arriba @SuppressWarnings("unchecked") para comunicarle al compilador que lo que se va hacer es seguro
		return copia;
		}
		//movimientos
		public int getMovimientos() {
			return movimientos;
		}
		public void setMovimientos(int movimientos) {
			if(movimientos < 1) {
				this.movimientos = 0;
			}else {
				this.movimientos = movimientos;
			}
		}
	//Metodos añadidos
		
		/*
		 * Prototipo: public void mirarContenidoMochila()
		 * 
		 * Comentario: Este metodo se encarga de mostrar el contenido que tiene un Jugador en su mochila tanto si tiene un objeto 
		 * 			   como sino.
		 * 
		 * Entradas: Ninguna
		 * 
		 * Salidas: Ninguna
		 * 
		 * Precondiciones: Ninguna
		 * 
		 * Postcondiciones: Este metodo al ser un procedimiento no devolvera ningun tipo de dato, en este caso solo mostrara los 
		 * 					objetos de tipo Objeto que tiene un Jugador en su mochila y tambien los espacios libres si los hay
		 * 
		 */
		public void mirarContenidoMochila() {
			
			System.out.print("Contenido de la mochila ---> ");
			
			for(int i = 0; i < mochila.size(); i++) {
				if(mochila.get(i) != null) {
					System.out.print("  ["+ i+"] "+ mochila.get(i).toString());
				}else {
					System.out.print("  ["+ i+"]"+ " Espacio libre");
				}
			}	
			System.out.println();
		}
		
		/*
		 * Prototipo: public void reducirMovimiento()
		 * 
		 * Comentario: Este metodo se encarga de reducir los movimientos de un objeto Jugador
		 * 
		 * Entradas: Niguna
		 * 
		 * Salidas: Ninguna
		 * 
		 * Precondiciones: Ninguna
		 * 
		 * Postcondiciones: Este metodo no devolvera ningun tipo de dato ya que se trata de un procedimiento, 
		 * 					solo reducira los movimientos de un Jugador
		 * 
		 */
		public void reducirMovimiento() {
			setMovimientos(movimientos-1);
		}
		
		
		/*
		 * Prototipo: public boolean cogerObjeto(Objeto nuevo)
		 * 
		 * Comentario: Este metodo se encarga de guardar un objeto de tipo Objeto en la mochila(ArrayList<Objeto>) de un Jugador
		 * 
		 * Entradas: Objeto nuevo
		 * 
		 * Salidas: boolean guardado
		 * 
		 * Precondiciones: Ninguna
		 * 
		 * Postcondiciones: Este metodo devolvera en este caso un tipo de dato boolean(guardado) ya que se trata de una funcion. 
		 * 					Dicho dato booleano tendra dos posibilidades:
		 * 						-True: Cuando en la mochila haya sitio y se guarde el Objeto recibido como parametro formal
		 * 						-False: Cuando en la mochila no haya sitio y por lo tanto no se pueda guardar en Objeto recibido como parametro formal
		 * 
		 */
		public boolean cogerObjeto(Objeto nuevo) {
			boolean guardado = false;
			
			for(int i = 0; i < mochila.size() && guardado == false; i++) {
				if(mochila.get(i) == null) {
					nuevo.setEquipado(true);
					mochila.set(i, nuevo);
					guardado = true;
				}
			}
			return guardado;
		}
		

		/*
		 * Prototipo: public Objeto tirarObjeto(int posicionObjeto)
		 * 
		 * Comentario: Este metodo se encarga de sacar un objeto de la mochila de Jugador y devolver dicho objeto.
		 * 
		 * Entradas: int posicionObjeto(la posicion en la mochila donde esta el objeto que quiere tirar el Jugador)  
		 * 
		 * Salidas: Objecto tirado
		 * 
		 * Precondiciones: posicionObjeto tiene que ser una posicion valida(Que este en el rango de posiciones de la mochila) en la mochila, 
		 * 				   donde haya un objeto de tipo Objeto sino se producira un error.
		 * 
		 * Postcondiciones: Este metodo al tratarse de una funcion devolvera un tipo de dato, en este caso un Objeto(tirado)
		 * 					que sera el objeto que contenga un Jugador en su mochila, quedando la posicion donde estaba antes el objeto libre
		 * 
		 * 
		 */
		public Objeto tirarObjeto(int posicionObjeto) {
			Objeto tirado = mochila.get(posicionObjeto);
			
			mochila.set(posicionObjeto, null);
			tirado.setEquipado(false);
			
			return tirado;
		}
		
		/*
		 * Prototipo: public int realizarAtaque(int posicionObjeto)
		 * 
		 * Comentario: Este metodo se encarga de devolver el ataque de un Jugador cuando este vaya a usar un objeto de tipo Objeto para atacar.
		 * 			   Dicho ataque puede ser critico(* 2) o no
		 * 
		 * Entradas: int posicionObjeto(la posicion en la mochila donde esta el objeto que quiere usar el Jugador)  
		 * 
		 * Salidas: int danhoFinal
		 * 
		 * Precondiciones:  posicionObjeto tiene que ser una posicion valida(Que este en el rango de posiciones de la mochila) en la mochila.
		 * 
		 * Postcondiciones: Este metodo al ser una funcion devolvera un tipo de dato, en este caso un int(danhoFinal) que sera el daño
		 * 					que causa un Jugador mas el que le proporcione el objeto que use para atacar
		 * 
		 */
		public int realizarAtaque(int posicionObjeto) {
			final int BONIFICACION = 2; //Valor que se multiplicara al ataque que realiza un Personaje cuando se produzca un critico
			int danhoFinal = getDanho();
			int critico = (int)(Math.random()*10+1);
			Objeto objeto = mochila.get(posicionObjeto);
			
			if(objeto != null) {
				danhoFinal += objeto.getDanho();
			}
			
			if(critico < 4){
				danhoFinal *= BONIFICACION;
			}
			return danhoFinal;
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
		
		public int consultarObjetosMisionMochila() {
			final int OBJETOS_NECESARIOS = 3;
			int objetosMision = 0;
			String nombreObjeto = "";
			
			for(int i = 0; i < mochila.size() && objetosMision < OBJETOS_NECESARIOS; i++) {
				if(mochila.get(i) != null) {
					nombreObjeto = mochila.get(i).getNombre();
					if(nombreObjeto.equals("Llave Coche") || nombreObjeto.equals("Gasolina") || nombreObjeto.equals("Bateria") ) {
						objetosMision++;
					}
				}
			}
			return objetosMision;
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
		public boolean consultarObjetosNecesarioMochila(String nombreObjeto) { 
			boolean disponible = false;

			for(int i = 0; i < mochila.size() && disponible == false; i++) {
				if(mochila.get(i) != null && mochila.get(i).getNombre().equals(nombreObjeto)) {
					disponible = true;
				}
			}
			
			return disponible;
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
		
		public void consumirObjeto(int incremento, String opcion) {
			
			if(opcion.equals("Vida")) {
				setVida(getVida()+incremento);
			}else {
				movimientos += incremento;
			}
		}
		
	//Metodos heredados

	    @Override
		public String toString() {
			return super.toString()+" - Mochila: "+mochila.size()+" - Movimientos: "+movimientos;
		}	
}
