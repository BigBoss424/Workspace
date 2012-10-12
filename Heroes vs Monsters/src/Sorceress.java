
public class Sorceress extends Hero
{
	public Sorceress(String name)
	{
		super(name, 75, 5, 25, 45, 70, 30);
		this.specialAttack = "Blood Transfusion";
	}

	private void bloodTransfusion()
	{
		int heal = rand.nextInt(50) + 26;
		this.health += heal;
		System.out.println("Using your enemy's blood (you're rather creepy, aren't you?), you managed to restore " + heal + " health.");
	}

	public static String getTitle()
	{
		switch (rand.nextInt(3))
		{
			case 0:
				return " the Zapper";
			case 1:
				return " the Fiesty";
			case 2:
				return " the Flashy";
		}
	}

	@Override
	private void specialAttack(DungeonCharacter other)
	{
		bloodTransfusion();
	}

}