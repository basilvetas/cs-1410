package assignment02;
import java.util.Scanner;

public class HailstoneSequence 
{

	/**
	 * This is Part 1 of assignment #2. This program allows the user to input an integer and 
	 * then runs the 'Hailstone sequence' on the number until it converges to the integer 1.
	 * 
	 * @Basil Vetas
	 * @January 21, 2013
	 */
	public static void main(String[] args) 
	{
		// These steps declare the necessary variables to create a while loop asking the user to
		// input a number, and looping until the input in a positive number. 
		
		int inputN = 0;
		Scanner in = new Scanner(System.in);
		boolean userInputGood = false;
		
		while(! userInputGood)
		{	System.out.print("Enter a number: ");		  // Prompt user to input an initial number N.
			if (in.hasNextInt()){inputN = in.nextInt();}  // Input number N from the user (as an int). 
			else {in.next ();}							  // Prevents an error if input isn't type int.	
		
		// If the number is not positive, loop and ask the user to input another number.  
		// Keep asking the user for a number until they input a positive number.
			
			if(inputN > 0) {userInputGood = true;}
		}
		
		int initialN = inputN;
		
		// This step computes the Hailstone sequence for the initial number N and counts the number of 
		// iterations required to converge to 1.
		
		int iterations = 0;
		while(inputN != 1)
		{	if(inputN % 2 == 0) 	// if N is even, it will divide N by 2
			{	inputN = inputN/2;
				iterations++;
			}
			else 					// if N is odd, it will multiply N*3 + 1
			{	inputN = inputN*3 + 1;
				iterations++; 
			}
			
		}
		
		// Print out a user-friendly message with the original number N, along with a count 
		// of how many iterations were required to arrive at N==1.
		
		System.out.print("You entered the number N = " + initialN + ", and it took " + iterations 
							+ " iterations of the Hailstone sequence to reach N = 1");
		
	}
}
