import java.util.Random;


public class MazeGenerator
{
	private int[][] grid;
	protected static Random rand = new Random();

	private final int LEFT = 1;
	private final int UP   = 2;
	private final int RIGHT = 3;
	private final int DOWN = 4;

	public MazeGenerator(int width, int height)
	{
		grid = new int[height][width];
	}

	public int[][] getGrid()
	{
		return grid;
	}


	public void generate()
	{
		if (!generate(0, 0, 0))
			generate();
	}

	private boolean generate(int x, int y, int direction)
	{
		// error!
		if (outOfBounds(x, y))
			return false;

		if (x == grid[0].length - 1 && y == grid.length -1)
			return true;

		grid[y][x] = 7;
		
		// determine direction of motion
		int motion = (direction > 0 && direction < 5) ? direction : 0;

		// if there was no motion, go right by default
		if (motion == 0)
			motion = RIGHT;

		// otherwise see if we're lucky enough to turn
		else if (rand.nextInt(100) < 25 || !isEmpty(x, y, direction))
		{
			int temp;
			boolean done = false;

			if (rand.nextInt(100) < 50)
			{
				temp = (motion - 1 > 0) ? motion - 1 : 4;

				if (isEmpty(x, y, temp))
				{
					motion = temp;
					done = true;
				}
			}
			if (!done)
			{
				temp = (motion + 1 < 5) ? motion + 1 : 1;

				if (isEmpty(x, y, temp))
				{
					motion = temp;
					done = true;
				}
			}

			// impossible. :/
			if (!done && !isEmpty(x, y, direction))
			{
				return false;
			}
		}

		if (motion == LEFT)
			return generate(x-1, y, motion);
		else if (motion == RIGHT)
			return generate(x+1, y, motion);
		else if (motion == UP)
			return generate(x, y-1, motion);
		else // down
			return generate(x, y+1, motion);

	}

	private boolean isEmpty(int x, int y, int direction)
	{
		int newX = x;
		int newY = y;

		if (direction == LEFT)
			newX -= 1;
		if (direction == UP)
			newY -= 1;
		if (direction == RIGHT)
			newX += 1;
		if (direction == DOWN)
			newY += 1;

		return (!outOfBounds(newX, newY) && grid[newY][newX] == 0);
	}

	private boolean outOfBounds(int x, int y)
	{
		return x < 0 || x >= grid[0].length || y < 0 || y >= grid.length;
	}
}
