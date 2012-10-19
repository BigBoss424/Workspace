
public abstract class Employee
{
	protected String name;
	protected int salary = 40000;
	
	public Employee(String name, int salaryBonus)
	{
		this.name = name;
		salary += salaryBonus;
	}
	
	public abstract void reportSalary();
}
