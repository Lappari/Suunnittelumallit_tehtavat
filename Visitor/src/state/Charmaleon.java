package state;

import visitor.AVisitor;

public class Charmaleon extends State {
	private static State charmaleon = null;

	private Charmaleon() {
	}

	public static State getInstace() {
		if (charmaleon == null) {
			charmaleon = new Charmaleon();
		}
		return charmaleon;
	}

	
	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	//toteutetaan staten vaihto
	public void evolve(PokemonContext c, State s) {
		System.out.println(c.getName()+" muuttaa muotoaan ja on nyt "+s.getClass().getSimpleName()+"!");
		
		if (c.getName() == "Charmaleon") {
			c.setName("Charizard"); // jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
		}			
		c.setPokemonEvolution(s);
		c.setLvlExpMultiplayer(400);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nWhen it swings its burning tail, it elevates the temperature to unbearably high levels.\n");
	}
}
