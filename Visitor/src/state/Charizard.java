package state;

import visitor.AVisitor;

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

	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nSpits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally.\n");
	}

}
