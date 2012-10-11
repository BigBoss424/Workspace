
public abstract class Hero extends DungeonCharactor
{
	protected int blockChance;
	protected int turnNumber;
	protected String specialAttack = "Cower in Fear";

	public Hero(String name, int health, int attackSpeed, int rangeMin, int rangeMax, int hitChance, int blockChance)
	{
		super(name, health, attackSpeed, rangeMin, rangeMax, hitChance);

		this.blockChance = blockChance;
		this.name = getInputName();
	}

	public void attack(DungeonCharactor other)
	{
		Scanner kb = new Scanner(System.in);

		System.out.println("Attack Options:");
		System.out.println("\t1) Normal");
		System.out.println("\t2) " + specialAttack);
		System.out.println("Enter an attack: ");

		if (kb.nextInt() == 2)
			specialAttack(other);
		else
			super.attack(other);
	}

	private void specialAttack(DungeonCharactor other)
	{
		// does nothing at this level
	}

	private String getInputName()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your hero's name: ");

		return kb.nextLine();
	}

	@Override
	public void removeHealth(int amount)
	{
		if (rand.nextInt(100) < blockChance)
			System.out.println("Attack blocked!");
		else
			super(amount);
	}
}