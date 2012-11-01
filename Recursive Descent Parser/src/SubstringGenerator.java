/**
 * Primary class for the Recursive Descent Parser. Contains all of the recursive
 * code necessary.
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class SubstringGenerator
{
	/**
	 * Generates all possible permutations of a string.
	 * 
	 * @param str
	 *            the base string
	 * @return String a multiline string of the permutations
	 */
	public static String generate(String str)
	{
		if (str.length() <= 0)
		{
			return str;
		}

		return innerGenerate(str) + generate(str.substring(1));
	}

	/**
	 * Generates the permutations possible by shortening a string from the
	 * right. Used exclusively by generate().
	 * 
	 * @param str
	 *            the base string
	 * @return String a multiline string of the permutations
	 */
	private static String innerGenerate(String str)
	{
		if (str.length() < 1)
		{
			return str;
		}

		return str + "\n" + innerGenerate(str.substring(0, str.length() - 1));
	}
}
