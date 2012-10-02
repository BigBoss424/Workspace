
/*
*	Stephen Hoerner	
*	CSCD 210
*	5/28/12
*/

// -- NOTICE: Extra Credit Attempted -- //

import java.io.*;
import java.util.Scanner;

public class LineDriver {
	
	private static Line line1 = new Line();
	private static Line line2 = new Line();

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int choice = 0;
	
		while (choice != 8) {
			do {
				displayMenu();
				System.out.print("Choice: ");
	
				choice = getValue(kb);
				System.out.println();
	
				if (choice <= 0 || choice > 8) {
					System.out.println("That is an invalid choice. Please try again.");
				}
			}
			while (choice <= 0 || choice > 8);
	
			String choiceStr;
	
			switch (choice) {
				case 1:
					// set the first line
					System.out.println("Enter data in following format: \"x1, y1, x2, y2, width, color\"");
					choiceStr = kb.nextLine();
					
					try {
						line1 = createLine(choiceStr);
					}
					catch (Exception e) {
						System.out.println("Invalid data!");
					}
					
					break;
	
				case 2:
					// set the second line
					System.out.println("Enter data in following format: \"x1, y1, x2, y2, width, color\"");
					choiceStr = kb.nextLine();
					
					try {					
						line2 = createLine(choiceStr);
					}
					catch (Exception e) {
						System.out.println("Invalid data!");
					}
					
					break;
	
				case 3:
					// compare lines
					if (line1.equals(line2))
					{
						System.out.println("The two lines are EQUAL.");
					}
					else 
					{
						System.out.println("The two lines are UNEQUAL.");
					}
					
					break;
	
				case 4:
					// print the first line
					System.out.println(line1.toString());					
					break;
					
				case 5:
					// print the second line
					System.out.println(line2.toString());					
					break;
					
				case 6:
					// save current lines
					saveObjects();
					break;
					
				case 7:
					// load saved lines
					loadObjects();
					break;
			}
		}
	}

	private static Line createLine(String choiceStr) {
		String[] values = choiceStr.split(",");
		
		int x1 = Integer.parseInt(values[0].trim());
		int y1 = Integer.parseInt(values[1].trim());
		int x2 = Integer.parseInt(values[2].trim());
		int y2 = Integer.parseInt(values[3].trim());
		
		int width = Integer.parseInt(values[4].trim());
		String color = values[5].trim();
		
		if (Line.validateLine(x1, y1, x2, y2))
		{
			System.out.println("Success.");
			return new Line(x1, y1, x2, y2, color, width);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	private static void displayMenu() {
		System.out.println("\n1. Set values for line 1");
		System.out.println("2. Set values for line 2");
		System.out.println("3. Compare the lines");
		System.out.println("4. Show values of line 1");
		System.out.println("5. Show values of line 2");
		System.out.println("6. Save lines");
		System.out.println("7. Load lines");
		System.out.println("8. Quit\n");
	}
	
	private static int getValue(Scanner kb) {
		int value;

		try	{
			value = kb.nextInt();
		}
		catch (Exception e) {
			value = -1;
		}
		finally {
			kb.nextLine();
		}

		return value;
	}
	
	private static void saveObjects()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("serLines.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(line1);
			oos.writeObject(line2);
			
			oos.flush();
			oos.close();
			
			System.out.println("Success.");
		}
		catch (Throwable e)
		{
			System.out.println("Unable to save the lines.");
		}
	}
	
	private static void loadObjects()
	{
		try
		{
			FileInputStream fis = new FileInputStream("serLines.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			line1 = (Line)ois.readObject();
			line2 = (Line)ois.readObject();
			fis.close();
			
			System.out.println("Success.");
		}
		catch (Throwable e)
		{
			System.out.println("Unable to save the lines.");
		}
	}
}
