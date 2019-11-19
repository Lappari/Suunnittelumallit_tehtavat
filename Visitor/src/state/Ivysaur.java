package state;

import visitor.AVisitor;

public class Ivysaur extends State {
	private static State ivysaur = null;

	private Ivysaur() {
	}

	public static State getInstace() {
		if (ivysaur == null) {
			ivysaur = new Ivysaur();
		}
		return ivysaur;
	}

	//levelin kasvatus metodi
	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	//toteutetaan staten vaihto
	public void evolve(PokemonContext c, State s) {
		System.out.println(c.getName()+" muuttaa muotoaan ja on nyt "+s.getClass().getSimpleName()+"!");
		
		if (c.getName() == "Ivysaur") {
			c.setName("Venusaur"); // jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
		}			
		c.setPokemonEvolution(s);
		c.setLvlExpMultiplayer(155);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nWhen the bulb on its back grows large, it appears to lose the ability to stand on its hind legs. \n");
	}
}
