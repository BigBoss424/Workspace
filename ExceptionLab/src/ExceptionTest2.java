public class ExceptionTest2
{
	public static void main(String[] args)
	{
		try
		{
			throwOne();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Exiting normally...");
	}

	private static void throwOne() throws IllegalAccessException
	{
		System.out.println("Begin throwOne.");

		if (3 == 3)
		{

			throw new IllegalAccessException("demo");
		}

		System.out.println("End throwOne.");
	}
}
