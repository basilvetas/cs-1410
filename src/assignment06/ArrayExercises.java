package assignment06;

/* No other imports are allowed. */
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
/* No other imports are allowed. */


/**
 * This class contains a collection of static methods for processing arrays.
 * There are no instance or static variables.
 * This assignment does not use any Java library methods for sorting or searching through arrays.
 * 
 * @author Basil Vetas
 * @version February 19, 2013
 */

public class ArrayExercises
{
    /**
     * This method counts and returns how many times the target
     * string occurs in the array.  For this method,
     * two strings are considered the same if they contain
     * exactly the same text.
     * 
     * @param values   An array of String references
     * @param target   A target String object
     * @return   The number of strings in the array that equal the target
     * @throws NullPointerException   If values is null
     */
    public static int count (String[] values, String target)
    {
    	// Create counting variable
    	int count = 0;
    	// Look for target in array
    	for (int i = 0; i < values.length; i++) 
    	{
    		if (values[i].equals(target))
    			count++; // Increment count
    	}
        return count;
    }
    
    /**
     * This method sorts the elements in the data array
     * in descending order.  (The largest element will 
     * be placed in position 0.)
     * 
     * Note that this method does not have a return
     * type - the data array is sorted 'in place'.
     * 
     * @param data   The array to be sorted
     * @throws NullPointerException   If data is null
     */    
    public static void sort (int[] data)
    {
        // Loop for starting index
    	for (int i = 0; i < data.length; i++) 
    	{
    		int largestElement = i;
    		for (int j = i; j < data.length; j++) 
    		{
    			if (data[j] > data[largestElement])
    				largestElement = j;
    		}
    		int temp = data[i];
    		data[i] = data[largestElement];
    		data[largestElement] = temp;
    	}
    }
    
    /**
     * This method examines the elements in the array and
     * replaces all occurrences of the original object 
     * with the replacement object.
     * 
     * For this method, two objects are considered equal
     * if they refer to the same object.  Note that either
     * the original object, the replacement object, or
     * any of the objects in the list may be null.
     * 
     * This method does not have a return
     * type - the list array is modified directly.
     * 
     * @param list   An array of Object references
     * @param original   The object to be replaced
     * @param replacement   The replacement object
     * @throws NullPointerException   If list is null
     */
    public static void replace (Object[] list, Object original, Object replacement)
    {
    	// Iterate through the array
    	for (int i = 0; i < list.length; i++) {
    		// check if the element at index i is equal to the original element
    		if (list[i] == original)
    			list[i] = replacement; // replace element
    	}
    }
    
    /**
     * This method creates and returns a new array that
     * contains all the colors stored in the original array,
     * except those colors that are equal to the target.  For this
     * method, two colors are equal if they represent the
     * same color.
     * 
     * Note that target may be null, and pixels may contain
     * null elements.  Two null elements will be considered equal.
     * 
     * 
     * @param pixels   An array of Color references
     * @param target   The Color object to be removed
     * @throws NullPointerException   If pixels is null
     */
    public static Color[] remove (Color[] pixels, Color target)
    {
    	int count = 0; // represents number of instances of the target in the array
    	// Look for target in array
    	for (int i = 0; i < pixels.length; i++) {
    		if (pixels[i].equals(target))
    			count++; // Increment count
    	}
    	
    	// calculate new size
    	int newSize = pixels.length - count;
    	
    	// create new array
    	Color[] colors = new Color[newSize];
    	
    	// populate the array
    	int newIndex = 0;
    	for (int i = 0; i < pixels.length; i++) {
    		if (!pixels[i].equals(target)) {
    			colors[newIndex] = pixels[i];
    			newIndex++;
    		}
    	}
    	
        return colors;
    }
    
    
    /**
     * This method computes and returns the area of several rectangular
     * regions.  For a rectangle i, width[i] specifies
     * the width of the rectangle, and height[i] specifies
     * the height of the rectangle.  A new array is created
     * (that is the same size as the width and height arrays)
     * and the area of each rectangle is computed and placed
     * in this array.  (Area of rectangle i would be stored
     * in the ith position in the array.)  The array is then returned.
     * 
     * This method assumes that the widths and heights are positive.
     * 
     * Note that width and height arrays must be the same size.
     * 
     * @param widths   An array of rectangle widths
     * @param heights  An array of rectangle heights
     * @return   An array of rectangle areas
     * @throws NullPointerException   If widths or heights is null
     * @throws ArrayIndexOutOfBoundsException   If widths or heights are not the same size
     */
    public static double[] computeAreas (double[] widths, double[] heights)
    {
    	// Create new array for areas
    	double[] areas = new double[widths.length];
    	
    	for (int i = 0; i < widths.length || i < heights.length; i++) {
    		areas[i] = widths[i] * heights[i];
    	}
    	
        return areas;
    }
    
    /**
     * This method reverses 'in place' the elements in
     * the array.  Reversing is defined as moving the
     * elements in the array such that the first element
     * becomes the last element, the second element
     * becomes the second to last element, the third
     * element becomes the third to last element, etc.
     * 
     * This method should reverse the order of elements in the input array.  
     * Note:  A character array is not a String.  
     * It is an array of Character objects, each of which contain a Character.
     * 
     * @param symbols   An array that will be reversed.
     */
    public static void reverseOrder (Character[] symbols)
    {	
     	// Create counting variable
    	int count = 0;
    	
    	// Count characters in array
    	for (int j = 0; j < symbols.length; j++) 
    	{
    			count++; // Increment count
    	}
    	
    	//Subtract 1 to make count at a given position correspond to 'symbols' at the same position
    	
    	count = --count;
    	
    	   // Loop for starting index
    	for (int i = 0; i <= count*(.5); i++) 
    	{	
    		//This will loop through the first half of the array and switch the value with the corresponding
    		//position in the second half of the array, thereby reversing the order.
    	
    		// creates a placeholder 'char' variable
    		char temp = symbols[i];
    		
    		// creates a variables to hold the final position of the element
    		int finalPosition = (count - i);
    		
    		// stores the current finalPosition value in the ith position
    		symbols[i] = symbols[finalPosition];
    		
    		//stores the placeholder value in the current finalPosition
    		symbols[finalPosition] = temp;    		
    	}
    	
    }
    
    /**
     * This method counts how many times each value appears 
     * in the ages list, and returns an array of these counts.
     * (If 16 occurs 13 times in the ages array, then 
     * the returned array will contain a thirteen in the seventeenth
     * element of the array.)  This method assumes that age values 
     * will be non-negative and small.
     * 
     * The size of the returned list is determined by the maximum value
     * stored in the ages list.  The size of the returned list will be
     * one greater than the maximum value stored in the ages list.  
     * 
     * @param ages   A list ages
     * @return   An array of counts, each element corresponds to one age
     */
    public static int[] histogram (int[] ages)
    {	
    	// declares a variables to hold the length of the new histogram
    	int newHistLength = 0;
    	
    	// Count characters in array
    	for (int i = 0; i < ages.length; i++) 
    	{
    			// checks for the maximum value in the array
    			if (ages[i] > newHistLength)
    				newHistLength = ages[i];	// sets the length of the new array
    	}
	
    	// Declares a new histogram of length 'newHistLength'
    	int[] histogram = new int[newHistLength + 1];	// adds 1 to the length of the histogram to account for element '0'
    	
    	// sets all the elements in 'histogram' equal to zero
    	for(int i = 0; i < histogram.length; i++)
    	{
        	histogram[i] = 0;
    	}
    	
    	// creates a new loop to count each age and record it to the histogram
    	for(int i = 0; i < ages.length; i++)
    	{	
        	histogram[ages[i]]++;	// adds one to the element in 'histogram' for the given value of 'ages'
    
    	}
    	
    	// returns the new histogram of the ages
        return histogram;       
    }
    
    /**
     * This method creates and returns a new array that contains a list of the
     * unique File objects that occur in the files array.  For this method,
     * File objects are the same if they are equal using the .equals method.
     * 
     * The size of the returned list is determined by the number of unique
     * items in the original list.  The order of the items in the returned
     * list is unspecified.
     * 
     * The files array must not contain null.
     * 
     * @param files   An array of File objects, possibly containing duplicates
     * @return   An array of unique File objects
     * @throws NullPointerException   If files is null or files contains null
     */    
    public static File[] getUnique (File[] files)
    {	 
 		// New array to hold unique files
    	File[] uniqueFiles = new File[files.length];

    	// Set the first uniqueFile to the first 'files' value 
    	uniqueFiles[0] = files[0];	
    	
    	// This is a counter for the next empty space in uniqueFiles
    	int positionValue = 1;

    	// boolean switch to tell if value is unique
    	boolean uniqueValue=false;
    	
    	// This creates a loop that will compare the next first value to the next and see if they are the same
    	for(int i = 1; i < files.length; i++)
    	{		
    		//loops through new array, compares to 'files' and checks for equality
    		for(int j = 0; j < uniqueFiles.length; j++)
    		{	
    			if(files[i].equals(uniqueFiles[j]))	// if equal sets unique to false
    			{	
    				uniqueValue = false;
    				break;
    			}
    			else	//if not equal sets unique to true
    			{
    				uniqueValue = true;
    			}
    		}
    		
    		if(uniqueValue)
			{	uniqueFiles[positionValue] = files[i];	//sets new value in uniqueFiles	
				positionValue++; // Increments position counter
				
			}
    	}
    	
    	int newArrayLength = 0;	//counter for new array length
    	
    	//loops through to count all value that are not 'null'
    	for(int i = 0; i < uniqueFiles.length; i++)
    	{	
    		if(uniqueFiles[i] == (null))
    			break;
    		if(!uniqueFiles[i].equals(null))
    			newArrayLength++;	
    		
    	}
    	
    	// Array with unique values and no null values
    	File[] newArray = new File[newArrayLength];
    	
    	for(int i = 0; i < newArray.length; i++)
    	{
    		newArray[i] = uniqueFiles[i];
  
    	}

    	// remember to delete Arrays import
  
        return newArray;
    }
    
    
    /**
     * This method finds and returns the smallest rectangle in the
     * array.  The smallest rectangle is defined as the one
     * with the smallest area.  If two rectangles have the same
     * smallest area, the one that occurs last in the array
     * is returned.
     * 
     * This method requires that the rectangles array 
     * must not contain null.
     * 
     * @param rectangles   An array of rectangle objects
     * @return   The smallest rectangle in the array
     * @throws NullPointerException   If rectangles is null or rectangles contains null
     */
    public static Rectangle findSmallest (Rectangle[] rectangles)
    {		
    	// Create new array to hold areas
    	double[] areas = new double[rectangles.length];
    	
    	// Creates a loop to get the Width and Height from each element in 'rectangles' and puts in into areas[i]   	
    	for(int i = 0; i < rectangles.length; i++)
    	{	
    		double width = rectangles[i].getWidth(); 	// Gets width from rectangle i
    		double height = rectangles[i].getHeight();	// Gets height from rectangle i
    		
    		//System.out.println(width + " and " + height);
 
        	areas[i] = width * height;	// Multiplies Width * Height to get area and puts it into the new array
 
    	}
    	
    	// New variables to hold the smallest area and the corresponding smallest Rectangle
    	double smallestArea = areas[0];
    	Rectangle smallestRectangle = null;
    	
    	// Loop to test for the smallest area
	    for(int i = 0; i < areas.length; i++)
	    {	
	    
    		for(int j = i; j < areas.length; j++)
	    	{	
	    		if(areas[j] < smallestArea || areas[j] == (smallestArea))
	    		{
	    			smallestRectangle = rectangles[j];	//If areas[j] is smallest area, it sets the corresponding rectangle as the smallest rectangle
	    		}
	    	}
	    
	    }	
    	
	
        return smallestRectangle; // You will write this method as part of programming assignment #6.     
    }        
}
