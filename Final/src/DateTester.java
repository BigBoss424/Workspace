/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

import java.util.Scanner;
import java.io.*;

class DateTester {

	public static void main(String[] args) throws IOException {

		Scanner kb;
		Scanner fin;
		String fileName;

		kb = new Scanner(System.in);

		// get a valid file
		while (true) {
			try {
				System.out.print("\nPlease enter the filename: ");
				//fileName = kb.nextLine();
				
				System.out.println("dateList.txt");
				fileName = "dateList.txt";

				fin = FileUtil.openInputFile(fileName);
				break;
			}
			catch (Exception e) {
				System.out.println("Invalid file!\n");
			}
		}

		// create array of correct length
		Date dateList[] = new Date[countLines(fileName)];

		// populate array with valid objects
		for (int i = 0; fin.hasNextLine(); i++) {
			String value = fin.nextLine();

			if (Date.isValid(value)) {
				dateList[i] = new Date(value);
			}
			else {
				i--;
			}
		}

		fin.close();

		System.out.println(dateList.length);
		System.out.println();

		/////////////////////////////////////////

		SortSearchUtil.insertionSort(dateList);

		// it's menu time.

		int choice = 0;

		while (choice != 5) {
			do {
				displayMenu();
				System.out.print("Choice: ");

				choice = getValue(kb);
				System.out.println();

				if (choice <= 0 || choice > 5) {
					System.out.println("That is an invalid choice. Please try again.");
				}
			}
			while (choice <= 0 || choice > 5);

			int choiceInt;
			String choiceStr;

			switch (choice) {
				case 1:
					System.out.println("Do you want to:\n");
					System.out.println("\t1. Display values");
					System.out.println("\t2. Save values to file\n");

					choiceInt = getFromRange(kb, "Choice: ", 1, 2);

					if (choiceInt == 1) {
						System.out.println();
						for (Date day : dateList) {
							System.out.println(day);
						}
					}
					else {
						System.out.println("TODO: save to file");
					}
					break;

				case 2:
					System.out.print("Enter date: ");
					choiceStr = kb.nextLine();

					if (Date.isValid(choiceStr)) {
						int position = SortSearchUtil.binarySearch(dateList, new Date(choiceStr));

						if (position != -1) {
							System.out.println("Success! Date found.");
						}
						else {
							System.out.println("Date not found.");
						}
					}
					else {
						System.out.println("Date not found.");
					}
					break;

				case 3:
					System.out.print("Enter date: ");
					choiceStr = kb.nextLine();

					if (Date.isValid(choiceStr)) {
						// copy the array
						Date[] tempList = (Date[])dateList.clone();
						dateList = new Date[dateList.length + 1];

						// re-assign values
						for (int i = 0; i < tempList.length; i++) {
							dateList[i] = tempList[i];
						}
						// assign new value
						dateList[dateList.length - 1] = new Date(choiceStr);

						// now sort them
						SortSearchUtil.insertionSort(dateList);
						System.out.println("Date added.");
					}
					else {
						System.out.println("Invalid date.");
					}
					break;

				case 4:
					System.out.print("Enter date: ");
					choiceStr = kb.nextLine();

					if (Date.isValid(choiceStr)) {
						// locate the date
						int position = SortSearchUtil.binarySearch(dateList, new Date(choiceStr));

						if (position == -1) {
							// don't use a nonexistant date
							System.out.println("Date not found.");
							break;
						}

						// clone the list
						Date[] tempList = (Date[])dateList.clone();
						dateList = new Date[dateList.length - 1];

						// ignore the old value
						for (int i = 0; i < tempList.length; i++) {
							if (i < position) {
								dateList[i] = tempList[i];
							}
							if (i > position) {
								dateList[i - 1] = tempList[i];
							}
						}
						System.out.println("Deletion successful.");
					}
					else {
						System.out.println("Invalid date.");
					}
					break;
			}
		}
	}

	private static int countLines(String fileName) throws IOException {
		int count = 0;
		Scanner fin = new Scanner(new File(fileName));

		while (fin.hasNextLine()) {
			String t = fin.nextLine();

			if (Date.isValid(t))
				count++;
		}

		fin.close();
		return count;
	}


	private static void displayMenu() {
		System.out.println("\n1. Print/save the dates");
		System.out.println("2. Search for a date");
		System.out.println("3. Add a date");
		System.out.println("4. Delete a date");
		System.out.println("5. Exit\n");
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

	private static int getFromRange(Scanner kb, String prompt, int min, int max) {
		int index = 0;
		do {
			System.out.print(prompt);
			index = getValue(kb);

			if (index < min || index > max) {
				System.out.println("That is an invalid choice. Please try again.\n");
			}
		}
		while (index < min || index > max);
		return index;
	}
}