/*
*	Stephen Hoerner	
*	CSCD 210
*	5/21/12
*/

import java.util.Scanner;
import java.io.*;

class FileUtil {

	public static Scanner openInputFile(String fileName) throws FileNotFoundException {
		File fileHandle     = new File(fileName);
		Scanner fileScanner = new Scanner(fileHandle);

		return fileScanner;
	}

	public static Scanner openInputFile() throws IOException {
		Scanner kb = new Scanner(System.in);

		System.out.print("\nPlease enter the filename: ");
		String fileName = kb.nextLine();

		File fileHandle = new File(fileName);
		Scanner fileScanner = new Scanner(fileHandle);

		return fileScanner;
	}


}