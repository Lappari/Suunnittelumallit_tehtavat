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
				c.setAtk(r.nextInt(8) + 7);
				c.setDef(r.nextInt(7) + 5);
				c.setMaxHp(r.nextInt(10) + 30);
				c.setLvl(1);
			} else {
				c.setAtk(c.getAtk() + r.nextInt(6) + 1);
				c.setDef(c.getDef() + r.nextInt(4) + 1);
				c.setMaxHp(c.getMaxHp() + r.nextInt(15) + 11);
				c.setLvl(c.getLvl() + 1);
			}
		}

		if (c.getLvl() >= 16) {// kun pokemon saavuttaa levelin 16 tai yli se muuttaa muotoa
			asd.evolve(c, Charmaleon.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai level!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// CHARMALEON lvlup
	public void lvlUp(PokemonContext c, Charmaleon asd) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(7) + 3);
			c.setDef(c.getDef() + r.nextInt(5) + 2);
			c.setMaxHp(c.getMaxHp() + r.nextInt(18) + 14);
			c.setLvl(c.getLvl() + 1);

		}

		if (c.getLvl() >= 36) {// kun pokemon saavuttaa levelin 36 tai yli se muuttaa muotoa
			asd.evolve(c, Charizard.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai level!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// CHARIZARD lvlup
	public void charizardLvlUp(PokemonContext c, Charizard asd) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(9) + 5);
			c.setDef(c.getDef() + r.nextInt(6) + 4);
			c.setMaxHp(c.getMaxHp() + r.nextInt(20) + 16);
			c.setLvl(c.getLvl() + 1);
		}

		System.out.println("Sai level!");
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
				c.setAtk(r.nextInt(8) + 5);
				c.setDef(r.nextInt(7) + 7);
				c.setMaxHp(r.nextInt(8) + 32);
				c.setLvl(1);
			} else {
				c.setAtk(c.getAtk() + r.nextInt(2) + 1);
				c.setDef(c.getDef() + r.nextInt(6) + 1);
				c.setMaxHp(c.getMaxHp() + r.nextInt(15) + 13);
				c.setLvl(c.getLvl() + 1);
			}
		}

		if (c.getLvl() >= 16) {// kun pokemon saavuttaa levelin 16 tai yli se muuttaa muotoa
			asd.evolve(c, Ivysaur.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai level!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}

	// VENUSAUR lvlup
	public void lvlUp(PokemonContext c, Venusaur sad) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(5) + 4);
			c.setDef(c.getDef() + r.nextInt(7) + 5);
			c.setMaxHp(c.getMaxHp() + r.nextInt(20) + 20);
			c.setLvl(c.getLvl() + 1);
		}
		System.out.println("Sai level!");
		c.printInfo();
		scanner.nextLine();
		c.setHp(c.getMaxHp());
	}

	// IVYSAUR lvlup
	public void lvlUp(PokemonContext c, Ivysaur sad) {
		while (c.getExp() > (c.getLvl() * c.getLvlExpMultiplayer())) {
			c.setAtk(c.getAtk() + r.nextInt(5) + 2);
			c.setDef(c.getDef() + r.nextInt(7) + 3);
			c.setMaxHp(c.getMaxHp() + r.nextInt(18) + 14);
			c.setLvl(c.getLvl() + 1);

		}

		if (c.getLvl() >= 36) {// kun pokemon saavuttaa levelin 36 tai yli se muuttaa muotoa
			sad.evolve(c, Venusaur.getInstace());
			c.printInfo();
			scanner.nextLine();
		} else if (c.getLvl() != 1) {
			System.out.println("Sai level!");
			c.printInfo();
			scanner.nextLine();
		}
		c.setHp(c.getMaxHp());
	}
}
