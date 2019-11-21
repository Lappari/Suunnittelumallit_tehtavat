package main;

import java.util.ArrayList;
import builder.ABuilder;
import builder.HesburgerBuilder;
import builder.McDonaldsBuilder;
import builder.McTayte;

public class Main {

	public static void main(String[] args) {
		
		Tilaus tilaus = new Tilaus();
		ABuilder heseBuilder = new HesburgerBuilder();
		ABuilder mcBuilder = new McDonaldsBuilder();
		
		//Hese burget luonti ja tulostus
		tilaus.setBurgerBuilder(heseBuilder);
		tilaus.constructBurger();
	
		Object burger = tilaus.getBurger();
		
		printBurger(burger);
		
		
		//McBurger luonti ja tulostus
		tilaus.setBurgerBuilder(mcBuilder);
		tilaus.constructBurger();
	
		burger = tilaus.getBurger();
		
		printBurger(burger);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void printBurger(Object burger) {
		
		if(burger instanceof String) {
			System.out.println(burger);
		}else if(burger instanceof ArrayList) {
			System.out.print("McDonalds burger: ");
			((ArrayList<McTayte>) burger).forEach(n -> System.out.print(n.getNimi()+", "));
		}
	}
}
