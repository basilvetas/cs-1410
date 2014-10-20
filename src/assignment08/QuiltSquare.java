package assignment08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * This is an abstract class that extends JPanel and 
 * provides the framework for the individual square objects 
 * 
 * @author vetas
 * @date 3/21/13
 *
 */
abstract public class QuiltSquare extends JPanel implements NamedComponent, MouseListener
{
	protected Color color;	// variable to store the color of the quilt square
	protected String squareName; // variable to store the name of the quilt square
	
	public QuiltSquare()
	{
		this.addMouseListener(this);	// creates a mouse listen to detect a clicked mouse
	}
	
	/**
	 * Sets size to 100x100
	 * 
	 * @param void
	 */
	public Dimension getMinimumSize()	
	{
		return new Dimension(100,100);
	}
	

	/**
	 * Sets size to 100x100
	 * 
	 * @param void
	 */
	public Dimension getPreferredSize()
	{
		return new Dimension(100,100);
	}
	

	/**
	 * Sets size to 100x100
	 * 
	 * @param void
	 */
	public Dimension getMaximumSize()
	{
		return new Dimension (100,100);
	}

	@Override
	public String getSquareName()
	{	
		return squareName;	// returns the name of the square when user hovers mouse over area
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{	// lets the user change the color of the square
		color = JColorChooser.showDialog(this, "Choose a Color",  color);
		repaint();	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
