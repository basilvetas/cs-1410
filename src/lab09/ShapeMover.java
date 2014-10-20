package lab09;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 * This applet draws a few shapes for the user and allows the
 * user to drag the shapes around with the mouse.
 *
 * @author Peter Jensen
 * @version Spring 2013
 */
public class ShapeMover extends JApplet implements MouseListener,
                                                   MouseMotionListener
{
    // Instance variables.
    
    Shape[] shapes;

    int lastX, lastY;
    Shape current;

    /**
     * Initialize the applet.  Create the shapes, and
     * register this object as a listener to mouse events
     * produced by this object.
     */
    public void init ()
    {
	// Make the shapes.
	
	shapes = new Shape[]
	    {
	       new Rectangle    (130,  40, 60, 60, Color.RED),
	       new Rectangle    ( 30, 140, 40, 40, Color.YELLOW),
	       new Circle    (130,  40, 60, Color.RED),
	       new Circle    ( 30, 140, 40, Color.YELLOW)
	    };

	// Register this object as a listener to its own events.
	
	this.addMouseListener (this);
	this.addMouseMotionListener (this);
    }

    /**
     * Draws the shapes at their current locations
     * and colors.  Note that an offscreen buffer is
     * used to avoid flickering.
     *
     * @param g
     *         the Graphics object to draw to
     */
    public void paint (Graphics g)
    {
	// Create an offscreen buffer.

	Image offscreenBuffer = createImage(this.getWidth(), this.getHeight());
	Graphics offscreenGraphics = offscreenBuffer.getGraphics();

	// Fill it wit a nice color.
	
	offscreenGraphics.setColor(new Color (0.8f, 0.8f, 1.0f));
	offscreenGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
	
	// Draw to the offscreen buffer.
	
	for (Shape s : shapes)
	    s.draw(offscreenGraphics);

	// Draw the offscreen buffer to the screen.

	g.drawImage(offscreenBuffer, 0, 0, this);
    }

    /**
     * This method is part of the MouseListener interface.
     * Because we registered this applet object as a listener
     * to its own mouse events, this method will be automatically
     * called whenever the mouse button is pressed down.
     * <p>
     *
     * In this method, we determine if the mouse click occurred
     * in any of our shapes.  If so, we record that shape object
     * as the current shape.  This has the effect of selecting
     * a shape to drag around.
     *
     * @param e
     *         the mouse event
     */
    public void mousePressed  (MouseEvent e) 
    {
	// Get the location of the mouse click within this window.
	
	int x = e.getX (); 
	int y = e.getY ();

	// Save it for later use.
	
	lastX = x;
	lastY = y;

	// Determine if the mouse click is within any shape.
	//   If so, save the shape as the current shape.

	for (Shape s : shapes)
	    if (s.isInside (x, y))
		current = s;
    }
    
    /**
     * This method is part of the MouseListener interface.
     * Because we registered this applet object as a listener
     * to its own mouse events, this method will be automatically
     * called whenever the mouse button is let down.
     * <p>
     *
     * In this method, we mark the current shape as null.  This
     * has the effect of dropping whatever shape we are dragging
     * around.
     *
     * @param e
     *         the mouse event
     */
    public void mouseReleased (MouseEvent e) 
    {
	current = null;
    }
    
    /**
     * This method is part of the MouseListener interface.
     * Because we registered this applet object as a listener
     * to its own mouse events, this method will be automatically
     * called whenever the mouse is moved with the button pressed down.
     * <p>
     *
     * In this method, we adjust the position of the shape the user
     * is dragging around.
     *
     * @param e
     *         the mouse event
     */
    public void mouseDragged  (MouseEvent e) 
    {
	// Compute how far the mouse moved since the last event.
	
	int x = e.getX (); 
	int y = e.getY ();
	
	int deltaX = x - lastX;
	int deltaY = y - lastY;

	// Save the current mouse position.
	
	lastX = x;
	lastY = y;

	// If the user is dragging around a shape, move it by
	//   the same amount that the mouse moved.
	
	if (current != null)
	    {
		current.move (deltaX, deltaY); 
		repaint ();
	    }
    }

    // Unused event methods (required by the interfaces).

    public void mouseClicked  (MouseEvent e) { }
    public void mouseEntered  (MouseEvent e) { }
    public void mouseExited   (MouseEvent e) { }
    public void mouseMoved    (MouseEvent e) { }
}
