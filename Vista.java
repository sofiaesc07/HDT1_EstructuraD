import java.util.Scanner;

public class Vista {
    
    public Scanner sc = new Scanner(System.in);

    public Boolean isOn(){  //Menu que solo muestra la opción para encender la radio
 
        System.out.println("========== Radio ===========");   
        System.out.println("[ 1 ] Encender");
        String respuesta = "";
        while(true){
            System.out.print("Opcion No: ");
            respuesta = sc.nextLine();
            if(respuesta.equals("1")){
                return true;
            }
            else{
                System.out.println("\nRespuesta no reconocida, intenta de nuevo..\n");
            }
        }
    }

    public String MenuRadio(){ //Metodo para mostrar el menú general para los carros de modelo S, A  y C, es decir que todos los modelos pueden realizar estas opciones
 
        System.out.println("========== Radio  ==========");
        System.out.println("[ 1 ] Cambiar FM/AM");
        System.out.println("[ 2 ] Avanzar emisora");
        System.out.println("[ 3 ] Guardar emisora");
        System.out.println("[ 4 ] Seleccionar emisora");
        System.out.println("[ 5 ] Apagar la radio");

        String respuesta = "";
        while(true){
            System.out.print("Opcion No: ");
            respuesta = sc.nextLine();
            if(respuesta.equals("1") || respuesta.equals("2") || respuesta.equals("3") || respuesta.equals("4" ) || respuesta.equals("5")){
                return respuesta;
            }
            else{
                System.out.println("\nRespuesta no reconocida, intenta de nuevo..\n");
            }

        }
    }
}
