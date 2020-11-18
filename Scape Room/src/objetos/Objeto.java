package objetos;

import java.io.Serializable;

public class Objeto implements Serializable{

	private static final long serialVersionUID = 1L; //Id para control de versiones
	
	//Atributos 
	private String nombre;
	private int danho;
	private String descripcion;
	private boolean cogido;
	
	//Constructor por defecto
	public Objeto() {
		nombre = "";
		danho = 0;
		descripcion = "";
		cogido = false;
	}
	
	//Constructor con parametros
	public Objeto(String nombre, int danho, String descripcion) {
		this.nombre = nombre;
		this.danho = danho;
		this.descripcion = descripcion;
		cogido = false;
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
		//cogido
		public boolean getCogido() { 
			return cogido;
		}
		public void setCogido(boolean cogido) {
			this.cogido = cogido;
		}
	//Metodos Heredados
	@Override
	public String toString() {
		return "Nombre: "+nombre+" Daño: "+danho+" Descripcion: "+descripcion+" Cogido: "+cogido;
	}		
}

