
/**
 * Runner class for the maze solver. Contains initialization
 * of Maze object, calls the solve() method, and prints
 * the results.
 * 
 * <b>EXTRA CREDIT:<b>
 * <p>None attempted, as none assigned. However, a
 *    primitive maze generation class was added for fun.</p>
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class MazeTester
{

	/**
	 * Entry point for the application.
	 * @param args  standard application arguments
	 */
	public static void main(String[] args)
	{
		// === DEFAULT MAZE ===
		
    	Maze tunnel = new Maze();
    	System.out.println("Preparing to solve...");
    	
    	if (tunnel.solve())
    		System.out.println("Solution found!");
    	else
    		System.out.println("No solution possible.");
    	
    	System.out.println();
    	System.out.println(tunnel);

    	
    	// === CUSTOM MAZE ===
    	
        MazeGenerator gen = new MazeGenerator(32, 16);
        gen.generate();
        
        System.out.println("\nCustom maze generation (for fun):\n");
        System.out.println(gen);
	}
}
