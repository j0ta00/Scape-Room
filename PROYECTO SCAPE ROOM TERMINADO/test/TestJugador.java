package test;

import objetos.Objeto;
import personajes.Jugador;

public class TestJugador {
	
	public static void main(String[] args) {
	
		Jugador sinParametros = new Jugador();
		Jugador conParametros = new Jugador("Prueba",500,15,10);
		Objeto llave = new Objeto("Llave",0,"Esto es una prueba");
		Objeto cuchillo = new Objeto("Cuchillo",10,"Esto es una prueba");
		Objeto gasolina = new Objeto("Gasolina",0,"Esto es una prueba");
		Objeto Valvula = new Objeto("Valvula",0,"Esto es una prueba");

		System.out.println("--- Metodos Fundamentales (GETTERS AND SETTERS) ---");
		System.out.println("		GETTERS			");
		System.out.println("sinParametros: Nombre: "+sinParametros.getNombre()+" Danho: "+sinParametros.getDanho()+" Vida: "+sinParametros.getVida()
							+" Movimientos: "+sinParametros.getMovimientos()+" Mochila: "+sinParametros.getMochila().get(0));
		System.out.println("conParametros: Nombre: "+conParametros.getNombre()+" Danho: "+conParametros.getDanho()+" Vida: "+conParametros.getVida()
							+" Movimientos: "+conParametros.getMovimientos()+" Mochila: "+conParametros.getMochila().get(0));
		System.out.println("		SETTERS			");
		conParametros.setMovimientos(-2);
		System.out.println("conParametros: atributo movimentos cambia de 10 a 0 --> "+conParametros.getMovimientos());
		conParametros.setMovimientos(5);
		System.out.println("conParametros: atributo movimentos cambia de 0 a 5 --> "+conParametros.getMovimientos());
		System.out.println("--- Metodos a�adidos ---");
		System.out.println("		mirarContenido");
		System.out.print("conParametros: resultado esperado 5 Espacio vacios --> ");
		conParametros.mirarContenidoMochila();
		conParametros.cogerObjeto(llave);
		System.out.print("conParametros: resultado esperado llave + 4 Espacio vacios --> ");
		conParametros.mirarContenidoMochila();
		System.out.println("		reducirMovimientos");
		conParametros.reducirMovimiento();
		System.out.println("conParametros: atributo movimentos cambia de 5 a 4 --> "+conParametros.getMovimientos());
		conParametros.setMovimientos(0);
		conParametros.reducirMovimiento();
		System.out.println("conParametros: atributo movimentos cambia de 4 a 0 --> "+conParametros.getMovimientos());
		System.out.println("		cogerObjeto");
		System.out.println("conParametros: resultado esperado true --> "+conParametros.cogerObjeto(cuchillo));
		conParametros.cogerObjeto(cuchillo);
		conParametros.cogerObjeto(cuchillo);
		conParametros.cogerObjeto(llave);
		System.out.println("conParametros: resultado esperado false --> "+conParametros.cogerObjeto(llave));
		System.out.println("		tirarObjeto");
		conParametros.tirarObjeto(0);
		System.out.print("conParametros: tira objeto llave de la posicion 0 de la mochila, si miramos su contenido en la posicion 0 se espera Espacio libre --> ");
		conParametros.mirarContenidoMochila();
		System.out.println("		colocarObjeto");
		conParametros.cogerObjeto(Valvula);
		conParametros.mirarContenidoMochila();
		conParametros.colocarObjeto("Valvula");
		System.out.print("conParametros: coloca objeto valvula, si miramos su contenido en la posicion 0 se espera Espacio libre --> ");
		conParametros.mirarContenidoMochila();
		System.out.println("		realizarAtaque");
		System.out.println("conParametros: resultado esperado de realizarAtaque  25 o 50 --> "+conParametros.realizarAtaque(3));
		System.out.println("conParametros: resultado esperado de realizarAtaque  15 o 30 --> "+conParametros.realizarAtaque(0));
		System.out.println("		consultarObjetosNecesarioMochila");
		System.out.println("conParametros: resultado esperado false --> "+conParametros.consultarObjetosNecesarioMochila("Cuchillo"));
		System.out.println("		consultarObjetosMisionMochila");
		System.out.println("conParametros: resultado esperado false --> "+conParametros.consultarObjetosMisionMochila("Bateria","",""));
		conParametros.cogerObjeto(gasolina);
		conParametros.tirarObjeto(1);
		conParametros.tirarObjeto(3);
		System.out.println("conParametros: resultado esperado true--> "+conParametros.consultarObjetosMisionMochila("Gasolina","Llave","Cuchillo"));
		System.out.println("		consumirObjeto");
		System.out.println("conParametros: Antes de consumir el objeto -->"+conParametros.getVida());
		conParametros.consumirObjeto(50,"Vida");
		System.out.println("Tras consumirlo, resultado esperado 550 de vida -->"+conParametros.getVida());
		System.out.println("--- Metodos Heredados ---");
		System.out.println("		toString");
		System.out.println("conParametros : "+conParametros.toString());
	}
}
