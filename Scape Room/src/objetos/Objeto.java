package objetos;

public class Objeto {

	//Atributos 
	private String nombre;
	private int danho;
	private String descripcion;
	
	//Constructor por defecto
	public Objeto() {
		nombre = "";
		danho = 0;
		descripcion = "";
	}
	
	//Constructor con parametros
	public Objeto(String nombre, int danho, String descripcion) {
		this.nombre = nombre;
		this.danho = danho;
		this.descripcion = descripcion;
	}
	
	//Metodos fundamentales
	
	 	//nombre
		public String getNombre() {
			return nombre;
		}
		//danho
		public int getDanho() {
			return danho;
		}
		//descripcion
		public String getDescripcion() {
			return descripcion;
		}
		
	//Metodos Heredados
	@Override
	public String toString() {
		return "Nombre: "+nombre+" Daño: "+danho+" Descripcion: "+descripcion;
	}
		
}
