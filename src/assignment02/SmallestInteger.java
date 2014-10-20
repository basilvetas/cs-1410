package assignment02;
import java.util.Scanner;

public class SmallestInteger 
{

	/**
	 *This program determines the smallest integer that cannot have its full Hailstone 
	 *sequence computed using only 'int' variables.
	 *Notes: This program takes less than a second to finish, however, when I was testing
	 *to find the smallest number, I printed out the variable 'count', and it took a few
	 *seconds to compute before reaching the smallest number. 
	 * 
	 * @Basil Vetas
	 * @January 21, 2013
	 */
	public static void main(String[] args) 
	{
		// First I declare my necessary variable so that I can create a counting loop to evaluate all of
		// the possible integers and find the smallest one that cannot compute the Hailstone sequence.
		
	
		int count = 1;
		int Smallest = 0;
		
		// Below is the counting loop that has the Hailstone sequence within it.
		
		while((count*3 + 1) > count)
		{	
			count++;				// Counts up by one
		
		// This step computes the Hailstone sequence for the initial number N and counts the number of 
		// iterations required to converge to 1.
			
			int N = count;
			Smallest = count;
			while(N != 1)
			{	if(N % 2 == 0) 			// if N is even, it will divide N by 2
				{	N = N/2;		
				}
				else if((N*3 + 1) < N)
				{	count = N;
					break; 				// The smallest integer is 113383.
				}
				else
				{	N = N*3 + 1;		// if N is odd, it will multiply N*3 + 1
				} 					
			}
		}
		
		// Prints the answer
		
		System.out.print("The integer " + Smallest + " cannot have its Hailstone sequence computed using int"
				+ " variables.");
	}
}
