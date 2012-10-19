import java.util.ArrayList;

public class Driver
{
	public static void main(String[] args)
	{
		ArrayList<Employee> workers = new ArrayList<Employee>();
		
		workers.add(new Programmer("Stephen Hoerner", false));
		workers.add(new Programmer("Will E. Makit", true));
		
		workers.add(new Lawyer("Ivana Killmen", 11));
		workers.add(new Lawyer("Luke N. Dimm", 0));
		workers.add(new Lawyer("Eileen Dover", 100));
		
		workers.add(new Accountant("Bill Cheatem", 17.00));
		workers.add(new Accountant("Joe Kisonyou", 45.50));
		workers.add(new Accountant("Seymore Butts", 2.50));
		
		for (Employee e : workers)
		{
			e.reportSalary();
		}
	}
}
