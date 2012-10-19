// Stephen Hoerner

public class Sorceress extends Hero
{
	public Sorceress()
	{
		super(75, 5, 25, 45, 70, 30);
		this.specialAttack = "Blood Transfusion";
	}

	private void bloodTransfusion()
	{
		int heal = rand.nextInt(50) + 26;
		this.health += heal;
		System.out.println("Using your enemy's blood (you're rather creepy, aren't you?), you managed to restore " + heal + " health.");
		System.out.println("You now have " + this.health + " health.");
	}

	protected String getTitle()
	{
		switch (rand.nextInt(3))
		{
			case 0:
				return " the Zapper";
			case 1:
				return " the Fiesty";
			default:
				return " the Flashy";
		}
	}

	@Override
	protected void specialAttack(DungeonCharacter other)
	{
		bloodTransfusion();
	}

}