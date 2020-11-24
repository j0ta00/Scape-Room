package objetos;

import java.io.Serializable;

public class Objeto implements Serializable{


	private static final long serialVersionUID = 1L;//Id control de versiones
	
	//Atributos 
	private String nombre;
	private int danho;
	private String descripcion;
	private boolean equipado;
	
	//Constructor por defecto
	public Objeto() {
		nombre = "";
		danho = 0;
		descripcion = "";
		equipado = false;
	}
	
	//Constructor con parametros
	public Objeto(String nombre, int danho, String descripcion) {
		this.nombre = nombre;
		this.danho = danho;
		this.descripcion = descripcion;
		equipado = false;
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
		public boolean getEquipado() { 
			return equipado;
		}
		public void setEquipado(boolean equipado) {
			this.equipado = equipado;
		}
	//Metodos Heredados
	@Override
	public String toString() {
		return "Nombre: "+nombre+" - Daño: "+danho+" - Descripcion: "+descripcion+" - Equipado: "+equipado;
	}
		
}
