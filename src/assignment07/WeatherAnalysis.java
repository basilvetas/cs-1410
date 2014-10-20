package assignment07;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This class evaluate the weather over a one year period of time for different features
 * such as cold fronts, high temperatures, low temperatures, etc.
 * 
 *@author Basil Vetas
 *@date	3/5/13
 */
public class WeatherAnalysis 
{	
	/**
	 * Creates chooser and fills arrays with data file content
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{	String[] weatherDates = new String[365];
		int[] highTemps = new int[365];
		int[] lowTemps = new int[365];
		Weather[] year = new Weather[365];
	
		// Creates the GUI to ask user to select a data file
		
		JFileChooser chooser; 
		chooser = new JFileChooser("C:\\Users\\TEMP.USERS.002\\workspace\\CS1410\\src\\assignment07");
		chooser.setDialogTitle("Please Choose a Weather Data File: ");
	
		// Prevents an error if the user cancels the dialog box
		int selection;
		selection = chooser.showOpenDialog(null);
		if(selection == JFileChooser.CANCEL_OPTION)
		{	return; 	// User cancelled the chooser.
		}
		
		// Creates a file to store the data file selected by the user
		File inputFile;
		inputFile = chooser.getSelectedFile();
		JOptionPane.showMessageDialog(null, "You chose: " + inputFile);
		
 		try
		{	//Create the scanner and fill arrays
			Scanner in = new Scanner(inputFile);
			int count = 0;
			while(in.hasNext())
			{
				String date = in.next();
				int high = in.nextInt();
				int low = in.nextInt();
				weatherDates[count] = date;
				highTemps[count] = high;
				lowTemps[count] = low;
				year[count] = new Weather(date, high, low);
				count++;
			}

		}
		catch(IOException e)
		{
			// This code runs if there is an error
			JOptionPane.showMessageDialog(null, "Could not read the file: " + inputFile);
		}
 		
 		//Computation 1
 		int highTemp = findHigh(highTemps);
 		String highTempDate = extremeDate(highTemp, highTemps, weatherDates);
 		int lowTemp = findLow(lowTemps);
 		String lowTempDate = extremeDate(lowTemp, lowTemps, weatherDates);
 		
 		// Computation 2
 	 	int perfectDays = countPerfectDays(lowTemps, highTemps);
 	 	
 	 	// Computation 3
 	 	int coldFronts = countColdFronts(highTemps, lowTemps);
 	 	
 	 	// Computation 4
 		int[] tenHigh = getHighTempDays(year);
 		int[] tenLow = getLowTempDays(year);
 		
 		// Computation 5
 		Weather[] median = getMedianDays(year);
 		
 		//Within this try/catch, it creates a new .txt file to print the results
 		try
 		{
 		File outputFile = new File(inputFile.getParentFile(), "results.txt"); 		
 		PrintWriter out = new PrintWriter (outputFile);
 		// prints all the results of computations to new file
 		out.println ("Assignment #7 \nCS 1410 \nBasil Vetas \n");
 		// Computation 1
 		out.println ("The maximum high temperature was " + highTemp + " on " + highTempDate + ".");
 		out.println ("The minimum low temperature was " + lowTemp + " on " + lowTempDate + ".");
 		//Computation 2
 		out.println ("There " + (perfectDays == 1? "was ":"were ") + perfectDays + " perfect days in the year.");
 		//Computation 3
 		out.println ("There " + (perfectDays == 1? "was ":"were ") + coldFronts + " significant cold fronts this year.");
 		//Computation 4
 		out.print ("The temperatures of the ten coldest days of the year were: ");
 		for(int i=0; i < tenLow.length; i++)
 			out.print(tenLow[i] + " ");
 		out.print("\n");
 		out.print ("The temperatures of the ten hottest days of the year were: ");
 		for(int i=0; i < tenHigh.length; i++)
 			out.print(tenHigh[i] + " ");
 		out.print("\n");
 		//Computation 5
 		out.println ("The five median days were:\n" + median[0] + "\n" + median[1] + "\n" + median[2] + "\n" + median[3] + "\n" + median[4]);
 		out.close ();  // Completes the file writing
 		}
 		catch(IOException e)
 		{
 			System.out.println("Error");	//runs if there is an error
 		}
	}
	
	/**
	 * This method will return the highest temperature of the year.
	 * 
	 * @param temp
	 * @return high
	 */
	public static int findHigh(int[] temp)
	{	// int for highest temp	
		int high = 0;
		
		// nested loop to compare all the temperatures and find the highest
		for(int i = 0; i < temp.length; i++)
		{	high = temp[i];
			for(int j = 1; j < temp.length; j++)
			{	
				if(temp[j] > high)
				{
					high = temp[j];	//sets the highest temp to 'high'
					
				}
			}
		}
		return high;	// returns highest temp
	}
	
	/**
	 * This will find the lowest temperature of the year
	 * 
	 * @param temp
	 * @return low
	 */
	public static int findLow(int[] temp)
	{	// int for lowest temp	
		int low = 0;
			
		// nested loop to compare all the temperatures and find the lowest
		for(int i = 0; i < temp.length; i++)
		{	low = temp[i];
			for(int j = 1; j < temp.length; j++)
			{	
				if(temp[j] < low)
				{
					low = temp[j];	//sets the lowest temp to 'low'
					
				}
			}
		}
		return low;	// returns lowest temp
	}
	
	/**
	 * This will take your extreme temperature, and find the date that
	 * corresponds to it and return that date
	 * 
	 * @param temp, weather, weatherDate
	 * @return dateOfExtreme
	 */
	public static String extremeDate(int temp, int[] weather, String[] weatherDate)
	{	// variable for date of either highest or lowest temp
		String dateOfExtreme = null;
		
		// loop to compare extreme temp to position in array
		for(int i = 0 ; i < weather.length; i++)
		{
			if(weather[i] == (temp))		// if extreme temp equals temp in that position of the array
			{
				dateOfExtreme = weatherDate[i];		// sets extreme date to date of corresponding position												
			}
		}

		return dateOfExtreme;	// returns date of extreme temperature
	}	
	
	/**
	 * Counts perfect days
	 * 
	 * @param lowTemps, highTemps
	 * @return countPerfectDays
	 */
	public static int countPerfectDays(int[] lowTemps, int[] highTemps)
	{	// counter for perfect days
		int perfectDays = 0;
		// loop to check for a cold front in the temperature range
		for(int i = 0; i < lowTemps.length; i++)
		{
			if(lowTemps[i] >= 50 && highTemps[i] < 80)
			{
				perfectDays++;	// add to counter
			}
		}
		//return number of perfect days
		return perfectDays;
	}
	
	/**
	 * Counts significant cold fronts
	 * 
	 * @param highTemps, lowTemps
	 * @return coldFronts
	 */
	public static int countColdFronts(int[] highTemps, int[] lowTemps)
	{	// counter for cold fronts
		int coldFronts = 0;
		// loop to check for a significant cold front
		for(int i = 1; i < lowTemps.length; i++)
		{	
			if((lowTemps[i] <= (lowTemps[i-1] - 15)) || (highTemps[i] <= (highTemps[i-1] - 15)))
			{	
				coldFronts++;	//add to counter if day had a cold front
			}
		}
		//return number of cold fronts
		return coldFronts;
	}
	
	/**
	 * finds 10 hottest days of the year
	 * 
	 * @param year
	 * @return tenHottest
	 */
	public static int[] getHighTempDays(Weather [] year)
	{	// array to hold ten hottest temps
		int[] tenHighest = new int[10];
		// sorts 'year' array
		Arrays.sort(year, new HighTempComparator());
		// assigns ten hottest temps to new array
		for(int i = 0; i < 10; i++)
			tenHighest[i] = year[i].getHigh();
		// returns ten hottest temps
		return tenHighest;
	}
	
	/**
	 * Sorts Weather by high temperatures from highest to lowest
	 * 
	 * @author Basil Vetas
	 * @date 3/5/13
	 */
	private static class HighTempComparator implements Comparator<Weather>
	{
	    public int compare(Weather a, Weather b)
	    {
	        // 'if' statements that compare a and b for order
	    	if(a.getHigh() > b.getHigh())
	    		return -1;
	    	if(a.getHigh() < b.getHigh())
	    		return 1;
	    	
	    	return 0;
	    }
	}
	/**
	 * finds 10 coldest days of the year
	 * 
	 * @param year
	 * @return tenLowest
	 */
	public static int[] getLowTempDays(Weather [] year)
	{	// creates array to hold coldest temps
		int[] tenLowest = new int[10];
		// sorts weather
		Arrays.sort(year, new LowTempComparator());
		// assigns ten coldest temps into the new array
		for(int i = 0; i < 10; i++)
			tenLowest[i] = year[i].getLow();
		//returns coldest temps
		return tenLowest;
	}
	
	/**
	 * Sorts low temperatures from lowest to highest
	 * 
	 * @author Basil Vetas
	 * @date 3/5/13
	 */
	private static class LowTempComparator implements Comparator<Weather>
	{
	    public int compare(Weather a, Weather b)
	    {
	        // 'if' statements that compare a and b for order
	    	if(a.getLow() < b.getLow())
	    		return -1;
	    	if(a.getLow() > b.getLow())
	    		return 1;
	    	
	    	return 0;
	
	    }
	}
	
	/**
	 * Finds 5 median days of the year
	 * 
	 * @param year
	 * @return medianDays
	 */
	public static Weather[] getMedianDays(Weather [] year)
	{	// creates array to hold median days weather
		Weather[] medianDays = new Weather[5];
		// sorts array
		Arrays.sort(year, new MedianComparator());
		// sets each position of median days to the five middle days in 'year'
		medianDays[0] = year[181];
		medianDays[1] = year[182];
		medianDays[2] = year[183];
		medianDays[3] = year[184];
		medianDays[4] = year[185];
		// returns median days
		return medianDays;
	}
	
	/**
	 * 
	 * @author Basil Vetas
	 * @date 3/5/13
	 */
	private static class MedianComparator implements Comparator<Weather>
	{
	    public int compare(Weather a, Weather b)
	    {
	        // 'if' statements that compare a and b for order
	    	if(a.getHigh() < b.getHigh())
	    		return -1;
	    	if(a.getHigh() > b.getHigh())
	    		return 1;
	    	
	    	return a.getLow() - b.getLow();
	
	    }
	}
}
