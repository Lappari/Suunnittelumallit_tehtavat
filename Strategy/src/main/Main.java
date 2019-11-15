package main;

import java.util.ArrayList;
import java.util.List;

import strategy.Composition;
import strategy.IteratorStrategy;
import strategy.ListStrategy;
import strategy.TableStrategy;

public class Main {
	public static void main(String[] args) {
		
		Composition tulostaja = new Composition();
		String tulostus;
		
		List<String> sanat = new ArrayList<String>();
		sanat.add("kissa ");
		sanat.add("kapusi ");
		sanat.add("tikkaita ");
		sanat.add("taivaaseen ");
		sanat.add("tikkaat ");
		sanat.add("katkes ");
		sanat.add("kissan ");
		sanat.add("maha");
		
		tulostaja.selectStrategy(new IteratorStrategy());
		tulostus = tulostaja.ListConverter(sanat);
		
		System.out.println("Tulostetaan lista niin että jokaisen alkion jälkeen on rivinvaihto iteraattoria käyttäen.\n"+tulostus);
		
		tulostaja.selectStrategy(new ListStrategy());
		tulostus = tulostaja.ListConverter(sanat);
		
		System.out.println("Tulostetaan lista niin että joka toisen alkion jäleen on rivinvaihto for each metodia käyttäen.\n"+tulostus);
		
		tulostaja.selectStrategy(new TableStrategy());
		tulostus = tulostaja.ListConverter(sanat);
		
		System.out.println("Tulostetaan lista niin että joka kolmannen alkion jälkeen on rivinvaihto String listaa käyttäen.\n"+tulostus);
		
	}
}
