package assignment02;
import java.util.Scanner;

public class FiniteLoop 
{

	/**
	 * This program creates a loop that seems like it will never terminate, but it actually does... 
	 * 
	 * Notes: I timed how long it took the program to terminate 3 times, and my times were 3.6 seconds,
	 * 3.5 seconds, 3.4 seconds. So I've concluded that it takes the program about 3.5 seconds on average
	 * to terminate. In order to see why the program terminated, within the 'while' loop body, below 'x++'
	 * I enter and 'if' statement that would print every number less than 100. I expected to see 1-99, but
	 * it also printed all the negative integers, counting down from '-2147483648'. I realized that once 
	 * the program reaches the highest number of '2147483647', it begins counting down the negative numbers
	 * from '-2147483648' until it reaches x = -1.
	 * 
	 * @Basil Vetas
	 * @January 21, 2013
	 */
	public static void main(String[] args)
	{
		// Declare variables
		
		int x = 0; 
		int y = -1;
		
		// Below is a loop that loops as long as X and Y are not equal.
		
		while(x != y)
		{	x++;
		}
		
		// This statement will print once the while loop is finished:
		
		System.out.println("Program Terminated");
	}		
}
