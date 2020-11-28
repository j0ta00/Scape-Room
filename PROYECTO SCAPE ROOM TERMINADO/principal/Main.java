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
		Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia número 1
		
		//LeerNombreJugador
		Gestora.mostrarTextoLento("�Cu�l es tu nombre?\n");
		nombre = teclado.nextLine();
		
		Jugador usuario = new Jugador(nombre,500,10,11);  //Crear jugador

		//Mostrar Estadisticas Jugador
		System.out.println("Estadisticas del jugador: "+usuario.toString());
		 
		do{
			//LeerValidarOpcionInicial
			opcionInicial = validacion.mostrarObtenerOpcionInicial();
			switch(opcionInicial) {
			
			case 1: //Opci�n garaje
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				do {
					//LeerValidarOpcionesGaraje
					opcionGaraje = validacion.mostrarObtenerOpcionesGaraje();
					switch(opcionGaraje) {
					
					case 1: //Opci�n Inspeccionar coche
						
						Gestora.mostrarTextoLento("Parece que alguien estaba reuniendo las piezas de este coche para huir pero no llego a conseguirlo.");
						Gestora.mostrarTextoLento("Hay un plano muy desgastado y sucio en la guantera del coche en el cual se pueden distinguir algunas de las piezas que faltan: \n");
						Gestora.mostrarTextoLento("-Aceite: L  to");
						Gestora.mostrarTextoLento("-R  da : Listo ");
						Gestora.mostrarTextoLento("-G s lina: Sin completar");
						Gestora.mostrarTextoLento("-B    ia: Si c mp  ar");
						Gestora.mostrarTextoLento("-Motor: Listo");
						Gestora.mostrarTextoLento("-Ll es: Sin completar");
						
						//Obtener si se tienen objetos que se require para la mision(Son necesarios 3)
						objetosMision = usuario.consultarObjetosMisionMochila("Llave coche","Bater�a","Gasolina");
						
						if(objetosMision) {
							Gestora.mostrarTextoLento("Tienes todo lo necesario para hacer que el coche funcione. Sacas tu lado mecanico y procedes a instalas las piezas");
							Gestora.mostrarTextoLento("Parace que funciona todo bien, el coche parece en buen estado y capaz de soportar lo "
												+ "suficiente como para huir de la ciudad, metes la llave y arrancas el coche.");

						}else {
							Gestora.mostrarTextoLento("Parece que al coche le falta algo todav�a");
						}
					break; //Fin Opci�n Inspeccionar coche
					
					case 2: //Opci�n Registrar Caja herramienta
						Gestora.mostrarTextoLento("Parece no estar en muy buen estado, esas herramientas no te servir�n para mucho.");
						objetoZona = Gestora.obtenerObjeto(objetos, "Spray de aceite");
						if(!objetoZona.getEquipado()) {
							Gestora.mostrarTextoLento("Al lado de esta parece haber algo interesante");
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}
					break; //Fin Opci�n Registrar Caja herramienta
					
					case 3: //Opci�n mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opcion mirar mochila
					
					case 4: //Opci�n ver estado
						Gestora.mostrarTextoLento(usuario.toString()+"\n");
					break;	//Fin Opci�n ver estado
					}
				}while(opcionGaraje != 0 && objetosMision == false);
				
			break;
			
			case 2: //Opci�n ir al cementerio
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do{
					//LeerValidarOpcionesCementario
					opcionCementerio = validacion.mostrarObtenerOpcionesCementario();
					switch(opcionCementerio) {
					
					case 1: //Opci�n Registrar tumbas
						do {
							//LeerValidarOpcionesRegistrarTumba
							opcionTumbas = validacion.mostrarObtenerOpcionesRegistrarTumba();
							switch(opcionTumbas) {
							
							case 1: //Tumba 1
								
								if(tumba1 == false && usuario.consultarObjetosNecesarioMochila("Pala")) { //Si se tiene una pala y la tumba aun no ha sido abierta
									Gestora.mostrarTextoLento("La tumba no contiene nada");
									tumba1 = true;
									
								}else {
									
									if(tumba1 == true) {
										Gestora.mostrarTextoLento("Esta tumba ya fue abierta");
									}else {
										Gestora.mostrarTextoLento("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break; //Fin Tumba 1
							
							case 2: //Tumba 2
								
								if(tumba2 == false && usuario.consultarObjetosNecesarioMochila("Pala")) {
									enemigo = new Personaje("Mordedor r�pido",250,25);
									Gestora.mostrarTextoLento("Ha salido un "+enemigo.getNombre()+" de la tumba\n");	
									Gestora.combateJugadorEnemigo(enemigo, usuario);
									tumba2 = true;
								}else {
									
									if(tumba2 == true) {
										Gestora.mostrarTextoLento("Esta tumba ya fue abierta, observas a su lado el cadaver del zombie");
									}else {
										Gestora.mostrarTextoLento("Necesitas una pala para abrir esta tuma");
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
										Gestora.mostrarTextoLento("Esta tumba ya fue abierta");
										if(!objetoZona.getEquipado()) {
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										Gestora.mostrarTextoLento("Necesitas una pala para abrir esta tuma");
									}
								}
								
							break;//Fin Tumba 3

							}
							
						}while(opcionTumbas != 0 && usuario.getVida() > 0);			
					break;//Fin Opci�n Registrar tumbas
			
					case 2: //Opci�n registrar casetilla				
						Gestora.mostrarTextoLento("Visualizas una casetilla al final del cementerio, ves que la puerta esta abierta y entras, ves que hay una caja en la cual:");
						objetoZona = Gestora.obtenerObjeto(objetos, "Pala");
						
						if(!objetoZona.getEquipado()) {
							Gestora.mostrarTextoLento("Hay una pala con una nota pegada. ");
							historia = Gestora.obtenerTextoHistoria(2); //Se obtiene el texto de la historia n�mero 2
							Gestora.mostrarTextoLento(historia);  //Se muestra el texto de la historia n�mero 2
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}else {
							Gestora.mostrarTextoLento("No hay nada m�s por aqu�");
						}	
					break; //Fin Opci�n registrar casetilla
					
					case 3: //Opci�n mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opci�n mirar mochila
					
					case 4: //Opci�n ver estado
						Gestora.mostrarTextoLento(usuario.toString()+"\n");
					break; //Fin Opci�n mirar mochila
					
					}
					
				}while(opcionCementerio != 0 && usuario.getVida() > 0);
				
			break; //Fin Opci�n ir al cementerio
			
			case 3://Opci�n ir a la mansion
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do {
					//LeerValidarOpcionesMansion
					opcionMansion = validacion.mostrarObtenerOpcionesMansion();
					switch(opcionMansion) {
					
					case 1://Opci�n Registrar cocina
						objetoZona = Gestora.obtenerObjeto(objetos, "Taza");
					
						if(comidaCocina == false) { //Si no se a comido la comida de la cocina
							Gestora.mostrarTextoLento("Llegas a la cocina y observas que en la encimera hay un plato encima de otro, parece que hay algo en su interior");
							Gestora.mostrarTextoLento("Te acercas al plato y lo abres con cuidado. Vaya es una tapa de jam�n y una Cruzcampo.");
							Gestora.mostrarTextoLento("�Quieres comertelo todo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								usuario.consumirObjeto(50, "Vida"); //Por la tapa de jam�n
								usuario.consumirObjeto(2,"Movimientos"); //Por la Cruzcampo
								Gestora.mostrarTextoLento("Las mejores sin duda, son igualitas a las que hace tu madre. Te sientes lleno de energia");
								comidaCocina = true;
							}else {
								Gestora.mostrarTextoLento("Dejas la comina en su lugar.");
							}
						}else {
							Gestora.mostrarTextoLento("Hay un plato en la encimera pero se encuentra vac�o.");
						}
						
						Gestora.mostrarTextoLento("Justo encima de la encimera hay un mueble, te dispones a abrirlo y en su interior: ");
						if(!objetoZona.getEquipado()) { //Si no tiene equipado el objeto que sale en la cocina
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
						}else {
							Gestora.mostrarTextoLento("No hay nada de valor");
						}
						
						Gestora.mostrarTextoLento("Parece que no hay nada mas que hacer aqui, abandonas la cocina");
						
					break; //Fin Opci�n Registrar cocina
					
					case 2: //Opci�n subir al dormitorio						
						do {
							//LeerYValidarOpcionDormitorio
							opcionDormitorio = validacion.mostrarObtenerOpcionesDormitorio();	
							switch(opcionDormitorio) {
							
							case 1: //Opci�n registrar armario	
								objetoZona = Gestora.obtenerObjeto(objetos, "Zapato usado");
								
								if(!objetoZona.getEquipado()) {
									Gestora.mostrarTextoLento("Abres el armario y ves algo al fondo que te llama la atenci�n");
									Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
									
								}else {
									Gestora.mostrarTextoLento("No hay nada m�s que ropa vieja y adem�s no es de tu talla");
								}								
							break;	//Fin Opci�n registrar armario
							
							case 2: //Opci�n registrar mesita de noche								
								objetoZona = Gestora.obtenerObjeto(objetos, "Pistola");
								
								Gestora.mostrarTextoLento("Avanzas lentamente hasta detenerte justo delante de una mesita de noche, encima hay una lampara rota y toda la mesita esta llena de cristales, ves que esta contiene un caj�n y con sumo cuidado lo abres: ");
								if(!objetoZona.getEquipado()) {
									Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);						
								}else {
									Gestora.mostrarTextoLento("No hay nada en el interior");
								}								
							break;	//Fin Opci�n registrar mesita de noche
							
							case 3: //Opci�n registrar cama
								Gestora.mostrarTextoLento("Remueves las sabanas sucias pero no hay nada. Levantas el colch�n en busca de algo que te pueda servir pero nada, aqu� no guardan el dinero debajo del colchon como en las pel�culas. ");
							break;	//Fin Opci�n registrar cama
							
							}	
							
						}while(opcionDormitorio != 0);
						
						Gestora.mostrarTextoLento("Has bajado a la planta principal");			
					break;	//Fin Opci�n subir al dormitorio
					
					case 3:	//Opci�n salir al jard�n
						
						do {
							//LeerYValidarOpcionesJardin
							opcionJardin = validacion.mostrarObtenerOpcionesJardin();
							switch(opcionJardin) {
							
							case 1:	//Opci�n Registrar Cuartillo
								
								Gestora.mostrarTextoLento("Te acercas al cuartillo hasta plantarte justo delante. ");
								
								if(cuartillo == false && usuario.consultarObjetosNecesarioMochila("Llave vieja")) { //Si el cuartillo esta cerrado y el jugador tiene una llave vieja
									Gestora.mostrarTextoLento("Se encuentra cerrado. Tienes una llave en el inventario. �Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										Gestora.mostrarTextoLento("Ha funcionado la puerta se ha abierto. Observas una estanteria en la cual hay dos objetos: ");
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha");
										Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										cuartillo = true;
									}
								}else {
									if(cuartillo == true) { //Si el cuartillo ya ha sido abierto
										Gestora.mostrarTextoLento("El cuartillo se encuentra abierto. ");
										
										objetoZona = Gestora.obtenerObjeto(objetos, "Regadera"); 
										if(!objetoZona.getEquipado()) { //Si el objeto regadera no se tiene equipado se da la opcion de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
										objetoZona = Gestora.obtenerObjeto(objetos, "Hacha"); 
										if(!objetoZona.getEquipado()) { //Si el objeto hacha no se tiene equipado se da la opcion de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
										
										Gestora.mostrarTextoLento("No hay nada m�s que hacer aqu�");
									}else {
										Gestora.mostrarTextoLento("*CERRADO* Necesitas alg�n tipo de llave que encaje con la cerradura");
									}
								}
							break;	//Fin Opci�n Registrar Cuartillo
							
							case 2: //Opci�n interactuar con planta
								objetoZona = Gestora.obtenerObjeto(objetos, "V�lvula");
								Gestora.mostrarTextoLento("Ves una planta enorme en el huerto");
								
								if(interaccionPlanta == false && usuario.consultarObjetosNecesarioMochila("Regadera")) { //Si no se ha interactuado con la planta y se tiene una regadera
									enemigo = new Personaje("Planta carnivora",80,5);
									Gestora.mostrarTextoLento("Parece que estuviera pididendo agua a gritos, llevas encima una regadera. �Quieres usarla?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S') {
										Gestora.mostrarTextoLento("La planta comienza a levantarse, vaya no parece muy amigable.");
										Gestora.combateJugadorEnemigo(enemigo, usuario);
										if(usuario.getVida() > 0) { //Si el Jugador despues del combate sigue vivo
											Gestora.mostrarTextoLento("Tras morir la planta parece que ha soltado algo"); 
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);											
										}
										interaccionPlanta = true;
									}else {
										Gestora.mostrarTextoLento("Dejas la planta tal y como estaba");
									}
									
								}else {
									if(interaccionPlanta == true) {
										Gestora.mostrarTextoLento("Se encuentra aplastada, esperemos que Greta no se sienta ofendida");
										if(!objetoZona.getEquipado()) { //Si el objeto v�lvula no se tiene equipado se da la opci�n de volvero a equipar
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										}
									}else {
										Gestora.mostrarTextoLento("Necesitaras una regadera para interactuar con ella");
									}	
								}	
							break;	//Fin Opci�n interactuar con planta
							}	
						}while(opcionJardin != 0 && usuario.getVida() > 0);			
												
					break;	//Fin Opci�n salir al jard�n
					
					case 4:	//Opci�n Bajar al s�tano
						do {
							//LeerYValidarOpcionesSotano
							opcionSotano = validacion.mostrarObtenerOpcionesSotano();
							switch(opcionSotano) {
							
							case 1: //Opci�n Registrar estanter�as
								Gestora.mostrarTextoLento("Hay muchos libros, est�n llenos de polvo parece que hace mucho tiempo que no se leen");
								Gestora.mostrarTextoLento("De entre ellos hay uno completamente desenpolvado parece que ha sido leido hace poco. �Quieres cogerlo?'");
								respuesta = validacion.leerValidarRespuesta();
								if(respuesta == 'S'){
									historia = Gestora.obtenerTextoHistoria(3); //Se obtiene el texto de la historia n�mero 3
									Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 3
								}else {
									Gestora.mostrarTextoLento("No lo has cogido");
								}
							break;  //Fin Opci�n Registrar estanter�as
							
							case 2: //Opci�n Investigar pared desgastada
								if(entradaLaboratorio == false) { //Si no es activada la entrada al laboratorio
									Gestora.mostrarTextoLento("Parece una simple pared pero a trav�s de ella pasa una ligera brisa");
								}else {
									Gestora.mostrarTextoLento("Lo que antes era una pared ahora es un largo pasadizo. Te adentras muy lentamente hasta que llegas al lugar.");
									do {
										//LeerYValidarOpcionesLaboratorio
										opcionLaboratorio = validacion.mostrarObtenerOpcionesLaboratorio();
										switch(opcionLaboratorio){
										
										case 1:	// Opci�n Comprobar puerta vieja
											objetoZona = Gestora.obtenerObjeto(objetos, "Bater�a");
											Gestora.mostrarTextoLento("Se trata de una puerta que destaca debido a que parece mucho m�s vieja que el resto del laboratorio");
											Gestora.mostrarTextoLento("Se ve muy descuidada y parece sacada de un manicomio");
											
											if(puertaOxidada == false){ //Si la puerta oxidada no se ha abierto nunca
												Gestora.mostrarTextoLento("�Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
											
												if(respuesta == 'S' && usuario.consultarObjetosNecesarioMochila("Spray de aceite")) {
													Gestora.mostrarTextoLento("Has apretado el bot�n pero no se abre, chirria bastante parece desengrasada. Por tu suerte llevas encima un Spray de aceite que aplicas en la puerta");
													Gestora.mostrarTextoLento("Has vuelto a apretar el bot�n, se ha abierto perfectamente");
													historia = Gestora.obtenerTextoHistoria(4); //Se obtiene el texto de la historia n�mero 4
													Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 4
													Gestora.mostrarTextoLento("Parece ser que la bater�a a�n funciona");
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
													Gestora.mostrarTextoLento("Parece que cerca de la bater�a hay una nota, dice lo siguiente:");
													historia = Gestora.obtenerTextoHistoria(5); //Se obtiene el texto de la historia n�mero 5
													Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 5
													puertaOxidada = true;
												}else {
													if(respuesta == 'N') {
														Gestora.mostrarTextoLento("No la has abierto");
													}
													else{
														Gestora.mostrarTextoLento("Has pulsado el bot�n para abrirla, pero parece que no se abre chirria bastante parece muy desengrasada...");
													}
												}						
											}else{
												Gestora.mostrarTextoLento("Como la engrasaste se ha abierto y has entrado. "); 
												if(!objetoZona.getEquipado()) { //Si el objeto bater�a no se tiene equipado se da la opcion de volvero a equipar
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
												}
												Gestora.mostrarTextoLento("No queda nada interesante as� que has vuelto al principio del laboratorio");	
											}	
										break;	//Fin Opci�n Comprobar puerta vieja
										
										case 2:	//Opci�n Entrar en sala de desarrollo
											Gestora.mostrarTextoLento("Parece la t�pica sala de laboratorio esta llena de probetas y muestras, es mejor no tocar nada.");
											Gestora.mostrarTextoLento("En la mesa al lado de un microscopio hay una nota, dice lo siguiente:");
											historia = Gestora.obtenerTextoHistoria(6); //Se obtiene el texto de la historia n�mero 6
											Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 6
											Gestora.mostrarTextoLento("Has vuelto al principio del laboratorio");
										break;	//Fin Opci�n Entrar en sala de desarrollo
										
										case 3:	//Opci�n Sala de espec�menes
											Gestora.mostrarTextoLento("Has entrado y parece una especie de perrera enorme con decenas de jaulas en las que apenas cabe una persona adulta de pie \n"
													+ "Por alguna extra�a raz�n ese lugar te resulta muy familiar, a su vez sientes un fuerte dolor de cabeza y leves n�useas");
											if(jaulaAbierta == false) {
												Gestora.mostrarTextoLento("Hay una jaula enorme cerrada esta muy oscura. �Quieres abrirla?");
												respuesta = validacion.leerValidarRespuesta();
												
												if(respuesta == 'S'){
													enemigo = new Personaje("Monstruo Tel�pata",500,40);
													Gestora.mostrarTextoLento("Ha salido un "+enemigo.getNombre()+" justo al abrir la jaula");	
													Gestora.combateJugadorEnemigo(enemigo, usuario);
													if(usuario.getVida() > 0) { //Si el jugador no muere despues del combate
														Gestora.mostrarTextoLento("El extra�o individuo antes de perecer inocul� un mensaje que resuena en tu cabeza \n"
																+ "lo siento, no quer�as hacerlo y se que tu tampoco, ellos nos obligaron...");
													}
													jaulaAbierta = true;
													
												}else{
													Gestora.mostrarTextoLento("Resuena una voz en tu cabeza que dice salvame, proviene desde dentro de la Jaula, "
															+ "pero no la has abierto...");
												}
											}else{											
												Gestora.mostrarTextoLento("El enorme cadaver de ese poderoso ser permanece inm�vil su jaula esta llena de cadaveres de cient�ficos...");
											}
										break;	//Fin Opci�n Sala de especimenes
										
										case 4:	//Opci�n Continuar Pasillo
											
											Gestora.mostrarTextoLento("El pasillo esta bloqueado por una gran cantidad de escombros, parece como si hubiera sucedido \n"
													+ "un terremoto o explosi�n, has vuelto por donde has venido, hay un cient�fico medio enterrado en los escombros \n"
													+ "pero tiene algo en su mano. �Quieres mirar?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												objetoZona = Gestora.obtenerObjeto(objetos, "Llave coche");
												if (!objetoZona.getEquipado()) {
													Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
												}else {
													Gestora.mostrarTextoLento("Ya no queda nada interesante que hacer aqu�");
												}
											}else {
												Gestora.mostrarTextoLento("Sigues tu camino, has vuelto al principio del laboratorio");												
											}
										break;	//Fin Opci�n Continuar Pasillo
										
										case 5://Opci�n Entrar en oficina
											Gestora.mostrarTextoLento("Es una oficina com�n y corriente todos los ordenadores est�n apagados excepto uno, �Quieres ver que hay en �l?");
											respuesta = validacion.leerValidarRespuesta();
											if(respuesta == 'S') {
												Gestora.mostrarTextoLento("El ordenador tiene un e-mail abierto, en el pone lo siguiente:");
												historia = Gestora.obtenerTextoHistoria(7); //Se obtiene el texto de la historia n�mero 7
												Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 7
											}else {
												Gestora.mostrarTextoLento("Has salido de la oficina y has vuelto al principio del laboratorio");	
											}
										break;//Fin Opci�n entrar en oficina
										
										case 6: //Opci�n mirar mochila
											usuario.mirarContenidoMochila();
										break; //Fin Opci�n mirar mochila
										
										case 7: //Opci�n ver estado
											Gestora.mostrarTextoLento(usuario.toString()+"\n");
										break; //Fin Opci�n ver estado
										}
									}while(opcionLaboratorio != 0 && usuario.getVida() > 0);
								}
							break; //Fin Opci�n Investigar pared desgastada
							
							case 3: //Opci�n Investigar grifo goteando
								Gestora.mostrarTextoLento("No es m�s que una tuber�a con un grifo.");
								if(usuario.consultarObjetosNecesarioMochila("V�lvula")){
									Gestora.mostrarTextoLento("Parece que le falta una pieza y por eso gotea...");
									Gestora.mostrarTextoLento("La v�lvula encaja perfectamente. �Quieres colocarla sobre en el grifo roto?");
									respuesta = validacion.leerValidarRespuesta();
									
									if(respuesta == 'S'){
										usuario.colocarObjeto("V�lvula"); //La v�lvula se usa y ya desaparace no se puede volver a obtener
										Gestora.mostrarTextoLento("Has colocado la v�lvula y has girado la manivela parece que funciona");
										Gestora.mostrarTextoLento("*PRPRPRPRPRP* Un gran estruendo sucumbe la habitaci�n, parece que la parede se est� abriendo");
										Gestora.mostrarTextoLento("La pared desgastada se ha abierto, resultaba ser un pasadizo secreto, ahora parece ser la entrada a un rec�ndito y extra�o lugar...");
										entradaLaboratorio = true;	
									}else {
										Gestora.mostrarTextoLento("No has colocado nada");
									}
								}else {
									if(entradaLaboratorio == true) {
										Gestora.mostrarTextoLento("Gracias a la v�lvula el grifo ya no gotea");
									}else {
										Gestora.mostrarTextoLento("Es como si algo pudiera deterner el goteo");
									}
								}
							break; //Fin Opci�n Investigar grifo goteando
						
							case 4: //Opci�n mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opci�n mirar mochila
							
							case 5: //Opci�n ver estado
								Gestora.mostrarTextoLento(usuario.toString()+"\n");
							break; //Fin Opci�n ver estado
							}
							
						}while(opcionSotano != 0 && usuario.getVida() > 0);
					break;	//Fin Opci�n Bajar al s�tano
					
					case 5: //Opci�n mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opci�n mirar mochila
					
					case 6: //Opci�n ver estado
						Gestora.mostrarTextoLento(usuario.toString()+"\n");
					break; //Fin Opci�n ver estado
					
					}
				
				}while(opcionMansion != 0 && usuario.getVida() > 0);
				
			break;// Fin Opci�n ir a la mansion
			
			case 4://Opci�n ir a la gasolinera
				
				//Restar Movimiento al Jugador
				usuario.reducirMovimiento();
				
				do{
					//LeerYValidarOpcionesGasolinera
					opcionGasolinera = validacion.mostrarObtenerOpcionesGasolinera();
					switch(opcionGasolinera) {

					case 1: //Opci�n registrar caja registradora
						Gestora.mostrarTextoLento("Es una vieja caja registradora");
						objetoZona = Gestora.obtenerObjeto(objetos, "D�lares");
						
						if (!objetoZona.getEquipado()) {
							Gestora.mostrarTextoLento("Parece que a�n tiene dinero");
							Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
							
						}else {
							Gestora.mostrarTextoLento("Ya no queda nada interesante que hacer aqu�");
						}
					break;//Fin Opci�n registrar caja registradora
						
					case 2://Opci�n Revisar surtidores
						Gestora.mostrarTextoLento("Actualmente se encuentran fuera de servicio");	
					break;//Fin Opci�n Revisar surtidores
					
					case 3://Opci�n Mirar coche en mal estado
						Gestora.mostrarTextoLento("No es m�s que un coche completamente destruido");
						Gestora.mostrarTextoLento("Parece que intento huir de la ciudad pero se choco por desgracia ninguna de las piezas del veh�culo te servir�n");
						
						if(cocheDestruidoRevisado == false) { //Si el coche no ha sido revisado todav�a
							Gestora.mostrarTextoLento("�Quieres registrar el interior del veh�culo a ver si contiene algo?");
							respuesta = validacion.leerValidarRespuesta();
							
							if(respuesta == 'S') {
								enemigo = new Personaje("Zombie Tullido",250,20);
								Gestora.mostrarTextoLento("Ha salido un "+enemigo.getNombre()+" justo al abrir las puertas del coche");	
								Gestora.combateJugadorEnemigo(enemigo, usuario);
								cocheDestruidoRevisado = true;
								
								if(usuario.getVida() > 0) {
									Gestora.mostrarTextoLento("El zombie ha muerto y ha dejado caer una nota, dice lo siguiente:");
									historia = Gestora.obtenerTextoHistoria(8); //Se obtiene el texto de la historia n�mero 8
									Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 8
								}
							}else {
								Gestora.mostrarTextoLento("No has abierto el coche lo has dejado tal y como estaba");	
							}
						}else {
							Gestora.mostrarTextoLento("Ya no queda nada interesante que hacer aqu�");							
						}
					break;//Fin Opci�n Mirar coche en mal estado
					
					case 4://Opci�n Mirar Almac�n
	
						do {
							//LeerYValidarOpcionesAlmacenGasolinera
							opcionAlmacen = validacion.mostrarObtenerOpcionesAlmacenGasolinera();
							switch(opcionAlmacen) {
							
							case 1://Registrar Zona
								
								if(palancaActivada == false) { //Si la palanca de la electricidad no ha sido activada
									
									if(cajasApartadas == false){ //Si no se han apartados las cajas	
										Gestora.mostrarTextoLento("Nada m�s hay cajas viejas");
										Gestora.mostrarTextoLento("�Quieres apartarlas?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											cajasApartadas = true;
											Gestora.mostrarTextoLento("Ouch!! Una llave inglesa ha golpeado tu cabeza");
											Gestora.mostrarTextoLento("Has sufrido un leve da�o");
											usuario.recibirDanho(30);	
											
										}else{
											Gestora.mostrarTextoLento("Las has dejado donde estaban");
										}
									}
									
									if(cajasApartadas == true && usuario.getVida() > 0) { //Si las cajas fueron apartadas y el jugador esta vivo. Se controla que el jugador este vivo porque la primera vez que se quitan las cajas habra un objeto que te haga da�o 																									
										Gestora.mostrarTextoLento("Detr�s de las cajas hay una vieja palanca. �Quieres usarla?");
										respuesta = validacion.leerValidarRespuesta();
										
										if(respuesta == 'S'){
											palancaActivada = true;
											Gestora.mostrarTextoLento("Parece que la electricidad ha sido desactivada");
											
										}else{
											Gestora.mostrarTextoLento("No la has activado");
										}
									}		
								}else {	
									Gestora.mostrarTextoLento("Ya no queda nada interesante que hacer aqu�");
								}
							
							break; //Fin Registrar Zona
							
							case 2://Revisar Puerta Extra�a
								
								Gestora.mostrarTextoLento("Se trata de la puerta de un armario de limpieza con un simbolo de Warning");
								Gestora.mostrarTextoLento("�Quieres abrir la puerta?");
								respuesta = validacion.leerValidarRespuesta();
								
								if(respuesta == 'S') {
									
									objetoZona = Gestora.obtenerObjeto(objetos, "Gasolina");
									if (!objetoZona.getEquipado()) { //Sino se tiene equipado el objeto de esta zona 
										if(palancaActivada == false) { //Sino se activo la palanca que corta la electricidad
											usuario.recibirDanho(50);
											Gestora.mostrarTextoLento("TRTRTTRTRTTRTR *SONIDO DE CHISPORROTEO*");
											Gestora.mostrarTextoLento("Has recibido algo de da�o");
											Gestora.mostrarTextoLento("Vaya parece que te has llevado una buena descarga, al parecer la puerta tiene \n"
													+ "alg�n tipo de mecanismo de seguridad y a�n sigue cerrada");
										}else {
											Gestora.mostrarTextoLento("Has abierto la puerta, justo detr�s de ella parece haber un bid�n de algo");
											Gestora.interaccionUsuarioConObjeto(objetoZona, usuario);
										} 
									}else {
										Gestora.mostrarTextoLento("No hay nada, ya no queda nada interesante que hacer aqu�. Cierras la puerta al salir");
									}
									
								}else {			
									Gestora.mostrarTextoLento("No la has abierto");
								}
							break;//Fin Revisar Puerta Extra�a
							
							case 3: //Opci�n mirar mochila
								usuario.mirarContenidoMochila();
							break; //Fin Opci�n mirar mochila
							
							case 4: //Opci�n ver estado
								Gestora.mostrarTextoLento(usuario.toString()+"\n");
							break;	//Fin Opci�n ver estado
							}
						
						}while(opcionAlmacen != 0 && usuario.getVida() > 0);

					break; //Fin Opci�n Mirar Almacen
					
					case 5: //Opci�n mirar mochila
						usuario.mirarContenidoMochila();
					break; //Fin Opci�n mirar mochila
					
					case 6: //Opci�n ver estado
						Gestora.mostrarTextoLento(usuario.toString());
					break;	//Fin Opci�n ver estado
					}
					
				}while(opcionGasolinera != 0 && usuario.getVida() > 0);
				
			break;//Fin Opci�n ir a la gasolinera
			
			case 5:	//Opci�n mirar contenido mochila
				usuario.mirarContenidoMochila();
			break;	//Fin Opci�n mirar contenido mochila
			
			case 6: //Opci�n mirar estado
				Gestora.mostrarTextoLento(usuario.toString()+"\n");
			break;	//Fin Opci�n mirar estado
			}

		}while(opcionInicial != 0 && usuario.getVida() > 0 && usuario.getMovimientos() > 0 && objetosMision == false);
		
		//Mostrar diferentes tipos de final
		if(opcionInicial == 0) {
			Gestora.mostrarTextoLento("Has abandonado el juego");
		}else {
			if(objetosMision == true) {
				Gestora.mostrarTextoLento("Has conseguido salir sano y salvo de la ciudad, pero en el coche comienza a reproducirse un mensaje a trav�s de la radio");
				historia = Gestora.obtenerTextoHistoria(9); //Se obtiene el texto de la historia n�mero 9
				Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 9
				Gestora.mostrarTextoLento("�Quieres rendirte y entregarte a Nova Corp? S/N");
				respuesta = validacion.leerValidarRespuesta();
				if(respuesta == 'S'){
					historia = Gestora.obtenerTextoHistoria(10); //Se obtiene el texto de la historia n�mero 10
					Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 10
				}else {
					historia = Gestora.obtenerTextoHistoria(11); //Se obtiene el texto de la historia número 11
					Gestora.mostrarTextoLento(historia); //Se muestra el texto de la historia n�mero 11
				}
			}else {
				if(usuario.getMovimientos() == 0) {
					Gestora.mostrarTextoLento("\nVaya te has quedado sin movimientos, te sientes muy cansado y sin fuerza para hacer un desplazamiento tan largo, no te queda energ�a y no puedes moverte, este es tu fin \n"
							+ "has andado demasiado y tienes la boca muy seca, comienzas a alucinar y ves seres extra�as sufriendo y personas que te hacen da�o \n"
							+ "acto seguido, caes al suelo y poco a poco pierdes el conocimiento hasta que cierras los ojos y llega tu final.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}else { //Si el usuario se queda s�n vida
					Gestora.mostrarTextoLento("\nNo te queda vida, tu cuerpo no puede m�s, tus p�rpados pesan mucho y cierras los ojos, las heridas de tu cuerpo \n"
							+ "sangran m�s y m�s hasta que finalmente tu coraz�n deja de latir y mueres, tu conciencia, tu alma, tu ser, deja este mundo, para jam�s volver.\n");
					Gestora.mostrarFraseMuerte(pathFrases);
				}
			}
		}
		
		if(objetosMision == false) { //Si no completas la misi�n se da la opci�n de ver la soluci�n 
			Gestora.mostrarTextoLento("�Quieres conocer la soluci�n del juego? S/N");
			respuesta = validacion.leerValidarRespuesta();
			if(respuesta =='S') {
			//Mostrar soluci�n del juego
			System.out.println("\nSoluci�n del juego");
			System.out.println("1.Visitar el garaje para registrar la caja de herramientas y coger el Spray");
			System.out.println("2.Visitar cementerio, una vez dentro ir al cuartillo y coger la pala");
			System.out.println("  Una vez se tiene la pala, registrar la tumba numero 3 y coger la llave");
			System.out.println("3.Visitar la mansion e ir al jard�n, una vez all� entrar al cuartillo y coger la regadera. Se interactua con la planta");
			System.out.println("  Se derrota a la planta y se coge la v�lvula. Ir al s�tano de la mansion y se investiga el grifo que esta goteando y se coloca la v�lvula");
			System.out.println("  Una vez colocada se investiga la pared desgastada pues se abrio el laboratorio. Una vez dentro de este se comprueba la puerta oxidada, se entra y se coge la bater�a");
			System.out.println("  Dentro del laboratorio aun se continua por el pasillo y se coge la llave del coche");
			System.out.println("4.Visitar gasolinera y acceder al almacen, una vez dentro se registra la zona, se apartan las cajas y se activa la palanca");
			System.out.println("  A continuaci�n se revisar la puerta extra�a y se coge la gasolina");
			System.out.println("5.Volver al departemento, visitar de nuevo el garaje e investigar el coche y arrancarlo para poder escapar y fin del juego.");
			}	
		}
		teclado.close();
	}
}
