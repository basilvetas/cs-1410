package assignment01;
import java.util.Scanner;

public class Temperature 
{
	/**
	 * This program will receive an input from the user (Fahrenheit
	 * temperature) and convert it into Celsius temperature. 
	 * 
	 * @author Basil Vetas
	 * @version January 15, 2013
	 */
	
	public static void main(String[] args) 
	{
		// This step declares my variables
		// Note: an error will occur if the user enters a double 
		// value for their input, because 'inches' is of type int
		
		int tempFaht;	// Fahrenheit temperature
		int tempCels;	// Celsius temperature
		
		// This step receives user input from 'console' and assigns
		// the value to 'tempFaht'.
		
		System.out.print("Enter the Fahrenheit temperature: ");
		Scanner console = new Scanner(System.in);
		tempFaht = console.nextInt();
		
		// This step partially converts the Fahrenheit temperature
		//into the Celsius temperature. 
		
		tempCels = (tempFaht -32);
		
		// This step completes the conversion and prints the result
		// to the console.
		
		System.out.print("A temperature of " + tempFaht + " degree" 
							+ " Fahrenheit equals "  
							+ ((5.0/9)*(tempCels)) 
							+ " degrees Celsius.");
	}
}
