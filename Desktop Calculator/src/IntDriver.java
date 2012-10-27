/*
 * 10/23/12
 * 
 * Stephen Hoerner
 * CSCD 211 ~ Assignment #4
 * 
 * No external code used.
 * Extra credit NOT attempted.
 * 
 */

import java.util.Scanner;

public class IntDriver
{
	// useful fields
	private static LongInteger num1;
	private static LongInteger num2;
	private static int opr = 0;
	private static int mode = 0;

	// this makes printing easier
	private final static String[] OPERATORS = { "", "+", "-", "*", "/" };

	public static void main(String[] args)
	{
		String input;
		Scanner kb = new Scanner(System.in);

		boolean running = true;

		// continue running until user exits
		while (running)
		{
			displayMenu();

			// infinite loop for valid input
			while (true)
			{
				try
				{
					System.out.print("Option or value -->  ");
					input = kb.nextLine();

					// interpret the choice
					switch (input.toLowerCase())
					{
					// modes
						case "dcm":
						case "dec":
						case "decimal":
							mode = 0;
							break;
						case "bin":
						case "binary":
							mode = 1;
							break;
						case "oct":
						case "octal":
							mode = 2;
							break;
						case "hex":
						case "hexadecimal":
							mode = 3;
							break;

						// quitting
						case "q":
						case "quit":
							System.out.println("Bye.");
							running = false;
							break;

						// operators
						case "+":
							opr = 1;
							break;
						case "-":
							opr = 2;
							break;
						case "*":
							opr = 3;
							break;
						case "/":
							opr = 4;
							break;

						// operate
						case "=":
							// if the operation works out, remove the old
							// operator
							operate();
							break;

						// turn input into number
						default:
							LongInteger temp;

							// determine type (exceptions will be thrown if
							// input is invalid)
							switch (mode)
							{
								case 1:
									temp = new BinaryInteger(input);
									break;
								case 2:
									temp = new OctalInteger(input);
									break;
								case 3:
									temp = new HexInteger(input);
									break;
								default:
									temp = new DecInteger(input);
									break;
							}

							// assign to correct slot
							if (num1 == null)
							{
								num1 = temp;
							}
							else
							{
								// ensure that we've already got an operator
								if (opr == 0)
								{
									throw new UnsupportedOperationException();
								}
								num2 = temp;
							}

							break;
					}
					// if we've reached this break, the input is valid
					break;
				}
				catch (UnsupportedOperationException e)
				{
					System.out
							.println("Invalid option; operator not specified.\n");
				}
				catch (Exception e)
				{
					System.out.println("Invalid option.\n");
				}
			}
		}
	}

	// applies the correct operator to the two number objects
	private static void operate() throws Exception
	{

		if (num1 == null || num2 == null || opr == 0)
		{
			throw new Exception("Not enough numbers.");
		}

		switch (opr)
		{
			case 1:
				num1 = num1.add(num2);
				break;
			case 2:
				num1 = num1.subtract(num2);
				break;
			case 3:
				num1 = num1.multiply(num2);
				break;
			case 4:
				num1 = num1.divide(num2);
				break;
			default:
				throw new Exception("Invalid operator.");
		}

		// clear the second number & the operator's value
		num2 = null;
		opr = 0;
	}

	private static void displayMenu()
	{
		System.out.println();

		// print the current mode
		switch (mode)
		{
			case 1:
				System.out.println("[Binary]");
				break;
			case 2:
				System.out.println("[Octal]");
				break;
			case 3:
				System.out.println("[Hexadecimal]");
				break;
			default:
				System.out.println("[Decimal]");
				break;
		}

		// print the current expression
		if (num1 != null)
		{
			System.out.print(num1 + "\t");
		}

		if (opr != 0)
		{
			System.out.print(OPERATORS[opr] + "\t");
		}

		if (num2 != null)
		{
			System.out.print(num2);
		}

		// print the actual menu
		System.out.println("\n");
		System.out.println("Bin - Binary        +");
		System.out.println("Oct - Octal         -");
		System.out.println("Dcm - Decimal       *");
		System.out.println("Hex - Hexadecimal   /");
		System.out.println("Q   - Quit          =\n");
	}
}
