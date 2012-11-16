import java.util.Scanner;


public class LinkTester
{
	private static final String LINE = "- - - - -";
	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		LinkedList list = new LinkedList(10);
		
		printLine();
		list.print();
		printLine();
		
		System.out.println("Item to remove: ");
		int delItem = new Integer(kb.nextLine().trim());
		
		System.out.println(list.deleteValue(delItem) + " occurence(s) deleted.\n");
		
		printLine();
		list.printReversed();
		printLine();
	}
	
	private static void printLine()
	{
		System.out.println(LINE);
	}
}
