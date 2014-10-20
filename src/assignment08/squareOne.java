package assignment08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JPanel;


/**
 * This creates a quilt square with a red Utah Utes Logo
 * 
 * @author bvetas
 * @date 3/21/13
 */
public class squareOne extends QuiltSquare
{	
	public squareOne()
	{	
		this.color = Color.RED; // stores color
		this.squareName = "Utah Utes"; // stores name
	}
	
	/**
	 * Paints the Logo of the University of Utah
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
		double percentage = .51;

		// makes the rectangle red
		g.setColor(color);
		g.fillRect(startX + (int)(0*percentage), startY + (int)(0*percentage), (int)(200*percentage), (int)(200*percentage));
		
		// whites-out portions of the rectangle to give shape
		g.setColor(Color.WHITE);
		g.fillRect(startX + (int)(75*percentage), startY+ (int)(50*percentage), (int)(50*percentage), (int)(80*percentage));
		g.fillRect(startX + (int)(85*percentage), startY + (int)(0*percentage), (int)(30*percentage), (int)(50*percentage));
		g.fillRect(startX + (int)(85*percentage), startY + (int)(0*percentage), (int)(30*percentage), (int)(50*percentage));
		g.fillRect(startX + (int)(0*percentage), startY + (int)(50*percentage), (int)(10*percentage), (int)(150*percentage));
		g.fillRect(startX + (int)(190*percentage), startY + (int)(50*percentage), (int)(10*percentage), (int)(150*percentage));
		g.fillRect(startX + (int)(0*percentage), startY + (int)(190*percentage), (int)(200*percentage), (int)(10*percentage));
		
		// whites-out the bottom corners of the shape
		for(int n = 0; n < 45; n++)
		{	for(int i = 0; i <= 25; i++)
			{
				g.fillRect(startX + (int)(5*percentage) + (int)(n*percentage), startY + (int)(155*percentage) + (int)(n*percentage) + (int)(i*percentage), (int)(5*percentage), (int)(5*percentage));
				g.fillRect(startX + (int)(190*percentage) - (int)(n*percentage), startY + (int)(155*percentage) + (int)(n*percentage) + (int)(i*percentage), (int)(5*percentage), (int)(5*percentage));
			}
		}
		
		// draws a black box as the border
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
		
	}
}
