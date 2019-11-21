package adapter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import state.PokemonContext;

public class Adapter {

	private static Adapter adapter;

	private ObservableList<Pokemon> pokemons;
	
	private Adapter() {
		adapter = this;
	}

	public static Adapter getInstance() {
		if (adapter == null) {
			adapter = new Adapter();
		}
		return adapter;
	}

	public ObservableList<Pokemon> pokemonInfo(PokemonContext pokemonFire, PokemonContext pokemonLeaf) {
		pokemons = FXCollections.observableArrayList();	
		pokemons.add(new Pokemon(pokemonFire));
		pokemons.add(new Pokemon(pokemonLeaf));
		return pokemons;
	}
	
	public void update() {
		for(Pokemon p:pokemons) {
			p.update();
		}
	}

}
