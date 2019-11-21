package main;

import builder.ABuilder;

public class Tilaus {
	
	private ABuilder burgerBuilder;
	
	public void setBurgerBuilder(ABuilder b) {
		this.burgerBuilder=b;
	}
	
	public Object getBurger() {
		return burgerBuilder.getBurger();
	}
	
	public void constructBurger() {
		burgerBuilder.createNewBurger();
		burgerBuilder.buildSampyla();
		burgerBuilder.buildPihvi();
		burgerBuilder.buildSalaatti();
		burgerBuilder.buildKastike();
	}
}
