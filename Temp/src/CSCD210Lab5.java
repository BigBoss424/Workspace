import java.util.Scanner;

public class CSCD210Lab5 {

	public static void main (String[] args){
	
		Scanner kb = new Scanner (System.in);
		int term, x, y;
		System.out.print("Enter an integer that is greater than 9: ");
		term = kb.nextInt();
		while (term<10)
			{
			System.out.println("Integer entered is less than 9, try again.");
			System.out.print("Enter an integer that is greater than 9: ");
			term = kb.nextInt();
			}
			
		float sum = 0;
		y=1;
	
		for(x=1; x<term; x++)
		{
			if(x%2==1)
			{
				sum += 4.0/y;
				y+=2;
			}
		}					
	}
}