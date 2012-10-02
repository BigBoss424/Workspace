
/**
 * @author Stephen Hoerner
 *
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

// Post Office: capable of loading letters from a file, sorting them, and printing them
public class PostOffice
{
	private Letter[] letters;
	private int letterCount = 0;
	
	public void readLetters(String file) throws IOException
	{
		Scanner fin = new Scanner(new File(file));
		
		int lineCount = countLines(file);
		this.letterCount = lineCount / 7;
		
		letters = new Letter[letterCount];
		
		// each of these iterations represents 7 lines (1 letter)
		for (int i = 0; i < this.letterCount; i++)
		{
			letters[i] = new Letter(
					// 'to' details 
					fin.nextLine(), fin.nextLine() + "\n" + fin.nextLine(),
					// 'from' details
					fin.nextLine(), fin.nextLine() + "\n" + fin.nextLine(),
					// weight
					new Double(fin.nextLine().trim()));
		}
	}
	
	public void sortLetters()
	{
		for (int index = 1; index < letters.length; index++)
		{
			Letter key = letters[index];
			int position = index;

			while (position > 0 && key.compareTo(letters[position - 1]) < 1)
			{
				letters[position] = letters[position - 1];
				position--;

			}

			letters[position] = key;
		}
	}
	
	public void printLetters()
	{
		double postage = 0;
		String result = "";
		
		for (int i = 0; i < this.letterCount; i++)
		{
			postage += Letter.getPostage(letters[i].getWeight());
			result += letters[i].toString() + "\n\n";
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Letter count: " + this.letterCount);
		System.out.println("Total postage: $" + df.format(postage));
		System.out.println();
		System.out.println(result);
		
		// TODO build printLetters() method
	}
	
	private static int countLines(String file) throws IOException
	{
		int count = 0;
		Scanner fin = new Scanner(new File(file));

		while (fin.hasNextLine())
		{
			fin.nextLine();
			count++;
		}

		fin.close();
		return count;
	}
}
