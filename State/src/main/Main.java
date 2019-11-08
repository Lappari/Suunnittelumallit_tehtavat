package main;

import state.PokemonContext;

public class Main {

	public static void main(String[] args) {
		
		PokemonContext pokemon = new PokemonContext();
		
		pokemon.printInfo();
		pokemon.pokedexEntry();
		
		pokemon.addExp(2300);
		
		pokemon.printInfo();
		pokemon.pokedexEntry();
		
		pokemon.addExp(3000);
		
		pokemon.printInfo();
		pokemon.pokedexEntry();
	}

}
