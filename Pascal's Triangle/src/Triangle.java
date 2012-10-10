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
				if (col == 0 || col == row)
					nums[row][col] = 1;
				else
					nums[row][col] = nums[row-1][col-1] + nums[row-1][col];
			}
		}
	}
	
	@Override
	public String toString()
	{
		String[] result = new String[nums.length];
		
		//result[row] = repeat("\t", (maxLength - nums[row].length) / 4);
		
		// loop through the rows
		for (int row = 0; row < nums.length; row++)
		{	
			result[row] = "";
			
			for (int val : nums[row])
				result[row] += val + "\t\t";
		}
		
		// prepare for some formatting
		int almostMaxLength = result[result.length - 2].length();
		int maxLength = result[result.length - 1].length();
		
		// loop through the rows AGAIN
		for (int row = 0; row < nums.length; row++)
		{	
			if (row % 2 == 0)
				result[row] = repeat("\t", (maxLength - result[row].length()) / 16) + result[row];
			else
				result[row] = repeat("\t", (almostMaxLength - result[row].length()) / 16) + result[row];
		}
		
		String total = "";
		
		for (String row : result)
			total += row + "\n";

		return total;
	}
	
	//	acquired from RosettaCode — http://rosettacode.org/wiki/Repeat_a_string#Java
	
	public static String repeat(String str, int times)
	{
		return new String(new char[times]).replace("\0", str);
	}
}
