
/**
 * Defines all the methods that a Radio should have.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public interface Radio{

    public void turnOnOff();
    /**
     * Move forward into the station dial.
     * @param station boolean indicating if the frequency is AM or FM. true = AM
     */

    public double getStation();
    /**
     * Save a station on the favorites array.
     * @param position index indicating where to store the station.
     * @param station double indicating the station.
     */
    public void saveStation(int position, double station);
    /**
     * Get a saved station on the favorites array
     * @param position index indicating which station to pick.
     */
    public double getSavedStation(int position);
    /**
     * Get the current frequency.
     * @return boolean indicating if it is AM or FM. true = AM.
     */
    public boolean getFrequency();
    /**
     * Switch the frequency selected.
     */

    @Override
    public void nextStation() {//Metodo para cambiar la emisora del radio.
        this.emisora_actual += 0.5f;
        System.out.println("Se ha cambiado a la emisora " + this.emisora_actual);
    }

    public void nextStation() {//Metodo para cambiar la emisora del radio.
        this.emisora_actual += 0.5f;
        System.out.println("Se ha cambiado a la emisora " + this.emisora_actual);
    }

    @Override
    public void prevStation(boolean station);
    () { //Método que guarda las emisoras y que indica cuando ya no hay espacio para guardar más.

        if(this.emisoras_guardadas.size() > 50){
            System.out.println("\nLimite de emisoras sobrepasado!\n");
        }
        else{this.emisoras_guardadas.add(this.emisora_actual);
        System.out.println("Se ha guardado la emisora actual " + this.emisora_actual);}
    }
    @Override
    public void CargarAEmisora() { //Método para mostrar que emisora se está reproduciendo.

        System.err.println("Cargando emisora actual [" + this.modo_actual + "] " + this.emisora_actual);
    }

    public void switchAMFM(){//Metodo para cambiar la frecuencia del radio.

        if(this.modo_actual.equals("AM")){this.modo_actual = "FM";}
        else{this.modo_actual = "AM";}
        System.out.println("Se ha cambiado al modo " + this.modo_actual);
    }
} 