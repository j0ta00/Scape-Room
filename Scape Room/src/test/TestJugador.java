package test;

import objetos.Objeto;
import personajes.Jugador;

public class TestJugador {

	public static void main(String[] args) {

		Jugador sinParametros = new Jugador();
		Jugador conParametros = new Jugador("Juanjo",100,5,0);
		Objeto prueba = new Objeto("prueba",15,"Esto es una prueba");
		Objeto prueba2 = new Objeto("prueba2",25,"Esto es la segunda prueba");
		System.out.println("--- Metodos Fundamentales (GETTERS AND SETTERS) ---");
		System.out.println("		GETTERS			");
		System.out.println("sinParametros: Nombre: "+sinParametros.getNombre()+" Daño: "+sinParametros.getDanho()+" Vida "+sinParametros.getVida()+" Movimiento "+sinParametros.getMovimientos());
		System.out.println("conParametros: Nombre: "+conParametros.getNombre()+" Daño: "+conParametros.getDanho()+" Vida "+conParametros.getVida()+" Movimiento "+conParametros.getMovimientos());
		System.out.println("ArrayList"+conParametros.getMochila());
		System.out.println("		SETTERS			");
		sinParametros.setMovimientos(1);
		conParametros.setMovimientos(70);
		System.out.println("conParametros: Movimientos "+conParametros.getMovimientos());
		System.out.println("\n--- Metodos Añadidos ---");
		System.out.println("cogerObjeto\n");
		System.out.println("conParametros "+conParametros.cogerObjeto(prueba));
		System.out.println("sinParametros "+sinParametros.cogerObjeto(prueba)+"\n");
		System.out.println("sinParametros "+sinParametros.cogerObjeto(null)+"\n");
		System.out.println("mirarContenidoMochila\n");
		sinParametros.mirarContenidoMochila();
		conParametros.mirarContenidoMochila();
		System.out.println("\nmirarContenidoMochila cuando la mochila esta llena y por lo tanto no debería coger el nuevo objeto\n");
		sinParametros.cogerObjeto(prueba);
		sinParametros.cogerObjeto(prueba);
		sinParametros.cogerObjeto(prueba);
		sinParametros.cogerObjeto(prueba);
		sinParametros.cogerObjeto(prueba);
		sinParametros.cogerObjeto(prueba2);
		sinParametros.mirarContenidoMochila();
		System.out.println("\nreducirMovimiento\n");
		conParametros.reducirMovimiento();
		System.out.println("Movimientos tras la reducción "+conParametros.getMovimientos());
	}

}
