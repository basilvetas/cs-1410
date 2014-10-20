package assignment01;
import java.util.Scanner;

public class Converter 
{
	/** 
	 * This program will receive the user input as an integer  
	 * (length in inches) and convert that value to a 
	 * double (length in millimeters).
	 * 
	 * @author Basil Vetas
	 * @version January 15, 2013
	*/ 	
	
	public static void main(String[] args) 
	{
		// This step declares my variables.
		// Note: an error will occur if the user enters a double 
		// value for their input, because 'inches' is of type int.
		
		int inches;
		double millimeters;
		
		// This step retrieves the user input from 'keyboard' 
		// and assigns it to 'inches'.
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("To convert inches to millimeters, " 
							+ "please enter a whole number: ");
		inches = keyboard.nextInt();
		
		// This step computes the calculation from inches into 
		// millimeters.
		
		millimeters = inches * 25.4;
		
		// Finally, this step prints the results to the console 
		// window.  
		
		System.out.print("You entered " + inches 
							+ " inches, which equals " 
							+ millimeters + " millimeters.");
	}
}
