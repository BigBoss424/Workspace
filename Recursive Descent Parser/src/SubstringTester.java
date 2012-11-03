/**
 * Runner class for the Recursive Descent Parser. Contains initial call to
 * recursive method and the proper printing code.
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

import java.util.Scanner;

public class SubstringTester
{
	/**
	 * Entry point for the application. Receives input from the user and
	 * generates its permutations, repeating until the user opts to quit.
	 * 
	 * @param args
	 *            standard program arguments
	 */
	public static void main(String[] args)
	{
		String input = "y";
		Scanner kb = new Scanner(System.in);

		while (input.trim().equalsIgnoreCase("y"))
		{
			System.out.print("Enter something: ");
			input = kb.nextLine();

			System.out.println("--------");
			System.out.println(SubstringGenerator.generate(input));
			System.out.println("--------");

			System.out.print("Again? (Y/N): ");
			input = kb.nextLine();
		}
	}
}
