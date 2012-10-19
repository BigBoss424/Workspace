// Stephen Hoerner

public abstract class Monster extends DungeonCharacter
{
	protected int healChance;
	protected int maxHeal;
	protected int minHeal;

	public Monster(String name, int health, int attackSpeed, int rangeMin, int rangeMax, int hitChance, int healChance, int maxHeal, int minHeal)
	{
		super(name, health, attackSpeed, rangeMin, rangeMax, hitChance);

		this.healChance = healChance;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	}

	@Override
	public void attack(DungeonCharacter other)
	{
		if (!this.isLiving() || !other.isLiving())
			return;

		if (turnNumber == 0)
			turnNumber = getAttackRatio(other);
		else 
		{
			super.attack(other);
			if (--turnNumber > 0 && other.health > 0)
				attack(other);
		}
	}

	public String getName()
	{
		return name;
	}
	
	private void heal()
	{
		if (rand.nextInt(100) < healChance)
		{
			int heal = rand.nextInt(maxHeal - minHeal) + minHeal + 1;
			health += heal;
			System.out.println(name + " managed to heal for " + heal + "points.");
			System.out.println(name + " now has " + health + " health.");
		}
		else
		{
			System.out.println(name + " tried to heal but failed.");
		}
	}

	@Override
	public void removeHealth(int amount)
	{
		super.removeHealth(amount);

		if (health > 0)
			heal();
	}
}