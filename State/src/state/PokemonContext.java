package state;

public class PokemonContext {
	
	private State pokemonEvolution;
	
	//pokemonin statsit
	private int atk=0,def=0,hp=0,exp=0,lvl=0;
	private String name = null;
	
	//asetetaan aloitus stateksi ensimmäinen muoto
	public PokemonContext() {
		pokemonEvolution = Charmander.getInstace();
		exp=1;
		levelUp();
	}
	
	//kutsutaan kun pokemoni saa kokemuspisteitä
	public void addExp(int exp) {
		pokemonEvolution.addExp(this, exp);
	}
	//kutsutaan kun tarkistetaan saako pokemon levelin ja toteuttaa levelin saannin
	public void levelUp() {
		pokemonEvolution.lvlUp(this);
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

}
