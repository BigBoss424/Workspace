import java.util.ArrayList;
import java.util.Scanner;


public class Challenge {


	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.print("\nStart: ");
		int i = kb.nextInt();
		
		System.out.print("End: ");
		int j = kb.nextInt();
		
		System.out.println();
		
		if (i > j)
		{
			int z = i;
			i = j;
			j = z;
		}
		
		int max = 0;
		
		for (int x = i; x <= j; x++)
		{
			int temp = generate(x).size();
			if (temp > max)
			{
				max = temp;
			}
		}
		
		System.out.println(i + " " + j + " " + max);
	}
	
	private static ArrayList<Integer> generate(int initial)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int n = initial;
		list.add(n);
		
		while (n != 1)
		{
			if (n % 2 == 0)
				n = n / 2;
			else
				n = n * 3 + 1;
			
			list.add(n);
		}
		
		return list;
	}

}
