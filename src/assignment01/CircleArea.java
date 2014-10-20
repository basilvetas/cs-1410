package assignment01;
import java.util.Scanner;

public class CircleArea 
{

	/**
	 * This program will receive input from the user and use it to 
	 * compute and display the area of a circle.
	 * 
	 * @author Basil Vetas
	 * @version January 15, 2013
	 */
	
	public static void main(String[] args) 
	{
		// This step declares my variables.
		
		double radius;
		double area; 
		
		// This step retrieves the user input from 'keyboard' 
		// and assigns it to 'radius'.
		
		Scanner keyboard = new Scanner(System.in);	 
		System.out.print("To calculate the area of a circle," 
							+ " please enter the radius: ");
		radius = keyboard.nextDouble();
				
		// This step uses the input value from 'radius' to compute
		// the area of the circle.
		
		area = (radius * radius)*(Math.PI);
				
		// Finally, this step prints the results to the console 
		// window.
		
		System.out.print("A circle of radius " + radius
							+ " has an area of " + area);
	}
}
