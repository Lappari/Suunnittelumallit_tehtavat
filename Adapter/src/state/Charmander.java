package state;

import visitor.AVisitor;

public class Charmander extends State {
	private static State charmander = null;

	private Charmander() {
	}

	public static State getInstace() {
		if (charmander == null) {
			charmander = new Charmander();
		}
		return charmander;
	}

	public void lvlUp(AVisitor lvlUp,PokemonContext c) {
		lvlUp.lvlUp(c, this);
	}
	
	public void evolve(PokemonContext c,State s) {
		if(c.getName()=="Charmander") c.setName("Charmaleon"); //jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
		
		c.setPokemonEvolution(s);
		c.setLvlExpMultiplayer(180);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nObviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.\n");
	}
}
