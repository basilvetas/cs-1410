package assignment05;

import java.io.IOException;

import javax.swing.JOptionPane;

public class ComputePi
{
	/**
	 * This main method will compute the number Pi which is roughly 3.14159
	 * 
	 * @author bvetas
	 * @date February 10, 2013
	 */
	public static void main(String[] args)
	{	
		// Creates variables to be used in the 'for' loop
		
		Fraction total = null;
		Fraction sum = new Fraction(0);
		int counter = 0;
		//This 'for' loop creates the recursion of the equation, allowing for
		// the summation of all the fractions.	
		
		for(long k = 0; k < 5 ; k++) 																			
		{
			// Gets first part of fraction	
			Fraction firstRatio = Ratio(k); 	
			
			// Gets second part of fraction
			Fraction secondRatio = Equation(k);
			
			// Multiplies fractions together to get total
			total = secondRatio.multiply(firstRatio);
		
			// Sums using fractions
			try
			{
				sum = sum.add(total); 
			}
			catch (ArithmeticException e) 
			{  
			      
			}
			
			counter = (int) k;
		}
		
		double pi = sum.toDouble();
		
		// Displays the number 'Pi' as calculated by the main method
		JOptionPane.showMessageDialog(null, "The number Pi is equal to " 
										+ pi  + " and it took "
										+ counter + " iterations to compute the result.");
		// Displays Pi as a fraction
		JOptionPane.showMessageDialog(null,  "As a fraction, Pi is equal to " + sum + ".");
	}
	
	/**
	 * This computes the ratio 1 divided by 16 raised to the k power
	 * 
	 * @param long
	 * @return Fraction
	 */
	public static Fraction Ratio(long k)
	{	
		//raises the number 16 to the kth power
		double raisedToK = Math.pow(16, k);
		
		// Creates a new fraction with 16^k as the denominator
		Fraction ratio1 = new Fraction(1, (long) raisedToK);
		
		// Returns the fraction
		return ratio1;
		
	}
	
	/**
	 * This computes the sum of the ratios in the bracketed part
	 * of the formula for Pi.
	 * 
	 * @param long
	 * @return Fraction
	 */
	public static Fraction Equation(long k)
	{	
		// Turns the term (8 x k) into a variable
		long timesK = 8*k;
		
		// Creates the four rational terms in the bracketed part of
		// the 'Pi' equation
		
		Fraction first = new Fraction(4, (timesK + 1));
		Fraction second = new Fraction(2, (timesK + 4));
		Fraction third = new Fraction(1, (timesK + 5));
		Fraction fourth = new Fraction(1, (timesK + 6));
		
		// Subtracts term 2, 3, and 4 from the first term
		Fraction total = first.subtract(second).subtract(third).subtract(fourth);
		
		// Returns the total
		return total;
	}
}
