package adicionales;

import java.util.ArrayList;

import objetos.Objeto;

public class prueba {

	public static void main(String[] args) {
		
		ArrayList<Objeto> aa = new ArrayList<Objeto>();

		aa.add(new Objeto("Nombre",12,"asas"));
		
		System.out.println(aa.get(0).toString());
		
		Gestora.obtenerObjeto(aa, "Nombre");
		
		System.out.println(aa.get(0).toString());

	}

}
