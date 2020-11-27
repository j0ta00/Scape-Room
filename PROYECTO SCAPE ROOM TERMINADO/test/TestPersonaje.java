package test;

import personajes.Personaje;

public class TestPersonaje {

	public static void main(String[] args) {
		
		Personaje sinParametros = new Personaje();
		Personaje conParametros = new Personaje("Prueba",100,10);
		int ataque = 0;
		
		System.out.println("--- Metodos Fundamentales (GETTERS AND SETTERS) ---");
		System.out.println("		GETTERS			");
		System.out.println("sinParametros: Nombre: "+sinParametros.getNombre()+" Danho: "+sinParametros.getDanho()+" Vida: "+sinParametros.getVida());
		System.out.println("conParametros: Nombre: "+conParametros.getNombre()+" Danho: "+conParametros.getDanho()+" Vida: "+conParametros.getVida());
		System.out.println("		SETTERS			");
		conParametros.setVida(-10);
		System.out.println("conParametros: atributo vida cambia de 100 a 0 --> "+conParametros.getVida());
		conParametros.setVida(70);
		System.out.println("conParametros: atributo vida cambia de 0 a 70 --> "+conParametros.getVida());
		System.out.println("--- Metodos Añadidos ---");
		System.out.println("		realizarAtaque");
		ataque = conParametros.realizarAtaque();
		System.out.println("conParametros: resultado esperado realizarAtaque 10 o 20 --> "+ataque);
		System.out.println("		recibirdaño");
		conParametros.recibirDanho(ataque);
		System.out.println("conParametros: vida esperada despues del metodo recibirDaño 60 o 50 --> "+conParametros.getVida());
		conParametros.recibirDanho(100);
		System.out.println("conParametros: vida esperada despues del metodo recibirDaño 0 --> "+conParametros.getVida());
		System.out.println("--- Metodos Heredados ---");
		System.out.println("		toString");
		System.out.println("conParametros: "+conParametros.toString());
		
	}
}
