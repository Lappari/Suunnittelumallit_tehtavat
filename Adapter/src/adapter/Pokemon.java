package adapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import state.PokemonContext;

public class Pokemon {
	
	private StringProperty pokemonName,exp,hp;
	private IntegerProperty atk,def,lvl;
	private PokemonContext pokemon;
	
	public Pokemon(PokemonContext pokemon) {
		this.pokemon=pokemon;
		this.pokemonName = new SimpleStringProperty(pokemon.getName());
		this.atk = new SimpleIntegerProperty(pokemon.getAtk());
		this.def = new SimpleIntegerProperty(pokemon.getDef());
		this.hp = new SimpleStringProperty(hpCounter());
		this.exp = new SimpleStringProperty(expCounter());
		this.lvl = new SimpleIntegerProperty(pokemon.getLvl());
	}
	
	public void update() {
		setPokemonName(pokemon.getName());
		setAtk(pokemon.getAtk());
		setDef(pokemon.getDef());
		setHp(hpCounter());
		setExp(expCounter());
		setLvl(pokemon.getLvl());
	}
	
	public String expCounter() {
		String exp="";		
		exp+=pokemon.getExp()+"/"+(pokemon.getLvl()*pokemon.getLvlExpMultiplayer());
		return exp;
	}
	
	public String hpCounter() {
		String hp = pokemon.getHp()+"/"+pokemon.getMaxHp();
		return hp;
	}
	
	//GETTERIT JA SETTERI ALLA
	public StringProperty pokemonNameProperty() {
		return this.pokemonName;
	}
	

	public String getPokemonName() {
		return this.pokemonNameProperty().get();
	}
	

	public void setPokemonName(final String pokemonName) {
		this.pokemonNameProperty().set(pokemonName);
	}
	

	public IntegerProperty atkProperty() {
		return this.atk;
	}
	

	public int getAtk() {
		return this.atkProperty().get();
	}
	

	public void setAtk(final int atk) {
		this.atkProperty().set(atk);
	}
	

	public IntegerProperty defProperty() {
		return this.def;
	}
	

	public int getDef() {
		return this.defProperty().get();
	}
	

	public void setDef(final int def) {
		this.defProperty().set(def);
	}
	

	public StringProperty hpProperty() {
		return this.hp;
	}
	

	public String getHp() {
		return this.hpProperty().get();
	}
	

	public void setHp(final String hp) {
		this.hpProperty().set(hp);
	}
	

	public StringProperty expProperty() {
		return this.exp;
	}
	

	public String getExp() {
		return this.expProperty().get();
	}
	

	public void setExp(final String string) {
		this.expProperty().set(string);
	}

	public IntegerProperty lvlProperty() {
		return this.lvl;
	}
	

	public int getLvl() {
		return this.lvlProperty().get();
	}
	

	public void setLvl(final int lvl) {
		this.lvlProperty().set(lvl);
	}
	
	
	
}
