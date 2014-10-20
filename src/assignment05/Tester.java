package assignment05;


public class Tester 
{

	/**
	 * This method tests all of the methods in the 'Fraction' class
	 * 
	 * @author bvetas
	 * @date February 10, 2013
	 */
	public static void main(String[] args) 
	{	System.out.println("Fraction tester:" );
	
			// Testing Fraction constructor
		Fraction a = new Fraction (3, 10);
		
			// Testing Fraction constructor
		Fraction b = new Fraction (7, -8);
		
			// Testing Fraction multiply method
		Fraction c = a.multiply(b);
		
			// Testing Fraction divide method
		Fraction d = a.divide(b);
		
			// Testing Fraction add method
		Fraction e = a.add(b);
		
			// Testing Fraction subtract method
		Fraction f = a.subtract(b);
		
			// Testing double toDouble method
		double g = a.toDouble();
		
			// Testing long getDenominator method
		long h = a.getDenominator();
		
			// Testing long getNumberator method
		long i = b.getNumerator();
		
			// Testing second Fraction constructor
		Fraction j = new Fraction(4);
		
			// Testing second Fraction constructor
		Fraction k = new Fraction(-6);
			
			// Prints output
		System.out.println(a + " * " + 
						b + " * " +
						c + " * " +
						d + " * " +
						e + " * " +
						f + " * " +
						g + " * " +
						h + " * " +
						i + " * " +
						j + " * " +
						k);

	}
	

}
