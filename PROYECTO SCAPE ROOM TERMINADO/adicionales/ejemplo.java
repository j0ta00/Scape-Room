package adicionales;

public class ejemplo {

	public static void main(String[] args) {
		String historia; 
		historia = Gestora.obtenerTextoHistoria(5);
		
		Gestora.mostrarTextoHistoriaLento(historia);

	}

}
