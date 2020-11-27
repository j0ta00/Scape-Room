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
		mochila = new ArrayList<Objeto>(Arrays.asList(null,null,null,null,null)); //Se inicializa con 5 espacios vacios
		movimientos = 0;
	}
	
	//Constructor con parametros
	public Jugador(String nombre, int vida, int danho, int movimientos) {
		super(nombre, vida, danho);
		mochila = new ArrayList<Objeto>(Arrays.asList(null,null,null,null,null));
		this.movimientos = movimientos;
	}
	
	//Metodos fundamentales
		//mochila
		public ArrayList<Objeto> getMochila(){
			@SuppressWarnings("unchecked")
			ArrayList<Objeto> copia = (ArrayList<Objeto>) mochila.clone(); //El compilador marca como -Type safety: Unchecked cast from Object to ArrayList<Objeto>- porque cree que se puede llegar a producir un error por ello, por eso el de arriba @SuppressWarnings("unchecked") para comunicarle al compilador que lo que se va hacer es seguro
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
		 * Entradas: Ninguna
		 * 
		 * Salidas: boolean guardado
		 * 
		 * Entrada/Salida: Objeto nuevo(Se modificaria su atributo Equipado si en la mochial hay espacio)
		 * 
		 * Precondiciones: Ninguna
		 * 
		 * Postcondiciones: Este metodo devolvera en este caso un tipo de dato boolean(guardado) ya que se trata de una funcion. 
		 * 					Dicho dato booleano tendra dos posibilidades:
		 * 						-true: Cuando en la mochila haya sitio y se guarde el Objeto recibido como parametro formal
		 * 						-false: Cuando en la mochila no haya sitio y por lo tanto no se pueda guardar en Objeto recibido como parametro formal
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
		 * Prototipo: public void tirarObjeto(int posicionObjeto)
		 * 
		 * Comentario: Este metodo se encarga de sacar un objeto de la mochila de Jugador.
		 * 
		 * Entradas: int posicionObjeto(la posicion en la mochila donde esta el objeto que quiere tirar el Jugador)  
		 * 
		 * Salidas: Ninguna
		 * 
		 * Entradas/Salidas: El objeto que se vaya a tirar se le modificara su atributo equipado, por referencia
		 * 
		 * Precondiciones: posicionObjeto tiene que ser una posicion valida(Que este en el rango de posiciones de la mochila) en la mochila, 
		 * 				   donde haya un objeto de tipo Objeto sino se producira un error.
		 * 
		 * Postcondiciones: Este metodo no devolvera ningun tipo de dato ya que se trata de un procedimiento.
		 * 
		 */
		public void tirarObjeto(int posicionObjeto) {
			Objeto tirado = mochila.get(posicionObjeto);
			
			mochila.set(posicionObjeto, null);
			tirado.setEquipado(false);
			
		}
	
		/*
		 * Prototipo: public void colocarObjeto(String nombreObjeto)
		 * 
		 * Comentario: Este metodo se encarga de sacar un objeto de la mochila de Jugador y colocarlo en una zona determinada de manera que ese objeto no volvera a aparecer
		 * 
		 * Entradas: String nombreObjeto 
		 * 
		 * Salidas: Ninguna
		 * 
		 * Entradas/Salidas: Ninguna
		 * 
		 * Precondiciones: String nombreObjeto debe coincidir con el nombre de uno de los objetos que el usuario lleve en el inventario en dicho momento.
		 * 
		 * Postcondiciones: Este metodo no devolvera ningun tipo de dato ya que se trata de un procedimiento.
		 * 
		 */
		public void colocarObjeto(String nombreObjeto) {
			boolean colocado = false;
			
			for(int i = 0; i < mochila.size() && colocado == false ; i++) {	
				if(mochila.get(i).getNombre().equals(nombreObjeto)){
					mochila.set(i, null);	
					colocado = true;
				} 
			}	
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
			Objeto objeto = mochila.get(posicionObjeto); //Se obtiene el objeto de dicha posicionObjeto que hay en la mochila
			
			if(objeto != null) { //Si el objeto no esta vacio(Es una posicion en la que hay un objeto y no nada) Se sumara el ataque del objeto
				danhoFinal += objeto.getDanho();
			}
			
			if(critico < 4){ 
				danhoFinal *= BONIFICACION;
			}
			return danhoFinal;
		} 
		
		/*
		 * Prototipo: public boolean consultarObjetosMisionMochila(String necesario1, String necesario2, String necesario3)
		 * 
		 * Comentario: Este metodo permite consultar al jugador si tiene todos los objetos necesarios para conseguir cumplir la mision
		 * 
		 * Entradas: String necesario1, String necesario2, String necesario3
		 * 
		 * Salidas: boolean mision
		 * 
		 * Precondiciones: Los tres parametros String deben de ser el nombre de alguno de los objetos del juego
		 * 
		 * Postcondiciones: Este metodo se trata de una funcion que en este caso devuelve un tipo de dato booleano.
		 * 					Dicho booleano(mision) puede tener dos posibilidades:
		 * 					-true: Si el usuario tiene en su mochila los tres objetos necesarios(especificados como paraemtros) para cumplir la mision,
		 * 					-false: Si el usuario no tiene en su mochila los tres objetos necesarios(especificados como paraemtros) para cumplir la mision
		 * 
		 */
		
		public boolean consultarObjetosMisionMochila(String necesario1, String necesario2, String necesario3) {
			boolean mision = false;
			final int OBJETOS_NECESARIOS = 3;
			int objetosMision = 0;
			String nombreObjeto = "";
			
			//Se busca y cuenta cuantos objetos hay en la mochila que sean alguno de los 3 necesarios
			for(int i = 0; i < mochila.size() && objetosMision < OBJETOS_NECESARIOS; i++) {
				if(mochila.get(i) != null) {
					nombreObjeto = mochila.get(i).getNombre();
					if(nombreObjeto.equals(necesario1) || nombreObjeto.equals(necesario2) || nombreObjeto.equals(necesario3) ) {
						objetosMision++;
					}
				}
			}
			
			if(objetosMision == OBJETOS_NECESARIOS) { //Se comprueba si se tienen los 3 objetos necesarios para la mision
				mision = true;
			}
			return mision;
		}
		
		/*
		 * Prototipo: public boolean consultarObjetosNecesarioMochila(String nombreObjeto)  
		 * 
		 * Comentario: Se trata de un metodo permitira al Jugador comprobar si tiene en su inventario el objeto necesario para
		 * 				continuar la aventura o abrir algo.
		 *
		 * Entradas: String nombreObjeto 
		 * 
		 * Salidas: boolean disponible 
		 * 
		 * Precondiciones: El nombre del objeto debera ser introducido correctamente 
		 * 
		 * Postcondiciones: Se trata de una funcion que nos devolvera un tipo de dato booleano, el cual puede tomar dos posibilidades:
		 * 					-true: Si el objeto el jugador lo tiene en su mochila
		 * 					-false: Si el objeto el jugador no lo tiene en su mochila 
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
		 * Prototipo: public void consumirObjeto(int incremento, String opcion) 
		 * 
		 * Comentario: Este metodo permitira que el usuario consuma un objeto y obtenga un incremento en su vida o sus movimientos
		 * 
		 * Entradas: int incremento, String opcion 
		 * 
		 * Salidas: Ninguna 
		 * 
		 * Precondiciones: opcion debe tener un valor especifico "Vida" o "Movimiento" 
		 * 
		 * Postcondiciones: Se trata de un procedimento el cual solo modificara la vida o los movimientos de un jugador
		 * 
		 */
		
		public void consumirObjeto(int incremento, String opcion) {
			
			if(opcion.equals("Vida")) {
				setVida(getVida()+incremento);
			}else if(opcion.equals("Movimiento")){
				setMovimientos(movimientos + incremento);
			}
		}
		
	//Metodos heredados

	    @Override
		public String toString() {
			return super.toString()+" - Mochila: "+mochila.size()+" - Movimientos: "+movimientos;
		}	
}
