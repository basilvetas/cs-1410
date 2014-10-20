package assignment01;
import java.util.Scanner;

public class Hypotenuse 
{

	/** 
	 * This program will compute the hypotenuse of a right triangle 
	 * by receiving user input for the length of two sides and
	 * computing the third using the Pythagorean Theorem.
	 * 
	 * @author Basil Vetas
	 * @version January 15, 2013
	*/ 	
	
	public static void main(String[] args) 
	{
		// This step declares my variables.
		double sideA;
		double sideB;
		double hypotenuse;
		
		// This step receives two user inputs from 'keyboard' and
		// assigns them to 'sideA' and 'sideB' respectively.
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("To calculate the hypotenuse of the " 
							+ "triangle, please enter the length" 
							+ " of side a: ");
		sideA = keyboard.nextDouble();
		System.out.print("Now, please enter the length of side b: ");
		sideB = keyboard.nextDouble();
		
		System.out.print("Your triangle has sides of length "
							+ sideA + " and " + sideB);
		
		// This step calculates the hypotenuse of the triangle using
		// the Pythagorean Theorem.
		
		hypotenuse = Math.sqrt((sideA*sideA) + (sideB*sideB));
		
		// Finally, this step prints the results to the console 
		// window.  
		
		System.out.print(", and the hypotenuse of your triangle is "
							+ hypotenuse);
	}
}
