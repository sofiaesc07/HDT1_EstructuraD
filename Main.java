import java.util.Scanner;

/**
 * @author Ana Sofía Escobar
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Radio inter = new RControlador();
		
		RControlador radio = new RControlador();
		Scanner sc = new Scanner(System.in);
		
		boolean menu = true;

        while(menu) {
        	
        	System.out.println("");
        	System.out.println("+----------------------------------+");
            System.out.println("|             Radio               |");
            System.out.println("+----------------------------------+");
            System.out.println("");
            System.out.println(radio.mostrarEstado());
            System.out.println("");
            System.out.println("1. Encender/Apagar.");
            System.out.println("2. Cambiar frecuencia (AM/FM).");
            System.out.println("3. Avanzar dial de emisora.");
            System.out.println("4. Guardar emisora.");
            System.out.println("5. Reproducir emisora predeterminada.");
            System.out.println("6. Salir.");
            System.out.println("");
            System.out.print("Seleccione el numero de la accion que desea realizar: ");
            int sel = sc.nextInt();
            sc.nextLine();
            while(sel < 1 || sel > 6) {
            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                sel = sc.nextInt();
                sc.nextLine();
    		}
            System.out.println("");
            if(sel == 6) {
            	menu = false;
            	System.out.println("...");
            }else if(sel==1) {
            	inter.turnOnOff();
        		System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==2) {
            	if(radio.obtenerPoder()) {
            		inter.switchAMFM();
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==3) {
            	if(radio.obtenerPoder()) {
            		boolean escoger = true;
                	while(escoger) {
	            		System.out.print("Elija para donde quiere ir (1. Adelante / 0. Atras): ");
	                    String cam = sc.nextLine();
	                    if(cam.equals("1")) {
	                    	System.out.println(radio.nextStation(true));
	                    }else {
	                    	System.out.println(radio.nextStation(false));
	                    }
	                    System.out.print("�Desea cambiar otra vez de emisora?(1. Si / 0. No): ");
	                    String ch = sc.nextLine();
	                    if(!ch.equals("1")) {
	                    	escoger = false;
	                    }
                	}
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==4) {
            	if(radio.obtenerPoder()) {
            		
                    System.out.print("Elija que frecuencia es (1. AM / 0. FM): ");
                    String cam = sc.nextLine();
                    
                    System.out.print("Ingrese el numero de la emisora que desee guardar: ");
                    double vo = sc.nextDouble();
                    vo = round(vo, 2);
                    sc.nextLine();
                    boolean completo = true;             
                    if(cam.equals("1")) {
	            		int valor = (int)vo %10;
	            		while(vo < 530 || vo > 1610 || valor != 0) {
	                    	System.out.print("Parece que eso no es una emisora AM. Intente de nuevo:");
	                    	vo = sc.nextDouble();
	                        sc.nextLine();
	                        valor = (int)vo %10;
	            		}
                    }else {
                    	double valor = vo-(int)vo;
                    	valor = round(valor, 1);
	            		while(vo < 87.9 || vo > 107.9 || !(valor == 0.1 || valor == 0.3 || valor == 0.5 || valor == 0.7 || valor == 0.9)) {
	                    	System.out.print("Parece que eso no es una emisora FM. Intente de nuevo:");
	                    	vo = sc.nextDouble();
	                        sc.nextLine();
	                        valor = vo-(int)vo;
	                    	valor = round(valor, 1);
	            		}
                    }
                    System.out.print("Ingrese en que posicion quiere colocarlo: ");
                    int po = sc.nextInt();
                    sc.nextLine();
                    po -= 1;
                    while(po < 0 || po > 12) {
                    	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                    	po = sc.nextInt();
                        sc.nextLine();
            		}
                    radio.saveStation(vo, po);
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }else if(sel==5) {
            	if(radio.obtenerPoder()) {
                    System.out.println(radio.getSavedStation(sel));
            		System.out.print("Ingrese el numero de emisora que desea reproducir: ");
                    int po = sc.nextInt();
                    sc.nextLine();
                    po -= 1;
                    while(po < 0 || po > 12) {
	                    System.out.print("Seleccion fuera de rango. Intente de nuevo:");
	                    po = sc.nextInt();
	                    sc.nextLine();
             		}
                    System.out.println(radio.seleccionar_guardada(po));
            	}else {
            		System.out.println("Radio apagada");
            	}
            	System.out.println("Presione enter para continuar...");
        		sc.nextLine();
            }
        }
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
