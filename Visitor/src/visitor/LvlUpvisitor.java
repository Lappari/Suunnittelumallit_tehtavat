package visitor;

import java.util.Random;
import java.util.Scanner;

import state.Bulbasaur;
import state.Charizard;
import state.Charmaleon;
import state.Charmander;
import state.Ivysaur;
import state.PokemonContext;
import state.Venusaur;

public class LvlUpvisitor extends AVisitor {

	private Random r = new Random();
	private Scanner scanner = new Scanner(System.in);

	// CHARMANDER lvlup
	public void lvlUp(PokemonContext c, Charmander asd) {

		if (c.getName() == null) {// tarkistetaan onko pokemon nimetty jos ei annetaan pokemonille sen muodon nimi
			c.setName("Charmander");
		}

		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			if (c.getLvl() < 1) {// alustetaan pokemonille aloitus pisteet
				c.setAtk(r.nextInt(4) + 14);
				c.setDef(r.nextInt(4) + 8);
				c.setMaxHp(r.nextInt(10) + 30);
				c.setLvl(1);
			} else {
				c.setAtk(c.getAtk() + r.nextInt(3) + 4);
				c.setDef(c.getDef() + r.nextInt(2) + 3);
				c.setMaxHp(c.getMaxHp() + r.nextInt(7) + 19);
				c.setLvl(c.getLvl() + 1);
			}
		}

		if (c.getLvl() >= 16) {// kun pokemon saavuttaa levelin 16 tai yli se muuttaa muotoa
			asd.evolve(c, Charmaleon.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai levelin!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// CHARMALEON lvlup
	public void lvlUp(PokemonContext c, Charmaleon asd) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(4) + 12);
			c.setDef(c.getDef() + r.nextInt(3) + 6);
			c.setMaxHp(c.getMaxHp() + r.nextInt(9) + 23);
			c.setLvl(c.getLvl() + 1);

		}

		if (c.getLvl() >= 36) {// kun pokemon saavuttaa levelin 36 tai yli se muuttaa muotoa
			asd.evolve(c, Charizard.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai levelin!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// CHARIZARD lvlup
	public void lvlUp(PokemonContext c, Charizard asd) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(4) + 12);
			c.setDef(c.getDef() + r.nextInt(3) + 9);
			c.setMaxHp(c.getMaxHp() + r.nextInt(10) + 26);
			c.setLvl(c.getLvl() + 1);
		}

		System.out.println("Sai levelin!");
		c.printInfo();
		scanner.nextLine();

		c.setHp(c.getMaxHp());
	}

	// BULBASAUR lvlup
	public void lvlUp(PokemonContext c, Bulbasaur asd) {
		if (c.getName() == null) {// tarkistetaan onko pokemon nimetty jos ei annetaan pokemonille sen muodon nimi
			c.setName("Bulbasaur");
		}

		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			if (c.getLvl() < 1) {// alustetaan pokemonille aloitus pisteet
				c.setAtk(r.nextInt(4) + 12);
				c.setDef(r.nextInt(3) + 11);
				c.setMaxHp(r.nextInt(8) + 32);
				c.setLvl(1);
			} else {
				c.setAtk(c.getAtk() + r.nextInt(2) + 3);
				c.setDef(c.getDef() + r.nextInt(4) + 4);
				c.setMaxHp(c.getMaxHp() + r.nextInt(10) + 20);
				c.setLvl(c.getLvl() + 1);
			}
		}

		if (c.getLvl() >= 16) {// kun pokemon saavuttaa levelin 16 tai yli se muuttaa muotoa
			asd.evolve(c, Ivysaur.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai levelin!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// VENUSAUR lvlup
	public void lvlUp(PokemonContext c, Venusaur sad) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(3) + 10);
			c.setDef(c.getDef() + r.nextInt(3) + 14);
			c.setMaxHp(c.getMaxHp() + r.nextInt(15) + 30);
			c.setLvl(c.getLvl() + 1);
		}
		System.out.println("Sai levelin!");
		c.printInfo();
		scanner.nextLine();
		c.setHp(c.getMaxHp());
	}

	// IVYSAUR lvlup
	public void lvlUp(PokemonContext c, Ivysaur sad) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(2) + 9);
			c.setDef(c.getDef() + r.nextInt(4) + 9);
			c.setMaxHp(c.getMaxHp() + r.nextInt(12) + 23);
			c.setLvl(c.getLvl() + 1);

		}

		if (c.getLvl() >= 36) {// kun pokemon saavuttaa levelin 36 tai yli se muuttaa muotoa
			sad.evolve(c, Venusaur.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai levelin!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}
}
