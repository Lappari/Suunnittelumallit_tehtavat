package model;

public class Vaate implements IVaate {
	private String nimi;
	private String merkki;
	
	public Vaate(String nimi, String merkki) {
		this.nimi = nimi;
		this.merkki = merkki;		
	}
	
	public String toString() {
		return nimi + " merkkiä " + merkki;
	}
}
