package controller;

import adapter.Adapter;
import adapter.Pokemon;
import application.MainViewController;
import javafx.collections.ObservableList;
import state.Bulbasaur;
import state.Charmander;
import state.PokemonContext;
import visitor.AVisitor;
import visitor.PokemonBattle;

public class Controller {
	private Adapter adapter;
	private MainViewController mvc;
	private AVisitor visitor;
	private PokemonContext pokemonFire;
	private PokemonContext pokemonLeaf;
	
	public Controller(MainViewController mainViewController) {
		mvc = mainViewController;
		adapter = Adapter.getInstance();
		visitor = new PokemonBattle(this);
		pokemonFire = new PokemonContext(Charmander.getInstace(),this);
		pokemonLeaf = new PokemonContext(Bulbasaur.getInstace(),this);
	}
	
	public ObservableList<Pokemon> getPokemons(){
		return adapter.pokemonInfo(pokemonFire,pokemonLeaf);
	}
	
	public void battle() {
		visitor.pokemonBattle(pokemonFire, pokemonLeaf);
		adapter.update();
	}

	public void battlePika() {
		while (pokemonFire.getLvl() <= 36 && pokemonLeaf.getLvl() <= 36) {
			visitor.pokemonBattle(pokemonFire, pokemonLeaf);
			adapter.update();
		}
	}
	
	public void printConsole(String txt) {
		mvc.printConsole(txt);
	}

}
