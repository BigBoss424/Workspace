import java.util.Scanner;


public class LinkTester
{
	private static final String LINE = "- - - - -";
	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		LinkedList list = new LinkedList();

		int choice;

		do
		{
			// get a valid choice
			displayMenu();
			
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

				case 2:
					System.out.println("Sorted.");
					break;

				case 3:
					printLine();
					list.print();
					printLine();
					break;

				case 4:
					printLine();
					list.printReversed();
					printLine();
					break;

				case 5:
					printLine();
					list.getEvens().print();
					printLine();
					break;

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

				case 8:
					list.clear();
					System.out.println("List cleared.");
					break;
			}

			System.out.println();

		}
		while (choice > 0 && choice < 9);
	}
	
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

	private static void printLine()
	{
		System.out.println(LINE);
	}
}
