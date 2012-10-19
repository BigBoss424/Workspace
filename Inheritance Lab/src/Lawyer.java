
public class Lawyer extends Employee
{
	private int stockOptions;
	
	public Lawyer(String name, int stockOptions)
	{
		super(name, 30000);
		this.stockOptions = stockOptions;
	}

	@Override
	public void reportSalary()
	{
		System.out.println("I am a lawyer. I get $" + salary + ", and I have " 
			+ stockOptions + " shares of stock.");
	}
}
