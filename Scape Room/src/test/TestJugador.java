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
		Objeto tirado = null;

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
		System.out.println("--- Metodos Añadidos ---");
		System.out.println("		mirarContenido");
		System.out.print("conParametros: resultado esperado 4 Espacio vacios --> ");
		conParametros.mirarContenidoMochila();
		conParametros.cogerObjeto(llave);
		System.out.print("\nconParametros: resultado esperado llave + 3 Espacio vacios --> ");
		conParametros.mirarContenidoMochila();
		System.out.println("\n		reducirMovimientos");
		conParametros.reducirMovimiento();
		System.out.println("conParametros: atributo movimentos cambia de 5 a 4 --> "+conParametros.getMovimientos());
		conParametros.setMovimientos(0);
		conParametros.reducirMovimiento();
		System.out.println("conParametros: atributo movimentos cambia de 4 a 0 --> "+conParametros.getMovimientos());
		System.out.println("		cogerObjeto");
		System.out.println("conParametros: resultado esperado true --> "+conParametros.cogerObjeto(cuchillo));
		conParametros.cogerObjeto(cuchillo);
		conParametros.cogerObjeto(cuchillo);
		System.out.println("conParametros: resultado esperado false --> "+conParametros.cogerObjeto(llave));
		System.out.println("		tirarObjeto");
		tirado = conParametros.tirarObjeto(0);
		System.out.print("conParametros tira objeto llave de la posicion 1 de la mochila, si miramos su contenido en la posicion 1 se espera Espacio libre --> ");
		conParametros.mirarContenidoMochila();
		System.out.println("\ntoString del objeto tirado "+tirado.toString());
		System.out.println("		realizarAtaque");
		System.out.println("conParametros: resultado esperado de realizarAtaque  25 o 50 --> "+conParametros.realizarAtaque(3));
		System.out.println("		consultarObjetosNecesarioMochila");
		System.out.println("conParametros: resultado esperado true --> "+conParametros.consultarObjetosNecesarioMochila("Cuchillo"));
		System.out.println("		consultarObjetosMisionMochila");
		System.out.println("conParametros: resultado esperado 0 --> "+conParametros.consultarObjetosMisionMochila());
		System.out.println("Le añadiremos al inventario uno de los objetos necesarios en esta caso la Gasolina ");
		System.out.println("		consumirObjeto");
		System.out.println("Antes de consumir el objeto -->"+conParametros.getVida());

		conParametros.consumirObjeto(50,"Vida");
		System.out.println("Tras consumirlo, resultado esperado 550 de vida -->"+conParametros.getVida());
		 conParametros.tirarObjeto(1);
		 conParametros.tirarObjeto(2);
		 conParametros.tirarObjeto(3);
		//System.out.println("conParametros: resultado esperado de consultarObjetoDisponible  false --> "+conParametros.consultarObjetosDisponibles());
		System.out.println("--- Metodos Heredados ---");
		System.out.println("		toString");
		System.out.println("conParametros : "+conParametros.toString());
	}
}
