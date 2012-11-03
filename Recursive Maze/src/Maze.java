
public class Maze
{
    private int[][] grid =  {	{1,1,1,0,1,1,0,0,0,1,1,1,1},
								{1,0,1,1,1,0,1,1,1,1,0,0,1},
								{0,0,0,0,1,0,1,0,1,0,1,0,0},
								{1,1,1,0,1,1,1,0,1,0,1,1,1},
								{1,0,1,0,0,0,0,1,1,1,0,0,1},
								{1,0,1,1,1,1,1,1,0,1,1,1,1},
								{1,0,0,0,0,0,0,0,0,0,0,0,0},
								{1,1,1,1,1,1,1,1,1,1,1,1,1}	};
    
    private final int VISITED = 3;
    private final int CORRECT = 7;
    
    private int width = grid[0].length;
    private int height = grid.length;
    
    public static void main(String[] args)
    {
    	Maze ma = new Maze();
    	ma.solve();
    }
    
    public boolean solve()
    {
    	boolean result = solve(0, 0);
    	System.out.print(grid);
    	return result;
    }
    
    private boolean solve(int row, int col)
    {
    	boolean found = false;
    	
    	grid[row][col] = VISITED;
    	
    	//if (row == grid.length-1 && col == grid[row].length-1)
    	if (row == 1 && col == 2)
    		found = true;
    		
    	// left
    	if (!found && col-1 >= 0 && grid[row][col-1] != VISITED)
    	{
    		found = solve(row, col-1);
    	}
    	// right
    	if (!found && col+1 <= grid[row].length-1 && grid[row][col+1] != VISITED)
    	{
    		found = solve(row, col+1);
    	}
    	// up
    	if (!found && row-1 >= 0 && grid[row-1][col] != VISITED)
    	{
    		found = solve(row, col-1);
    	}
    	// down
    	if (!found && row+1 <= grid.length-1 && grid[row+1][col] != VISITED)
    	{
    		found = solve(row, col-1);
    	}
    	
    	if (found)
    		grid[row][col] = CORRECT;
    	
    	return found;
    }
}
