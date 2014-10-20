package assignment03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FinancialSummaries 
{

	/**
	 * This program receive a file from the user and reads through the selected file and evaluates 
	 * if the financial summaries are correct. This program uses a main method as well as 
	 * three helper methods. This program uses recursion to simplify the amount of code needed.
	 * 
	 * 
	 * @Basil Vetas
	 * @January 29, 2013
	 */
	public static void main(String[] args) 
	{
		// Creates the GUI to ask user to select a data file
		
		JFileChooser chooser;
		chooser = new JFileChooser("C:\\Users\\TEMP\\workspace\\CS1410\\src\\assignment03");
		chooser.setDialogTitle("Please Choose a Data File: ");
	
		// Prevents an error if the user cancels the dialog box
		
		int selection;
		selection = chooser.showOpenDialog(null);
		
		if(selection == JFileChooser.CANCEL_OPTION)
		{	return; 	// User cancelled the chooser.
		
		}
		
		// Creates a file to store the data file selected by the user
		
		File inputFile;
		inputFile = chooser.getSelectedFile();
		JOptionPane.showMessageDialog(null, "You chose: " + inputFile);
		
 		try
		{	//Create the scanner and calls a helper method
			
			Scanner in = new Scanner(inputFile);
			scanNextTransaction(in);
			JOptionPane.showMessageDialog(null, "Your financial data is correct!");
		}
		catch(IOException e)
		{
			// This code runs if there is an error
		
			JOptionPane.showMessageDialog(null, "Could not read the file: " + inputFile);
		}
	}
	
	/**
	 * This method will evaluate the next transaction listed and return the dollar value listed.
	 * To call this method, enter a 'scanner' parameter, and the program will return the value in dollar
	 * terms of that transaction.
	 * 
	 * @param a
	 * @return moneyValue
	 */
	public static double scanNextTransaction(Scanner a)
	{	double moneyValue = 0;
		
		// Creates a variable to store the next string in the file
	
		String word = a.next();
		
		// Evaluates if the string say 'BUY' or 'SELL' or else 'SUMMARY'
		
		if(word.equals("BUY") || word.equals("SELL"))
		{
			// Scans the date and stores it in 'date'
			
			String date = a.next();
			
			// Scans the value and uses a helper method to convert it to a double, 
			// then stores it in 'moneyValue'
			
			moneyValue = scanMoneyValue(a);	
		}
		else	// If the next transaction is a 'SUMMARY' it will go here
		{	
			moneyValue = scanSubSummary(a);
		}
		
		// This will return the dollar value of the next transaction as a 'double', either from
		//	a single transaction or a summary of many sub-transactions.
		
		return moneyValue;	
	}
	
	/**
	 * This method scan the selected string and converts it from a 'string' into a 'double' 
	 * value that can be evaluated. To call this method, enter a 'scanner' parameter and the 
	 * method will return the next dollar value listed as a 'double'.
	 * 
	 * @param b
	 * @return convertString
	 */
	public static double scanMoneyValue(Scanner b)
	{	String nextWord;
		
		nextWord = b.next();	// This stores the next dollar value as a 'string
		
		String dropSign = nextWord.substring(1); //Gets rid of $ sign
		double convertString;
		convertString = Double.parseDouble(dropSign); // Converts 'string' to 'double'
	
		return convertString; // This returns the dollar value as a double that can be compared to other numbers
	}
		
	/**
	 * This method scans the summary line of a transaction and stores each value. It then adds up the values
	 * of each transaction within that summary and evaluates if the total is equal to the value listed on 
	 * the summary line. To call this method, enter a 'scanner' parameter and the method will return either 
	 * a message that your summary is incorrect, or it will return the summary value if correct.
	 * 
	 * @param c
	 * @return summaryValue
	 */
	public static double scanSubSummary(Scanner c)
	{	
		// stores the remainder of the SUMMARY
		
		String summaryDate = c.next();
		double summaryValue = scanMoneyValue(c);
		int transactions = c.nextInt();
		
		// Adds the values of the Sub-Summaries
		
		double total = 0;
		while (transactions > 0)	// This will add all the sub-transactions within a summary
		{	double subSummary = scanNextTransaction(c);
			total = total + subSummary;		// This add the next transaction to the previous one
			transactions--;
		}
		
		// Evaluates if the Summary value is equal to the total value of its transactions
		
		if(Math.abs(summaryValue - total) >= 1e-10)
		{
			// Convert double to a string format with 2 decimal places
			
			String formatted;
			formatted = String.format("%.2f", total);	
			
			// If the Summary and Transactions are not equal, it will print an error message and exit
			
			JOptionPane.showMessageDialog(null, "Summary error on " + summaryDate + ". \nAmount is " 
											+ summaryValue + ", should be " + formatted + ".");
			System.exit(0);
		}
		
		return summaryValue; // This will return the 'summaryValue' if it equals the total of all transactions
	
	}	
}
