package state;

import visitor.AVisitor;

public class Bulbasaur extends State {
	private static State bulbasaur = null;

	private Bulbasaur() {
	}

	public static State getInstace() {
		if (bulbasaur == null) {
			bulbasaur = new Bulbasaur();
		}
		return bulbasaur;
	}

	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	public void evolve(PokemonContext c,State s) {
		System.out.println(c.getName()+" muuttaa muotoaan ja on nyt "+s.getClass().getSimpleName()+"!");
		
		if(c.getName()=="Bulbasaur") c.setName("Ivysaur"); //jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
		
		c.setPokemonEvolution(s);
		c.setLvlExpMultiplayer(180);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nA strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon. \n");
	}
}
