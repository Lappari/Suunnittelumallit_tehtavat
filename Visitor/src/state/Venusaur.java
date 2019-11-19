package state;

import visitor.AVisitor;

public class Venusaur extends State {
	private static State venusaur = null;

	private Venusaur() {
	}

	public static State getInstace() {
		if (venusaur == null) {
			venusaur = new Venusaur();
		}
		return venusaur;
	}

	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nThe plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.\n");
	}

}
