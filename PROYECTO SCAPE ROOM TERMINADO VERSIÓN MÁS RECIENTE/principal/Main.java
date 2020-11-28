/*
 * 
 * Comentarios: -Durante el juego los objetos si se tiran vuelven a reaparecer en su lugar de origen. Es decir si el usuario tiene la mochila 
 * 				 llena y decide equiparse otro objeto tirando antes uno, ese objeto que tira vuelve al sitio de donde se obtuvo, de tal manera 
 * 				 que si por error o no, se tira un objeto necesario para la mision se pueda volver a recuperar y completar la mision.
 * 				-Durante el juego muchos objetos no son necesarios, son adicionales y no hace falta interactuar con ellos para completar
 * 				 la mision. Asi que el usuario debera de tener en cuenta que objeto coger y cuales no puesto que su mochila tiene un limite
 * 
 */
package principal;

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
		
		//Creacion de ficheros(Frases y objetos) y rutas
	 	String pathFrases = "C:\\Users\\Public\\FrasesMuertesScapeRoom.txt";
		String pathObjetos = "C:\\Users\\Public\\ObjetosScapeRoom.txt";
		boolean existeFichero = false;
		
		existeFichero = Gestora.comprobarExistenciaFichero(pathObjetos);
		if(!existeFichero) { //Si el fichero con los objetos no esta creado se procede a ello
			Gestora.crearGuardarObjetos(pathObjetos);
		}
		existeFichero = Gestora.comprobarExistenciaFichero(pathFrases);
		if(!existeFichero) { //Si el fichero con las frases no esta creado se procede a ello
			Gestora.guardarFrasesMuerte(pathFrases);
		}
	
		//Se obtienen todos los objetos que hay en la partida del fichero de objetos
		ArrayList<Objeto> objetos = Gestora.obtenerObjetos(pathObjetos);
				
		//Instancia de un objeto Validaciones(Para poder aplicar las validaciones de opciones y demas)
		Validaciones validacion = new Validaciones();
		
		//Variables necesarias para el juego
		int opcionInicial = 0, opcionCementerio = 0, opcionTumbas = 0, opcionGasolinera = 0, opcionJardin = 0, opcionGaraje = 0, 
			opcionMansion = 0, opcionDormitorio = 0,opcionSotano = 0,opcionLaboratorio = 0, opcionAlmacen = 0;
		boolean tumba1 = false, jaulaAbierta=false, tumba2 = false, entradaLaboratorio=false, tumba3 = false, cuartillo = false, comidaCocina = false,
				objetosMision = false, puertaOxidada=false, palancaActivada = false, cajasApartadas = false, cocheDestruidoRevisado = false, interaccionPlanta = false;
		char respuesta =' ';
		String nombre = " ", historia = " ";
		Objeto objetoZona = null;
		Personaje enemigo = null;
		
		historia = Gestora.obtenerTextoHistoria(1); //Se obtiene el texto de la historia número 1
		Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 1
		
		//LeerNombreJugador
		Gestora.mostrarTextoHistoriaLento("Ingresar nombre jugador\n");
		nombre = teclado.nextLine();
		
		Jugador usuario = new Jugador(nombre,500,10,7);//Crear jugador

		//Mostrar Estadisticas Jugador
		System.out.println("Estadisticas del jugador: \n"+usuario.toString()+"\n");
		 
		do{
			//LeerValidarOpcionInicial
			opcionInicial = validacion.mostrarObtenerOpcionInicial();
			switch(opcionInicial) {
			
			case 1: //Opcion garaje
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				do {
					//LeerValidarOpcionesGaraje
					opcionGaraje = validacion.mostrarObtenerOpcionesGaraje();
					switch(opcionGaraje) {
					
					case 1: //Opcion Inspeccionar coche
						
						Gestora.mostrarTextoHistoriaLento("Parcece que alguien estaba reuniendo las piezas de este coche para huir pero no llego a conseguirlo.\n");
						Gestora.mostrarTextoHistoriaLento("Hay un plano muy desgastado y sucio en la guantera del coche en el cual se pueden distinguir algunas de las piezas que faltan: \n");
						Gestora.mostrarTextoHistoriaLento("Aceite: L  to\n");
						Gestora.mostrarTextoHistoriaLento("R  da : Listo");
						Gestora.mostrarTextoHistoriaLento("G s lina: Sin completar\n");
						Gestora.mostrarTextoHistoriaLento("B   ia: Si c mp  ar\n");
						Gestora.mostrarTextoHistoriaLento("Motor: Listo\n");
						Gestora.mostrarTextoHistoriaLento("Ll es: Sin completar\n");
						
						//Obtener si se tienen objetos que se require para la mision(Son necesarios 3)
						objetosMision = usuario.consultarObjetosMisionMochila("Llave coche","Batería","Gasolina");
						
						if(objetosMision) {
							Gestora.mostrarTextoHistoriaLento("Tienes todo lo necesario para hacer que el coche funcione. Sacas tu lado mecanico y procedes a instalas las piezas");
							Gestora.mostrarTextoHistoriaLento("Parace que funciona todo bien, el coche parece en buen estado y capaz de soportar lo "
												+ "suficiente como para huir de la ciudad, metes la llave y arrancas el coche.");

						}else {
							Gestora.mostrarTextoHistoriaLento("Parece que al coche le falta algo todavia\n");
						}
					break; //Fin Opcion Inspeccionar coche
					
					case 2: //Opcion Registrar Caja herramienta
						Gestora.mostrarTextoHistoriaLento("Parece no estar en muy buen estado, esas herramientas no te serviran para mucho.");
						objetoZona = Gestora.obtenerObjeto(objetos, "Spray de aceite");
						if(!objetoZona.getEquipado()) {
							Gestora.mostrarTextoHistoriaLento("Al lado de esta parece haber algo interesante\n");
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}
					break; //Fin Opcion Registrar Caja herramienta
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opcion ver estado
						Gestora.mostrarTextoHistoriaLento(usuario.toString());
					break;	//Fin Opcion ver estado
					}
				}while(opcionGaraje != 0 && objetosMision == false);
				
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
									Gestora.mostrarTextoHistoriaLento("La tumba no contiene nada");
									tumba1 = true;
									
								}else {
									
									if(tumba1 == true) {
										Gestora.mostrarTextoHistoriaLento("Esta tumba ya fue abierta");
									}else {
										Gestora.mostrarTextoHistoriaLento("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break; //Fin Tumba 1
							
							case 2: //Tumba 2
								
								if(tumba2 == false && usuario.consultarObjetosNecesarioMochila("Pala")) {
									enemigo = new Personaje("Zombie",300,25);
									Gestora.mostrarTextoHistoriaLento("Ha salido un "+enemigo.getNombre()+" de la tumba");	
									Gestora.combateJugadorEnemigo(enemigo, usuario);
									tumba2 = true;
								}else {
									
									if(tumba2 == true) {
										Gestora.mostrarTextoHistoriaLento("Esta tumba ya fue abierta, observas a su lado el cadaver del zombie");
									}else {
										Gestora.mostrarTextoHistoriaLento("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break; //Fin Tumba 2
							
							case 3: //Tumba 3
								objetoZona = Gestora.obtenerObjeto(objetos, "Llave vieja");
								
								if(tumba3 == false && usuario.consultarObjetosNecesarioMochila("Pala")) {
									Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
									tumba3 = true;
									
								}else {
									
									if(tumba3 == true) {
										Gestora.mostrarTextoHistoriaLento("Esta tumba ya fue abierta");
										if(!objetoZona.getEquipado()) {
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										Gestora.mostrarTextoHistoriaLento("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;//Fin Tumba 3

							}
							
						}while(opcionTumbas != 0 && usuario.getVida() > 0);			
					break;//Fin Opcion Registrar tumbas
			
					case 2: //Opcion registrar casetilla				
						Gestora.mostrarTextoHistoriaLento("Visializas una casetilla al final del cementerio, ves que la puerta esta abierta y entras, ves que hay una caja en la cual:");
						objetoZona = Gestora.obtenerObjeto(objetos, "Pala");
						
						if(!objetoZona.getEquipado()) {
							Gestora.mostrarTextoHistoriaLento("Hay una pala con una nota pegada");
							historia=Gestora.obtenerTextoHistoria(2); //Se obtiene el texto de la historia número 2
							Gestora.mostrarTextoHistoriaLento(historia);//Se muestra el texto de la historia número 2
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}else {
							Gestora.mostrarTextoHistoriaLento("No hay nada más por aquí");
						}	
					break; //Fin Opcion registrar casetilla
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opcion ver estado
						Gestora.mostrarTextoHistoriaLento(usuario.toString());
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
						objetoZona = Gestora.obtenerObjeto(objetos, "Taza");
					
						if(comidaCocina == false) { //Si no se a comido la comida de la cocina
							Gestora.mostrarTextoHistoriaLento("Llegas a la cocina y observas que en la encimera hay un plato encima de otro, parece que hay algo en su interior");
							Gestora.mostrarTextoHistoriaLento("Te acercas al plato y lo abres con cuidado. Vaya son unas croquetas.");
							Gestora.mostrarTextoHistoriaLento("¿Quieres comertelas?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								usuario.consumirObjeto(50, "Vida");
								Gestora.mostrarTextoHistoriaLento("Las mejores sin duda, son igualitas a las que hace tu madre. Te sientes lleno de energia");
								comidaCocina = true;
							}else {
								Gestora.mostrarTextoHistoriaLento("Dejas la comina en su lugar.");
							}
						}else {
							Gestora.mostrarTextoHistoriaLento("Hay un plato en la encimaera pero se encuentra vacio.");
						}
						
						Gestora.mostrarTextoHistoriaLento("Justo encima de la encimera hay un mueble, te dispones a abrirlo y en su interior: ");
						if(!objetoZona.getEquipado()) { //Si no tiene equipado el objeto que sale en la cocina
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}else {
							Gestora.mostrarTextoHistoriaLento("No hay nada de valor");
						}
						
						Gestora.mostrarTextoHistoriaLento("Parece que no hay nada mas que hacer aqui, abandonas la cocina");
						
					break; //Fin Opcion Registrar cocina
					
					case 2: //Opcion subir al dormitorio						
						do {
							//LeerYValidarOpcionDormitorio
							opcionDormitorio = validacion.mostrarObtenerOpcionesDormitorio();	
							switch(opcionDormitorio) {
							
							case 1: //Opcion registrar armario	
								objetoZona = Gestora.obtenerObjeto(objetos, "Zapato usado");
								
								if(!objetoZona.getEquipado()) {
									Gestora.mostrarTextoHistoriaLento("Abres el armario y ves algo al fondo que te llama la atencion ");
									Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
									
								}else {
									Gestora.mostrarTextoHistoriaLento("No hay nada más que ropa vieja y además no es de tu talla");
								}								
							break;	//Fin Opcion registrar armario
							
							case 2: //Opcion registrar mesita de noche								
								objetoZona = Gestora.obtenerObjeto(objetos, "Pistola");
								
								Gestora.mostrarTextoHistoriaLento("Avanzas lentamente hasta detenerte justo delante de una mesita de noche, encima hay una lampara rota y toda la mesita esta llena de cristales, ves que esta contiene un cajón y con sumo cuidado lo abres: ");
								if(!objetoZona.getEquipado()) {
									Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);						
								}else {
									Gestora.mostrarTextoHistoriaLento("No hay nada en el interior");
								}								
							break;	//Fin Opcion registrar mesita de noche
							
							case 3: //Opcion registrar cama
								Gestora.mostrarTextoHistoriaLento("Remueves las sabanas sucias pero no hay nada. Levantas el colchon en busca de algo que te pueda servir pero nada, aqui no guardan el dinero debajo del colchon como en las peliculas. ");
							break;	//Fin Opcion registrar cama
							
							}	
							
						}while(opcionDormitorio != 0);
						
						Gestora.mostrarTextoHistoriaLento("Has bajado a la planta principal");			
					break;	//Fin Opcion subir al dormitorio
					
					case 3:	//Opcion salir al jardín
						
						do {
							//LeerYValidarOpcionesJardin
							opcionJardin = validacion.mostrarObtenerOpcionesJardin();
							switch(opcionJardin) {
							
							case 1:	//Opcion Registrar Cuartillo
								
								Gestora.mostrarTextoHistoriaLento("Te acercas al cuartillo hasta plantarte justo delante. ");
								
								if(cuartillo == false && usuario.consultarObjetosNecesarioMochila("Llave vieja")) { //Si el cuartillo esta cerrado y el jugador tiene una llave vieja
									Gestora.mostrarTextoHistoriaLento("Se encuentra cerrado. Tienes una llave en el inventario. ¿Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										Gestora.mostrarTextoHistoriaLento("Ha funcionado la puerta se ha abierto. Observas una estanteria en la cual hay dos objetos: ");
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha");
										Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										cuartillo = true;
									}
								}else {
									if(cuartillo == true) { //Si el cuartillo ya ha sido abierto
										Gestora.mostrarTextoHistoriaLento("El cuartillo se encuentra abierto. ");
										
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										if(!objetoZona.getEquipado()) { //Si el objeto regadera no se tiene equipado se da la opcion de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha"); 
										if(!objetoZona.getEquipado()) { //Si el objeto hacha no se tiene equipado se da la opcion de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
										
										Gestora.mostrarTextoHistoriaLento("No hay nada más que hacer aquí");
									}else {
										Gestora.mostrarTextoHistoriaLento("*CERRADO* Necesitas algún tipo de llave que encaje con la cerradura");
									}
								}
							break;	//Fin Opcion Registrar Cuartillo
							
							case 2: //Opcion interactuar con planta
								objetoZona = Gestora.obtenerObjeto(objetos, "Válvula");
								Gestora.mostrarTextoHistoriaLento("Ves una planta enorme marchita en el huerto");
								
								if(interaccionPlanta == false && usuario.consultarObjetosNecesarioMochila("Regadera")) { //Si no se ha interactuado con la planta y se tiene una regadera
									enemigo = new Personaje("Planta carnivora",80,5);
									Gestora.mostrarTextoHistoriaLento("parece que estuviera pididendo agua a gritos, llevas encima una regadera. ¿Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										Gestora.mostrarTextoHistoriaLento("La planta comienza a levantarse, vaya no parece muy amigable.");
										Gestora.combateJugadorEnemigo(enemigo, usuario);
										if(usuario.getVida() > 0) { //Si el Jugador despues del combate sigue vivo
											Gestora.mostrarTextoHistoriaLento("Tras morir la planta parece que ha soltado algo"); 
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);											
										}
										interaccionPlanta = true;
									}else {
										Gestora.mostrarTextoHistoriaLento("Dejas la planta tal y como estaba");
									}
									
								}else {
									if(interaccionPlanta == true) {
										Gestora.mostrarTextoHistoriaLento("Se encuentra aplastada, esperemos que Greta no se sienta ofendida");
										if(!objetoZona.getEquipado()) { //Si el objeto válvula no se tiene equipado se da la opcion de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										Gestora.mostrarTextoHistoriaLento("Necesitaras una regadera para interactuar con ella");
									}	
								}	
							break;	//Fin Opcion interactuar con planta
							}	
						}while(opcionJardin != 0 && usuario.getVida() > 0);			
						
						
					break;	//Fin Opcion salir al jardín
					
					case 4:	//Opcion Bajar al sótano
						do {
							//LeerYValidarOpcionesSotano
							opcionSotano = validacion.mostrarObtenerOpcionesSotano();
							switch(opcionSotano) {
							
							case 1: //Opcion Registrar estatenrias
								Gestora.mostrarTextoHistoriaLento("Hay muchos libros, están llenos de polvo parece que hace mucho tiempo que no se leen");
								Gestora.mostrarTextoHistoriaLento("De entre ellos hay uno completamente desenpolvado parece que ha sido leido hace poco. ¿Quieres cogerlo?'");
								respuesta = validacion.leerValidarRespuesta();
								if(respuesta == 'S'){
									historia = Gestora.obtenerTextoHistoria(3); //Se obtiene el texto de la historia número 3
									Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 3
								}else {
									Gestora.mostrarTextoHistoriaLento("No lo has cogido");
								}
							break;  //Fin Opcion Registrar estanterias
							
							case 2: //Opcion Investigar pared desgastada
								if(entradaLaboratorio == false) { //Si no es activada la entrada al laboratorio
									Gestora.mostrarTextoHistoriaLento("Parece una simple pared pero a través de ella pasa una ligera brisa");
								}else {
									Gestora.mostrarTextoHistoriaLento("Lo que antes era una pared ahora es un largo pasadizo. Te adentras muy lentamente hasta que llegas al lugar.");
									do {
										//LeerYValidarOpcionesLaboratorio
										opcionLaboratorio = validacion.mostrarObtenerOpcionesLaboratorio();
										switch(opcionLaboratorio){
										
										case 1:	// Opcion Comprobar puerta vieja
											objetoZona = Gestora.obtenerObjeto(objetos, "Batería");
											Gestora.mostrarTextoHistoriaLento("Se trata de una puerta que destaca debido a que parece mucho más vieja que el resto del laboratorio");
											Gestora.mostrarTextoHistoriaLento("Se ve muy descuidada y parece sacada de un manicomio");
											
											if(puertaOxidada == false){
												Gestora.mostrarTextoHistoriaLento("¿Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
											
												if(respuesta == 'S' && usuario.consultarObjetosNecesarioMochila("Spray de aceite")) {
													Gestora.mostrarTextoHistoriaLento("Has apretado el botón pero no se abre, chirria bastante parece desengrasada. Por tu suerte llevas encima un Spray de aceite que aplicas en la puerta");
													Gestora.mostrarTextoHistoriaLento("Has vuelto a apretar el botón, se ha abierto perfectamente");
													historia = Gestora.obtenerTextoHistoria(4); //Se obtiene el texto de la historia número 4
													Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 4
													Gestora.mostrarTextoHistoriaLento("Parece ser que la batería aún funciona");
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
													Gestora.mostrarTextoHistoriaLento("Parece que cerca de la batería hay una nota, dice lo siguiente:");
													historia = Gestora.obtenerTextoHistoria(5); //Se obtiene el texto de la historia número 5
													Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 5
													puertaOxidada = true;
												}else {
													if(respuesta == 'N') {
														Gestora.mostrarTextoHistoriaLento("No la has abierto");
													}
													else{
														Gestora.mostrarTextoHistoriaLento("Has pulsado el botón para abrirla, pero parece que no se abre chirria bastante parece muy desengrasada...");
													}
												}						
											}else{
												Gestora.mostrarTextoHistoriaLento("Como la engrasaste se ha abierto y has entrado. "); 
												if(!objetoZona.getEquipado()) { //Si el objeto batería no se tiene equipado se da la opcion de volvero a equipar
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
												}
												Gestora.mostrarTextoHistoriaLento("No queda nada interesante así que has vuelto al principio del laboratorio");	
											}	
										break;	//Fin Opcion Comprobar puerta vieja
										
										case 2:	//Opcion Entrar en sala de desarrollo
											Gestora.mostrarTextoHistoriaLento("Parece la típica sala de laboratorio esta llena de probetas y muestras, es mejor no tocar nada.");
											Gestora.mostrarTextoHistoriaLento("En la mesa al lado de un microscopio hay una nota, dice lo siguiente:");
											historia = Gestora.obtenerTextoHistoria(6); //Se obtiene el texto de la historia número 6
											Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 6
											Gestora.mostrarTextoHistoriaLento("Has vuelto al principio del laboratorio");
										break;	//Fin Opcion Entrar en sala de desarrollo
										
										case 3:	//Opcion Sala de especÃ­menes
											Gestora.mostrarTextoHistoriaLento("Has entrado y parece una especie de perrera enorme con decenas de jaulas en las que apenas cabe una persona adulta de pie \n"
													+ "Por alguna extraña razón ese lugar te resulta muy familiar, a su vez sientes un fuerte dolor de cabeza y leves náuseas");
											if(jaulaAbierta == false) {
												Gestora.mostrarTextoHistoriaLento("Hay una jaula enorme cerrada esta muy oscura. ¿Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
												
												if(respuesta == 'S'){
													enemigo = new Personaje("Monstruo Telépata",700,100);
													Gestora.mostrarTextoHistoriaLento("Ha salido un "+enemigo.getNombre()+" justo al abrir la jaula");	
													Gestora.combateJugadorEnemigo(enemigo, usuario);
													if(usuario.getVida() > 0) {//Si el jugador no muere despues del combate
														Gestora.mostrarTextoHistoriaLento("El extraño individuo antes de perecer inoculó un mensaje que resuena en tu cabeza \n"
																+ "lo siento, no querías hacerlo y se que tu tampoco, ellos nos obligaron...");
													}
													jaulaAbierta = true;
													
												}else{
													Gestora.mostrarTextoHistoriaLento("Resuena una voz en tu cabeza que dice salvame, proviene desde dentro de la Jaula, "
															+ "pero no la has abierto...");
												}
											}else{											
												Gestora.mostrarTextoHistoriaLento("El enorme cadaver de ese poderoso ser permanece inmovil su jaula esta llena de cadaveres de cientíicos...");
											}
										break;	//Fin Opcion Sala de especÃ­menes
										
										case 4:	//Opcion Continuar Pasillo
											
											Gestora.mostrarTextoHistoriaLento("El pasillo esta bloqueado por una gran cantidad de escombros, parece como si hubiera sucedido \n"
													+ "un terremoto o explosión, has vuelto por donde has venido, hay un científico medio enterrado en los escombros \n"
													+ "pero tiene algo en su mano. ¿Quieres mirar?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												objetoZona = Gestora.obtenerObjeto(objetos, "Llave coche");
												if (!objetoZona.getEquipado()) {
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
												}else {
													Gestora.mostrarTextoHistoriaLento("Ya no queda nada interesante que hacer aquí");
												}
											}else {
												Gestora.mostrarTextoHistoriaLento("Sigues tu camino, has vuelto al principio del laboratorio");												
											}
										break;	//Fin Opcion Continuar Pasillo
										
										case 5://Opcion Entrar en oficina
											Gestora.mostrarTextoHistoriaLento("Es una oficina común y corriente todos los ordenadores están apagados excepto uno, ¿Quieres ver que hay en él?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												Gestora.mostrarTextoHistoriaLento("El ordenador tiene un e-mail abierto, en el pone lo siguiente:");
												historia = Gestora.obtenerTextoHistoria(7); //Se obtiene el texto de la historia número 7
												Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 7
											}else {
												Gestora.mostrarTextoHistoriaLento("Has salido de la oficina y has vuelto al principio del laboratorio");	
											}
										break;//Fin Opcion entrar en oficiona
										
										case 6: //Opcion mirar mochila
											usuario.mirarContenidoMochila();
										break; //Fin Opcion mirar mochila
										
										case 7: //Opcion ver estado
											Gestora.mostrarTextoHistoriaLento(usuario.toString());
										break; //Fin Opcion ver estado
										}
									}while(opcionLaboratorio != 0 && usuario.getVida() > 0);
								}
							break; //Fin Opcion Investigar pared desgastada
							
							case 3: //Opcion Investigar grifo goteando
								Gestora.mostrarTextoHistoriaLento("No es mas que una tuberia con un grifo, parece que le falta una pieza y por eso gotea...");
								if(usuario.consultarObjetosNecesarioMochila("Válvula")){
									Gestora.mostrarTextoHistoriaLento("Parece que la válvula encaja perfectamente. ¿Quieres colocarla sobre en el grifo roto?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S'){
										usuario.colocarObjeto("Válvula");
										Gestora.mostrarTextoHistoriaLento("Has colocado la válvula y has girado la manivela parece que funciona");
										Gestora.mostrarTextoHistoriaLento("*PRPRPRPRPRP* Un gran estruendo sucumbe la habitacion, parece que la parede se esta abriendo");
										Gestora.mostrarTextoHistoriaLento("La pared desgastada se ha abierto, resultaba ser un pasadizo secreto, ahora parece ser la entrada a un recondito y extraño lugar...");
										entradaLaboratorio = true;	
									}else {
										Gestora.mostrarTextoHistoriaLento("No has colocado nada");
									}
								}
							break; //Fin Opcion Investigar grifo goteando
						
							case 4: //Opcion mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opcion mirar mochila
							
							case 5: //Opcion ver estado
								Gestora.mostrarTextoHistoriaLento(usuario.toString());
							break; //Fin Opcion ver estado
							}
							
						}while(opcionSotano != 0 && usuario.getVida() > 0);
					break;	//Fin Opcion Bajar al sótano
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 6: //Opcion ver estado
						Gestora.mostrarTextoHistoriaLento(usuario.toString());
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
						Gestora.mostrarTextoHistoriaLento("Es una vieja caja registradora");
						objetoZona = Gestora.obtenerObjeto(objetos, "Dólares");
						
						if (!objetoZona.getEquipado()) {
							Gestora.mostrarTextoHistoriaLento("Parece que aún tiene dinero");
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
							
						}else {
							Gestora.mostrarTextoHistoriaLento("Ya no queda nada interesante que hacer aquí");
						}
					break;//Fin Opcion registrar caja registradora
						
					case 2://Opcion Revisar surtidores
						Gestora.mostrarTextoHistoriaLento("Actualmente se encuentran fuera de servicio");	
					break;//Fin Opcion Revisar surtidores
					
					case 3://Opcion Mirar coche en mal estado
						Gestora.mostrarTextoHistoriaLento("No es más que un coche completamente destruido");
						Gestora.mostrarTextoHistoriaLento("Parece que intento huir de la ciudad pero se choco por desgracia ninguna de las piezas del vehículo te servirán");
						
						if(cocheDestruidoRevisado == false) {
							Gestora.mostrarTextoHistoriaLento("¿Quieres registrar el interior del vehículo a ver si contiene algo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								enemigo = new Personaje("Zombie Tullido",250,20);
								Gestora.mostrarTextoHistoriaLento("Ha salido un "+enemigo.getNombre()+" justo al abrir las puertas del coche");	
								Gestora.combateJugadorEnemigo(enemigo, usuario);
								cocheDestruidoRevisado = true;
								
								if(usuario.getVida() > 0) {
									Gestora.mostrarTextoHistoriaLento("El zombie ha muerto y ha dejado caer una nota, dice lo siguiente:");
									historia = Gestora.obtenerTextoHistoria(8); //Se obtiene el texto de la historia número 8
									Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 8
								}
							}else {
								Gestora.mostrarTextoHistoriaLento("No has abierto el coche lo has dejado tal y como estaba");	
							}
						}else {
							Gestora.mostrarTextoHistoriaLento("Ya no queda nada interesante que hacer aquí");							
						}
					break;//Fin Opcion Mirar coche en mal estado
					
					case 4://Opcion Mirar Almacen
	
						do {
							//LeerYValidarOpcionesAlmacenGasolinera
							opcionAlmacen = validacion.mostrarObtenerOpcionesAlmacenGasolinera();
							switch(opcionAlmacen) {
							
							case 1://Registrar Zona
								
								if(palancaActivada == false) { //Si la palanca de la electricidad no ha sido activada
									
									if(cajasApartadas == false){ //Si no se han apartados las cajas	
										Gestora.mostrarTextoHistoriaLento("Nada más hay cajas viejas");
										Gestora.mostrarTextoHistoriaLento("¿Quieres apartarlas?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											cajasApartadas = true;
											Gestora.mostrarTextoHistoriaLento("Ouch!! Una llave inglesa ha golpeado tu cabeza");
											Gestora.mostrarTextoHistoriaLento("Has sufrido un leve daño");
											usuario.recibirDanho(30);	
											
										}else{
											Gestora.mostrarTextoHistoriaLento("Las has dejado donde estaban");
										}
									}
									
									if(cajasApartadas == true && usuario.getVida() > 0) { //Si las cajas fueron apartadas y el jugador esta vivo. Se controla que el jugador este vivo porque la primera vez que se quitan las cajas habra un objeto que te haga daÃ±o 																									
										Gestora.mostrarTextoHistoriaLento("Detrás de las cajas hay una vieja palanca. ¿Quieres usarla?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											palancaActivada = true;
											Gestora.mostrarTextoHistoriaLento("Parece que la electricidad ha sido desactivada");
											
										}else{
											Gestora.mostrarTextoHistoriaLento("No la has activado");
										}
									}		
								}else {	
									Gestora.mostrarTextoHistoriaLento("Ya no queda nada interesante que hacer aquí");
								}
							
							break; //Fin Registrar Zona
							
							case 2://Revisar Puerta ExtraÃ±a
								
								Gestora.mostrarTextoHistoriaLento("Se trata de la puerta de un armario de limpieza con un simbolo de Warning");
								Gestora.mostrarTextoHistoriaLento("¿Quieres abrir la puerta?");
								respuesta = validacion.leerValidarRespuesta();
								
								if(respuesta == 'S') {
									
									objetoZona = Gestora.obtenerObjeto(objetos, "Gasolina");
									if (!objetoZona.getEquipado()) { //Sino se tiene equipado el objeto de esta zona 
										if(palancaActivada == false) { //Sino se activo la palanaca que corta la electricidad
											usuario.recibirDanho(50);
											Gestora.mostrarTextoHistoriaLento("TRTRTTRTRTTRTR *SONIDO DE CHISPORROTEO*");
											Gestora.mostrarTextoHistoriaLento("Has recibido algo de daño");
											Gestora.mostrarTextoHistoriaLento("Vaya parece que te has llevado una buena descarga, al parecer la puerta tiene \n"
													+ "algún tipo de mecanismo de seguridad y aún sigue cerrada");
										}else {
											Gestora.mostrarTextoHistoriaLento("Has abierto la puerta, justo detrás de ella parece haber un bidón de algo");
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										} 
									}else {
										Gestora.mostrarTextoHistoriaLento("No hay nada, ya no queda nada interesante que hacer aquí. Cierras la puerta al salir");
									}
									
								}else {			
									Gestora.mostrarTextoHistoriaLento("No la has abierto");
								}
							break;//Fin Revisar Puerta ExtraÃ±a
							
							case 3: //Opcion mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opcion mirar mochila
							
							case 4: //Opcion ver estado
								Gestora.mostrarTextoHistoriaLento(usuario.toString());
							break;	//Fin Opcion ver estado
							}
						
						}while(opcionAlmacen != 0 && usuario.getVida() > 0);

					break; //Fin Opcion Mirar Almacen
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 6: //Opcion ver estado
						Gestora.mostrarTextoHistoriaLento(usuario.toString());
					break;	//Fin Opcion ver estado
					}
					
				}while(opcionGasolinera != 0 && usuario.getVida() > 0);
				
			break;//Fin Opcion ir a la gasolinera
			
			case 5:	//Opcion mirar contenido mochila
				usuario.mirarContenidoMochila();
			break;	//Fin Opcion mirar contenido mochila
			
			case 6: //Opcion mirar estado
				Gestora.mostrarTextoHistoriaLento(usuario.toString());
			break;	//Fin Opcion mirar estado
			}

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && objetosMision == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			Gestora.mostrarTextoHistoriaLento("Has abandonado el juego");
		}else {
			if(objetosMision == true) {
				Gestora.mostrarTextoHistoriaLento("Has conseguido salir sano y salvo de la ciudad, pero en el coche comienza a reproducirse un mensaje a través de la radio");
				historia = Gestora.obtenerTextoHistoria(9); //Se obtiene el texto de la historia número 9
				Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 9
				Gestora.mostrarTextoHistoriaLento("¿Quieres rendirte y entregarte a Nova Corp? S/N");
				respuesta = validacion.leerValidarRespuesta();
				if(respuesta == 'S'){
					historia = Gestora.obtenerTextoHistoria(10); //Se obtiene el texto de la historia número 10
					Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 10
				}else {
					historia = Gestora.obtenerTextoHistoria(11); //Se obtiene el texto de la historia número 11
					Gestora.mostrarTextoHistoriaLento(historia); //Se muestra el texto de la historia número 11
				}
			}else {
				if(usuario.getMovimientos() == 0) {
					Gestora.mostrarTextoHistoriaLento("\nVaya te has quedado sin movimientos, te sientes muy cansado y sin fuerza para hacer un desplazamiento tan largo, no te queda energía y no puedes moverte, este es tu fin \n"
							+ "has andado demasiado y tienes la boca muy seca, comienzas a alucinar y ves seres extrañs sufriendo y personas que te hacen daño \n"
							+ "acto seguido, caes al suelo y poco a poco pierdes el conocimiento hasta que cierras los ojos y llega tu final.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}else { //Si el usuario se queda sin vida
					Gestora.mostrarTextoHistoriaLento("\nNo te queda vida, tu cuerpo no puede más, tus párpados pesan mucho y cierras los ojos, las heridas de tu cuerpo \n"
							+ "sangran más y más hasta que finalmente tu corazón deja de latir y mueres, tu conciencia, tu alma, tu ser, deja este mundo, para jamás volver.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}
			}
		}
		if(objetosMision == false) {
		Gestora.mostrarTextoHistoriaLento("¿Quieres conocer la solución del juego? S/N");
		respuesta = validacion.leerValidarRespuesta();
		if(respuesta =='S') {
		//Mostrar solución del juego
		System.out.println("\nSolución del juego");
		System.out.println("1.Visitar el garaje para registrar la caja de herramientas y coger el Spray");
		System.out.println("2.Visitar cementerio, una vez dentro ir al cuartillo y coger la pala");
		System.out.println("  Una vez se tiene la pala, registrar la tumba numero 3 y coger la llave");
		System.out.println("3.Visitar la mansion e ir al jardín, una vez alli entrar al cuartillo y coger la regadera. Se interactua con la planta");
		System.out.println("  Se derrota a la planta y se coge la válvula. Ir al sótano de la mansion y se investiga el grifo que esta goteando y se coloca la válvula");
		System.out.println("  Una vez colocada se investiga la pared desgastada pues se abrio el laboratorio. Una vez dentro de este se comprueba la puerta oxidada, se entra y se coge la batería");
		System.out.println("  Dentro del laboratorio aun se continua por el pasillo y se coge la llave del coche");
		System.out.println("4.Visitar gasolinera y acceder al almacen, una vez dentro se registra la zona, se apartan las cajas y se activa la palanca");
		System.out.println("  A continuación se revisar la puerta extraña y se coge la gasolina");
		System.out.println("5.Volver al departemento, visitar de nuevo el garaje e investigar el coche y arrancarlo para poder escapar y fin del juego.");
		}
		teclado.close();
		}
	}
}
