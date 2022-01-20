import java.util.ArrayList;

/**
 * @author Sofia Escobar
 *
 */
public class RControlador implements Radio{
	
	private boolean isOn;
	private String frecuencia;
	private double getStation;
	private ArrayList<Double> emisoras;
	
	/**
	 * @param isOn
	 * @param frecuencia
	 * @param getStation
	 * @param emisoras
	 */
	public RControlador() {
		this.isOn = true;
		this.frecuencia = "AM";
		this.getStation = 1070;
		this.emisoras = new ArrayList<Double>();
		for(int i=0;i<12;i++)
		{
		    emisoras.add(0.00);
		}
	}

	@Override
	public void turnOnOff() {
		// TODO Auto-generated method stub
		isOn = !isOn;
	}

	public String nextStation(boolean frequency) {
		// TODO Auto-generated method stub
		String cadena = "Reproduciendo ";
		double posicion = getStation;
		if(frecuencia == "AM") {
			if(frequency) {
				posicion = (posicion == 1610)?530:posicion +10;
			}else {
				posicion = (posicion == 530)?1610:posicion -10;
			}
		}else {
			if(frequency) {
				posicion = (posicion == 107.9)?87.9:posicion +0.2;
			}else {
				posicion = (posicion == 87.9)?107.9:posicion -0.2;
			}
			posicion = Math.round(posicion*100.0)/100.0;
		}
		getStation = posicion;
		cadena = cadena + getStation + " " + frecuencia + "...";
		return cadena;
	}

	@Override
	public void switchAMFM() {
		// TODO Auto-generated method stub
		if(frecuencia == "AM") {
			frecuencia = "FM";
			getStation = 97.9;
		}else {
			frecuencia = "AM";
			getStation = 107.0;
		}
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void saveStation(double station, int position) {
		// TODO Auto-generated method stub
		emisoras.set(position, station);
	}

	public String getSavedStation() {
		// TODO Auto-generated method stub
		int position = 0;
        String cadena = "Listado de emisoras guardadas:\n=====================================================\n\n";
		for(double em:emisoras) {
			position+=1;
			if(em == 0){
				cadena = cadena + position + ".) \n";
			}else if(em-(int)em==0) {
				cadena = cadena + position + ".) "+ em + " AM\n";
			}else {
				cadena = cadena + position + ".) "+ em + " FM\n";
			}
			
		}
		return cadena;
	}
	
	public String getSavedStation(int position) {
		// TODO Auto-generated method stub
		String cadena = "Reproduciendo ";
		if(emisoras.get(position) == 0) {
			cadena = "Parece que no tienes una emisora en ese espacio.";
		}else {
			getStation = emisoras.get(position);
			String f = "";
			if(getStation-(int)getStation==0) {
				frecuencia = "AM";
			}else {
				frecuencia = "FM";
			}
			cadena = cadena + getStation + " " + frecuencia + "... ";
		}
		return cadena;
	}
	
	public String mostrarEstado() {
		// TODO Auto-generated method stub
		String cadena = "";
		String estado = (isOn)?"Encendido":"Apagado";
		String emi = (!isOn)?"Sin reproducciones aun":""+getStation;
		String frec = (!isOn)?"":""+frecuencia;
		
		cadena = "Estado del Radio: "+ estado + "\nReproduciendo: "+ emi + " " + frec + "\n";
		return cadena;
	}

	@Override
	public String toString() {
		return "RadioController [power=" + isOn + ", frecuencia=" + frecuencia + ", emisora_seleccionada="
				+ getStation + ", emisoras=" + emisoras + "]";
	}
}
