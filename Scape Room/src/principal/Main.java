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
		int opcionInicial = 0, opcionCementerio = 0, opcionTumbas = 0, opcionGasolinera = 0, opcionJardin = 0, opcionGaraje = 0, opcionMansion = 0, opcionDormitorio = 0, opcionAlmacen = 0;
		int objetosMisionUsuario = 0;
		final int OBJETOS_MISION = 3;
		boolean tumba1 = false, tumba2 = false, tumba3 = false, cuartillo = false, cocina = false, cocheHuida = false, palancaActivada = false, cajasApartadas = false, cocheDestruidoRevisado=false ;
		char respuesta =' ';
		String nombre = " ";
		Objeto objetoZona = null;
		Personaje enemigo = null;
		
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
			opcionInicial = validacion.mostrarObtenerOpcionInicial();
			
			switch(opcionInicial) {
			
			case 1: //Opcion garaje
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				System.out.println("Contar algo sobre histaria de los coches en el garaje o algo ");
				do {
					//LeerValidarOpcionesGaraje
					opcionGaraje = validacion.mostrarObtenerOpcionesGaraje();
					switch(opcionGaraje) {
					
					case 1: //Opcion Inspeccionar coche
						
						//Obtener cuantos objetos se tiene de la mision(Son necesarios 3)
						objetosMisionUsuario = usuario.consultarObjetosMisionMochila();
						
						if(objetosMisionUsuario == OBJETOS_MISION) {
							System.out.println("Tienes todo lo necesario para hacer que el coche funcione. Sacas tu lado mecanico y procedes a instalas las piezas");
							System.out.println("Parace que funciona todo bien, el coche parece en buen estado y capaz de soportar lo "
												+ "suficiente como para huir de la ciudad, metes la llave pero no arranca.\n�Quieres volverlo a intentar?");
							respuesta = validacion.leerValidarRespuesta();
							if(respuesta == 'S') {
								System.out.println("Por suerte arranca y empiezas a escuhar el motor ���brrrr!!!. Aqui contar como que los zombies han escuchado el sonido y vienen a por ti");
								cocheHuida = true;
							}else {
								System.out.println("Bajas del coche y te paras enfrente de el.");
							}
							
						}else {
							System.out.println("Aun no esta listo el coche cuenta con "+objetosMisionUsuario+" objetos esenciales para arrancarlo\n");
						}
					break; //Fin Opcion Inspeccionar coche
					
					case 2: //Opcion Registrar Caja herramienta
						System.out.println("Parece no estar en muy buen estado, esas herramientas no te serviran para mucho, se encuentran en muy mal estado");
					break; //Fin Opcion Registrar Caja herramienta
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opcion ver estado
						System.out.println(usuario.toString());
					break;	//Fin Opcion ver estado
					}
				}while(opcionGaraje != 0 && cocheHuida == false);
				
			break;
			
			case 2: //Opcion ir al cementerio
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do{
					//LeerValidarOpcionesCementario
					opcionCementerio = validacion.mostrarObtenerOpcionesCementario();
					
					switch(opcionCementerio) {
					
					case 1: //Opcion Registrar tumbas
	
						do {
							//LeerValidarOpcionesRegistrarTumba
							opcionTumbas = validacion.mostrarObtenerOpcionesRegistrarTumba();
							
							switch(opcionTumbas) {
							
							case 1: //Tumba 1
								
								if(tumba1 == false && usuario.consultarObjetosNecesarioMochila("Pala")) { //Si se tiene una pala y la tumba aun no ha sido abierta
									System.out.println("La tumba no contiene nada");
									tumba1 = true;
									
								}else {
									
									if(tumba1 == true) {
										System.out.println("Esta tumba ya fue abierta");
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break; //Fin Tumba 1
							
							case 2: //Tumba 2
								
								if(tumba2 == false && usuario.consultarObjetosNecesarioMochila("Pala")) {
									
									enemigo = new Personaje("Zombie",700,25);
									System.out.println("Ha salido un "+enemigo.getNombre()+" de la tumba");	
									Gestora.combateJugadorEnemigo(enemigo, usuario);
									tumba2 = true;
								}else {
									
									if(tumba2 == true) {
										System.out.println("Esta tumba ya fue abierta, observas a su lado el cadaver del zombie");
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break; //Fin Tumba 2
							
							case 3: //Tumba 3
								objetoZona = Gestora.obtenerObjeto(objetos, "Llave vieja");
								
								if(tumba3 == false && usuario.consultarObjetosNecesarioMochila("Pala")) {
									
									Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);

									tumba3 = true;
									
								}else {
									
									if(tumba3 == true) {
										System.out.println("Esta tumba ya fue abierta");
										if(!objetoZona.getEquipado()) {
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										System.out.println("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;//Fin Tumba 3

							}
							
						}while(opcionTumbas != 0 && usuario.getVida() > 0);
						
					break;//Fin Opcion Registrar tumbas
			
					case 2: //Opcion registrar casetilla
						
						System.out.println("Visializas una casetilla al final del cementerio, ves que la puerta esta abierta y entras, vez que hay una caja en la cual:");
						objetoZona = Gestora.obtenerObjeto(objetos, "Pala");
						
						if(!objetoZona.getEquipado()) {
							System.out.println("Hay una nota: ......");//leer nota
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
						}else {
							System.out.println("No hay mas nada");
						}	
					break; //Fin Opcion registrar casetilla
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opcion ver estado
						System.out.println(usuario.toString());
					break; //Fin Opcion mirar mochila
					
					}
				}while(opcionCementerio != 0 && usuario.getVida() > 0);
				
			break; //Fin Opcion ir al cementerio
			
			case 3://Opcion ir a la mansion
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do {
					//LeerValidarOpcionesMansion
					opcionMansion = validacion.mostrarObtenerOpcionesMansion();
					
					switch(opcionMansion) {
					
					case 1://Opcion Registrar cocina
						
						if(cocina == false) {
							System.out.println("Llegas a la cocina y obervas que el microondas esta abierto, te acercas y ves que en el interior hay un rico plato de croquetas");
							System.out.println("�Quieres comertelo?");
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
					break; //Fin Opcion Registrar cocina
					
					case 2:
						
					break;
					
					case 3:
						
					break;
					
					case 4:
						
					break;	
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 6: //Opcion ver estado
						System.out.println(usuario.toString());
					break; //Fin Opcion ver estado
					
					}
				
				}while(opcionMansion != 0 && usuario.getVida() > 0);
				
			break;// Fin Opcion ir a la mansion
			
			case 4://Opcion ir a la gasolinera
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do{
					//LeerYValidarOpcionesGasolinera
					opcionGasolinera = validacion.mostrarObtenerOpcionesGasolinera();
					switch(opcionGasolinera) {

					case 1: //Opcion registrar caja registradora
						System.out.println("Es una vieja caja registradora");
						objetoZona = Gestora.obtenerObjeto(objetos, "Dolares");
						
						if (!objetoZona.getEquipado()) {
							System.out.println("Parece que a�n tiene dinero");
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
							
						}else {
							System.out.println("Ya no queda nada interesante que hacer aqu�");
						}
					break;//Fin Opcion registrar caja registradora
						
					case 2://Opcion Revisar surtidores
						System.out.println("Parecen que se encuentran fuera de servicio");	
					break;//Fin Opcion Revisar surtidores
					
					case 3://Opcion Mirar coche en mal estado
						System.out.println("No es m�s que un coche completamente destruido");
						System.out.println("Parece que intento huir de la ciudad pero se choco por desgracia ninguna de las piezas del veh�culo te servir�an");
						
						if(cocheDestruidoRevisado == false) {
							System.out.println("�Quieres registrar el interior del veh�culo a ver si contiene algo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								enemigo = new Personaje("Zombie Tullido",250,20);
								System.out.println("Ha salido un "+enemigo.getNombre()+" justo al abrir las puertas del coche");	
								Gestora.combateJugadorEnemigo(enemigo, usuario);
								cocheDestruidoRevisado = true;
								
								if(usuario.getVida() > 0) {
								System.out.println("El zombie ha muerto y ha dejado caer una nota, dice lo siguiente:");
								System.out.println("Hola Tom las cosas se han puesto dif�ciles por aqu� as� que \n"
										+ "he decidido marcharme, los rumores son ciertos no estaban locos es verdad \n"
										+ "hay seres infernales por las afueras de la ciudad y sobre todo cerca de esa vieja mansi�n, \n"
										+ "antes de que esos seres lleguen a la ciudad deber�as abandonarla, utiliza los surtidores \n"
										+ "y huye cuanto antes, pero si llegas tarde te dejar� combustible suficiente como para abandonarla, \n"
										+ "lo guardar� en el armario de la limpieza en el almacen de la gasolinera, recuerda que debes \n"
										+ "desactivar la electricidad si no quieres achicharrarte, tambi�n te dejo algo \n"
										+ "de efectivo en la caja por si necesitas comprar algo durante el viaje, te esperamos en la casa \n"
										+ "de mama, espero que esta carta te llegue a tiempo pues debido a que las carreteras estan cortadas \n"
										+ "no puedo hacertela llegar, adem�s ni el internet ni la l�nea funcionan esto es muy extra�o la pol�cia o \n"
										+ "incluso el gobierno debe estar detr�s de esto,bueno mucha suerte espero que llegues sano y salvo y volvamos a vernos \n"
										+ "Con cari�o tu hermano John");
								}
							}else {
								System.out.println("No has abierto el coche lo has dejado tal y como estaba");	
							}
						}else {
							System.out.println("Ya no queda nada interesante que hacer aqu�");							
						}
					break;//Fin Opcion Mirar coche en mal estado
					
					case 4://Opcion Mirar Almac�n
	
						do {
							//LeerYValidarOpcionesAlmacenGasolinera
							opcionAlmacen = validacion.mostrarObtenerOpcionesAlmacenGasolinera();
							
							switch(opcionAlmacen) {
							
							case 1://Registrar Zona
								
								if(palancaActivada == false) { //Si la palanca de la electricidad no ha sido activada
									
									if(cajasApartadas == false){ //Si no se han apartados las cajas	
										System.out.println("Nada m�s hay cajas viejas");
										System.out.println("�Quieres apartarlas?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											cajasApartadas = true;
											System.out.println("Ouch!! Una llave inglesa ha golpeado tu cabeza");
											System.out.println("Has sufrido un leve da�o");
											usuario.recibirDanho(30);	
											
										}else{
											System.out.println("Las has dejado donde estaban");
										}
									}
									
									if(cajasApartadas == true && usuario.getVida() > 0) { //Si las cajas fueron apartadas y el jugador esta vivo. Se controla que el jugador este vivo porque la primera vez que se quitan las cajas habra un objeto que te haga da�o																									
										System.out.println("Detr�s de las cajas hay una vieja palanca, �Qui�res usarla?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											palancaActivada = true;
											System.out.println("Parece que la electricidad ha sido desactivada");
											
										}else{
											System.out.println("No la has activado");
										}
									}		
								}else {	
									System.out.println("Ya no queda nada interesante que hacer aqu�");
								}
							
							break; //Fin Registrar Zona
							
							case 2://Revisar Puerta Extra�a
								
								System.out.println("Se trata de la puerta de un armario de limpieza con un simbolo de Warning");
								System.out.println("�Quieres abrir la puerta?");
								respuesta = validacion.leerValidarRespuesta();
								
								if(respuesta == 'S') {
									
									objetoZona = Gestora.obtenerObjeto(objetos, "Gasolina");
									if (!objetoZona.getEquipado()) { //Si no se tiene equipado el objeto de esta zona 
										if(palancaActivada == false) {
											usuario.recibirDanho(50);
											System.out.println("TRTRTTRTRTTRTR *SONIDO DE CHISPORROTEO*");
											System.out.println("Has recibido algo de da�o");
											System.out.println("Vaya parece que te has llevado una buena descarga, al parecer la puerta tiene \n"
													+ "alg�n tipo de mecanismo de seguridad y a�n sigue cerrada");
										}else {
											System.out.println("Has abierto la puerta, justo detr�s de ella parece haber un bid�n de algo");
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										} 
									}else {
										System.out.println("No hay nada, ya no queda nada interesante que hacer aqu�. Cierras la puerta al salir");
									}
									
								}else {			
									System.out.println("No la has abierto");
								}
							break;//Fin Revisar Puerta Extra�a
							
							case 3: //Opcion mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opcion mirar mochila
							
							case 4: //Opcion ver estado
								System.out.println(usuario.toString());
							break;	//Fin Opcion ver estado
							}
						
						}while(opcionAlmacen!=0 && usuario.getVida()>0);

					break; //Fin Opcion Mirar Almac�n
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 6: //Opcion ver estado
						System.out.println(usuario.toString());
					break;	//Fin Opcion ver estado
					}
					
				}while(opcionGasolinera != 0 && usuario.getVida()>0);
				
			break;//Fin Opcion ir a la gasolinera
			
			case 5:	//Opcion mirar contenido mochila
				usuario.mirarContenidoMochila();
			break;	//Fin Opcion mirar contenido mochila
			
			case 6: //Opcion mirar estado
				System.out.println(usuario.toString());
			break;	//Fin Opcion mirar estado
			}

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && cocheHuida == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			System.out.println("Has abandonado el juego");
		}else {
			if(cocheHuida == true) {
				System.out.println("���ENHORABUENA!!! Estas hecho todo un superviviente, ya puedes huir de un apocalipsis sin despeinarte");
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
