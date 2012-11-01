import java.util.Random;

public class ExceptionTest1
{
	public static void main(String[] args)
	{
		int a = 0, b = 0, c = 0;
		int good = 0, bad = 0;
		Random r = new Random();

		for (int i = 0; i < 32000; i++)
		{
			try
			{
				b = r.nextInt();
				c = r.nextInt();
				a = 12345 / (b / c);
				good++;
			}
			catch (ArithmeticException e)
			{
				System.out.println("/ by zero at " + i + " b: " + b + "  c: " + c);
				bad++;
			}
		}
		System.out.println("Good:  " + good + "  Bad:  " + bad);
	}
}
