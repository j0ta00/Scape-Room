package personajes;

public class Personaje {

	//Atributos
	private String nombre;
	private int vida;
	private int danho;
	
	//Constructor por defecto
	public Personaje(){
		nombre = "";
		vida = 0; 
		danho = 0;
	}
	
	//Constructor con parametros
	public Personaje(String nombre, int vida, int danho) {
		this.nombre = nombre;
		this.vida = vida;
		this.danho = danho;
	}
	
	//Constructor de copia
	public Personaje(Personaje otro) {
		nombre = otro.nombre;
		vida = otro.vida;
		danho = otro.danho;
	}
	
	//Metodos fundamentales
		//Nombre
		public String getNombre() {
			return nombre;
		}
		//Vida
		public int getVida() {
			return vida;
		}
		public void setVida(int vida) {
			if(vida < 1) {
				this.vida = 0;
			}else {
				this.vida=vida;	
			}
		}
		//danho
		public int getDanho() {
			return danho;
		}
	//Metodos añadidos
		
	/*
	 * Prototipo: public void recibirDaño(int danho)
	 * 
	 * Comentario: Este metodo se encarga de reducir la vida de un objeto de tipo Personaje cuando recibe un daño
	 * 
	 * Entradas: int danho
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: El daño recibido tiene que ser mayor que 0 
	 * 
	 * Postcondiciones: Este metodo como es un procedimiento no devolvera ningun tipo de dato, 
	 * 					en este caso solo disminuira el atributo vida de un Personje.
	 * 
	 */
	public void recibirDanho(int danho){
		setVida(vida-danho);
	}
	
	/*
	 * Prototipo: public int realizarAtaque()
	 * 
	 * Comentario: Este metodo se encarga de devolver el ataque de un Personaje pudiendo ser dicho ataque critico(*2)
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: int ataque
	 * 
	 * Precondiciones: Ninguna
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion y devolvera en este caso un tipo de dato entero(ataque)
	 * 
	 */
	public int realizarAtaque() {
		final int BONIFICACION = 2; //Valor que se multiplicara al ataque que realiza un Personaje cuando se produzca un critico
		int critico = (int)(Math.random()*10+1);
		int ataque = danho;
			
		if(critico < 4) {
			ataque *= BONIFICACION;
		}
		return ataque;
	}
	//Metodos heredados 
	
	@Override
	public String toString() {
		return "Nombre: "+nombre+" - Vida: "+vida+" - Daño: "+danho;
	}
}
