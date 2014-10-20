package lab10;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

/**
 * A helper class that loads images.  Loaded images
 * are added to an ImagesPanel object.
 * 
 * @autor Peter Jensen
 */
public class ImageLoader implements Runnable
{
    /*
     * 
     */
    private ImagesPanel panel;
    
    private String[] imageAddresses =
    
      /* Uncomment one of the following array creations. */
    
      /* Use this form to animate files stored on your local hard drive. */
      
//       new String [] { "File:\\C:\\images\\imageA.gif",
//                       "File:\\C:\\images\\imageB.jpg"};

      /* Use this one to animate files stored from the web. */
      
      /* Currently it loads images from the national weather service. */
      
       new String [] { "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.1.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.2.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.3.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.4.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.5.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.6.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.7.jpg",
                       "http://sat.wrh.noaa.gov/satellite/4km/WR/animation/IR4.GIF.8.jpg"};
                 
      /* Here is a bunny animation. */
      
//      new String [] { "http://www.amazing-kids.org/old/tut2-6.gif",
//                      "http://www.amazing-kids.org/old/tut2-7.gif",
//                      "http://www.amazing-kids.org/old/tut2-6.gif",
//                      "http://www.amazing-kids.org/old/tut2-7.gif",
//                      "http://www.amazing-kids.org/old/tut2-8.gif",
//                      "http://www.amazing-kids.org/old/tut2-9.gif",
//                      "http://www.amazing-kids.org/old/tut2-11.gif"};
                    
  
    /**
     * Creates an image loader that will add
     * images to the specified panel.
     */
    public ImageLoader (ImagesPanel panel)
    {
        this.panel = panel;
    }
    
    /**
     * Initiates loading of the images.
     */
    public void startLoading ()
    {
        Thread t = new Thread(this);
        t.start();
    }
    
    /**
     * Loads the images and adds them to the panel.
     */
    public void run ()
    {
        int count = imageAddresses.length;
        Image[] images = new Image[count];
        
        MediaTracker tracker = new MediaTracker(panel);
        
        for (int i = 0; i < imageAddresses.length; i++)
        {
            URL url;
            try
            {
                url = new URL(imageAddresses[i]);
                images[i] = ImageIO.read(url);
            }
            catch (MalformedURLException e)
            {
                System.err.println ("Bad URL: " + imageAddresses[i]);
                continue;
            }
            catch (IOException e)
            {
                System.err.println ("Unable to load image: " + imageAddresses[i]);
                continue;
            }
            
            tracker.addImage(images[i], i);
        }
        
        for (int current = 0; current < count; current++)
        {
            if (images[current] == null)
                continue;
                
            try
            {
                tracker.waitForID(current);
            }
            catch (InterruptedException e)
            {
                System.err.println ("Load aborted: " + imageAddresses[current]);
                continue;
            }
            
            if (tracker.isErrorID(current))
            {
                System.err.println ("Unable to load image: " + imageAddresses[current]);
                continue;
            }
            panel.add(images[current]);    
        }
    }
}
