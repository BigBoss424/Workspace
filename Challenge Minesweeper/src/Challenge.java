import java.util.Scanner;


public class Challenge {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Lines: ");
		int n = kb.nextInt();
		
		System.out.print("Columns: ");
		int m = kb.nextInt();
		
		if (n <= 0 || m <= 0 || n > 100 || m > 100)
		{
			System.out.println("Invalid values.");
			return;
		}
		
		
	}

}
