package main;

import pizzaModel.AnanasTayte;
import pizzaModel.IPizza;
import pizzaModel.JalopenoTayte;
import pizzaModel.JuustoTayte;
import pizzaModel.KinkkuTayte;
import pizzaModel.PepperoniTayte;
import pizzaModel.SimplePizza;

public class Main {
	public static void main(String[] args) {
		
		IPizza kinkkuPizza = new JuustoTayte(new KinkkuTayte(new SimplePizza()));
		IPizza kolmeTaytetta = new AnanasTayte(new PepperoniTayte(new JalopenoTayte(new SimplePizza())));
		IPizza kaikkiTaytteet = new AnanasTayte(new KinkkuTayte(new JuustoTayte(new JalopenoTayte(new PepperoniTayte(new SimplePizza())))));
		
		System.out.println("Hinta: "+kinkkuPizza.getHinta()+"€ "+kinkkuPizza.getKuvaus());
		System.out.println("Hinta: "+kolmeTaytetta.getHinta()+"€ "+kolmeTaytetta.getKuvaus());
		System.out.println("Hinta: "+kaikkiTaytteet.getHinta()+"€ "+kaikkiTaytteet.getKuvaus());
	}
}
