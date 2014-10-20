package assignment07;

/**
 *This object represents the weather for a single day
 * 
 * @author Basil
 * @version March 5, 2013
 */
public class Weather
{
    String date;
    int lowTemperature; 
    int highTemperature;
	
    public Weather(String date, int high, int low) 
    {
       	this.date = date;
    	highTemperature = high;
    	lowTemperature = low;
	}

    public String getDate()
    {
    	return date;
    }
    
    public int getHigh()
    {
    	return highTemperature;
    }
    
    public int getLow()
    {
    	return lowTemperature;
    }
    
    public String toString()
    {
    	String summary = date + " High: " + highTemperature + " Low: " + lowTemperature;
    	return summary;
    }

}
