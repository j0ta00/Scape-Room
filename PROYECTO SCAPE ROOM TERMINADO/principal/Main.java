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
				objetosMision = false, puertaOxidada=false, palancaActivada = false, cajasApartadas = false, cocheDestruidoRevisado = false, iteracionPlanta = false;
		char respuesta =' ';
		String nombre = " ";
		Objeto objetoZona = null;
		Personaje enemigo = null;
		
		//Contar historia
		Gestora.mostrarTextoHistoria(1); //Se muestra el texto de la historia numero 1
		
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
				do {
					//LeerValidarOpcionesGaraje
					opcionGaraje = validacion.mostrarObtenerOpcionesGaraje();
					switch(opcionGaraje) {
					
					case 1: //Opcion Inspeccionar coche
						
						System.out.println("Parcece que alguien estaba reuniendo las piezas de este coche para huir pero no llego a conseguirlo.");
						System.out.println("Hay un plano muy desgastado y sucio en la guantera del coche en el cual se pueden distinguir algunas de las piezas que faltan: ");
						System.out.println("Aceite: L  to");
						System.out.println("R  da : Listo");
						System.out.println("G s lina: Sin completar");
						System.out.println("B   ia: Si c mp  ar");
						System.out.println("Motor: Listo");
						System.out.println("Ll es: Sin completar");
						
						//Obtener si se tienen objetos se require para la mision(Son necesarios 3)
						objetosMision = usuario.consultarObjetosMisionMochila("Llave coche","Bateria","Gasolina");
						
						if(objetosMision) {
							System.out.println("Tienes todo lo necesario para hacer que el coche funcione. Sacas tu lado mecanico y procedes a instalas las piezas");
							System.out.println("Parace que funciona todo bien, el coche parece en buen estado y capaz de soportar lo "
												+ "suficiente como para huir de la ciudad, metes la llave pero no arranca.\n¿Quieres volverlo a intentar?");

						}else {
							System.out.println("Parece que al coche le falta algo todavia\n");
						}
					break; //Fin Opcion Inspeccionar coche
					
					case 2: //Opcion Registrar Caja herramienta
						System.out.println("Parece no estar en muy buen estado, esas herramientas no te serviran para mucho.");
						objetoZona = Gestora.obtenerObjeto(objetos, "Spray de aceite");
						if(!objetoZona.getEquipado()) {
							System.out.println("Al lado de esta parece haber algo interesante");
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
						}
					break; //Fin Opcion Registrar Caja herramienta
					
					case 3: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opcion ver estado
						System.out.println(usuario.toString());
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
							//Generar texto historia 2
							Gestora.mostrarTextoHistoria(2);//leer nota
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
						objetoZona = Gestora.obtenerObjeto(objetos, "Taza");
					
						if(comidaCocina == false) { //Si no se a comido la comida de la cocina
							System.out.println("Llegas a la cocina y observas que en la encimera hay un plato encima de otro, parece que hay algo en su interior");
							System.out.println("Te acercas al plato y lo abres con cuidado. Vaya son unas croquetas.");
							System.out.println("¿Quieres comertelo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								usuario.consumirObjeto(50, "Vida");
								System.out.println("Las mejores sin duda, son igualitas a las que hace tu madre. Te sientes lleno de energia");
								comidaCocina = true;
							}else {
								System.out.println("Dejas la comina en su lugar.");
							}
						}else {
							System.out.println("El plato se encuentra vacio.");
						}
						
						System.out.print("Justo encima de la encimera hay un mueble, te dispones a abrirlo y en su interior: ");
						if(!objetoZona.getEquipado()) { //Si no tiene equipado el objeto que sale en la cocina
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
						}else {
							System.out.println("No hay nada de valor");
						}
						
						System.out.println("Parece que no hay nada mas que hacer aqui, abandonas la cocina");
						
					break; //Fin Opcion Registrar cocina
					
					case 2: //Opcion subir al dormitorio						
						do {
							//LeerYValidarOpcionDormitorio
							opcionDormitorio = validacion.mostrarObtenerOpcionesDormitorio();
							
							switch(opcionDormitorio) {
							
							case 1: //Opcion registrar armario	
								objetoZona = Gestora.obtenerObjeto(objetos, "Zapato usado");
								
								if(!objetoZona.getEquipado()) {
									System.out.println("Abres el armario y ves algo al fondo que te llama la atencion ");
									Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
									
								}else {
									System.out.println("No hay nada mas util, solo queda ropa vieja y encima no es de tu talla");
								}								
							break;	//Fin Opcion registrar armario
							
							case 2: //Opcion registrar mesita de noche								
								objetoZona = Gestora.obtenerObjeto(objetos, "Pistola");
								
								System.out.println("Avanzas lentamente hasta detenerte justo delante de una mesita de noche. Encima hay una lampara rota y toda la mesita esta llena de cristales. Ves que esta contiene un cajon y con sumo cuidado lo abres: ");
								if(!objetoZona.getEquipado()) {
									Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);						
								}else {
									System.out.println("No hay nada en el interior");
								}								
							break;	//Fin Opcion registrar mesita de noche
							
							case 3: //Opcion registrar cama
								System.out.println("Remueves las sabanas sucias pero no hay nada. Levantas el colchon en busca de algo que te pueda servir pero nada, aqui no guardan el dinero debajo del colchon como en las peliculas. ");
							break;	//Fin Opcion registrar cama
							
							}	
							
						}while(opcionDormitorio != 0);
						
						System.out.println("Has bajado a la planta principal");			
					break;	//Fin Opcion subir al dormitorio
					
					case 3:	//Opcion salir al jardin
						
						do {
							//LeerYValidarOpcionesJardin
							opcionJardin = validacion.mostrarObtenerOpcionesJardin();
							
							switch(opcionJardin) {
							
							case 1:	//Opcion Registrar Cuartillo
								
								System.out.print("Te acercas al cuartillo hasta plantarte justo delante. ");
								
								if(cuartillo == false && usuario.consultarObjetosNecesarioMochila("Llave vieja")) { //Si el cuartillo esta cerrado y el jugador tiene una llave vieja
									System.out.println("Se encuentra cerrado. Tienes una llave en el inventario. Â¿Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										System.out.println("Ha funcionado la puerta se ha abierto. Observas una estanteria en la cual hay dos objetos: ");
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha");
										Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										cuartillo = true;
									}
								}else {
									if(cuartillo == true) { //Si el cuartillo ya ha sido abierto
										System.out.println("El cuartillo se encuentra abierto. ");
										
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										if(!objetoZona.getEquipado()) { //Si el objeto regadera no se tiene equipado se da la opcion de volvero a equipar
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										}
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha"); 
										if(!objetoZona.getEquipado()) { //Si el objeto hacha no se tiene equipado se da la opcion de volvero a equipar
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										}
										
										System.out.println("No hay nada mas que hacer aqui");
									}else {
										System.out.println("CERRADO. Necesitas algun tipo de llave que encaje con la cerradura");
									}
								}
							break;	//Fin Opcion Registrar Cuartillo
							
							case 2: //Opcion interactuar con planta
								objetoZona = Gestora.obtenerObjeto(objetos, "Valvula");
								System.out.print("Ves una planta encima de una mesa ");
								
								if(iteracionPlanta == false && usuario.consultarObjetosNecesarioMochila("Regadera")) { //Si no se ha interactuado con la planta y se tiene una regadera
									enemigo = new Personaje("Planta carnivora",80,5);
									System.out.println("parece que estuviera pididendo agua a gritos. Llevas encima una regadera ¿Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										System.out.println("La planta comienza a levantarse, vaya no parece muy amigable.");
										Gestora.combateJugadorEnemigo(enemigo, usuario);
										if(usuario.getVida() > 0) { //Si el Jugador despues del combate sigue vivo
											System.out.println("Tras morir la planta parece que ha soltado algo"); 
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);											
										}
										iteracionPlanta = true;
									}else {
										System.out.println("Dejas la planta tal y como estaba");
									}
									
								}else {
									if(iteracionPlanta == true) {
										System.out.println("se encuentra aplastada, esperemos que Greta no se sienta ofendida");
										if(!objetoZona.getEquipado()) { //Si el objeto valvula no se tiene equipado se da la opcion de volvero a equipar
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										System.out.println("necesitaras una regadera para interactuar con ella");
									}	
								}	
							break;	//Fin Opcion interactuar con planta
							}	
						}while(opcionJardin != 0 && usuario.getVida() > 0);			
						
						
					break;	//Fin OpciÃ³n salir al jardin
					
					case 4:	//Opcioc Bajar al sotano
						do {
							//LeerYValidarOpcionesSotano
							opcionSotano = validacion.mostrarObtenerOpcionesSotano();
							switch(opcionSotano) {
							
							case 1: //Opcion Registrar estatenrías
								System.out.println("Hay muchos libros, están llenos de polvo parece que hace mucho tiempo que no se leen");
								System.out.println("De entre ellos hay uno completamente desenpolvado parece que ha sido leido hace poco, ¿Quieres cogerlo?'");
								respuesta = validacion.leerValidarRespuesta();
								if(respuesta == 'S'){
									Gestora.mostrarTextoHistoria(3); //Se muestra el texto de la historia numero 2
								}else {
									System.out.println("No lo has cogido");
								}
							break;  //Fin Opcion Registrar estanterÃ­as
							
							case 2: //Opcion Investigar pared desgastada
								if(entradaLaboratorio == false) {
									System.out.println("Parece una simple pared pero a través de ella pasa una ligera brisa");
								}else {
									System.out.println("Lo que antes era una pared ahora es un largo pasadizo. Te adentras muy lentamente hasta que llegas al lugar.");
									do {
										//LeerYValidarOpcionesLaboratorio
										opcionLaboratorio = validacion.mostrarObtenerOpcionesLaboratorio();
										switch(opcionLaboratorio){
										
										case 1:	// Opcion Comprobar puerta vieja
											objetoZona = Gestora.obtenerObjeto(objetos, "Bateria");
											System.out.println("Se trata de una puerta que destaca debido a que parece mucho más vieja que el resto del laboratorio");
											System.out.println("Se ve muy descuidada y parece sacada de un manicomio");
											
											if(puertaOxidada == false){
												System.out.println("¿Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
											
												if(respuesta == 'S' && usuario.consultarObjetosNecesarioMochila("Spray de aceite")) {
													System.out.println("Has apretado el botón pero no se abre, chirria bastante parece desengrasada. Por tu suerte llevas encima un Spray de aceite que aplicas en la puerta");
													System.out.println("Has vuelto a apretar el botón, se ha abierto perfectamente");
													Gestora.mostrarTextoHistoria(4); //Se muestra el texto de la historia numero 3
													System.out.println("Parece ser que la batería aún funciona");
													Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
													System.out.println("Parece que cerca de la batería hay una nota, dice lo siguiente:");
													Gestora.mostrarTextoHistoria(5); //Se muestra el texto de la historia numero 4
													puertaOxidada = true;
												}else {
													if(respuesta == 'N') {
														System.out.println("No la has abierto");
													}
													else{
														System.out.println("Has pulsado el botón para abrirla, pero parece que no se abre chirria bastante parece muy desengrasada...");
													}
												}						
											}else{
												System.out.print("Como la engrasaste se ha abierto y has entrado. "); 
												if(!objetoZona.getEquipado()) { //Si el objeto batería no se tiene equipado se da la opcion de volvero a equipar
													Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
												}
												System.out.println("No queda nada interesante así que has vuelto al principio del laboratorio");	
											}	
										break;	//Fin Opcion Comprobar puerta vieja
										
										case 2:	//Opcion Entrar en sala de desarrollo
											System.out.println("Parece la típica sala de laboratorio esta llena de probetas y muestras, es mejor no tocar nada.");
											System.out.println("En la mesa al lado de un microscopio hay una nota, dice lo siguiente:");
											Gestora.mostrarTextoHistoria(6); //Se muestra el texo de la historia numero 5
											System.out.println("Has vuelto al principio del laboratorio");
										break;	//Fin Opcion Entrar en sala de desarrollo
										
										case 3:	//Opcion Sala de especímenes
											System.out.println("Has entrado y parece una especie de perrera enorme con decenas de jaulas en las que apenas cabe una persona adulta de pie \n"
													+ "Por alguna extraña razón ese lugar te resulta muy familiar, a su vez sientes un fuerte dolor de cabeza y leves náuseas");
											if(jaulaAbierta == false) {
												System.out.println("Hay una jaula enorme cerrada esta muy oscura,¿Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
												
												if(respuesta == 'S'){
													enemigo = new Personaje("Monstruo Telépata",700,120);
													System.out.println("Ha salido un "+enemigo.getNombre()+" justo al abrir la jaula");	
													Gestora.combateJugadorEnemigo(enemigo, usuario);
													if(usuario.getVida() > 0) {//Si el jugadorf no muere despues del combate
														System.out.println("El extraño individuo antes de perecer inoculó un mensaje que resuena en tu cabeza \n"
																+ "lo siento, no quería hacerlo y se que tu tampoco, ellos nos obligaron...");
													}
													jaulaAbierta = true;
													
												}else{
													System.out.println("Resuena una voz en tu cabeza que dice Salvame, proviene desde dentro de la Jaula, "
															+ "pero no la has abierto...");
												}
											}else{											
												System.out.println("El enorme cadaver de ese poderoso ser permanece inmovil su jaula esta llena de cadaveres de científicos...");
											}
										break;	//Fin Opcion Sala de especímenes
										
										case 4:	//Opcion Continuar Pasillo
											
											System.out.println("El pasillo esta bloqueado por una gran cantidad de escombros, parece como si hubiera sucedido \n"
													+ "un terremoto o explosión, has vuelto por donde has venido, hay un científico medio enterrado en los escombros \n"
													+ "pero tiene algo en su mano,¿Quieres mirar?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												objetoZona = Gestora.obtenerObjeto(objetos, "Llave coche");
												if (!objetoZona.getEquipado()) {
													Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
												}else {
													System.out.println("Ya no queda nada interesante que hacer aquí");
												}
											}else {
												System.out.println("Sigues tu camino, has vuelto al principio del laboratorio");												
											}
										break;	//Fin Opcion Continuar Pasillo
										
										case 5://Opcion Entrar en oficina
											System.out.println("Es una oficina común y corriente todos los ordenadores están apagados excepto uno,¿Quieres ver que hay en él?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												System.out.println("El ordenador tiene un e-mail abierto, en el pone lo siguiente:");
												Gestora.mostrarTextoHistoria(7); //Se muestra el texo de la historia numero 6
											}else {
												System.out.println("Has salido de la oficina y has vuelto al principio del laboratorio");	
											}
										break;//Fin Opcion entrar en oficiona
										
										case 6: //OpciÃ³n mirar mochila
											usuario.mirarContenidoMochila();
										break; //Fin OpciÃ³n mirar mochila
										
										case 7: //OpciÃ³n ver estado
											System.out.println(usuario.toString());
										break; //Fin OpciÃ³n ver estado
										}
									}while(opcionLaboratorio != 0 && usuario.getMovimientos() > 0 && objetosMision == false && usuario.getVida()>0);
								}
							break; //Fin Opcion Investigar pared desgastada
							
							case 3: //Opcion Investigar grifo goteando
								System.out.println("No es mas que una tuberia con un grifo, parece que le falta una pieza y por eso gotea...");
								if(usuario.consultarObjetosNecesarioMochila("Valvula")){
									System.out.println("Parece que la valvula encaja perfectamente,¿Quieres colocarla sobre en el grifo roto?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S'){
										usuario.colocarObjeto("Valvula");
										System.out.println("Has colocado la valvula y has girado la manivela parece que funciona");
										System.out.println("*PRPRPRPRPRP* Un gran estruendo sucumbe la habitacion, parece que la parede se esta abriendo");
										System.out.println("La pared desgastada se ha abierto, resultaba ser un pasadizo secreto, ahora parece ser la entrada a un recondito y extraño lugar...");
										entradaLaboratorio = true;	
									}else {
										System.out.println("No has colocado nada");
									}
								}
							break; //Fin Opcion Investigar grifo goteando
						
							case 4: //Opcion mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opcion mirar mochila
							
							case 5: //Opcion ver estado
								System.out.println(usuario.toString());
							break; //Fin Opcion ver estado
							}
							
						}while(opcionSotano != 0 && usuario.getVida() > 0);
					break;	//Fin Opcion Bajar al sotano
					
					case 5: //Opcion mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 6: //OpciÃ³n ver estado
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
							System.out.println("Parece que aún tiene dinero");
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
							
						}else {
							System.out.println("Ya no queda nada interesante que hacer aquÃ­");
						}
					break;//Fin Opcion registrar caja registradora
						
					case 2://Opcion Revisar surtidores
						System.out.println("Parecen que se encuentran fuera de servicio");	
					break;//Fin Opcion Revisar surtidores
					
					case 3://Opcion Mirar coche en mal estado
						System.out.println("No es más que un coche completamente destruido");
						System.out.println("Parece que intento huir de la ciudad pero se choco por desgracia ninguna de las piezas del vehículo te servirán");
						
						if(cocheDestruidoRevisado == false) {
							System.out.println("¿Quieres registrar el interior del vehículo a ver si contiene algo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								enemigo = new Personaje("Zombie Tullido",250,20);
								System.out.println("Ha salido un "+enemigo.getNombre()+" justo al abrir las puertas del coche");	
								Gestora.combateJugadorEnemigo(enemigo, usuario);
								cocheDestruidoRevisado = true;
								
								if(usuario.getVida() > 0) {
									System.out.println("El zombie ha muerto y ha dejado caer una nota, dice lo siguiente:");
									Gestora.mostrarTextoHistoria(8); //Se muestra el texo de la historia numero 7
								}
							}else {
								System.out.println("No has abierto el coche lo has dejado tal y como estaba");	
							}
						}else {
							System.out.println("Ya no queda nada interesante que hacer aquÃ­");							
						}
					break;//Fin Opcion Mirar coche en mal estado
					
					case 4://Opcion Mirar AlmacÃ©n
	
						do {
							//LeerYValidarOpcionesAlmacenGasolinera
							opcionAlmacen = validacion.mostrarObtenerOpcionesAlmacenGasolinera();
							
							switch(opcionAlmacen) {
							
							case 1://Registrar Zona
								
								if(palancaActivada == false) { //Si la palanca de la electricidad no ha sido activada
									
									if(cajasApartadas == false){ //Si no se han apartados las cajas	
										System.out.println("Nada más hay cajas viejas");
										System.out.println("¿Quieres apartarlas?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											cajasApartadas = true;
											System.out.println("Ouch!! Una llave inglesa ha golpeado tu cabeza");
											System.out.println("Has sufrido un leve daÃ±o");
											usuario.recibirDanho(30);	
											
										}else{
											System.out.println("Las has dejado donde estaban");
										}
									}
									
									if(cajasApartadas == true && usuario.getVida() > 0) { //Si las cajas fueron apartadas y el jugador esta vivo. Se controla que el jugador este vivo porque la primera vez que se quitan las cajas habra un objeto que te haga daÃ±o																									
										System.out.println("Detrás de las cajas hay una vieja palanca, ¿Quieres usarla?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											palancaActivada = true;
											System.out.println("Parece que la electricidad ha sido desactivada");
											
										}else{
											System.out.println("No la has activado");
										}
									}		
								}else {	
									System.out.println("Ya no queda nada interesante que hacer aquí");
								}
							
							break; //Fin Registrar Zona
							
							case 2://Revisar Puerta ExtraÃ±a
								
								System.out.println("Se trata de la puerta de un armario de limpieza con un simbolo de Warning");
								System.out.println("¿Quieres abrir la puerta?");
								respuesta = validacion.leerValidarRespuesta();
								
								if(respuesta == 'S') {
									
									objetoZona = Gestora.obtenerObjeto(objetos, "Gasolina");
									if (!objetoZona.getEquipado()) { //Si no se tiene equipado el objeto de esta zona 
										if(palancaActivada == false) {
											usuario.recibirDanho(50);
											System.out.println("TRTRTTRTRTTRTR *SONIDO DE CHISPORROTEO*");
											System.out.println("Has recibido algo de daño");
											System.out.println("Vaya parece que te has llevado una buena descarga, al parecer la puerta tiene \n"
													+ "algún tipo de mecanismo de seguridad y aún sigue cerrada");
										}else {
											System.out.println("Has abierto la puerta, justo detráss de ella parece haber un bidón de algo");
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										} 
									}else {
										System.out.println("No hay nada, ya no queda nada interesante que hacer aquí. Cierras la puerta al salir");
									}
									
								}else {			
									System.out.println("No la has abierto");
								}
							break;//Fin Revisar Puerta ExtraÃ±a
							
							case 3: //Opcion mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opcion mirar mochila
							
							case 4: //Opcion ver estado
								System.out.println(usuario.toString());
							break;	//Fin Opcion ver estado
							}
						
						}while(opcionAlmacen!=0 && usuario.getVida()>0);

					break; //Fin Opcion Mirar AlmacÃ©n
					
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

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && objetosMision == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			System.out.println("Has abandonado el juego");
		}else {
			if(objetosMision == true) {
				System.out.println("Has conseguido salir sano y salvo de la ciudad, pero en el coche comienza a reproducirse un mensaje a través de la radio");
				Gestora.mostrarTextoHistoria(9);
				System.out.println("¿Quieres rendirte y entregarte a Nova Corp? S/N");
				respuesta = validacion.leerValidarRespuesta();
				if(respuesta=='S'){
					
					Gestora.mostrarTextoHistoria(10);
					
				}else {
					
					Gestora.mostrarTextoHistoria(11);
					
				}
			}else {
				if(usuario.getMovimientos() == 0) {
					System.out.println("\nVaya te has quedado sin movimientos, te sientes muy cansado, no te queda energía y no puedes moverte, este es tu fin \n"
							+ "has andado demasiado y tienes la boca muy seca, comienzas a alucinar y ves seres extraños sufriendo y personas que te hacen daño \n"
							+ "acto seguido, caes al suelo y poco a poco pierdes el conocimiento hasta que cierras los ojos y llega tu final.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}else {
					System.out.println("\nNo te queda vida, tu cuerpo no puede más, tus párpados pesan mucho y cierras los ojos, las heridas de tu cuerpo \n"
							+ "sangran más y más hasta que finalmente tu corazón deja de latir y mueres, tu conciencia, tu alma, tu ser, deja este mundo, para jamás volver.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}
			}
		}
		teclado.close();
	}
}
