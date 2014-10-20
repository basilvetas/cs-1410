package lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This application loads and displays images.  Once the student
 * completes this application, they will have an application that
 * animates images.
 * 
 * @autor Peter Jensen
 */
public class ImageAnimator implements ActionListener, Runnable
{
	private boolean running = false;
    private ImagesPanel panel;
    
    /**
     * This constructor creates an instance of this class.
     * The static main method handles the application
     * portion of the class, so this object must have a 
     * different purpose.  The ImageAnimator object
     * exists simply to listen to action events.
     * 
     * The action events may need to modify the panel,
     * so the panel is required as a parameter.
     */
    public ImageAnimator (ImagesPanel panel)
    {
        this.panel = panel;
    }

    /**
     * The application main entry point.
     */
    static public void main (String[] args)
    {
        JFrame frame = new JFrame ("Image animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        
        ImagesPanel imagesPanel = new ImagesPanel();
        content.add(imagesPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        
        JButton go = new JButton ("Go");
        JButton stop = new JButton ("Stop");
        
        buttonPanel.add(go, BorderLayout.WEST);
        buttonPanel.add(stop, BorderLayout.EAST);
        
        content.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
        
        ImageAnimator animator = new ImageAnimator(imagesPanel);
        
        go.addActionListener(animator);
        stop.addActionListener(animator);
        
        ImageLoader loader = new ImageLoader(imagesPanel);
        loader.startLoading();        
    }
    
    /**
     * Handles button presses.
     */
    public void actionPerformed (ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        
        if (button.getText().equals("Go"))
        {
		    if(running == false)
		    {
        	// You will place code here to create a new thread    
		    //   on this object, and start it  (if it is not
		    //   already running).
		    	
            running = true;	// boolean to determine if the thread should go
        	Thread going = new Thread(this);	// declares a thread
            going.start();		// starts running the 'run' thread
		    }
        }
        else
        {
            // Currently does nothing, you'll need one instruction here.
        	running = false;	// if false, stop running
        }
    }

	@Override
	public void run() 
	{
		while(running == true)
		{
			panel.advanceImage();
			try {Thread.sleep(500);}// pauses every half second
	        catch(InterruptedException z){}
		}
	}
	
}
