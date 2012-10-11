
public class Warrior extends Hero
{
	public Warrior(String name)
	{
		super(name, 125, 4, 35, 60, 80, 20);
		this.specialAttack = "Crushing Blow";
	}

	private void crushingBlow(DungeonCharacter other)
	{
		if (rand.nextInt(100) < 40)
		{
			int damage = rand.nextInt(75) + 101;
			other.removeHealth(damage);
			System.out.println("You landed a CRUSHING blow for " + damage + "health!");
		}
		else
			System.out.println("You were distracted by a fly and crushed it instead. :(");
	}
}