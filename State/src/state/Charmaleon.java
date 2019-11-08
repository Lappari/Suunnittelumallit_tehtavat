package state;

import java.util.Random;

public class Charmaleon extends State {
	private static State charmaleon = null;

	private Charmaleon() {
	}

	public static State getInstace() {
		if (charmaleon == null) {
			charmaleon = new Charmaleon();
		}
		return charmaleon;
	}

	//levelin kasvatus metodi
	public void lvlUp(PokemonContext c) {

		Random r = new Random();

		while (c.getExp() > (c.getLvl() * 150)) {
			c.setAtk(c.getAtk() + r.nextInt(7) + 3);
			c.setDef(c.getDef() + r.nextInt(5) + 2);
			c.setHp(c.getHp() + r.nextInt(18) + 14);
			c.setLvl(c.getLvl() + 1);
			//System.out.println(c.getName() + " sai levelin ja sen pisteetkasvoivat:\nATK:" + c.getAtk() + "\nDEF:"
				//	+ c.getDef() + "\nHP:" + c.getHp());
		}

		if (c.getLvl() >= 36)

		{// kun pokemon saavuttaa levelin 36 tai yli se muuttaa muotoa
			if (c.getName() == "Charmaleon")
				c.setName("Charizard"); // jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
			evolve(c, Charizard.getInstace());
		}
	}
	
	//toteutetaan staten vaihto
	private void evolve(PokemonContext c, State s) {
		System.out.println(c.getName()+" muuttaa muotoaan Charizardiksi!");
		c.setPokemonEvolution(s);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nWhen it swings its burning tail, it elevates the temperature to unbearably high levels.\n");
	}
}
