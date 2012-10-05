/**
 * @author Stephen Hoerner
 */

import java.io.*;

// Driver: this is what runs the show
public class Driver
{
	public static void main(String[] args) throws IOException
	{
		PostOffice postOffice = new PostOffice();
		
		postOffice.readLetters("letters.in");
		postOffice.sortLetters();
		postOffice.printLetters();
	}
}
