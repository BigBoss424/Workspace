import java.util.*;

public class Permutations
{
	private String word;
	/**
    Constructs a permutation generator.
    @param aWord the word to permute
	 */
	public Permutations(String aWord)
	{
		word = aWord;
	}

	/**
    Gets all permutations of a given word.
	 */
	public ArrayList<String> getPermutations()
	{
		ArrayList<String> result = new ArrayList<String>();

		// The empty string has a single permutation: itself
		if (word.length() == 0) 
		{ 
			result.add(word); 
			return result; 
		}

		// Loop through all character positions
		for (int i = 0; i < word.length(); i++)
		{
			// Form a simpler word by removing the ith character
			String shorterWord = word.substring(0, i)
					+ word.substring(i + 1);

			// Generate all permutations of the simpler word
			Permutations shorterPermutations = new Permutations(shorterWord);
			ArrayList<String> shorterWordPermutations = shorterPermutations.getPermutations();

			// Add the removed character to the front of
			// each permutation of the simpler word, 
			for (String s : shorterWordPermutations)
			{
				result.add(word.charAt(i) + s);
			}
		}
		// Return all permutations
		return result;
	}

}
