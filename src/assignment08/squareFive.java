package assignment08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Creates a quilt square that draws a green caterpillar
 * @author bvetas
 * @date 3/21/13
 */
public class squareFive extends QuiltSquare
{	
	public squareFive()
	{
		this.color = Color.GREEN;	// stores color
		this.squareName = "Caterpillar"; // stores name
	}
	
	/**
	 * This creates a caterpillar
	 * 
	 * 
	 * @param Graphics g
	 * @return void
	 */
	public void paintComponent(Graphics g)
	{
		// fills rectangles
		g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// creates local variable
		double percentage = .51;
		
		//draws eyes and feelers
		g.setColor(Color.BLACK);
		g.drawLine(50, 11, 45, 6);
		g.drawLine(50, 11, 55, 6);
		g.drawLine(45, 6, 30, 3);
		g.drawLine(55, 6, 70, 3);
		g.fillOval(40, 9, 5, 5);
		g.fillOval(55, 9, 5, 5);
		
		//fills in diamond body
		g.fillRect(40, 12, 20, 78);
		
		//draws legs
		g.drawLine(35, 32, 18, 24);
		g.drawLine(36, 52, 15, 45);
		g.drawLine(34, 72, 15, 78);
		g.drawLine(65, 71, 79, 82);
		g.drawLine(66, 54, 87, 45);
		g.drawLine(66, 34, 86, 22);
		
		// creates caterpillar body
		g.setColor(color);
		g.fillArc(45, 10, 25, 25, 315, 180);
		g.fillArc(30, 10, 25, 25, 45, 180);
		g.fillArc(45, 10, 25, 25, 225, 180);
		g.fillArc(30, 10, 25, 25, 135, 180);
		g.fillArc(45, 30, 25, 25, 225, 180);
		g.fillArc(30, 30, 25, 25, 135, 180);
		g.fillArc(45, 30, 25, 25, 315, 180);
		g.fillArc(30, 30, 25, 25, 45, 180);
		g.fillArc(45, 50, 25, 25, 225, 180);
		g.fillArc(30, 50, 25, 25, 135, 180);
		g.fillArc(45, 50, 25, 25, 315, 180);
		g.fillArc(30, 50, 25, 25, 45, 180);
		g.fillArc(45, 70, 25, 25, 315, 180);
		g.fillArc(30, 70, 25, 25, 45, 180);
		g.fillArc(45, 70, 25, 25, 225, 180);
		g.fillArc(30, 70, 25, 25, 135, 180);
		
		//draws eyes and feelers
		g.setColor(Color.BLACK);
		g.drawLine(50, 11, 45, 6);
		g.drawLine(50, 11, 55, 6);
		g.drawLine(45, 6, 30, 3);
		g.drawLine(55, 6, 70, 3);
		g.fillOval(40, 9, 5, 5);
		g.fillOval(55, 9, 5, 5);
		
		//draws legs
		g.drawLine(35, 32, 18, 24);
		g.drawLine(36, 52, 15, 45);
		g.drawLine(34, 72, 15, 78);
		g.drawLine(65, 71, 79, 82);
		g.drawLine(66, 54, 87, 45);
		g.drawLine(66, 34, 86, 22);
		
		// draws a black box as the border
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
	
	}
	
}
