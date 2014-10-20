package assignment05;

/**
 * This class allows you to input two numbers as a fraction and perform operations on them, 
 * such as retrieving the numerator or denominator, and performing fraction multiplication 
 * and division, addition and subtraction. You can also convert the fraction to type double.
 * 
 * @author bvetas
 * @date February 10, 2013
 */
public class Fraction 
{
	long numerator;
	long denominator;
	
	/**
	 * This method is the constructor of the class and takes two parameters. It will reduce
	 * fractions entered using the greatest common divisor
	 * 
	 * @param n
	 * @param d
	 */
	public Fraction (long n, long d)
	{
		// Computes the greatest common divisor of x and y using a well-known algorithm.
		
	    long gcd = n;
	    long remainder = d;

	    while (remainder != 0)
	    {
	        long temp = remainder;
	        remainder = gcd % remainder;
	        gcd = temp;
	    }
	    
		// This divides both the numerator and denominator by their greatest common factor
	    // in order to reduce them before being stored
	    n = n / gcd;
	    d = d/ gcd;
	    
	    // If the fraction is negative, it will negate both the numerator and denominator
	    // so that 4/-3 will be stored as -4/3
	    
	    if(d < 0)
	    {	d = d*(-1);
	    	n = n*(-1); 
	    }
	    
	    // stores the variables into the global variables 'numerator' and 'denominator'
	    
		this.numerator = n;
		this.denominator = d;
	}
	
	/**
	 * Takes one long as a parameter and turns it into a fraction with denominator of 1
	 * @param a
	 */
	public Fraction (long a)
	{
		// You could enter the number 5 and this will convert it to the fraction 5/1
		
		this.numerator = a;
		this. denominator = 1;
	}
	
	/**
	 * This method takes the long values in the constructor and converts them into Strings
	 * @return String
	 */
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * This method returns the numerator value n from the input Fraction.
	 * @return numerator
	 */
	public long getNumerator()
	{
		return numerator;
	}
	
	/**
	 * This method returns the denominator value d from the input Fraction.
	 * @return denominator
	 */
	public long getDenominator()
	{
		return denominator;
	}
	
	/**
	 * This method will convert the fraction into a 'double' value
	 * 
	 * @return a
	 */
	public double toDouble()
	{	
		double a = (double) this.numerator / this.denominator;
		return a;
	}
	
	/**
	 * This method takes one Fraction variable and performs multiplication between '.this' and
	 * the Fraction variable called 'rightHandSide'
	 * 
	 * @param rightHandSide
	 * @return result
	 */
	public Fraction multiply(Fraction rightHandSide)
	{
		// Create a variable to hold the result
		Fraction result;
		
		// Build a new Fraction object - send the products to the constructor
		result = new Fraction (this.numerator * rightHandSide.numerator,
                				this.denominator * rightHandSide.denominator);

		// Pass the resulting fraction back to the caller.
		return result; 
	}
	
	/**
	 * This object takes one Fraction variable and performs division between '.this' and
	 * the Fraction variable called 'rightHandSide'
	 * 
	 * @param rightHandSide
	 * @return result
	 */
	public Fraction divide(Fraction rightHandSide)
	{
		// Create a variable to hold the result
		Fraction result;
		
		// Build a new Fraction object - send the products to the constructor
		result = new Fraction (this.numerator * rightHandSide.denominator,
                				this.denominator * rightHandSide.numerator);

		// Pass the resulting fraction back to the caller.
		return result; 
	}
	
	/**
	 * This method takes one Fraction variable and performs addition between '.this' and
	 * the Fraction variable called 'rightHandSide'
	 * 
	 * @param rightHandSide
	 * @return result
	 */
	public Fraction add(Fraction rightHandSide)
	{
		// Create a variable to hold the result
		Fraction result;
		
		long newDenom = this.denominator * rightHandSide.denominator; 
		long newNum = ((this.numerator * (newDenom / this.denominator)) + 
						(rightHandSide.numerator * (newDenom / rightHandSide.denominator)));
		
		// Build a new Fraction object - send the products to the constructor
		result = new Fraction (newNum, newDenom);

		// Pass the resulting fraction back to the caller.
		return result; 
	}
	
	/**
	 * This method takes one Fraction variable and performs subtraction between '.this' and
	 * the Fraction variable called 'rightHandSide'
	 * 
	 * @param rightHandSide
	 * @return result
	 */
	public Fraction subtract(Fraction rightHandSide)
	{
		// Create a variable to hold the result
		Fraction result;
		
		long newDenom = this.denominator * rightHandSide.denominator; 
		long newNum = ((this.numerator * (newDenom / this.denominator)) - 
						(rightHandSide.numerator * (newDenom / rightHandSide.denominator)));
		
		// Build a new Fraction object - send the products to the constructor
		result = new Fraction (newNum,
                				newDenom);

		// Pass the resulting fraction back to the caller.
		return result; 
	}
}
