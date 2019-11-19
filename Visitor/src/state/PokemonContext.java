package state;

import visitor.AVisitor;
import visitor.LvlUpvisitor;

public class PokemonContext {
	
	private State pokemonEvolution;
	private AVisitor lvlUp;
	//pokemonin statsit
	private int atk=0,def=0,hp=0,maxHp=0,exp=0,lvl=0,lvlExpMultiplayer=145;
	private String name = null;
	
	//asetetaan aloitus stateksi ensimmäinen muoto
	public PokemonContext(State pokemon) {
		lvlUp = new LvlUpvisitor();
		pokemonEvolution = pokemon;
		inits();
	}
	
	private void inits() {
		exp=1;
		levelUp();		
	}
	
	//kutsutaan kun pokemoni saa kokemuspisteitä
	public void addExp(int exp) {
		this.exp+=exp;
	}
	//kutsutaan kun tarkistetaan saako pokemon levelin ja toteuttaa levelin saannin
	public void levelUp() {
		pokemonEvolution.lvlUp(lvlUp,this);
	}
	
	//pokemon toiminto
	public void pokedexEntry() {
		pokemonEvolution.pokedexEntry();
	}
	
	//tulostetaan pokemonin tiedot
	public void printInfo() {
		pokemonEvolution.getInfo(this);
	}
	
	//vaidetaan statea kun pokemon muuttaa muotoa
	protected void setPokemonEvolution(State pokemonEvolution) {
		this.pokemonEvolution = pokemonEvolution;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLvlExpMultiplayer() {
		return lvlExpMultiplayer;
	}

	public void setLvlExpMultiplayer(int lvlExpMultiplayer) {
		this.lvlExpMultiplayer = lvlExpMultiplayer;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	

}
