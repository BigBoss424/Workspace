
public class Programmer extends Employee
{
	private boolean hasBusPass;
	
	public Programmer(String name, boolean busPass)
	{
		super(name, 20000);
		hasBusPass = busPass;
	}

	@Override
	public void reportSalary()
	{
		System.out.println("I am a programmer. I make $" + salary + " and I"
			+ ((hasBusPass) ? " get a bus pass." : " do not get a bus pass."));
	}
}
