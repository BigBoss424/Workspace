
import java.util.Random;

public abstract class DungeonCharacter
{
	protected Random rand = new Random();

	protected String name;
	protected int health;
	protected int attackSpeed;
	protected int rangeMin;
	protected int rangeMax;
	protected int hitChance;
	protected int turnNumber = 0;
	
	public DungeonCharacter(String name, int health, int attackSpeed, int rangeMin, int rangeMax, int hitChance)
	{
		this.name = name;
		this.health = health;
		this.attackSpeed = attackSpeed;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.hitChance = hitChance;
	}

	public boolean isLiving()
	{
		return health > 0;
	}

	public void attack(DungeonCharacter other)
	{
		if (!this.isLiving() || !other.isLiving())
			return;
		
		if (rand.nextInt(100) < hitChance)
		{
			int damage = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;

			removeHealth(damage);

			System.out.println(name + " struck for " + damage + " damage.");

			if (other.health <= 0)
				System.out.println(other.name + " now has no health.");
			else
				System.out.println(other.name + " now has " + other.health + " health.");
		}
		else
		{
			System.out.println(name + " missed while trying to attack!");
		}
	}

	public void removeHealth(int amount)
	{
		this.health -= amount;
	}

	public int getAttackRatio(DungeonCharacter other)
	{
		return (this.attackSpeed/other.attackSpeed > 0) this.attackSpeed/other.attackSpeed ? 1;
	}
}