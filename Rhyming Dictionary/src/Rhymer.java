import java.io.*;
import java.util.*;


public class Rhymer {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner fin = new Scanner(new File("dict.dat"));
		List<String> dict = new ArrayList<String>();
		
		while (fin.hasNextLine())
		{
			String[] row = fin.nextLine().trim().split(" ");
			
			if (isAlpha(row[0]))
			{
				System.out.println(row[0]);
			}
			
			//dict.add(fin.nextLine().trim());

			
			/*String value = fin.nextLine();

			if (Date.isValid(value)) {
				dateList[i] = new Date(value);
			}
			else {
				i--;
			}*/
		}

		fin.close();

	}
	private static boolean isAlpha(String str)
	{
		List alpha = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray());
		for (char ch : str.toCharArray())
		{
			if (!alpha.contains(ch))
			{
				return false;
			}
		}
		return true;
	}
}
