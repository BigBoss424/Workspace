/**
 * Runner class for the maze solver. Contains initialization
 * of Maze object, calls the solve() method, and prints
 * the results.
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class MazeTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
    	Maze ma = new Maze();
    	System.out.println("Preparing to solve...");
    	
    	if (ma.solve())
    		System.out.println("Solution found!");
    	else
    		System.out.println("No solution possible.");
    	
    	System.out.println();
    	ma.displayGrid();

	}
}
