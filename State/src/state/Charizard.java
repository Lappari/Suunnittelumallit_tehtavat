package state;

import java.util.Random;

public class Charizard extends State {
	private static State charizard = null;

	private Charizard() {
	}

	public static State getInstace() {
		if (charizard == null) {
			charizard = new Charizard();
		}
		return charizard;
	}

	public void lvlUp(PokemonContext c) {

		Random r = new Random();

		while (c.getExp() > (c.getLvl() * 155)) {
			c.setAtk(c.getAtk() + r.nextInt(9) + 5);
			c.setDef(c.getDef() + r.nextInt(6) + 4);
			c.setHp(c.getHp() + r.nextInt(20) + 16);
			c.setLvl(c.getLvl() + 1);
			//System.out.println(c.getName() + " sai levelin ja sen pisteetkasvoivat:\nATK:" + c.getAtk() + "\nDEF:"
				//	+ c.getDef() + "\nHP:" + c.getHp());
		}
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nSpits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally.\n");
	}

}
