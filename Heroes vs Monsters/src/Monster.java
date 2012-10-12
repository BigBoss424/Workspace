
public abstract class Monster extends DungeonCharactor
{
	protected int healChance;
	protected int maxHeal;
	protected int minHeal;

	public Monster(String name, int health, int attackSpeed, int rangeMin, int rangeMax, int hitChance, int healChance, int maxHeal, int minHeal)
	{
		super(name, health, attackSpeed, rangeMin, rangeMax, hitChance);

		this.blockChance = blockChance;
		this.name = getInputName();
	}

	@Override
	public void attack(DungeonCharactor other)
	{
		if (!this.isLiving() || !other.isLiving())
			return;

		if (turnNumber = 0)
			turnNumber = getAttackRatio(other);
		else 
		{
			super.attack(other);
			if (--turnNumber > 0 && other.health > 0)
				attack();
		}
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
		super(amount);

		if (health > 0)
			heal();
	}
}