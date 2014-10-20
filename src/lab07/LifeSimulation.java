package lab07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This application simulates a game of life.  The user can
 * draw the initial position.
 * 
 * @author Peter Jensen  
 * @version Spring 2013
 */

public class LifeSimulation extends JPanel implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
    // Constants
    
    private static final int gridWidth = 40;
    private static final int gridHeight = 30;
    private static final int animationSpeed = 1;  // Updates per second - 1..20 is useful range.
    private static final int cellSize = 15; 
    
    private static final long serialVersionUID = 0;  // This just gets rid of an annoying warning.
    
    // Instance variables.
    
    private Grid grid;
    private boolean run, isRunning;
    private JButton clearButton, stepButton, goButton;
    private int gridX, gridY;
    private boolean lastChange;
    
    /**
     * Launches the life simulation application.  It builds
     * a GUI, and then exits.  The GUI will stay alive until
     * the window is closed and GUI events will be sent to
     * methods in this class.  (This is called event-driven
     * programming.)
     * 
     * @param args
     *            ignored
     */
    public static void main (String[] args)
    {
        // Create a window.
        
        JFrame frame = new JFrame("Cellular Life Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Get its content panel, set border layout.
        
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        
        // Create the application panel.  (Create one object of this
        //   class.)
        
        LifeSimulation gridPanel = new LifeSimulation();
        
        // Mouse events over the grid should be reported to the grid.
        
        gridPanel.addMouseListener(gridPanel);
        gridPanel.addMouseMotionListener(gridPanel);
        
        // Create the buttons.
        
        JPanel buttonPanel = new JPanel();
        gridPanel.addButtons(buttonPanel);
        
        // Add the panels to the application window.
        
        content.add(gridPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);
        
        // Done - Show the window.
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Constructor - creates a default Grid 40x30, and
     * sets the simulation state as not running.  Set the
     * default size of this panel.
     */
    public LifeSimulation ()
    {
        this.grid = new Grid(gridWidth, gridHeight);
        this.setMinimumSize(new Dimension(grid.getWidth() * cellSize + 10, grid.getHeight() * cellSize + 10));
        this.setPreferredSize(this.getMinimumSize());
        
        this.run = false;
        this.isRunning = false;
    }
    
    /**
     * This finalizer just stops the animation if it
     * is running.
     */
    public void finalize() throws Throwable
    {
        run = false;
        super.finalize();
    }
    
    /**
     * Helper function that adds buttons to the specified
     * JPanel.  No special layout is done on the panel.
     * This object is added as an ActionListener to each
     * button.
     * 
     * @param JPanel 
     *              the panel to receive the buttons  
     */
    protected void addButtons (JPanel panel)
    {
        panel.setLayout(new FlowLayout());
        
        clearButton = new JButton ("Clear the grid");
        stepButton = new JButton ("Step one generation");
        goButton = new JButton ("Animate");
        
        panel.add(clearButton);
        panel.add(stepButton);
        panel.add(goButton);
        
        clearButton.addActionListener(this);
        stepButton.addActionListener(this);
        goButton.addActionListener(this);
    }
    
    /**
     * The animation loop - this loop steps the life simulation
     * once a second.  (This method should not be called, it
     * will automatically be called when a new thread is started
     * on this object.)
     */
    public void run ()
    {
        while (run)
        {
            isRunning = true;
            grid.stepOneGeneration();
            repaint();
            try 
            { 
                for (int i = 0; run && i < Math.max(1, Math.min(10, 20-animationSpeed)); i++)  // Allow for quick wake-up.
                    Thread.sleep(100/animationSpeed); 
            } 
            catch (Exception e) {}
        }
        isRunning = false;
    }

    /**
     * Draws the grid.
     * 
     * @param g
     *         this panel's graphics object
     */
    public void paint (Graphics g)
    {
        // Compute the upper-left corner of the grid.
        
        int width = this.getWidth();
        int height = this.getHeight();
        int rows = grid.getHeight();
        int columns = grid.getWidth();
        
        gridX = (width - columns * cellSize) / 2;
        gridY = (height - rows * cellSize) / 2;

        // Wipe the window clean.
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        
        // Draw each grid cell.
        
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++)
            {
                // Draw a dark gray box around the cell.
                
                g.setColor (new Color(32, 32, 32));
                g.drawRect(gridX + column * cellSize, gridY + row * cellSize, cellSize+1, cellSize+1);
                
                // Draw a rounded yellowish cell if it is alive.
                
                if (grid.isAlive(row, column))
                {
                    g.setColor (new Color(255, 255, 224));
                    g.fillRoundRect(gridX + column * cellSize + 1, gridY + row * cellSize + 1, cellSize-1, cellSize-1, cellSize/2, cellSize/2);
                }
            }
    }
    
    /**
     * This method is called when one of the three
     * buttons are pressed (because we registered this
     * object as a listener).  It determines which button
     * was pressed, and acts accordingly.
     * 
     * @param event
     *             The action event that triggered the method call
     */
    public void actionPerformed (ActionEvent event)
    {
        Object source = event.getSource();
        
        // If the animation is running, stop it.
        
        boolean wasRun = run;
        
        if (isRunning)
        {
            run = false;
            while (isRunning)
                try { Thread.sleep(100); } catch (Exception e) {}
        }
        
        // Act upon the buttons.
        
        if (source == clearButton)
        {
            grid.clear();
        }
        else if (source == stepButton)
        {
            grid.stepOneGeneration();
        }
        else if (source == goButton)
        {
            if (!wasRun)  // If the animation was originally stopped, restart it.
            {
                run = true;
                new Thread(this).start();
            }
        }
        
        // Update the button text if needed.
                
        if (run)
            goButton.setText("Stop");
        else
            goButton.setText("Animate");
        
        // Repaint if needed.
        
        if (!run)
            repaint();
    }

    /**
     * Because I registered this object as a listener
     * to mouse events, this method will be called
     * whenever the mouse button is pushed down.
     * It records the row and column number  (in the grid) 
     * of the mouse press.  It then toggles the
     * grid state for this location.
     * 
     * @param event
     *             the mouse event that triggered this method call
     */
    public void mousePressed (MouseEvent event)
    {
        int column = (event.getX() - gridX) / cellSize;
        int row    = (event.getY() - gridY) / cellSize;

        if (row >= 0    && row < grid.getHeight() &&
            column >= 0 && column < grid.getWidth())
        {
            lastChange = !grid.isAlive(row, column);
            grid.setCellState(row, column, lastChange);
            repaint();
        }
    }

    /**
     * Because I registered this object as a listener
     * to mouse motion events, this method will be called
     * whenever the mouse is moved with the button pushed down.
     * It records the row and column number  (in the grid) 
     * of the mouse press.  It then sets the same grid
     * cell state that was set in mousePressed.
     * 
     * @param event
     *             the mouse event that triggered this method call
     */
    public void mouseDragged (MouseEvent event)
    {
        int column = (event.getX() - gridX) / cellSize;
        int row    = (event.getY() - gridY) / cellSize;

        if (row >= 0    && row < grid.getHeight() &&
            column >= 0 && column < grid.getWidth())
        {
            grid.setCellState(row, column, lastChange);
            repaint();
        }
        
    }
    
    // Unused event handlers - must be implemented because
    //   they are part of the interfaces.  Empty implementations below.
    
    public void mouseReleased (MouseEvent arg0) {}
    public void mouseClicked (MouseEvent arg0)  {}
    public void mouseEntered (MouseEvent arg0)  {}
    public void mouseExited (MouseEvent arg0)   {}
    public void mouseMoved (MouseEvent arg0)    {}
}
