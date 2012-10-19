// Stephen Hoerner

public class Warrior extends Hero
{
	public Warrior()
	{
		super(125, 4, 35, 60, 80, 20);
		this.specialAttack = "Crushing Blow";
	}

	private void crushingBlow(DungeonCharacter other)
	{
		if (rand.nextInt(100) < 40)
		{
			int damage = rand.nextInt(75) + 101;
			other.removeHealth(damage);
			System.out.println("You landed a CRUSHING blow for " + damage + " health!");

			if (other.health <= 0) 
				System.out.println(other.name + " now has no health.");
			else
				System.out.println(other.name + " now has " + other.health + " health.");
		}
		else
			System.out.println("You were distracted by a fly and crushed it instead. :(");
	}

	protected String getTitle()
	{
		switch (rand.nextInt(3))
		{
			case 0:
				return " the Slicer";
			case 1:
				return " the Amazing";
			default:
				return " the Brave";
		}
	}

	@Override
	protected void specialAttack(DungeonCharacter other)
	{
		crushingBlow(other);
	}
}