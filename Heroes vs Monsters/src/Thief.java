// Stephen Hoerner

public class Thief extends Hero
{
	public Thief()
	{
		super(75, 6, 20, 40, 80, 40);
		this.specialAttack = "Surprise Attack";
	}

	private void surpriseAttack(DungeonCharacter other)
	{
		if (rand.nextInt(100) < 40)
		{
			System.out.println("BAM! You caught them off guard!");
			this.turnNumber++;
			super.attack(other, true);
		}
		else if (rand.nextInt(100) < 20)
		{
			System.out.println("You were seen by the enemy and could not safely attack.");
		}
		else
		{
			int damage = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;
			other.removeHealth(damage);

			System.out.println("Though not a total surprise, you managed to hit the enemy for " + damage + " damage.");

			if (other.health <= 0)
				System.out.println(other.name + " now has no health.");
			else
				System.out.println(other.name + " now has " + other.health + " health.");
		}
	}

	protected String getTitle()
	{
		switch (rand.nextInt(3))
		{
			case 0:
				return " the Stealthy";
			case 1:
				return " the Surprising";
			default:
				return " the Timid";
		}
	}

	@Override
	protected void specialAttack(DungeonCharacter other)
	{
		surpriseAttack(other);
	}
}