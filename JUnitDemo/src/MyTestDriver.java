import junit.framework.*;

public class MyTestDriver extends TestCase
{
	
	public MyTestDriver()
	{
		
	}
	
	public void testFirstMethod()
	{
		assertTrue(false);
	}
	
	public void testSecondMethod()
	{
		
	}
	
	public static junit.framework.Test suite()
	{
		return new TestSuite(MyTestDriver.class);
	}
	
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(suite());
	}
}