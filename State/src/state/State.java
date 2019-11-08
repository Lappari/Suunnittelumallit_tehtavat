package state;

public abstract class State {
	
	public void lvlUp(PokemonContext c) {}
	public void pokedexEntry() {}
	private void evolve(PokemonContext c, State s) {}
	
	public void addExp(PokemonContext c,int exp) { 
		c.setExp(c.getExp()+exp);
		c.levelUp();//tarkistetaan saatiinko uusitaso
		}
	
	public void getInfo(PokemonContext c) {
		System.out.println("Nimi:"+c.getName()+" LVL:"+c.getLvl()+" EXP:"+c.getExp()+"\nATK:"+c.getAtk()+"\nDEF:"+c.getDef()+"\nHP:"+c.getHp());
	}
	
}
