package lab09;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle objects represent a rectangle shape
 * drawn to the screen at a particular position
 * with some size and color.
 * 
 * @author vetas
 *@date 3/8/13
 */
public class Rectangle extends Shape
{
	// Instance variables.

    private int width;
    private int height;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this rectangle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param width
     *              the width of this rectangle
     *
     * @param heighth
     *              the height of this rectangle
     *
     * @param color
     *             the color of this rectangle
     */
	 public Rectangle (int x, int y, int width, int height, Color color)
	 {
		// Call the superclass constructor.  This must be the first statement
		//   in this constructor.
		
		super (x, y, color);
		
		// Save the size.
		
		this.width = width;
		this.height = height;
	 }

    /**
     * Draws the rectangle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
	g.setColor (color);
	g.fillRect (x, y, width, height);
    }  
    
    /**
     * Returns true if the coordinates are within the rectangle.
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

	return targetX >= x &&
		       targetX < x + width &&
		       targetY >= y &&
		       targetY < y + height;
    }
}
