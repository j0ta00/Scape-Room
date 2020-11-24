package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import adicionales.Gestora;
import objetos.Objeto;
import personajes.Jugador;
import personajes.Personaje;
import validaciones.Validaciones;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		//Creacion de los objetos 
		String pathObjetos = "C:\\Users\\Public\\ObjetosScapeRoom.txt";
		File file = new File(pathObjetos);
		if(!file.exists()) { //Si el fichero no esta creado se procede a ello
			Gestora.crearGuardarObjetos("C:\\Users\\Public\\ObjetosScapeRoom.txt");
		}
		
		//Se obtienen todos los objetos que hay en la partida del fichero
		ArrayList<Objeto> objetos = Gestora.obtenerObjetos(pathObjetos);
			
		
		//Instancia de un objeto Validaciones(Para poder aplicar las validaciones de opciones y demas)
		Validaciones validacion = new Validaciones();
		
		//Variables necesarias para el juego
		int opcionInicial = 0, opcionCementerio = 0, opcionTumbas = 0, opcionGasolinera = 0, opcionJardin = 0, opcionGaraje = 0, opcionMansion = 0, opcionDormitorio = 0;
		int objetosMision = 0, ataqueUsuario = 0, ataqueEnemigo = 0, posicionMochila = 0;
		boolean tumba1 = false, tumba2 = false, tumba3 = false, cuartillo = false, cocina = false, cocheHuida = false;
		char respuesta =' ';
		String nombre = " ";
		Objeto objetoZona = null;
		Personaje zombie = null, plantaCarnivora = null;
		
		//Contar historia
		System.out.println("Contar historia inicial");
		
		//LeerNombreJugador
		System.out.println("Ingresar nombre jugador");
		nombre = teclado.nextLine();
		
		Jugador usuario = new Jugador(nombre,500,10,10);//Crear jugador

		//Mostrar Estadisticas Jugador
		System.out.println("Estadisticas del jugador: \n"+usuario.toString()+"\n");
		
		do{
			//LeerValidarOpcionInicial
			opcionInicial = validacion.mostrarLeerValidarOpcionInicial();
			
			switch(opcionInicial) {
			
			case 1: //Opcion garaje
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				System.out.println("Contar algo sobre histaria de los coches en el garaje o algo ");
				do {
					//LeerValidarOpcionesGaraje
					opcionGaraje = validacion.mostrarLeerValidarOpcionesGaraje();
					switch(opcionGaraje) {
					
					case 1: //Opcion Inspeccionar coche
						
						//Obtener cuantos objetos se tiene de la mision(Son necesarios 3)
						objetosMision = usuario.consultarObjetosMisionMochila();
						
						if(objetosMision == 3) {
							System.out.println("Tienes todo lo necesario para hacer que el coche funcione. Sacas tu lado mecanico y procedes a instalas las piezas");
							System.out.println("Parace que funciona todo bien, el coche parece en buen estado y capaz de soportar lo "
												+ "suficiente como para huir de la ciudad, metes la llave pero no arranca.\n¿Quieres volverlo a intentar?");
							respuesta = validacion.leerValidarRespuesta();
							if(respuesta == 'S') {
								System.out.println("Por suerte arranca y empiezas a escuhar el motor ¡¡¡brrrr!!!. Aqui contar como que los zombies han escuchado el sonido y vienen a por ti");
								cocheHuida = true;
							}else {
								System.out.println("Bajas del coche y te paras enfrente de el.");
							}
							
						}else {
							System.out.println("Aun no esta listo el coche cuenta con "+objetosMision+" objetos esenciales para arrancarlo\n");
						}
					break;
					
					case 2:
						System.out.println("Parece no estar en muy buen estado, esas herramientas no te serviran para mucho, se encuentran en muy mal estado");
					break;
					}
				}while(opcionGaraje != 0 && cocheHuida == false);
				
			break;
			
			case 2: //Opcion cementerio
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do{
					//LeerValidarOpcionesCementario
					opcionCementerio = validacion.mostrarLeerValidarOpcionesCementario();
					
					switch(opcionCementerio) {
					
					case 1: //Opcion Registrar tumbas
	
						do {
							//LeerValidarOpcionesRegistrarTumba
							opcionTumbas = validacion.mostrarLeerValidarOpcionesRegistrarTumba();
							
							switch(opcionTumbas) {
							
							case 1: //Tumba 1
								
								if(usuario.consultarObjetosNecesarioMochila("Pala") && tumba1 == false) { //Si se tiene una pala y la tumba aun no ha sido abierta
									System.out.println("La tumba no contiene nada");
									tumba1 = true;
									
								}else {
									
									if(tumba1 == true) {
										System.out.println("Esta tumba ya fue abierta");
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;
							
							case 2: //Tumba 2
								
								if(usuario.consultarObjetosNecesarioMochila("Pala") && tumba2 == false) {
									zombie = new Personaje("Zombie",700,25);
									System.out.println("Ha salido un "+zombie.getNombre()+" de la tumba");	
								
									do {
										//LeerValidar respuesta(En este caso sera la forma de atacar al enemigo)
										System.out.println("Quieres usar un objeto de tu mochila para atacar al enemigo(S), si dices que no prepara tus puños(N)");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S') {
											
											System.out.println("Miras rapido el contenido de tu mochila a ver si tienes algo util");
											usuario.mirarContenidoMochila(); //Mostrar contenido de la mochila del usuairo
											posicionMochila = validacion.leerValidarPosicionMochila();//Se selecciona el lugar en la mochila donde esta el objeto que quiere usar
											ataqueUsuario = usuario.realizarAtaque(posicionMochila);//Usuario realiza un ataque en funcion del objeto que ha seleccionado, si no hay nada en esa posicion no se tendra en cuenta
											
										}else {
											ataqueUsuario = usuario.realizarAtaque();
										}
										
										//Resultado ataque usuario
										System.out.println("Has realizado un ataque de "+ataqueUsuario);
										zombie.recibirDaño(ataqueUsuario);
										
										if(zombie.getVida() > 0) { //Si el enemigo esta vivo
											
											//Resultado ataque enemigo
											ataqueEnemigo = zombie.realizarAtaque();
											System.out.println("Has recibido un ataque de "+zombie.getNombre()+" de "+ataqueEnemigo);
											usuario.recibirDaño(ataqueEnemigo);
										}
										
										System.out.println(usuario.getNombre()+" tu vida es de: "+usuario.getVida());
										System.out.println("La vida de "+zombie.getNombre()+" es de: "+zombie.getVida());
										
									}while(zombie.getVida() > 0 && usuario.getVida() > 0);
									
									tumba2 = true;
								}else {
									
									if(tumba2 == true) {
										System.out.println("Esta tumba ya fue abierta, observas a su lado el cadaver del zombie");
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;
							
							case 3: //Tumba 3
								objetoZona = Gestora.obtenerObjeto(objetos, "Llave vieja");
								
								if(usuario.consultarObjetosNecesarioMochila("Pala") && tumba3 == false) {
									
									Gestora.iteracionUsuarioConObjeto(objetoZona, usuario, validacion);

									tumba3 = true;
									
								}else {
									
									if(tumba3 == true) {
										System.out.println("Esta tumba ya fue abierta");
										if(!objetoZona.getEquipado()) {
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario, validacion);
										}
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;

							}
							
						}while(opcionTumbas != 0 && usuario.getVida() > 0);
						
					break;
			
					case 2: //Opcion registrar casetilla
						
						System.out.println("Visializas una casetilla al final del cementerio, ves que la puerta esta abierta y entras, vez que hay una caja en la cual:");
						objetoZona = Gestora.obtenerObjeto(objetos, "Pala");
						
						if(!objetoZona.getEquipado()) {
							System.out.println("Hay una nota: ......");//leer nota
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario, validacion);
						}else {
							System.out.println("No hay mas nada");
						}	
					break;
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break;
					
					case 4: //Opcion ver estado
						System.out.println(usuario.toString());
					break;
					
					}
				}while(opcionCementerio != 0 && usuario.getVida() > 0);
			break;
			
			case 3://Opcion ir a la mansion
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do {
					//LeerValidarOpcionesMansion
					opcionMansion = validacion.mostrarLeerValidarOpcionesMansion();
					
					switch(opcionMansion) {
					
					case 1:
						
						if(cocina == false) {
							System.out.println("Llegas a la cocina y obervas que el microondas esta abierto, te acercas y ves que en el interior hay un rico plato de croquetas");
							System.out.println("¿Quieres comertelo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								usuario.consumirObjeto(50, "Vida");
								System.out.println("Las mejores sin duda, son igualitas a las que hace tu madre. Te sientes lleno de energia");
								cocina = true;
							}else {
								System.out.println("Dejas la comina en su lugar.");
							}
						}
						System.out.println("Parece que no hay nada mas que hacer aqui, abandonas la cocina");
					break;
					
					case 2:
						
					break;
					
					case 3:
						
					break;
					
					case 4:
						
					break;	
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break;
					
					case 6: //Opcion ver estado
						System.out.println(usuario.toString());
					break;
					
					}
				
				}while(opcionMansion != 0 && usuario.getMovimientos() > 0 && usuario.getVida() > 0);
				
			break;
			
			case 4://Opcion ir a la gasolinera
				
				do{
					//LeerYValidarOpcionesGasolinera
					opcionGasolinera = validacion.mostrarLeerValidarOpcionesGasolinera();
					switch(opcionGasolinera) {

						case 1: //Opcion registrar caja registradora
							System.out.println("Es una vieja caja registradora");
							objetoZona = Gestora.obtenerObjeto(objetos, "Dolares");
							
							if (!objetoZona.getEquipado()) {
								System.out.println("Parece que aún tiene dinero");
								Gestora.iteracionUsuarioConObjeto(objetoZona, usuario, validacion);
								
							}else {
								System.out.println("Ya no queda nada interesante que hacer aquí");
							}
						break;
						
						case 2:
							
						break;
						
					}
				}while(opcionGasolinera != 0);
				
			break;
			
			case 5://Opcion mirar contenido mochila
				usuario.mirarContenidoMochila();
			break;
			
			case 6: //Opcion mirar estado
				System.out.println(usuario.toString());
			break;
			}

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && cocheHuida == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			System.out.println("Has abandonado el juego");
		}else {
			if(cocheHuida == true) {
				System.out.println("¡¡¡ENHORABUENA!!! Estas hecho todo un superviviente, ya puedes huir de un apocalipsis sin despeinarte");
			}else {
				if(usuario.getMovimientos() == 0) {
					System.out.println("Vaya te has quedado sin movimientos, se acabo...");
				}else {
					System.out.println("LOSE. Tu cuerpo no aguantaba mas y has muerto");
				}
			}
		}
		teclado.close();
	}
}
