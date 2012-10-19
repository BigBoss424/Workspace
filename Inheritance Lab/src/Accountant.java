
public class Accountant extends Employee
{
	private double parkingMoney;
	
	public Accountant(String name, double parkingMoney)
	{
		super(name, 0);
		this.parkingMoney = parkingMoney;
	}

	@Override
	public void reportSalary()
	{
		System.out.println("I am an accountant. I make $" + salary
			+ " plus a parking allowance of $" + parkingMoney);
	}
}
