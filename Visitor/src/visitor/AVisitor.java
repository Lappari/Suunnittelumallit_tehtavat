package visitor;

import state.*;

public abstract class AVisitor {
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
