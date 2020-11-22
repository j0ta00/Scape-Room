package test;

import objetos.Objeto;
import personajes.Personaje;

public class TestPersonaje {

	public static void main(String[] args) {

		Personaje sinParametros = new Personaje();
		Personaje conParametros = new Personaje("Jugador",100,10);

		System.out.println("--- Metodos Fundamentales (GETTERS AND SETTERS) ---");
		System.out.println("		GETTERS			");
		System.out.println("sinParametros: Nombre: "+sinParametros.getNombre()+" Daño: "+sinParametros.getDanho()+" Vida: "+sinParametros.getVida());
		System.out.println("conParametros: Nombre: "+conParametros.getNombre()+" Daño: "+conParametros.getDanho()+" Vida: "+conParametros.getVida());
		System.out.println("		SETTERS			");
		System.out.println("Le asignamos 10 de vida a conParametros y 5 de vida a sinParametros");
		conParametros.setVida(10);
		sinParametros.setVida(5);
		System.out.println("conParametros: Vida ");
		System.out.println("sinParametros: Vida ");
		System.out.println("\n--- Metodos Añadidos ---");
		System.out.println("\n	recibirDanho	");
		conParametros.setVida(100);
		System.out.println("recibirá 70 de daño teniendo 100 de vida");
		conParametros.recibirDanho(70);
		System.out.println("Vida restante tras recibir el daño:"+conParametros.getVida());
		System.out.println("\n	realizarAtaque	");
		System.out.println("Imprimirá el daño realizado que sera el daño base del personaje con la posibilidad de un crítico: "+conParametros.realizarAtaque());
		System.out.println("\n--- Métodos Heredados ---");
		System.out.println("		toString	");
		System.out.println("conParametros --> "+conParametros.toString());
	}

}