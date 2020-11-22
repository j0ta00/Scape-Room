package principal;

import java.util.ArrayList;

import adicionales.Gestora;
import objetos.Objeto;
import personajes.Jugador;
import validaciones.Validaciones;

public class Main {

	public static void main(String[] args) {

		int opcion = 0;
		ArrayList<Objeto> objetos = Gestora.obtenerObjetos("  ");
		Validaciones validacion = new Validaciones();
		Jugador usuario = new Jugador();
		Objeto objetoZona1 = Gestora.obtenerObjeto(objetos, "Llave");
		
		System.out.println("sdsds ddsds d");
		

		do {
			
			opcion = validacion.mostrarLeerValidarOpcionInicial();
			
			switch(opcion) {
			
			case 1:
				
			break;
			
			case 2:
				
				do {
					
					opcion = validacion.mostrarLeerValidarOpcionesCementario();
					
					switch(opcion) {
					
					case 1:
						
						if(objetoZona1.getEquipado()) {
							System.out.println("Te encuentras en el cementerio y tienes : ");
							if(usuario.cogerObjeto(objetoZona1)) {
								
							}else {
								System.out.println("No tienes sitio en la mochila");
							}
						}else {
							System.out.println("Este objeto ya ha sido cogido");
						}	
						
					break;
					
					case 2:
						
					break;
					
					case 3:
						
					break;
					
					case 4:
						
					break;
					
					}

				}while(opcion != 0);

			break;
			
			case 3:
				
			break;
			
			case 4:
				
			break;
			
			}
			
			
			
		}while(opcion == 0);
	}
}
