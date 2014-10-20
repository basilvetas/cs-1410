package assignment08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * This creates a quilt square that draws a yellow star
 * 
 * @author bvetas
 * @date 3/21/13
 */
public class squareFour extends QuiltSquare
{	
	public squareFour()
	{
		this.color = Color.YELLOW;	//stores color
		this.squareName = "Star"; // stores name
	}
	
	/**
	 * This paints a star
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
		int startX = 0;
		int startY = 0;
		double percentage = 1;
		
		// creates star
		g.setColor(color);
		int[] xPoints = {50, 35, 5, 30, 20, 50, 80, 70, 95, 65, 50};
		int[] yPoints = {10, 35, 35, 50, 85, 65, 85, 50, 35, 35, 10}; 
		g.fillPolygon(xPoints, yPoints, 11);
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints, yPoints, 11);
	
		// draws a black box as the border
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
	
	}

}
