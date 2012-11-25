


import java.util.Scanner;

/**
 * Calling class for the LinkedList project.
 * 
 * @author Stephen Hoerner
 * @see "No external resources used"
 */

public class LinkTester
{
	/**
	 * Entry point for the program
	 * @param args Don't bother entering any arguments... we don't use 'em
	 */
	public static void main(String[] args)
	{
		// Initialization
		Scanner kb = new Scanner(System.in);
		LinkedList list = new LinkedList();

		int choice;
		
		// Loop through the menu until user quits
		do
		{
			displayMenu();
			
			// Get a VALID choice from the user, or repeat ad nauseum
			while (true)
			{
				try
				{
					System.out.print("Choice: ");
					choice = kb.nextInt();

 					if (choice < 1 || choice > 9)
 						throw new IllegalArgumentException();

 					break;
				}
				catch (Exception e)
				{
					System.out.println("Invalid choice.\n");
				}
				finally
				{
					kb.nextLine();
				}
			}

			switch (choice)
			{
				// Create new, random list
				case 1:
					try
					{
						System.out.print("How big shall this list be? ");
						list.generateList(kb.nextInt());
					}
					catch (Exception e)
					{
						System.out.println("No can do!");
					}
					finally
					{
						kb.nextLine();
					}
					break;

				// "Sort" the list — they're actually pre-sorted
				case 2:
					System.out.println("Sorted.");
					break;

				// Print the values
				case 3:
					printLine();
					list.print();
					printLine();
					break;
				
				// Print the values... in reverse!
				case 4:
					printLine();
					list.printReversed();
					printLine();
					break;

				// Print the even values
				case 5:
					printLine();
					list.getEvens().print();
					printLine();
					break;

				// Print the "Nth" values
				case 6:
					try
					{
						System.out.print("Printing the Nth nodes, where N = ");
						int enn = kb.nextInt();
						
						printLine();
						list.printNth(enn);
						printLine();
					}
					catch (Exception e)
					{
						System.out.println("He's dead Jim! (Error!)");
					}
					finally
					{
						kb.nextLine();
					}
					break;

				// Deletion by value
				case 7:
					try
					{
						System.out.print("Which node value shall we look for? ");
						System.out.println("Deleted " + list.deleteValue(kb.nextInt()) + " nodes.");
					}
					catch (Exception e)
					{
						System.out.println("Whoops, something went wrong!");
					}
					finally
					{
						kb.nextLine();
					}
					break;

				// Clear the list
				case 8:
					list.clear();
					System.out.println("List cleared.");
					break;
			}

			System.out.println();

		}
		while (choice > 0 && choice < 9);
	}
	
	/**
	 * Prints a copy of the menu
	 */
	private static void displayMenu()
	{
		System.out.println("OPTIONS");
		System.out.println("\t1) Create new list");
		System.out.println("\t2) Sort the list");
		System.out.println("\t3) Print the list");
		System.out.println("\t4) Print in reverse order");
		System.out.println("\t5) Print out all even numbers");
		System.out.println("\t6) Print every Nth node");
		System.out.println("\t7) Delete nodes by value");
		System.out.println("\t8) Clear the list");
		System.out.println("\t9) Quit");
		System.out.println();
	}

	/**
	 * Handy helper function
	 */
	private static void printLine()
	{
		System.out.println("- - - - -");
	}
}
