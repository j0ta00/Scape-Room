package principal;

import java.util.ArrayList;
import java.util.Scanner;

import adicionales.Gestora;
import objetos.Objeto;
import personajes.Jugador;
import validaciones.Validaciones;

public class Main {

	public static void main(String[] args) {
		
		Gestora.crearGuardarObjetos("C:\\Users\\Public\\ObjetosScapeRoom.txt");//Preguntar raul 
		ArrayList<Objeto> objetos = Gestora.obtenerObjetos("C:\\Users\\Public\\ObjetosScapeRoom.txt");
		Validaciones validacion = new Validaciones();
		Objeto objetoZona = null;
		Objeto objetoZona1 = null;
		
		Scanner teclado = new Scanner(System.in);
		
		int opcion = 0;
		int objetosMision = 0;
		String nombre = " ";
		
		System.out.println("Contar historia inicial");
		
		System.out.println("Ingresar nombre jugador");
		nombre = teclado.next();
		Jugador usuario = new Jugador(nombre,500,10,10);

		System.out.println("Estadisticas del jugador: \n"+usuario.toString());
		
		do {
			
			opcion = validacion.mostrarLeerValidarOpcionInicial();
			
			switch(opcion) {
			
			case 1:
				
				System.out.println("Coger el cohe y huyes");
				
				objetosMision = usuario.consultarObjetosMisionMochila();
				
				if(objetosMision == 3) {
					System.out.println("Coger el cohe y huyes");
				}else {
					System.out.println("Aun no esta listo el coche cuantas con "+objetosMision+" objetos");
				}
				
				
			break;
			
			case 2:
				
				do {
					
					opcion = validacion.mostrarLeerValidarOpcionesCementario();
					
					switch(opcion) {
					
					case 1:
						
						if(objetoZona.getEquipado()) {
							System.out.println("Te encuentras en el cementerio y tienes : ");
							if(usuario.cogerObjeto(objetoZona)) {
								
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
