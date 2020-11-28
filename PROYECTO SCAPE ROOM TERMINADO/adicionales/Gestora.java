package adicionales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objetos.Objeto;
import personajes.Jugador;
import personajes.Personaje;
import validaciones.Validaciones;

public class Gestora {
		
	/*
	 * Prototipo: public static boolean comprobarExistenciaFichero(String path)
	 * 
	 * Comentario: Este metodo encarga de comprobar si existe un fichero.
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Path es la ruta del fichero por lo tanto debe ser especificada de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion ya que devuleve un tipo de dato, en este caso un booleano(existe)
	 * 					el cual puede tomar dos posibles valores:
	 * 					-true: Si el fichero ya existe
	 * 					-false: Si el fichero no existe
	 * 
	 */
	public static boolean comprobarExistenciaFichero(String path) {
		File file = new File(path);
		
		return file.exists();
	}
	
	/*
	 * Prototipo: public static void guardarFrasesMuerte(String path)
	 * 
	 * Comentario: Este metodo guardara en un fichero varias frases para cuando un personaje muera 
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Path es la ruta del fichero donde se van a crear las frases, por lo tanto debe ser especificada de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento por lo que no devolvera ningun tipo de dato, en este caso solo
	 * 					escribira en un fichero varias frases
	 * 
	 */
	public static void guardarFrasesMuerte(String path) {
		
		BufferedWriter bw =null;
		
		try {
			bw = new BufferedWriter(new FileWriter(path));
			
			//Se escriben las frases en el fichero
			bw.write("“Las guerras seguirán mientras el color de la piel siga siendo más importante que el de los ojos.”-Bob Mareley-\n");
			bw.write("“Dar el ejemplo no es la principal manera de influir sobre los demás; es la única manera.”-Albert Einstein-\n");
			bw.write("“El dinero no puede comprar la vida.” -Últimas palabras de Bob Marley a su hijo-\n");
			bw.write("“Ningún hombre es lo bastante bueno para gobernar a otros sin su consentimiento.”-Abraham Lincoln-\n");
			bw.write("“El sabio no dice nunca todo lo que piensa, pero siempre piensa todo lo que dice.”-Aristóteles-\n");
			bw.write("“Lo que importa verdaderamente en la vida no son los objetivos que nos marcamos, sino los caminos que seguimos para lograrlo.”-Peter Bamm-\n");
			bw.write("“El mundo es bello, pero tiene un defecto llamado hombre.”-Friedrich Nietzsche-\n");
			bw.write("“De humanos es errar y de necios permanecer en el error.”-Marco Tulio Cicerón-\n");
			bw.write("“Hace falta toda una vida para aprender a vivir.”-Séneca-\n");
			bw.write("“Podrán cortar todas las flores, pero no podrán detener la primavera.”-Pablo Neruda-\n");
			bw.write("“Las últimas palabras son para los tontos que no han dicho suficiente.”-Últimas palabras de Karl Marx-\n");
			bw.write("“No es que me aterrorizara contemplar cosas horribles, sino que me aterraba la idea de no ver nada.”-Edgar Allan Poe-\n");
			bw.write("“Las religiones, como las luciérnagas, necesitan de oscuridad para brillar.”-Arthur Schopenhauer-\n");
			bw.write("“La peor lucha es la que no se hace”-Karl Marx-\n");
			bw.write("“El corazón tiene razones que la razón ignora”-Blaise Pascal-");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				bw.close();//Se cierra el fichero de escritura
			}catch(IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * Prototipo: public static void mostrarFraseMuerte(String path)
	 * 
	 * Comentario: Este metodo se encarga de mostrar una frase emotiva aleatoria cuando el jugador muera.
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Path es la ruta del fichero donde estan las frases, por lo tanto debe ser especificada de forma correcta
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento ya que no devolvera ningun tipo de dato, solo mostrara una frase al usuario
	 * 
	 */
	
	public static void mostrarFraseMuerte(String path){
		int aleatorio = (int)(Math.random()*15+1); //Entre 1 y 15 porque hay 15 frases
		String frase = "";
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(path));
			
			for(int i = 1; i <= aleatorio; i++) { //Mientras no se haya llegado a la frase numero(Aleatorio)
				frase = br.readLine();
			}
			
			System.out.println(frase);
			
		}catch(IOException e){
			e.printStackTrace();
		} finally{
			
		 	try{
		 		br.close(); //Se cierra el fichero de lectura
			}catch(IOException e){
				e.printStackTrace();
			}		
		}
	}
	/*
	 * Prototipo: public static void crearGuardarObjetos(String path)
	 * 
	 * Comentario: Este metodo se encarga de crear y guardar en un fichero una serie de objetos de tipo Objeto.
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Path es la ruta del fichero donde se crearan los objetos por lo que debera de estar bien especificada
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento, no devolvera ningun tipo de dato,
	 * 					solo creara una serie de objetos de tipo Objeto y los escribira en un fichero
	 * 
	 */
	public static void crearGuardarObjetos(String path) {
		
		ObjectOutputStream  oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));

			//Creacion de los objetos, que van ha salir en el juego
			oos.writeObject(new Objeto("Pala", 15, "Quizas puedas desenterrar algo con ella o defenderte"));
			oos.writeObject(new Objeto("Gasolina", 0, "Igual puede servir como combustible"));
			oos.writeObject(new Objeto("Llave coche", 0, "Vinculado con Audi R8"));
			oos.writeObject(new Objeto("Bateria", 0, "Tiene el tamaño perfecto para encajar en un automovil"));
			oos.writeObject(new Objeto("Pistola", 50, "Ideal para defenderte en medio de un apocalipsis"));
			oos.writeObject(new Objeto("Hacha", 30, "Te permitira cotar y despedazar"));
			oos.writeObject(new Objeto("Regadera", 0, "Aun contiene agua"));
			oos.writeObject(new Objeto("Dolares", 0, "La moneda de cambio mas popular, aunque no te serviara de mucho en un apocalipsis"));
			oos.writeObject(new Objeto("Llave vieja", 0, "Esta vieja pero todavia funciona"));
			oos.writeObject(new Objeto("Zapato usado", 0, "No huele muy bien pero... ¿Donde esta el otro?"));
			oos.writeObject(new Objeto("Taza", 1, "Perfecta para hacerte un ColaCao"));
			oos.writeObject(new Objeto("Spray de aceite", 0, "Te permite engrasar cosas para que tengan un correcto funcionamiento"));
			oos.writeObject(new Objeto("Valvula", 0, "Se trata de una gran válvula muy vieja, quizás aún funcione"));
		}catch(IOException i) {
			i.printStackTrace();
		}finally {
			
			try {
				oos.close();//Se cierra fichero de escritura
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
	}
	
	/*
	 * Prototipo: public static ArrayList<Objeto> obtenerObjetos(String path)
	 * 
	 * Comentario: Este metodo se encarga de buscar y coger todos objeto de tipo Objeto de un fichero y almacenarlos en un ArrayList.
	 * 			   (Se carga un fichero de Objeto en memoria)
	 * 
	 * Entradas: String path
	 * 
	 * Salidas: ArrayList<Objeto> solicitados
	 * 
	 * Precondiciones: Path es la ruta del fichero donde estan los objetos por lo que debera de estar bien especificada
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion por lo que devolvera un tipo de dato, en este caso un ArrayList<Objeto>
	 * 					que contendra todos los objetos de tipo Objeto que hay en un fichero
	 *  
	 */
	public static ArrayList<Objeto> obtenerObjetos(String path) {
		
		ArrayList<Objeto> solicitados = new ArrayList<Objeto>();
		Objeto objeto = null;
		ObjectInputStream  ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			
			while( (objeto = (Objeto)ois.readObject() ) != null ) { //Mientras no se ha fin de fichero
				solicitados.add(objeto); //Se guarda el objeto en el ArrayList solicitados
			}
	
		}catch(EOFException e){
			//Cuando se lee un fichero con ObjectInputStream y se llega a fin de fichero se lanza una excepcion EOFException
		}catch(IOException | ClassNotFoundException i ) {
			i.printStackTrace();
		}finally {	
			
			try {
				ois.close();//Se cierra el fichero de lectura
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
		return solicitados;
	}
	
	/*
	 * Prototipo: public static Objeto obtenerObjeto(ArrayList<Objeto> objetos, String nombre)
	 * 
	 * Comentario: Este metodo se encarga de coger un objeto de tipo Objeto de un ArrayList de Objeto
	 * 
	 * Entradas: ArrayList<Objeto> objetos, String nombre
	 * 
	 * Salidas: Objeto solicitado
	 * 
	 * Precondiciones: Nombre debe ser el de un objeto que haya en el ArrayList sino se devolvera Null(Vacio)
	 * 
	 * Postcondiciones: Este metodo se trata de una funcion por lo que devolvera un tipo de dato, en este caso un Objeto que sera 
	 * 					uno segun el nombre especificado como parametro formal
	 *  
	 */
	public static Objeto obtenerObjeto(ArrayList<Objeto> objetos, String nombre) {
		
		Objeto solicitado = null; 
		
		for(int i = 0; i < objetos.size() && solicitado == null; i++ ) { //Mientras haya objetos que mirar en el ArrayList y no se haya encontrado el objeto deseado
			
			if(objetos.get(i).getNombre().equals(nombre)) { //Si el nombre del objeto en la posicion i del ArrayList es igual al nombre recibido como parametro
				solicitado = objetos.get(i);
			}
		}
		return solicitado;
	}

	/*
	 * Prototipo: public static void iteracionUsuarioConObjeto(Objeto objeto, Jugador usuario)
	 * 
	 * Comentario: Este metodo se encarga de preguntar al usuario si desea coger un objeto y si es asi se guardara en el inventario y si 
     * 			   si este esta lleno se podra tirar otro objeto para hacer sitio al nuevo objeto
	 * 
	 * Entradas: Ninguna
	 * 
	 * Salidas: Ninguna 
	 * 
	 * Entradas/Salidas: Objeto objeto, Jugador usuario(El atributo equipado del objeto puede variar y la mochila del usuario tambien)
	 * 
	 * Precondiciones: Ninguna
	 * 
	 * Postcondiciones:Este metodo se trata de un procedimiento, en el cual se guardara un objeto en la mochila del usuario si este lo desea.
	 * 
	 */
	public static void iteracionUsuarioConObjeto(Objeto objeto, Jugador usuario) {
		char respuesta = ' ';
		int posicionMochila = 0;
		Validaciones validacion = new Validaciones();
	
		System.out.println("Has encontrado el siguiente objeto: "+objeto.getNombre());
		System.out.println("¿Quieres cogerlo?");
		respuesta = validacion.leerValidarRespuesta();
		
		if(respuesta == 'S') {
			if (usuario.cogerObjeto(objeto)) { //Si se puede coger el objeto porque se tiene sitio en la mochila
				System.out.println("El objeto ha sido equipado");
	
			} else {
				System.out.println("Tienes el inventario lleno");
				System.out.println("¿Quieres tirar algun objeto? Introduce 'S' para tirarlo o 'N' para no hacerlo");
				respuesta = validacion.leerValidarRespuesta();
				
				if (respuesta == 'S') {
					System.out.println("Estos son los objetos que tienes en tu inventario: ");
					usuario.mirarContenidoMochila(); //Muestra el contenido de la mochila del jugador
					posicionMochila = validacion.obtenerPosicionMochila(); //Lee la posicion del objeto a tirar
					System.out.println("Has tirado el objeto, puede ser que haya vuelto al lugar de origen");
					usuario.tirarObjeto(posicionMochila); //Se tira dicho objeto
					usuario.cogerObjeto(objeto); //Se guarda el nuevo objeto
				}
			}
		}else {
			System.out.println("Has dejado el objeto donde estaba");
		}
	}
	
	/*
	 * Prototipo: public static void combateJugadorEnemigo(Personaje enemigo,Jugador usuario )
	 * 
	 * Comentario: Este metodo se encarga de realizar un combate entre el usuario y un enemigo que solo acabara cuando
	 *			   la vida de alguno de los dos llegue a 0
	 * 
	 * Entradas: Ninguna 
	 * 
	 * Salidas: Ninguna
	 * 
	 * Entradas/Salida: Personaje enemigo, Jugador usuario(Se modificara la vida o del usuario o del enemigo o de ambos)
	 * 
	 * Precondiciones: Tanto el enemigo como el usuario no pueden estar a vacios(null), sino se producira una excepcion
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento, solo se modificara la vida del enemigo y el usuario
	 * 
	 */
	public static void combateJugadorEnemigo(Personaje enemigo,Jugador usuario ) {
		Validaciones validacion = new Validaciones();
		
		int ataqueUsuario = 0, ataqueEnemigo = 0, posicionMochila = 0;
		char respuesta = ' ';
		do {
			//LeerValidar respuesta(En este caso sera la forma de atacar al enemigo)
			System.out.println("Quieres usar un objeto de tu mochila para atacar al enemigo(S), si dices que no prepara tus puños(N)");
			respuesta = validacion.leerValidarRespuesta();
			
			if(respuesta == 'S') {
				System.out.println("Miras rapido el contenido de tu mochila a ver si tienes algo util");
				usuario.mirarContenidoMochila(); //Mostrar contenido de la mochila del usuairo
				posicionMochila = validacion.obtenerPosicionMochila();//Se selecciona el lugar en la mochila donde esta el objeto que quiere usar
				ataqueUsuario = usuario.realizarAtaque(posicionMochila);//Usuario realiza un ataque en funcion del objeto que ha seleccionado, si no hay nada en esa posicion(null) se tendra en cuenta y se atacara solo con el daño base
				
			}else {
				ataqueUsuario = usuario.realizarAtaque();//Ataque sin usar ningun objeto, solo con su daño base
			}
			
			//Resultado ataque usuario
			System.out.println("Has realizado un ataque de "+ataqueUsuario);
			enemigo.recibirDanho(ataqueUsuario);
			
			if(enemigo.getVida() > 0) { //Si el enemigo esta vivo
				
				//Resultado ataque enemigo
				ataqueEnemigo = enemigo.realizarAtaque();
				System.out.println("Has recibido un ataque de "+ataqueEnemigo);
				usuario.recibirDanho(ataqueEnemigo);
			}
			
			System.out.println(usuario.getNombre()+" tu vida es de: "+usuario.getVida());
			System.out.println("La vida de "+enemigo.getNombre()+" es de: "+enemigo.getVida()+"\n");
			
		}while(enemigo.getVida() > 0 && usuario.getVida() > 0);
	}
	
	/*
	 * Prototipo: public static void mostrarTextoHistoria(int parte)
	 * 
	 * Comentario: Este metodo se encarga de mostrar una parte especifica de la historia del juego
	 * 
	 * Entradas: int parte
	 * 
	 * Salidas: Ninguna
	 * 
	 * Precondiciones: Parte tiene que ser un numero entre 1 y 11
	 * 
	 * Postcondiciones: Este metodo se trata de un procedimiento ya que no devuelve ningun tipo de dato, solo muestra un parte de la historia del juego
	 */
	public static void mostrarTextoHistoria(int parte) {
		
		switch(parte) {
		case 1: 
			System.out.println("Sientes mucho frío, comienzas a abrir los ojos y te encuentras en una habitación muy ordenada \n"
					+ "no es más que un departamento común, tiene unas grandes ventanas, a través de ellas ves la ciudad, completamente \n"
					+ "desolada, en ruinas y todo parece vacío, decenas de cadáveres se amontonan en las calles y extrañas figuras reptan \n"
					+ "y se mueven sinuosamente, algunos parecen humanos pero están en condiciones deplorables, de repente a tu cabeza llegan \n"
					+ "varias preguntas la primera de todas quien eres y que haces aquí, no recuerdas nada apenas vislumbras lejanos recuerdos \n"
					+ "lo único que queda en tu memoria es tu nombre y la sensación de que sabes que hay algo que hacer y que debes escapar de esta ciudad...\n"
					+ "¡Que comience el espectáculo!");
		break;
		
		case 2:
			System.out.println("Parece que hay una nota, dice lo siguiente:");
			System.out.println("Alfred, muchas gracias por hacerme este favor, se que Emily falleció hace muchos años y nunca es agradable \n"
					+ "tener que pertubar el lugar de descanso pero no se me ocurre otro lugar donde pueda esconder ese objeto sin que sea encontrado por ellos \n"
					+ "tu también trabajaste en la mansión y sabes para que sirve esa llave, sin ella no podrán entrar ahí dentro donde he guardado el otro objeto \n"
					+ "que les impedirán bajar ahí abajo, nadie podrá encontrarlos, contacto contigo vía carta por que no se sí me están espiando y quizás \n"
					+ "escuchan las llamadas de mi teléfono, se que si Emily siguiera viva ella misma aceptaría esto, la extraño mucho y aunque no este aquí \n"
					+ "me ayudará a su manerá, se que todo esto es mi culpa pero no podía dejar que esas criaturas sufrierán, parecían humanos y sentián el dolor \n"
					+ "como nosotros, como iba a saber que Nova Corp no quería llevarselos si no sembrar el caos en la ciudad, ahora tengo que huir de ellos \n"
					+ "y de mis propios compañeros de trabajo, si el señor Mason se enterará también enviaría sicarios a por mi, estoy en una situación horrible \n"
					+ "y personas inocentes morirán por mi culpa, no espero su perdón solamente espero que entiendan que yo solo quería salvar la vida de esas criaturas \n"
					+ "bueno Alfred esta será probablemente mi ultima carta antes de que me asesinen, espero que en el laboratorio no hayan descubierto ya que he liberado \n"
					+ "los especímenes si no allí encontraré mi final, bueno muchas gracias por hacerme este gran favor esperemos que nadie se quede con las muestras del laboratorio \n"
					+ "y todas las criaturas no hagan daño a la gente...");
			System.out.println("El resto de la nota esta arrancado y no puede leerse");
		break;
		
		case 3:
			System.out.println("El libro tiene una página marcada, la pagina habla sobre jardinería pero dentro parece haber una nota");
			System.out.println("La nota dice lo siguiente: Las pruebas con el espécimen vegetal ya comienza a dar sus frutos señor Mason, \n"
					+ "me pongo en contacto con usted por correspondencia debido a que tenemos sospechas de que Nova Corp tiene un infiltrado \n"
					+ "en nuestras filas y se encuentra en nuestro propio laboratorio por lo que no es seguro usar la intranet de la compañia \n"
					+ "no se preocupe pondremos fin a esto enseguida y todo seguirá según lo acordado, saludos cordiales \n"
					+ " Firmado Doctor Alex Morgan");
		break;
		
		case 4:
			System.out.println("Has entrado dentro de la habitación y aquello parece una sala de tortura \n"
					+ "hay grandes manchas de sangre seca en el suelo, las paredes son de un marrón ennegrecido \n"
					+ "huele a muerto y apenas se ve bien ni con la luz encendida, es un escenario muy macabro \n"
					+ "también hay diversos instrumentos de tortura como herramientas, cuchillos y un enorme arsenal \n"
					+ "de numerosos y horribles utensilios, de entre estos destaca una gran batería con dos cables conectados \n"
					+ "y unas enormes pinzas, por alguna extaña y escalofriante razón esa sala te resulta familiar y te provoca un \n"
					+ "enorme pavor en el cuerpo...");
		break;
		
		case 5:
			System.out.println("		-Resultados tests 28-10-2012:\n"
					+ "El individuo C-238 responde adecuadamente a los estímulos es altamente resistente a \n"
					+ "todo tipo de daños, a su vez es inmune a la infección del resto de especímenes como el B-126 o el \n"
					+ "B-220 si bien estos pueden herirle de gravedad o matarle no pueden hacer que este forme parte de la simbiosis \n"
					+ "por lo cual es inmune al virus que infecta a los otros especímenes, continuaremos las pruebas pero \n"
					+ "podemos estar ante uno de los mayores avances en el proyecto.\n"
					+ "		-Resultados tests 15-11-2012:\n"
					+ "Una vez más el prototipo C-238 nos sorprende, no solo demuestra una resistencia y fuerza muy superior si no \n"
					+ "que además es más inteligente que la media humana, se situa entorno a unos 175 CI es decir solo el 0,001% \n"
					+ "de la población actual cuenta con un CI similar, a su vez destaca en la comprensión del lenguaje apenas se encuentra \n"
					+ "en estado larvario y ya es capaz de mantener conversaciones, siguiendo el protocolo nosotros no respondemos nada a sus cuestiones \n"
					+ "a su vez su desarrollo motor es muy superior también al del ser humano muy pronto alcanzará la etapa de la niñez\n"
					+ "		-Resultados tests 05-03-2013:\n"
					+ "Tras varios meses poniendo a prueba al espécimen C-238 recomendamos su aislamiento debido a que no se puede asegurar \n"
					+ "su integridad o la de sus congéneres, C-238 ha desarrollado unas habilidades sagaces es capaz de resolver enormes \n"
					+ "ecuaciones integrales mientras se divierte viendo la televisión, ha aprendido a hablar numerosas lenguas sin haberlas escuchado previamente \n"
					+ "hablamos de habilidades casi omnipotentes debido a esto comenzamos con terapias de electrochoque y según la tomografía axial computarizada craneal \n"
					+ "el individuo presenta enormes lesiones en la zona craneal que le provocan perdidas de memoria a corto y largo plazo, a su vez varios tumores \n"
					+ "se desarrollan en distintas zonas de su cuerpo parece que no respondio bien a las terapias de choque, pensabamos que iba a ser \n"
					+ "la evolución del ser humano pero parece que aún debemos seguir trabajando en ello.\n"
					+ "El resto de notas estan rotas o son ilegibles, por alguna extraña razón comienza a dolerte mucho la cabeza...");
		break;
		
		case 6:
			System.out.println("	-Resultados tests 19-08-2013:\n"
					+ "El espécimen C-238 falleció desgraciadamente, pero tuvimos suerte y pudimos conservar muestras de su ADN \n"
					+ "gracias a esto hemos desarrollado a C-306 una mejor versión más estable, responde mejor a los estímulos, \n"
					+ "es mucho más sensato y de una inteligencia y habilidad muy similar, no cuenta con habilidades sensoriales o telepáticas\n "
					+ "esta versión es idéntico a un ser humano en apariencia de hecho es exactamente igual que este físicamente hablando pero tan capaz como C-238\n"
					+ "solo que este usa armas/herramientas para la resolución de enigmas(sin rasgos de semi omnipotencia), este es el avance que buscabamos,  \n"
					+ "la humanidad evolucionará al final y nos haremos de oro, con esto Nova Corp no tendrá nada que hacer y el ejercito usará nuestros experimentos, nos espera un futuro prometedor...");
		break;
		
		case 7:
			System.out.println("Lo sentimos señor Mason todo ha salido mal, ese traidor se alió con Nova Corp y \n"
					+ "ha conseguido liberar varios especímenes por qué según él estaban sufriendo y no era ético \n"
					+ "que sabrá ese patán viudo lo que es ético o no, no se preocupe he puesto fin a su vida y capturaremos \n"
					+ "a los especímenes antes de que hagan destrozos por la ciudad o sean capturados por Nova Corp, tenemos \n"
					+ "la ayuda de la policía local, no saben los detalles pero por una cuantiosa suma nos ayudarán, resolveremos est_");
			System.out.println("El e-mail esta sin terminar y todo esta rodeado de sangre por lo que no tuvo un buen final...");	
		break;
		
		case 8:
			System.out.println("Hola Tom las cosas se han puesto difíciles por aquí así que \n"
					+ "he decidido marcharme, los rumores son ciertos no estaban locos es verdad \n"
					+ "hay seres infernales por las afueras de la ciudad y sobre todo cerca de esa vieja mansión, \n"
					+ "antes de que esos seres lleguen a la ciudad deberías abandonarla, utiliza los surtidores \n"
					+ "y huye cuanto antes, pero si llegas tarde te dejaré combustible suficiente como para abandonarla, \n"
					+ "lo guardaré en el armario de la limpieza en el almacen de la gasolinera, recuerda que debes \n"
					+ "desactivar la electricidad si no quieres achicharrarte, también te dejo algo \n"
					+ "de efectivo en la caja por si necesitas comprar algo durante el viaje, te esperamos en la casa \n"
					+ "de mama, espero que esta carta te llegue a tiempo pues debido a que las carreteras estan cortadas \n"
					+ "no puedo hacertela llegar, además ni el internet ni la línea funcionan esto es muy extraño la polícia o \n"
					+ "incluso el gobierno debe estar detrás de esto,bueno mucha suerte espero que llegues sano y salvo y volvamos a vernos \n"
					+ "Con cariño tu hermano John");
		break;
		
		case 9: 
			System.out.println("Bien hecho monstruo, gracias a ti hemos conseguido averiguar donde estaba el laboratorio, hemos entrado y \n"
					+ "conseguido las muestras a su vez hemos comprobado tu eficacia, desde luego que no eres una humano normal, eres mucho más \n"
					+ "inteligente y capaz, además de tus habilidades para el combate usando armas y herramientas sin haber sido instruido en su uso \n"
					+ "son mejores que las de un veterano de guerra, pero aún así en ningún momento sospechaste que tu huida y todo había sido preparado \n"
					+ "para que nos condujeras hacia las muestras, a pesar de ser tan inteligente...JAJAJAJAJA!! no dejas de ser un inútil engendro, además \n"
					+ "nos libraste de ese extraño ser casi invencible del que nos había hablado nuestro ''infiltrado'' aunque el era casi tan tonto como tú \n"
					+ "y penso que os liberariamos y así fue el mismo te libero a ti y a especímenes agresivos que acabaron con la ciudad, quizás tu eras el único \n"
					+ "que a pesar de las torturas seguía cuerdo o que no era un experimento fallido casi zombie,no se como te sentirás tras saber todo esto, solamente decirte \n"
					+ "que gracias a ti Nova Corp será multimillonaria, nuestro principal competidor en la carrera biológica ha desaparecido, Mason se irá a la bancarrota \n"
					+ "te venderemos a ti y al resto de especímenes que desarrollemos al gobierno y ellos se encargarán de vosotros para lo que decidan, así que gracias por \n"
					+ "todo y que sepas que el coche tiene un localizador y aunque salgas de él estamos justo detrás de ti y delante así que mejor rindete y vuelve a ser una \n"
					+ "rata de laboratorio");
		break;
		
		case 10: 
			System.out.println("Has parado el coche en seco y has salido de él, apenas 1 minuto después varios coches de color negro y con las ventanas tintadas se acercan a ti. \n"
					+ " Una vez los coches están en tu posición varios agentes de Nova Corp se bajan y proceden a arrestarte, tu mientras con la cabeza agachada obedeces a sus ordenes, \n"
					+ " ese ha sido el final de tu historia, tu libertad se acabo por qué no eres humano como ellos, no eres un ser creado por la naturaleza, no eres más que los designios de una \n"
					+ "raza que decidió jugar a ser Dios, este dia ha sido el primer y último en el que has visto el sol y desde luego, no ha sido un día fácil...");
			
			System.out.println("\nQuien con monstruos lucha cuide de no convertirse a su vez en monstruo. Cuando miras largo tiempo a un abismo, también éste mira dentro de ti.");
			System.out.println("Friedrich Nietzsche");
			System.out.println("\n\n													FIN");
		break;
		
		case 11:
			System.out.println("Has seguido tu camino pero varios coches bloquean el paso, son coches de color negro y con las ventanas tintadas, antes de que puedas hacer nada \n"
					+ "comienzan a abrir fuego contra tu coche, de repente una lluvia de balas comienza a caer por la parte trasera del automóvil, sin poder reaccionar has sido \n"
					+ "alcanzado por una infinidad de balas y comienzas a desangrarte, tus parpados pesan mucho y cierras los ojos, pero no sientes tristeza, has muerto luchando \n"
					+ "al contrario sientes felicidad encontrarás la paz que no has encontrado en este mundo por algo que tu no elegiste ser ni hacer, este es el final de tu historia, \n"
					+ "varios agentes de Nova Corp se acercan para comprobar como el cuerpo del espécimen yace impertérrito sobre el coche, acto seguido este explota debido a la leve llama \n"
					+ "que asomaba en su capo, provocando la muerte de todos los agentes de la zona, parece que el karma a veces si actúa, la carretera quedo en silencio, tu conciencia mientras \n"
					+ "vuela en un mar de calma antes de que todo se vuelva más y más oscuro, hasta que dejas de sentir y se acabó,has dejado este mundo...");
			
			System.out.println("\nQuien con monstruos lucha cuide de no convertirse a su vez en monstruo. Cuando miras largo tiempo a un abismo, también éste mira dentro de ti.");
			System.out.println("Friedrich Nietzsche");
			System.out.println("\n\n													FIN");
		break;
		}
	}
}
