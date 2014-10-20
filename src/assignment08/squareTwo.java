package assignment08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * This class creates a quilt square that draws a purple spiral
 * 
 * @author bvetas
 * @date 3/21/13
 */
public class squareTwo extends QuiltSquare
{
	public squareTwo()
	{
		this.color = Color.MAGENTA;	// stores color
		this.squareName = "Spiral"; // stores name
	}
	
	/**
	 * Paints a purple spiral
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
		int startY = this.getHeight() /2;
		double percentage = 1;
			
        // creates the spiral	  
        g.setColor(color);
        g.drawLine((int)(45*percentage), (int)(45*percentage), (int)(45*percentage), (int)(55*percentage));
        g.drawLine((int)(45*percentage), (int)(55*percentage), (int)(55*percentage), (int)(55*percentage));
        g.drawLine((int)(55*percentage), (int)(55*percentage), (int)(55*percentage), (int)(35*percentage));
        g.drawLine((int)(55*percentage), (int)(35*percentage), (int)(35*percentage), (int)(35*percentage));
        g.drawLine((int)(35*percentage), (int)(35*percentage), (int)(35*percentage), (int)(65*percentage));
        g.drawLine((int)(35*percentage), (int)(65*percentage), (int)(65*percentage), (int)(65*percentage));
        g.drawLine((int)(65*percentage), (int)(65*percentage), (int)(65*percentage), (int)(25*percentage));
        g.drawLine((int)(65*percentage), (int)(25*percentage), (int)(25*percentage), (int)(25*percentage));
        g.drawLine((int)(25*percentage), (int)(25*percentage), (int)(25*percentage), (int)(75*percentage));
        g.drawLine((int)(25*percentage), (int)(75*percentage), (int)(75*percentage), (int)(75*percentage));
        g.drawLine((int)(75*percentage), (int)(75*percentage), (int)(75*percentage), (int)(15*percentage));
        g.drawLine((int)(75*percentage), (int)(15*percentage), (int)(15*percentage), (int)(15*percentage));
        g.drawLine((int)(15*percentage), (int)(15*percentage), (int)(15*percentage), (int)(85*percentage));
        g.drawLine((int)(15*percentage), (int)(85*percentage), (int)(85*percentage), (int)(85*percentage));
        g.drawLine((int)(85*percentage), (int)(85*percentage), (int)(85*percentage), (int)(15*percentage));
  
		// draws a black box as the border
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 0, this.getHeight());
		g.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight());
		
	}

}
