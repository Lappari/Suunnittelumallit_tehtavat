package visitor;

import controller.Controller;
import state.*;

public abstract class AVisitor {
	
	protected Controller controller;
	
	public AVisitor(Controller c) {
		controller=c;
	}
	public void pokemonBattle(PokemonContext fire, PokemonContext leaf) {
	}

	public void lvlUp(PokemonContext pokemon, Charmander c) {
	}

	public void lvlUp(PokemonContext pokemon, Charmaleon c) {
	}

	public void lvlUp(PokemonContext pokemon, Charizard c) {
	}

	public void lvlUp(PokemonContext pokemon, Bulbasaur b) {
	}

	public void lvlUp(PokemonContext pokemon, Venusaur b) {
	}

	public void lvlUp(PokemonContext pokemon, Ivysaur b) {
	}
}
