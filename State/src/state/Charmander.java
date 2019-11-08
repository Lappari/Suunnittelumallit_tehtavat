package state;

import java.util.Random;

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

	public void lvlUp(PokemonContext c) {

		Random r = new Random();

		if (c.getName() == null) {// tarkistetaan onko pokemon nimetty jos ei annetaan pokemonille sen muodon nimi
			c.setName("Charmander");
		}

		while (c.getExp() > (c.getLvl() * 145)) {
			if(c.getLvl()<1) {//alustetaan pokemonille aloitus pisteet
				c.setAtk(r.nextInt(8)+7);
				c.setDef(r.nextInt(7)+5);
				c.setHp(r.nextInt(10)+30);
				c.setLvl(1);
			}else {
				c.setAtk(c.getAtk()+r.nextInt(6)+1);
				c.setDef(c.getDef()+r.nextInt(4)+1);
				c.setHp(c.getHp()+r.nextInt(15)+11);
				c.setLvl(c.getLvl()+1);
			//	System.out.println(c.getName()+" sai levelin ja sen pisteetkasvoivat:\nATK:"+c.getAtk()+"\nDEF:"+c.getDef()+"\nHP:"+c.getHp());
			}
		}
		
		if(c.getLvl()>=16) {//kun pokemon saavuttaa levelin 16 tai yli se muuttaa muotoa
			if(c.getName()=="Charmander") c.setName("Charmaleon"); //jos default nimi käytössä vaihdetaan nimi seuraavan muodon nimeen
			evolve(c,Charmaleon.getInstace());
		}
	}
	
	private void evolve(PokemonContext c,State s) {
		System.out.println(c.getName()+" muuttaa muotoaan Charmaleoniksi!");
		c.setPokemonEvolution(s);
	}
	
	public void pokedexEntry() {
		//tulostetaan generation 1 pokedex info pokemonista
		System.out.println("Pokedex Entry:\nObviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.\n");
	}
}
