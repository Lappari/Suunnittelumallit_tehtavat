package state;

import visitor.AVisitor;

public abstract class State {

	public void pokedexEntry() {
	}

	public void evolve(PokemonContext c, State s) {
	}

	public abstract void lvlUp(AVisitor lvlUp, PokemonContext c);

}
