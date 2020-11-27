package Ejercicio5;
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args){
      //Declaración de variables
      int horas=0, minutos=0, segundos=0;
      Scanner teclado = new Scanner(System.in);
      do {
          System.out.println("Introduce una hora válida");
          horas=teclado.nextInt();
          System.out.println("Introduce un minuto válido");
          minutos=teclado.nextInt();
          System.out.println("Introduce un segundo válido");
          segundos=teclado.nextInt();
      }while(validarDosHoras( horas, minutos, segundos)==false);
      System.out.println("Han trascurrido "+tiempoTranscurrido(horas, minutos, segundos)+" segundos desde las 00:00:00");
      teclado.close();



    }
    /*Método para conocer si una hora es válida
     *
     *Cabecera/Signatura:public static boolean validarDosHoras(int horas, int minutos, int segundos)
     *Descripción:Se trata de un método que nos validará las horas, segundos y minutos que introduzca el usuario
     *Entrada:int horas, int minutos, int segundos
     *Salida:boolean primo
     *Precondiciones:
     *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato booleano
     *
     * */
    public static boolean validarDosHoras(int horas, int minutos, int segundos){
        //Declaración de variables locales
        boolean horasValidas=true;
        if(horas<0 || horas>23 ) {

            horasValidas = false;

        }else
            if(minutos<0 || minutos>60){
                horasValidas = false;
        }else
            if(segundos<0 || segundos>60){
                horasValidas = false;
            }

        return horasValidas;

    }
    /*Método para conocer el tiempo transcurrido en segundos
     *
     *Cabecera/Signatura:public static int tiempoTranscurrido(int horas, int minutos, int segundos)
     *Descripción:Se trata de un método que nos devolverá el tiempo transcurrido en segundos
     *Entrada:int horas, int minutos, int segundos
     *Salida:int segundos
     *Precondiciones:
     *Postcondiciones:Se trata de una función y nos devolvera un tipo de dato entero
     *
     * */
    public static int tiempoTranscurrido(int horas, int minutos, int segundos){
        //Declaración de variables locales
        final int pasoDehorasASegundos=3600, pasoDeMinutosASegundos=60;
        horas*=pasoDehorasASegundos;
        minutos*=pasoDeMinutosASegundos;
        segundos+=minutos+horas;
        return segundos;

    }
}
