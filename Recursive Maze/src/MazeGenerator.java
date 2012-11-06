import java.util.Random;


public class MazeGenerator extends Maze
{
	protected static Random rand = new Random();

	public MazeGenerator(int width, int height)
	{
		super(new int[height][width]);
	}

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
