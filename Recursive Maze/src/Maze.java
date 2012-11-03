/**
 * Primary class of the maze solver. Contains all the
 * fields and methods necessary for solving a maze.
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class Maze
{
	// default values for the grid
    private int[][] grid = {{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,0,1,1,1,0,1,1,1,1,0,0,1},
							{0,0,0,0,1,0,1,0,1,0,1,0,0},
							{1,1,1,0,1,1,1,0,1,0,1,1,1},
							{1,0,1,0,0,0,0,1,1,1,0,0,1},
							{1,0,1,1,1,1,1,1,0,1,1,1,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0},
							{1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    // constants representing the possible values
    private final int OPEN = 1;
    private final int VISITED = 3;
    private final int CORRECT = 7;
    
    // helper fields
    private int width, height;
    private boolean awesomeMode = false;
    
	/**
	 * Constructs a default Maze object.
	 */
    public Maze()
    {
    	width = grid[0].length;
    	height = grid.length;
    }

	/**
	 * Constructs a Maze object, with a custom set of
	 * grid values. Verifies that the maze has adequate
	 * dimensions.
	 * 
	 * @param grid  the custom maze grid
	 * @throws IllegalArgumentException  if the dimensions were invalid
	 */
    public Maze(int[][] grid) throws IllegalArgumentException
    {
    	this.grid = grid;
    	width = grid[0].length;
    	height = grid.length;
    	
    	// validate the grid's dimensions
    	for (int[] row : grid)
    	{
    		if (row.length != width)
    			throw new IllegalArgumentException();
    	}
    }
    
	/**
	 * Returns the Maze in a viewable format. Each row 
	 * is on a line, with each column separated by a space.
	 * 
	 * @return the Maze as a string
	 */
    public String toString()
    {
    	String str = "";
    	
    	for (int[] row : grid)
    	{
    		for (int col : row)
    		{
    			if (!awesomeMode)
    				str += col + " ";
    			else if (col == 0)
    				str += "| ";
    			else if (col == 7)
    				str += "• ";
    		}
    		str += "\n";
    	}
    	
    	return str;
    }
    
    public void beAwesome()
    {
    	awesomeMode = true;
    }
    
	/**
	 * Simple-looking method that recursively
	 * solves the entire maze.
	 * 
	 * @return whether a solution was found
	 */
    public boolean solve()
    {
    	return solve(0, 0);
    }
    
	/**
	 * Inner recursive method for solving the maze. Works through
	 * all the possible options, unwinding/backtracking when necessary.
	 * 
	 * @param row  current row index
	 * @param col  current column index
	 * @return whether a solution was found
	 */
    private boolean solve(int row, int col)
    {
    	boolean done = false;
    	grid[row][col] = VISITED;
    	
    	// reached the end?
    	if (row == height-1 && col == width-1)
    		done = true;
    	
    	// up
    	if (!done && row > 0 && grid[row-1][col] == OPEN)
    	{
    		done = solve(row-1, col);
    	}
    	// down
    	if (!done && row < height - 1 && grid[row+1][col] == OPEN)
    	{
    		done = solve(row+1, col);
    	}
    	// left
    	if (!done && col > 0 && grid[row][col-1] == OPEN)
    	{
    		done = solve(row, col-1);
    	}
    	// right
    	if (!done && col < width - 1 && grid[row][col+1] == OPEN)
    	{
    		done = solve(row, col+1);
    	}
    	
    	// mark as correct
    	if (done)
    		grid[row][col] = CORRECT;
    	
    	return done;
    }
}
