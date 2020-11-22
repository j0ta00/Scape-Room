package test;

import objetos.Objeto;

public class TestObjeto {

	public static void main(String[] args) {
		
		Objeto sinParametros = new Objeto();
		Objeto conParametros = new Objeto("Prueba",10,"Esto es un a prueba");
		
		System.out.println("--- Metodos Fundamentales (GETTERS AND SETTERS) ---");
		System.out.println("		GETTERS			");
		System.out.println("sinParametros: Nombre: "+sinParametros.getNombre()+" Daño: "+sinParametros.getDanho()+" Descripcion: "+sinParametros.getDescripcion()+" Cogido: "+sinParametros.getEquipado());
		System.out.println("conParametros: Nombre: "+conParametros.getNombre()+" Daño: "+conParametros.getDanho()+" Descripcion: "+conParametros.getDescripcion()+" Cogido: "+conParametros.getEquipado());
		System.out.println("		SETTERS			");
		conParametros.setEquipado(true);
		System.out.println("conParametros: atributo codigo, cambio de false a true: "+conParametros.getEquipado());
		System.out.println("\n--- Metodos Heredados ---");
		System.out.println("		toString	");
		System.out.println("conParametros --> "+conParametros.toString());
		
	}

}
