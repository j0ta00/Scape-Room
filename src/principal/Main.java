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
	 	String pathFrases = "C:\\Users\\Public\\FrasesMuertes.txt";
		String pathObjetos = "C:\\Users\\Public\\ObjetosScapeRoom.txt";
		File file = new File(pathObjetos);
		File fileFrases = new File(pathFrases);
		if(!file.exists()) { //Si el fichero no esta creado se procede a ello
			Gestora.crearGuardarObjetos(pathObjetos);
		}
		if(!fileFrases.exists()) { //Si el fichero con las frases no esta creado se procede a ello
			Gestora.crearGuardarFrasesMuerte(pathFrases);
		}
		
		
		//Se obtienen todos los objetos que hay en la partida del fichero
		ArrayList<Objeto> objetos = Gestora.obtenerObjetos(pathObjetos);
				
		//Instancia de un objeto Validaciones(Para poder aplicar las validaciones de opciones y demas)
		Validaciones validacion = new Validaciones();
		
		//Variables necesarias para el juego
		int opcionInicial = 0, opcionCementerio = 0, opcionTumbas = 0, opcionGasolinera = 0, opcionJardin = 0, opcionGaraje = 0, opcionMansion = 0, opcionDormitorio = 0,opcionSotano=0,opcionLaboratorio=0, opcionAlmacen = 0;
		int objetosMisionUsuario = 0;
		final int OBJETOS_MISION = 3;
		boolean tumba1 = false, jaulaAbierta=false, tumba2 = false, entradaLaboratorio=false, tumba3 = false, cuartillo = false, comidaCocina = false, cocheHuida = false, puertaOxidada=false, palancaActivada = false, cajasApartadas = false, cocheDestruidoRevisado=false, iteracionPlanta = false;
		char respuesta =' ';
		String nombre = " ";
		Objeto objetoZona = null;
		Personaje enemigo = null;
		
		//Contar historia
		System.out.println("Contar historia inicial.....");
		
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
												+ "suficiente como para huir de la ciudad, metes la llave pero no arranca.\nÂ¿Quieres volverlo a intentar?");
							respuesta = validacion.leerValidarRespuesta();
							if(respuesta == 'S') {
								System.out.println("Por suerte arranca y empiezas a escuhar el motor Â¡Â¡Â¡brrrr!!!. Aqui contar como que los zombies han escuchado el sonido y vienen a por ti");
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
						
						objetoZona = Gestora.obtenerObjeto(objetos, "Taza");
					
						if(comidaCocina == false) { //Si no se a comido la comida de la cocina
							System.out.println("Llegas a la cocina y observas que en la encimera hay un plato encima de otro, parece que hay algo en su interior");
							System.out.println("Te acercas al plato y lo abres con cuidado. Vaya son unas croquetas de jamon.");
							System.out.println("Â¿Quieres comertelo?");
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
									System.out.println("No hay nada mas util solo queda ropa vieja y encima no es de tu talla");
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
								
								System.out.print("Ves una planta encima de una mesa ");
								if(iteracionPlanta == false && usuario.consultarObjetosNecesarioMochila("Regadera")) { //Si no se ha interactuado con la planta y se tiene una regadera
									enemigo = new Personaje("Planta carnivora",80,5);
									System.out.println("parece que estuviera pididendo agua a gritos. Llevas encima una regadera Â¿Quieres usarla?");
									
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										System.out.println("La planta comienza a levantarse, vaya no parece muy amigable.");
										
										Gestora.combateJugadorEnemigo(enemigo, usuario);
										System.out.println("Tras morir la planta parece que ha soltado algo");
										objetoZona = Gestora.obtenerObjeto(objetos, "Valvula"); 
										if(!objetoZona.getEquipado()) { //Si el objeto valvula no se tiene equipado se da la opcion de volvero a equipar
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
					
					case 4://OpciÃ³n 
							do {
								//LeerYValidarOpcionesSotano
								opcionSotano = validacion.mostrarObtenerOpcionesSotano();
								switch(opcionSotano) {
								
									case 1://Registrar estatenrías
										System.out.println("Hay muchos libros, estÃ¡n llenos de polvo parece que hace mucho tiempo que no se leen");
										System.out.println("De entre ellos hay uno completamente desenpolvado parece que ha sido leido hace poco, Â¿Quieres cogerlo?'");
										respuesta = validacion.leerValidarRespuesta();
										if(respuesta=='S'){
											
											System.out.println("El libro tiene una pÃ¡gina marcada la pagina habla sobre jardinerÃ­a pero dentro parece haber una nota");
											System.out.println("La nota dice lo siguiente: Las pruebas con el espÃ©cimen vegetal ya comienza a dar sus frutos seÃ±or Mason, \n"
													+ "me pongo en contacto con usted por correspondencia debido a que tenemos sospechas de que Nova Corp tiene un infiltrado \n"
													+ "en nuestras filas y se encuentra en nuestro propio laboratorio por lo que no es seguro usar la intranet de la compaÃ±ia \n"
													+ "no se preocupe pondremos fin a esto enseguida y todo seguirÃ¡ segÃºn lo acordado, saludos cordiales \n"
													+ " Firmado Doctor Alex Morgan");
										}else {
											System.out.println("No lo has cogido");
										}
									break;//Fin Registrar estanterÃ­as
									
									case 2: //Investigar pared desgastada
										if(entradaLaboratorio==false) {
										System.out.println("Parece una simple pared pero a travÃ©s de ella pasa una ligera brisa");
										}else {

											System.out.println("Lo que antes era una pared ahora es un largo pasadizo");
											System.out.println("Â¿Quieres adentrarte en Ã©l?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta=='S'){
												do {
												opcionLaboratorio=validacion.mostrarObtenerOpcionesLaboratori();
												switch(opcionLaboratorio){
													case 1://Comprobar puerta vieja
														objetoZona = Gestora.obtenerObjeto(objetos, "Bateria");
														System.out.println("Se trata de una puerta que destaca debido a que parece mucho más vieja que el resto del laboratorio");
														System.out.println("Se ve muy descuidada y parece sacada de un manicomio");
														if(puertaOxidada==false){
														System.out.println("¿Quieres abrirla?");
														respuesta = validacion.leerValidarRespuesta();
														
															if( respuesta=='S' && usuario.consultarObjetosNecesarioMochila("Spray de aceite")) {
																System.out.println("Has apretado el botón pero no se abre, chirria bastante parece desengrasada, ¿Quieres engrasarla?");
																respuesta = validacion.leerValidarRespuesta();
																if(respuesta =='S'){ 
																	System.out.println("Has vuelto a apretar el botón, esta vez se ha abierto perfectamente");
																	System.out.println("Has entrado dentro de la habitación y aquello parece una sala de tortura \n"
																			+ "hay grandes manchas de sangre seca en el suelo, las paredes son de un marrón ennegrecido \n"
																			+ "huele a muerto y apenas se ve bien ni con la luz encendida, es un escenario muy macabro \n"
																			+ "también hay diversos instrumentos de tortura como herramientas, cuchillos y un enorme arsenal \n"
																			+ "de numerosos y horribles utensilios, de entre estos destaca una gran batería con dos cables conectados \n"
																			+ "y unas enormes pinzas, por alguna extaña y escalofriante razón esa sala te resulta familiar y te provoca un \n"
																			+ "enorme pavor en el cuerpo...");
																	System.out.println("Parece ser que la batería aún funciona");
																	if(!objetoZona.getEquipado()) { //Si el objeto batería no se tiene equipado se da la opcion de volvero a equipar
																		Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
																	}
																	System.out.println("Parece que cerca de la batería hay una nota, dice lo siguiente:");
																	System.out.println("Nota Resultados tests 28-10-2012:\n"
																			+ "El individuo C-238 responde adecuadamente a los estímulos es altamente resistente a \n"
																			+ "todo tipo de daños, a su vez es inmune a la infección del resto de especímenes como el B-126 o el \n"
																			+ "B-220 si bien estos pueden herirle de gravedad o matarle no pueden hacer que este forme parte de la simbiosis \n"
																			+ "por lo cual es inmune al virus que infecta a los otros especímenes, continuaremos las pruebas pero \n"
																			+ "podemos estar ante uno de los mayores avances en el proyecto.\n"
																			+ "Nota Resultados tests 15-11-2012:\n"
																			+ "Una vez más el prototipo C-238 nos sorprende, no solo demuestra una resistencia y fuerza muy superior si no \n"
																			+ "que además es más inteligente que la media humana, se situa entorno a unos 175 CI es decir solo el 0,001% \n"
																			+ "de la población actual cuenta con un CI similar, a su vez destaca en la comprensión del lenguaje apenas se encuentra \n"
																			+ "en estado larvario y ya es capaz de mantener conversaciones, siguiendo el protocolo nosotros no respondemos nada a sus cuestiones \n"
																			+ "a su vez su desarrollo motor es muy superior también al del ser humano muy pronto alcanzará la etapa de la niñez"
																			+ "Nota Resultados tests 05-03-2013:\n"
																			+ "Tras varios meses poniendo a prueba al espécimen C-238 recomendamos su aislamiento debido a que no se puede asegurar \n"
																			+ "su integridad o la de sus congéneres, C-238 ha desarrollado unas habilidades sagaces es capaz de resolver enormes \n"
																			+ "ecuaciones integrales mientras se divierte viendo la televisión, ha aprendido a hablar numerosas lenguas sin haberlas escuchado previamente \n"
																			+ "hablamos de habilidades casi omnipotentes debido a esto comenzamos con terapias de electrochoque y según la tomografía axial computarizada craneal \n"
																			+ "el individuo presenta enormes lesiones en la zona craneal que le provocan perdidas de memoria a corto y largo plazo, a su vez varios tumores \n"
																			+ "se desarrollan en distintas zonas de su cuerpo parece que no respondio bien a las terapias de choque, pensabamos que iba a ser \n"
																			+ "la evolución del ser humano pero parece que aún debemos seguir trabajando en ello.\n"
																			+ "El resto de notas estan rotas o son ilegibles, por alguna extraña razón comienza a dolerte mucho la cabeza...");
																			puertaOxidada=true;
																}else {
																	
																	System.out.println("No la has engrasado");
																	
																}
															}else if(respuesta=='N'){
																
																System.out.println("No la has abierto");
															}else{
																
																System.out.println("Has pulsado el botón para abrirla, pero parece que no se abre chirria bastante parece muy dsengrasada...");
																
															}
													
													}else{
														System.out.println("Como la engrasaste se ha abierto y has entrado, pero no queda interesante así que has vuelto al principio del laboratorio");
														if(!objetoZona.getEquipado()) { //Si el objeto batería no se tiene equipado se da la opcion de volvero a equipar
															Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
														}
														
														
													}	
													break;//Fin Comprobar puerta vieja
													case 2://Entrar en sala de desarrollo
														System.out.println("Parece la típica sala de laboratorio esta llena de probetas y muestras, es mejor no tocar nada.");
														System.out.println("Parece que en la mesa al lado de un microscopio hay una nota, dice lo siguiente:");
														System.out.println("Nota Resultados tests 19-08-2013:\n"
																+ "El espécimen C-238 falleció desgraciadamente, pero tuvimos suerte y pudimos conservar muestras de su ADN \n"
																+ "gracias a esto hemos desarrollado a C-306 una mejor versión más estable, responde mejor a los estímulos, \n"
																+ "es mucho más sensato y de una inteligencia y habilidad muy similar, no cuenta con habilidades sensoriales o telepáticas \n "
																+ "esta versión es idéntico a un ser humano en apariencia de hecho es exactamente igual que este físicamente hablando pero tan capaz como C-238\n"
																+ "solo que este usa armas/herramientas para la resolución de enigmas(sin rasgos de semi omnipotencia), este es el avance que buscabamos,  \n"
																+ "la humanidad evolucionará al final y nos haremos de oro, con esto Nova Corp no tendrá nada que hacer y el ejercito usará nuestros experimentos, nos espera un futuro prometedor...");
														System.out.println("Has vuelto al principio del laboratorio");
														break;//Fin Entrar en sala de desarrollo
													case 3://Sala de especímenes
														System.out.println("Has entrado y parece una especie de perrera enorme con decenas de jaulas en las que apenas cabe una persona adulta de pie \n"
																+ "Por alguna extraña razón ese lugar te resulta muy familiar, a su vez sientes un fuerte dolor de cabeza y leves náuseas");
														if(jaulaAbierta==false) {
															System.out.println("Hay una jaula enorme cerrada esta muy oscura,¿Quieres abrirla?");
															respuesta = validacion.leerValidarRespuesta();
															if(respuesta=='S'){
																enemigo = new Personaje("Monstruo Telépata",750,200);
																System.out.println("Ha salido un "+enemigo.getNombre()+" justo al abrir la jaula");	
																Gestora.combateJugadorEnemigo(enemigo, usuario);
																System.out.println("El extraño individuo antes de perecer inoculó un mensaje que resuena en tu cabeza \n"
																		+ "lo siento, no quería hacerlo y se que tu tampoco, ellos nos obligaron...");
															}else{
																
																System.out.println("Resuena una voz en tu cabeza que dice Salvame, proviene desde dentro de la Jaula, \n"
																		+ "pero no la has abierto...");
																
															}
														}else{
															
															System.out.println("El enorme cadaver de ese poderoso ser permanece inmovil su jaula esta llena de cadaveres de científicos...");
															
														}
													break;//Fin Sala de especímenes
													case 4://Continuar Pasillo
														
														System.out.println("El pasillo esta bloqueado por una gran cantidad de escombros, parece como si hubiera sucedido \n"
																+ "un terremoto o explosión, has vuelto por donde has venido, hay un científico medio enterrado en los escombros \n"
																+ "pero tiene algo en su mano,¿Quieres mirar?");
														respuesta=validacion.leerValidarRespuesta();
														if(respuesta=='S') {
															objetoZona = Gestora.obtenerObjeto(objetos, "Llave coche");
															
															if (!objetoZona.getEquipado()) {
										
																Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
																
															}else {
																System.out.println("Ya no queda nada interesante que hacer aquÃ­");
															}
															
															
														}else {
															
															System.out.println("Has vuelto al principio del laboratorio");
															
														}
													break;//Fin Continuar Pasillo
													case 5://Entrar en oficina
														System.out.println("Es una oficina común y corriente todos los ordenadores están apagados excepto uno,¿Quieres ver que hay en él?");
														respuesta = validacion.leerValidarRespuesta();
														if(respuesta=='S') {
															System.out.println("El ordenador tiene un e-mail abierto, en el pone lo siguiente:");
															System.out.println("Lo sentimos señor Mason todo ha salido mal, ese traidor se alió con Nova Corp y \n"
																	+ "ha conseguido liberar varios especímenes por qué según él estaban sufriendo y no era ético \n"
																	+ "que sabrá ese patán viudo lo que es ético o no, no se preocupe he puesto fin a su vida y capturaremos \n"
																	+ "a los especímenes antes de que hagan destrozos por la ciudad o sean capturados por Nova Corp, tenemos \n"
																	+ "la ayuda de la policía local, no saben los detalles pero por una cuantiosa suma nos ayudarán, resolveremos est_");
															System.out.println("El e-mail esta sin terminar y todo esta rodeado de sangre por lo que no tuvo un buen final...");
															
															
														}else {
															System.out.println("Has salido de la oficina y has vuelto al principio del laboratorio");
															
														}
													break;//Fin entrar en oficiona
													case 6: //OpciÃ³n mirar mochila
														usuario.mirarContenidoMochila();
													break; //Fin OpciÃ³n mirar mochila
													
													case 7: //OpciÃ³n ver estado
														System.out.println(usuario.toString());
													break; //Fin OpciÃ³n ver estado
												 }
												}while(opcionLaboratorio != 0 && usuario.getMovimientos() > 0 && cocheHuida == false && usuario.getVida()>0);
											}else{
												System.out.println("No has entrado en el pasadizo");
											}
										}
									break; //Fin Investigar pared desgastada
									
									case 3: //Investigar grifo goteando
										System.out.println("No es mÃ¡s que una tuberÃ­a con un grifo, parece que le falta una pieza y por eso gotea...");
										if( usuario.consultarObjetosNecesarioMochila("Valvula")){
											System.out.println("Parece que la vÃ¡lvula encaja perfectamente,Â¿Quieres colocarla sobre en el grifo roto?");
											respuesta = validacion.leerValidarRespuesta();
											
											if(respuesta=='S'){
												System.out.println("Has colocado la vÃ¡lvula y has girado la manivela parece que funciona");
												System.out.println("*PRPRPRPRPRP* Un gran estruendo sucumbe la habitaciÃ³n, parece que la parede se esta abriendo");
												System.out.println("La pared desgastada se ha abierto, resultaba ser un pasadizo secreto, ahora parece ser la entrada a un recÃ³ndito y extraÃ±o lugar...");
												entradaLaboratorio=true;
												usuario.colocarObjeto("Valvula");
											}else {
												System.out.println("No has colocado nada");
											}
										}
									break; //Fin Investigar grifo goteando
								
									case 4: //OpciÃ³n mirar mochila
										usuario.mirarContenidoMochila();
									break; //Fin OpciÃ³n mirar mochila
									
									case 5: //OpciÃ³n ver estado
										System.out.println(usuario.toString());
									break; //Fin OpciÃ³n ver estado
									
								
								}
								
							}while(opcionSotano != 0 && usuario.getMovimientos() > 0 && cocheHuida == false);
					break;	
					
					case 5: //OpciÃ³n mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin OpciÃ³n mirar mochila
					
					case 6: //OpciÃ³n ver estado
						System.out.println(usuario.toString());
					break; //Fin OpciÃ³n ver estado
					
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
							System.out.println("Parece que aÃºn tiene dinero");
							Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
							
						}else {
							System.out.println("Ya no queda nada interesante que hacer aquÃ­");
						}
					break;//Fin Opcion registrar caja registradora
						
					case 2://Opcion Revisar surtidores
						System.out.println("Parecen que se encuentran fuera de servicio");	
					break;//Fin Opcion Revisar surtidores
					
					case 3://Opcion Mirar coche en mal estado
						System.out.println("No es mÃ¡s que un coche completamente destruido");
						System.out.println("Parece que intento huir de la ciudad pero se choco por desgracia ninguna de las piezas del vehÃ­culo te servirÃ­an");
						
						if(cocheDestruidoRevisado == false) {
							System.out.println("Â¿Quieres registrar el interior del vehÃ­culo a ver si contiene algo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								enemigo = new Personaje("Zombie Tullido",250,20);
								System.out.println("Ha salido un "+enemigo.getNombre()+" justo al abrir las puertas del coche");	
								Gestora.combateJugadorEnemigo(enemigo, usuario);
								cocheDestruidoRevisado = true;
								
								if(usuario.getVida() > 0) {
								System.out.println("El zombie ha muerto y ha dejado caer una nota, dice lo siguiente:");
								System.out.println("Hola Tom las cosas se han puesto difÃ­ciles por aquÃ­ asÃ­ que \n"
										+ "he decidido marcharme, los rumores son ciertos no estaban locos es verdad \n"
										+ "hay seres infernales por las afueras de la ciudad y sobre todo cerca de esa vieja mansiÃ³n, \n"
										+ "antes de que esos seres lleguen a la ciudad deberÃ­as abandonarla, utiliza los surtidores \n"
										+ "y huye cuanto antes, pero si llegas tarde te dejarÃ© combustible suficiente como para abandonarla, \n"
										+ "lo guardarÃ© en el armario de la limpieza en el almacen de la gasolinera, recuerda que debes \n"
										+ "desactivar la electricidad si no quieres achicharrarte, tambiÃ©n te dejo algo \n"
										+ "de efectivo en la caja por si necesitas comprar algo durante el viaje, te esperamos en la casa \n"
										+ "de mama, espero que esta carta te llegue a tiempo pues debido a que las carreteras estan cortadas \n"
										+ "no puedo hacertela llegar, ademÃ¡s ni el internet ni la lÃ­nea funcionan esto es muy extraÃ±o la polÃ­cia o \n"
										+ "incluso el gobierno debe estar detrÃ¡s de esto,bueno mucha suerte espero que llegues sano y salvo y volvamos a vernos \n"
										+ "Con cariÃ±o tu hermano John");
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
										System.out.println("Nada mÃ¡s hay cajas viejas");
										System.out.println("Â¿Quieres apartarlas?");
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
										System.out.println("DetrÃ¡s de las cajas hay una vieja palanca, Â¿QuiÃ©res usarla?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											palancaActivada = true;
											System.out.println("Parece que la electricidad ha sido desactivada");
											
										}else{
											System.out.println("No la has activado");
										}
									}		
								}else {	
									System.out.println("Ya no queda nada interesante que hacer aquÃ­");
								}
							
							break; //Fin Registrar Zona
							
							case 2://Revisar Puerta ExtraÃ±a
								
								System.out.println("Se trata de la puerta de un armario de limpieza con un simbolo de Warning");
								System.out.println("Â¿Quieres abrir la puerta?");
								respuesta = validacion.leerValidarRespuesta();
								
								if(respuesta == 'S') {
									
									objetoZona = Gestora.obtenerObjeto(objetos, "Gasolina");
									if (!objetoZona.getEquipado()) { //Si no se tiene equipado el objeto de esta zona 
										if(palancaActivada == false) {
											usuario.recibirDanho(50);
											System.out.println("TRTRTTRTRTTRTR *SONIDO DE CHISPORROTEO*");
											System.out.println("Has recibido algo de daÃ±o");
											System.out.println("Vaya parece que te has llevado una buena descarga, al parecer la puerta tiene \n"
													+ "algÃºn tipo de mecanismo de seguridad y aÃºn sigue cerrada");
										}else {
											System.out.println("Has abierto la puerta, justo detrÃ¡s de ella parece haber un bidÃ³n de algo");
											Gestora.iteracionUsuarioConObjeto(objetoZona, usuario);
										} 
									}else {
										System.out.println("No hay nada, ya no queda nada interesante que hacer aquÃ­. Cierras la puerta al salir");
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

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && cocheHuida == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			System.out.println("Has abandonado el juego");
		}else {
			if(cocheHuida == true) {
				System.out.println("Â¡Â¡Â¡ENHORABUENA!!! Estas hecho todo un superviviente, ya puedes huir de un apocalipsis sin despeinarte");
			}else {
				if(usuario.getMovimientos() == 0) {
					System.out.println("Vaya te has quedado sin movimientos, se acabo...");
				}else {
					System.out.println("Frase cuando mueras");
				}
			}
		}
		teclado.close();
	}
}
