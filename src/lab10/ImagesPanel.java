package lab10;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * This class represents a panel that draws an image
 * from a series of images.
 * 
 * It can be added to any GUI application.
 * 
 * @author Peter Jensen
 */
public class ImagesPanel extends JPanel
{   
    // Instance variables.
    
    private Vector<Image> images;  // Stores a list of images.
    private int currentImageIndex; // Indicates which image is currently drawn.

    /**
     * Creates the panel - initializes it as containing no images.
     */
    public ImagesPanel ()
    {
        images = new Vector<Image>();
        currentImageIndex = 0;
    }
    
    /**
     * Adds an image to the image list.
     */
    public void add (Image i)
    {
        images.add(i);
    }
    
    /**
     * Redraws the current image.
     */
    public void paint (Graphics g)
    {
        // Get the size of this window.
        
        int width  = this.getSize().width;
        int height = this.getSize().height;
        
        // Clear it to a neutral color.
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        
        // If there is no image, put up a message.
        
        if (images.size() == 0)
        {
            g.setColor (Color.BLACK);
            g.drawString ("No images - try pressing 'go'.", 10, height / 2 + 5);
            return;
        }
        
        // Draw the image.
        
        Image current = images.get(currentImageIndex);
        int imageWidth = current.getWidth(null);
        int imageHeight = current.getHeight(null);
        
        if (imageWidth < width && imageHeight < height)
        {
            int x = (width-imageWidth)/2;
            int y = (height-imageHeight)/2;
            g.drawImage (current, x, y, null);
        }
        else 
            g.drawImage (current, 0, 0, width, height, null);
     
    }
    
    /**
     * Advances this panel to draw the next image.  
     */
    public void advanceImage ()
    {
        if (images.size() > 0)
        {
            currentImageIndex = (currentImageIndex + 1) % images.size();
            repaint();
        }
    }
}
