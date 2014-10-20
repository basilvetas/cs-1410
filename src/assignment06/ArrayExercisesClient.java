package assignment06;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;

/**
 * This class is an application that tests the
 * methods in the ArrayExercises class.
 * 
 * @author Basil Vetas
 * @version February 19, 2013
 */
public class ArrayExercisesClient
{
    /**
     * The application entry point.  The application
     * thoroughly tests the ArrayExercises class static methods.
     * 
     * @param args    not used
     */
    public static void main (String[] args)
    {
        /* Tests for method #1 - public static int count (String[] values, String target) */

        // A test block.  Notice the { and } surrounding this
        //   code.  This way, we can cut and paste the block
        //   and reuse the same variable names.  (The variables
        //   are local to the BLOCK.)
        {
            // Declare the needed variables.

            String target;
            String[] data;
            int count;
        
            // Set up some data and make the call.
        
            target = "Hello";
            data = new String[] {"Hello", "Hi", "Goodbye", "Hello", "Goodbye", "Hello"};
            count = ArrayExercises.count(data, target);
        
            // Output the results.
        
            System.out.print (Arrays.toString(data));
            System.out.println (" contains exactly " + count + " occurrences of the word " + target);
        }
        
        // PLACE ANOTHER TEST HERE FOR METHOD #1.  (Hint - just cut-and-paste
        //    the above code and modify it.  Try counting "Goodbye" instead.
        
        {
            // Declare the needed variables.

            String target;
            String[] data;
            int count;
        
            // Set up some data and make the call.
        
            target = "Goodbye";
            data = new String[] {"Hello", "Hi", "Goodbye", "Hello", "Goodbye", "Hello"};
            count = ArrayExercises.count(data, target);
        
            // Output the results.
        
            System.out.print (Arrays.toString(data));
            System.out.println (" contains exactly " + count + " occurrences of the word " + target);
        }
        
        /* Tests for method #2 - public static void sort (int[] data) */
        
        {
            // Declare the needed variables.

            int[] data;
        
            // Set up some data and make the call.
        
            data = new int[] {0, 4, 3, 6, 8};
            ArrayExercises.sort(data);
        
            // Output the results.
        
            System.out.println (Arrays.toString(data));
        }
        
        // Hint - follow the same pattern as for the tests above.
        //   Declare variables, set up data and make the call, output results.
        
        {
            // Declare the needed variables.

            int[] data = null;
        
            // Set up some data and make the call.
            try
            {
            ArrayExercises.sort(data);
            }
            catch (NullPointerException e) {
            	System.out.println("Null pointer exception");
            }

            // Output the results.
            
            System.out.println (Arrays.toString(data));
        }
        
        /* Tests for method #3 - public static void replace (Object[] list, Object original, Object replacement) */
        
        {
            // Declare the needed variables.

            String original, replacement;
            String[] data;
        
            // Set up some data and make the call.
        
            original = "Goodbye";
            replacement = "See ya";
            data = new String[] {"Hello", "Hi", "Goodbye", "Hello", "Goodbye", "Hello"};
            ArrayExercises.replace(data, original, replacement);
        
            // Output the results.
        
            System.out.println (Arrays.toString(data));
        }
        
        // WRITE TEST FOR NULLPOINTEREXCEPTION!!!
        
        /* Tests for method #4 - public static Color[] remove (Color[] pixels, Color target) */
        
        {
            // Declare the needed variables.

            Color target, replacement;
            Color[] data;
        
            // Set up some data and make the call.
        
            target = Color.green;
            replacement = Color.black;
            data = new Color[] {Color.red, target, Color.black, Color.orange};
            ArrayExercises.replace(data, target, replacement);
        
            // Output the results.
        
            System.out.println (Arrays.toString(data));
        }
        
   
        
        /* Tests for method #5 - public static double[] computeAreas (double[] widths, double[] heights) */

        {
            // Declare the needed variables.

            double[] widths;
            double[] heights;
        
            // Set up some data and make the call.
        
            widths = new double[] {1.0, 3.5, 8.1};
            heights = new double[] {1.0, 3.5, 8.1};
            
            double[] areas;
            areas = ArrayExercises.computeAreas(widths, heights);
        
            // Output the results.
        
            System.out.println (Arrays.toString(areas));
        }
        
        {
            // Declare the needed variables.

            double[] widths;
            double[] heights;
        
            // Set up some data and make the call.
        
            widths = new double[] {1.0, 3.5, 8.1, 6.7};
            heights = new double[] {1.0, 3.5, 8.1};
            
            double[] areas;
            try 
            {
            areas = ArrayExercises.computeAreas(widths, heights);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            	System.out.println("Index out of bounds!");
            }
        
            // Output the results.
        
        }
        
        // WRITE MORE TESTS!!!!!!!
        
        /* The above tests are all that is required for the lab. */
        /* You must add additional tests as part of the assignment this week. */
   
        {
            // Declare the needed variables.

            Character[] symbols;
        
            // Set up some data and make the call.
        
            symbols = new Character[] {'a', 'b', 'c', 'd', 'e', 'f'};
          
            try
            {
            ArrayExercises.reverseOrder(symbols);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            	System.out.println("Index out of bounds!");
            }
            // Output the results.
        
            System.out.println (Arrays.toString(symbols));
        }
        
        {
            // Declare the needed variables.

            int[] ages;
        
            // Set up some data and make the call.
        
            ages = new int[] {1, 3, 1, 2, 3};
            
            int[] histogram = null;
            
            try
            {
            histogram = ArrayExercises.histogram(ages);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            	System.out.println("Index out of bounds!");
            }
            // Output the results.
        
            System.out.println (Arrays.toString(histogram));
        }
        
        {
            // Declare the needed variables.

            File[] files;
        
            // Set up some data and make the call.
        
            files = new File[]{new File ("Foo"), new File ("Bar"), new File ("Foo"), new File ("Boo"), new File("Boo"), new File("Foo"), new File ("Boo"), new File("New")};
            
            File[] uniqueFiles = null;
            
            try
            {
            uniqueFiles = ArrayExercises.getUnique(files);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            	System.out.println("Index out of bounds!");
            }
            catch(NullPointerException e)
            {
            	System.out.println("Null pointer exception");
            }
            // Output the results.
        
            System.out.println (Arrays.toString(uniqueFiles));
        }
        
        {
            // Declare the needed variables.

            Rectangle[] rectangles;
        
            // Set up some data and make the call.
        
            rectangles = new Rectangle[]{new Rectangle(0, 0, 3, 8), new Rectangle(1, 1, 6, 7), new Rectangle(2, 2, 6, 4)};
            
            Rectangle smallestRectangle = null;
            
            try
            {
            smallestRectangle = ArrayExercises.findSmallest(rectangles);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            	System.out.println("Index out of bounds!");
            }
            // Output the results.
        
            System.out.println (smallestRectangle);
        }
    
    }
    
    
    
    
}
