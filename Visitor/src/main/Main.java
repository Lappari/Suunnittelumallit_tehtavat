package main;

import java.util.Scanner;
import state.Bulbasaur;
import state.Charmander;
import state.PokemonContext;
import visitor.AVisitor;
import visitor.PokemonBattle;

public class Main {

	public static void main(String[] args) {
		int valinta = 0;
		String input = null;
		AVisitor visitor = new PokemonBattle();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		PokemonContext pokemonFire = new PokemonContext(Charmander.getInstace());
		PokemonContext pokemonLeaf = new PokemonContext(Bulbasaur.getInstace());

		do {

			System.out.println("Main Menu\n1. Tulosta pokemonin " + pokemonFire.getName()
					+ " tiedot.\n2. Tulosta pokemonin " + pokemonLeaf.getName()
					+ " tiedot.\n3. Laita pokemonit ottelemaan.\n4. Laita pokemoinit ottelemaan kunnes toinen saa viimeisen muodon.\n5. Lopeta ohjelma.");
			try {
				input = scanner.nextLine();
				valinta = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Anna komento numerona.");
				valinta = 0;
				continue;
			}

			switch (valinta) {
			case 1:
				pokemonFire.printInfo();
				scanner.nextLine();
				break;
			case 2:
				pokemonLeaf.printInfo();
				scanner.nextLine();
				break;
			case 3:
				visitor.pokemonBattle(pokemonFire, pokemonLeaf);
				break;
			case 4:
				while(pokemonFire.getLvl()<=36&&pokemonLeaf.getLvl()<=36) {
					visitor.pokemonBattle(pokemonFire, pokemonLeaf);
				}
				break;
			case 5:				
				break;
			}

		} while (valinta != 5);
	}

}
