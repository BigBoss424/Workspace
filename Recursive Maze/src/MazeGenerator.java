
/**
 * Extra class for a very simplistic maze generator.
 *  
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

import java.util.Random;

public class MazeGenerator extends Maze
{
	protected static Random rand = new Random();

	/**
	 * Constructor that receives the desired
	 * width & height for the "maze."
	 * 
	 * @param width number of nodes wide
	 * @param height number of nodes tall
	 */
	public MazeGenerator(int width, int height)
	{
		super(new int[height][width]);
	}

	/**
	 * The spectacular generation method!
	 * Each node has a 50:50 chance of being a
	 * 1 or a 0. Very basic. This will continue
	 * running until a solvable maze is created.
	 */
	public void generate()
	{
		do
		{
			for (int i = 0; i < grid.length; i++)
			{
				for (int k = 0; k < grid[0].length; k++)
				{
					grid[i][k] = rand.nextInt(2);
				}
			}
		} while (!this.solve());
	}
}
