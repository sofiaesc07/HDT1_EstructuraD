
public interface Radio{
    
    public boolean isOn();
    
    public void turnOnOff();
    
    public void nextStation(boolean frequency);
    
    public void prevStation(boolean frequency);
    
	public double getSavedStation(int position);
    
    public boolean getFrequency();

	public void switchAMFM();
	
	public double getStation();
    
    public void saveStation(int position, double station);
}