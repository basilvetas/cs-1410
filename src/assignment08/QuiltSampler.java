package assignment08;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

/**
 * This application displays five quilt squares assembled into a sample
 * quilt.
 *
 * Note that this program can be run as an application, or it can
 * be embedded into a webpage as an applet.
 *
 * @author Peter Jensen
 */
public class QuiltSampler extends JApplet
{
    /**
     * The main method is provided so the quilt sampler can be
     * run as an application.  Note that the command line arguments
     * (if any) are ignored.
     *
     * No work is required here, but you may make minor modifications
     * if you wish.
     *
     */
    static public void main (String[] args)
    {
        // Create the frame, give it a title and size.
        
        JFrame applicationFrame;
        
        applicationFrame = new JFrame("A Graphical Quilt Sampler");        
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setSize(1000, 800);

        // Use a helper method to lay out the application.
        
        Container content;
        
        content = applicationFrame.getContentPane();
        layoutContainer(content);
        
        // Make the frame visible.
        
        applicationFrame.setVisible(true);
        
        // Note - no event handling is done here.  The quilt squares will
        //   handle their own events.
    }

    /**
     * This method creates the components needed for this
     * application.  They are added to the specified container.
     *
     * No work is required here, but you may make minor modifications
     * if you wish.
     *
     * @param content The program's root Container object 
     */
    static public void layoutContainer(Container content)
    {
        // Create a title.
        
        JLabel title;
        
        title = new JLabel ("Graphical Quilt Sampler");
        title.setForeground (new Color (0.0f, 0.1f, 0.4f));  // A dark blue
        title.setHorizontalAlignment (JLabel.CENTER);
        
        // Select a random font for the title - just for fun.  (Studying this part is not required.)
        
        Font[] availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        Font randomFont;
        boolean ok;
        do
        {
            randomFont = availableFonts[(int)(Math.random()*availableFonts.length)];        
        } while (randomFont.canDisplayUpTo(title.getText()) >= 0);
        title.setFont (randomFont.deriveFont(Font.BOLD, 30));
	        
        // Create a panel to hold the quilt.
        
        JPanel outerQuiltPanel, innerQuiltPanel;
        
        outerQuiltPanel = new JPanel ();
        innerQuiltPanel = new JPanel ();
        
        outerQuiltPanel.setLayout(new FlowLayout());
        innerQuiltPanel.setLayout(new GridLayout(7, 9));
        
        outerQuiltPanel.add(innerQuiltPanel);  // Put the inner panel in the outer panel.
                
        // Create the quilt squares, add them to the inner panel.
        
        for (int row = 0; row < 7; row++)
          for (int column = 0; column < 9; column++)
          {
              JComponent quiltSquare = makeQuiltSquare((row+40-column) % 5);

              // Determine the name of this quilt square type.
              
              String quiltSquareName = "Unknown quilt square type.";
              
              if (quiltSquare instanceof NamedComponent)
                  quiltSquareName = ((NamedComponent) quiltSquare).getSquareName();

	      // Set the tool tip for this quilt square.  When the user
	      //   'hovers' the mouse over the square, the specified
	      //   text will automatically appear.
	      
              quiltSquare.setToolTipText(quiltSquareName);
                  
              // Add the square to the grid.
              
              innerQuiltPanel.add(quiltSquare);
          }
        
        // Get the content panel for the pane, set its layout, and
        //   add the outer quilt panel and title.
        
        content.setLayout(new BorderLayout());
        content.add(title, BorderLayout.NORTH);
        content.add(outerQuiltPanel, BorderLayout.CENTER);
        
    }

    /**
     * This method returns one quilt square of the specified
     * type.  The quilt square must be a JComponent object.
     * The 'type' parameter will be an integer from [0..4].
     * <p>
     *
     * You are to complete this method as part of the assignment.
     * 
     * @param type A quilt square type (as an integer from [0..4]
     * @return A JComponent quilt square
     */
    static public JComponent makeQuiltSquare (int type)
    {
        if (type == 0)
        {
            JComponent c = new squareOne();		// Utes Logo
            return c;
        }
        if (type == 1)
        {
            JComponent c = new squareTwo();		// Spiral
            return c;
        }
        if (type == 2)
        {
            JComponent c = new squareThree();	// Target
            return c;
        }
        if (type == 3)
        {
            JComponent c = new squareFour();	// Star
            return c;
        }
        if (type == 4)
        {
            JComponent c = new squareFive();	// Caterpillar
            return c;
        }
        
        return null;
    }

    /**
     * If this program is being displayed as an applet in
     * a web page, then 'main' will not be called.  This
     * method will be called instead after a QuiltSampler
     * object is created.  Since applets do not have a frame,
     * this code just needs to initialize the applet container
     * with the required components.
     *
     * No work is required here, but you may make minor modifications
     * if you wish.
     *
     */
    public void init ()
    {
        layoutContainer(this);
    }
}
