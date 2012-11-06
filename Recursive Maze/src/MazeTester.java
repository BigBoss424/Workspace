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
	 * Entry point for the application.
	 * @param args  standard application arguments
	 */
	public static void main(String[] args)
	{
    	Maze tunnel = new Maze();
    	
    	System.out.println("Preparing to solve...");
    	
    	if (tunnel.solve())
    		System.out.println("Solution found!");
    	else
    		System.out.println("No solution possible.");
    	
    	System.out.println();
    	System.out.println(tunnel);


        MazeGenerator gen = new MazeGenerator(10, 10);
        gen.generate();
        Maze generated = new Maze(gen.getGrid());
        System.out.println("\nGenerated: ");
        System.out.println();
	}
}
