package lab09;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Circle objects represent a circle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Peter Jensen
 * @version Spring 2013
 */
public class Circle extends Shape
{
    // Instance variables.

    private int diameter;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param diameter
     *              the diameter of this circle
     *
     * @param color
     *             the color of this circle
     */
   
	 public Circle (int x, int y, int diameter, Color color)
	 {
		// Call the superclass constructor.  This must be the first statement
		//   in this constructor.
		
		super (x, y, color);
		
		// Save the size.
		
		this.diameter = diameter;
	 }

    /**
     * Draws the circle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
	g.setColor (color);
	g.fillOval (x, y, diameter, diameter);
    }  
    
    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the shape
     */
    public boolean isInside (int targetX, int targetY)
    {
	int cx = x + diameter / 2;  // Calculate the center point
	int cy = y + diameter / 2;
	
	int deltaX = cx - targetX;  // Calculate the deltas to the click
	int deltaY = cy - targetY;
	
	return (deltaX * deltaX + deltaY * deltaY) * 4 <= diameter * diameter;
    }
}
