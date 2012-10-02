import java.io.*;
import java.util.*;

public class PermutationsDriver
{


	public static void main(String[] args) throws IOException
	{
		String results = "";
		String words[];
		String file = "wordsort.txt";
		Scanner fin = new Scanner(new File(file));
		
		int lineCount = countLines(file);
		words = new String[lineCount];
		
		// each of these iterations represents 7 lines (1 letter)
		for (int i = 0; i < lineCount; i++)
		{
			String w = fin.nextLine();
			if (w.length() > 7 || w.length() < 2 || w.charAt(1) != 'r')
			{
				i--;
				continue;
			}
			words[i] = w;
		}
		
		for (String word : words)
		{
			String t = word.substring(0,1) + "m" + word.substring(2);
			
			Permutations pg = new Permutations(t);
			ArrayList<String> perms = pg.getPermutations();
			
			for (String mutilation : perms)
			{
				if (SortSearchUtil.binarySearch(words, mutilation) && mutilation != word)
				{
					results += word + " --> " + t + " --> " + mutilation + "\n";
				}
			}
		}
		
		System.out.println(results);
	}
	
	private static int countLines(String file) throws IOException
	{
		int count = 0;
		Scanner fin = new Scanner(new File(file));

		while (fin.hasNextLine())
		{
			String w = fin.nextLine();
			if (w.length() <= 7 && w.length() >=2 && w.charAt(1) == 'r')
			{
				count++;
			}
		}

		fin.close();
		return count;
	}
}
