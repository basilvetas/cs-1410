package lab07;

/**
 * A grid object represents the grid part of a life simulation.
 * The grid object keeps track of the state of each square
 * (alive, dead), and allows the user to make one step in the
 * life simulation.
 * <p>
 * 
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 * 
 * @author pajensen
 */
public class Grid


{
    // Instance variables here.
	boolean[][] grid;
	int width, height;

    
    /**
     * Constructor - creates an empty grid of the
     * specified dimensions.
     * 
     * @param width The width of the new grid
     * @param height The height of the new grid
     */
    public Grid (int width, int height)
    {
    	grid = new boolean[height][width];
    	this.width = width;
    	this.height = height;
    }

    /**
     * Returns true if the specified cell in the grid
     * is alive, false otherwise.  If the coordinates
     * are illegal, false is returned.
     * 
     * @param row  a row number
     * @param column a column number
     * @return true iff that cell is alive
     */
    public boolean isAlive (int row, int column)
    {
    	if (row >= 0 && row < height && column >= 0 && column < width)
    		return grid[row][column];
    	else
    		return false;
    }
    
    /**
     * Sets the state of the specified cell in the
     * grid.
     * 
     * @param row a row number
     * @param column a column number
     * @param isAlive true if the grid cell should be alive
     */
    public void setCellState(int row, int column, boolean isAlive)
    {
    	grid[row][column] = isAlive;
    }
    
 
    /** 
     * Returns the width of the grid.
     * 
     * @return the width of this grid
     */
    public int getWidth ()
    {
    	return width;
    }

    /** 
     * Returns the height of the grid.
     * 
     * @return the height of this grid
     */
    public int getHeight ()
    {
    	return height;
    }
    
    /**
     * Clears the grid, all cells marked as
     * dead.
     */
    public void clear ()
    {
    	grid = new boolean[height][width];
    }
    
    /**
     * Performs one 'life' step using the standard rules
     * of life:<p>
     * 
     * Any live cell with fewer than two neighbors dies, as if by loneliness. <br> 
     * Any live cell with more than three neighbors dies, as if by overcrowding. <br>
     * Any live cell with two or three neighbors lives, unchanged, to the next generation. <br>
     * Any dead cell with exactly three neighbors comes to life.<p> 
     * 
     * Care must be taken to make sure the next generation is kept separate from the 
     * current generation.
     */
    public void stepOneGeneration ()
    {	
    	Grid nextGen = new Grid(width, height);
    	
    	for(int row = 0; row < height; row++)
    	{
    		for(int col = 0; col < width; col++)
    		{
    			int neighbors = 0;
    			if(isAlive(row-1, col-1))
    				neighbors++;
    			if(isAlive(row-1, col+1))
    				neighbors++;
    			if(isAlive(row-1, col))
    				neighbors++;
    			if(isAlive(row, col-1))
    				neighbors++;
    			if(isAlive(row, col+1))
    				neighbors++;
    			if(isAlive(row+1, col-1))
    				neighbors++;
    			if(isAlive(row+1, col+1))
    				neighbors++;
    			if(isAlive(row+1, col))
    				neighbors++;
    			
    			if(isAlive(row,col))	// current organism is alive
    			{
    				if(neighbors < 2 || neighbors >= 4)
    					nextGen.setCellState(row, col, false);
    				else
    					nextGen.setCellState(row, col, true);
    			}
    			else	// current organism is dead
    			{
    				if(neighbors == 3)
    					nextGen.setCellState(row, col, true);
    			}
    		}
    	}
    	this.grid = nextGen.grid;	
    		
    		
    		
    }
}
