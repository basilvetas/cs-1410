package assignment08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * This class creates a quilt square that draws a blue target
 * 
 * @author bvetas
 * @date 3/21/13
 */
public class squareThree extends QuiltSquare
{	
	public squareThree()
	{
		this.color = Color.BLUE;	// stores color
		this.squareName = "Target"; // stores name
	}
	
	/**
	 * paints a target
	 * 
	 * @param Graphics g
	 * @return void
	 */
	public void paintComponent(Graphics g)
	{	
		// fills rectangles
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// creates local variables
    	int startX = this.getWidth() / 2;
		int startY = this.getHeight() / 2;
		double percentage = 1;
		
        // creates rings of target
        g.setColor(color);
        g.fillOval(startX - (int)(45*percentage), startY - (int)(45*percentage), (int)(90*percentage), (int)(90*percentage));	  
        g.setColor(Color.WHITE);
        g.fillOval(startX - (int)(35*percentage), startY - (int)(35*percentage), (int)(70*percentage), (int)(70*percentage));
        g.setColor(color);
        g.fillOval(startX - (int)(25*percentage), startY - (int)(25*percentage), (int)(50*percentage), (int)(50*percentage));
        g.setColor(Color.WHITE);
        g.fillOval(startX - (int)(15*percentage), startY - (int)(15*percentage), (int)(30*percentage), (int)(30*percentage));
        g.setColor(color);
        g.fillOval(startX - (int)(5*percentage), startY - (int)(5*percentage), (int)(10*percentage), (int)(10*percentage));	
		
        // draws a black box as the border
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());

	}
	
}
