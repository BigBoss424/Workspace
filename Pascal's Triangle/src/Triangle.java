/**
 * Triangle.java
 * @author Stephen Hoerner
 * @course CSCD211
 * @date   10/9/12
 */

public class Triangle
{
	int[][] nums;
	
	public Triangle(int length)
	{
		nums = new int[length][];
		
		// loop through the rows
		for (int row = 0; row < length; row++)
		{
			// instantiate array
			nums[row] = new int[row + 1];
			
			// loop through & set internal array's values
			for (int col = 0; col < row + 1; col++)
			{
				// either first or last column; it shall be assigned '1'
				if (col == 0 || col == row)
					nums[row][col] = 1;
				
				// time for some arithmetic
				else
					nums[row][col] = nums[row-1][col-1] + nums[row-1][col];
			}
		}
	}
	
	@Override
	public String toString()
	{
		String result = "";

		// loop through the rows
		for (int row = 0; row < nums.length; row++)
		{	
			// concatenation 'n stuff
			for (int val : nums[row])
				result += val + "  ";
			
			result += "\n";
		}
		
		return result;
	}
}
