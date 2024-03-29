// Stephen Hoerner
// Last tweaked 10/19/12
// No extra credit attempted

import java.util.Random;
import java.util.Scanner;

public class HeroesVersusMonsters {

	private static Hero hero;
	private static Monster monster;
	private static Random rand = new Random();

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		do 
		{
			System.out.println("Heroes: ");
			System.out.println("\t1) Warrior");
			System.out.println("\t2) Sorceress");
			System.out.println("\t3) Thief");
			System.out.print("Which path will you choose? ");

			int type = kb.nextInt();
			kb.nextLine();

			while (type < 1 && type > 3)
			{
				System.out.println("\nI only gave you three options. Let's try this again...");
				System.out.print("Which path will you choose? ");

				type = kb.nextInt();
				kb.nextLine();
				System.out.println();
			}

			switch (type)
			{
				case 1:
					hero = new Warrior();
					break;
				case 2:
					hero = new Sorceress();
					break;
				case 3:
					hero = new Thief();
					break;
			}

			switch (rand.nextInt(3))
			{
				case 0:
					monster = new Ogre("Ollix the Ogre");
					break;
				case 1:
					monster = new Skeleton("Scantron the Skeleton");
					break;
				case 2:
					monster = new Gremlin("Grankle the Gremlin");
			}

			System.out.println("\nYou are fighting against " + monster.getName() + "!");
			
			while (hero.isLiving() && monster.isLiving())
			{
				hero.attack(monster);
				monster.attack(hero);
			}

			System.out.print("Play again? (y/n) ");

			String tester = kb.nextLine().toUpperCase();
			tester = tester.trim();
			
			if (tester.equals("N"))
				break;
			else
				System.out.println();
		}
		while (true);
	}
}
