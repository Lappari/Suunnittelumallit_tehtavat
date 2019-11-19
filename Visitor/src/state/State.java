package state;

import visitor.AVisitor;

public abstract class State {

	public void pokedexEntry() {
	}

	@SuppressWarnings("unused")

	public void evolve(PokemonContext c, State s) {
	}

	public void getInfo(PokemonContext c) {
		System.out.println("Nimi:" + c.getName() + " LVL:" + c.getLvl() + " EXP:" + c.getExp()+"/"+(c.getLvl()*c.getLvlExpMultiplayer()) + "\nATK:" + c.getAtk()
				+ "\nDEF:" + c.getDef() + "\nHP:" + c.getHp());
	}

	public abstract void lvlUp(AVisitor lvlUp, PokemonContext c);

}
