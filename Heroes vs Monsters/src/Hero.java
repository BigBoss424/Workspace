// Stephen Hoerner

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	protected int blockChance;
	protected String specialAttack = "Cower in Fear";

	public Hero(int health, int attackSpeed, int rangeMin, int rangeMax, int hitChance, int blockChance)
	{
		super("", health, attackSpeed, rangeMin, rangeMax, hitChance);

		this.blockChance = blockChance;
		this.name = getInputName() + this.getTitle();
	}

	@Override
	public void attack(DungeonCharacter other)
	{
		if (!this.isLiving() || !other.isLiving())
			return;

		if (turnNumber == 0)
		{
			turnNumber = getAttackRatio(other);
		}
		else 
		{
			System.out.println("\nTurns to attack: " + turnNumber);
			Scanner kb = new Scanner(System.in);
			
			System.out.println("Attack Options:");
			System.out.println("\t1) Normal");
			System.out.println("\t2) " + specialAttack);
			System.out.println("\t3) Flee (exit)");
			System.out.print("Enter an attack: ");

			while (true)
			{
				try
				{
					int option = Integer.parseInt(kb.nextLine());
					System.out.println();
					
					if (option == 2)
						specialAttack(other);
					else if (option == 3)
						this.health = 0;
					else
						super.attack(other);
					
					break;
				}
				catch (Exception e)
				{
					// nothing...
				}
			}

			System.out.println();

			if (--turnNumber > 0 && this.health > 0 && other.health > 0)
				attack(other);
		}
	}

	public void attack(DungeonCharacter other, boolean normal)
	{
		if (!this.isLiving() || !other.isLiving())
			return;

		if (normal)
			super.attack(other);
		else 
			attack(other);
	}

	protected abstract void specialAttack(DungeonCharacter other);
	protected abstract String getTitle();
	
	private String getInputName()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter your hero's name: ");

		return kb.nextLine();
	}

	@Override
	public void removeHealth(int amount)
	{
		if (rand.nextInt(100) < blockChance)
			System.out.println("Attack blocked!");
		else
			super.removeHealth(amount);
	}
}