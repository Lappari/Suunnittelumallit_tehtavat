package model;

public class Laiteosa implements ILaiteosa{
	
	private String nimi;
	private Float hinta;
	
	public Laiteosa(String nimi, Float hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
	}

	public void addLaiteosa(ILaiteosa lisattavaLaiteosa) {
		throw new RuntimeException
		("Ei voida lisätä osaa yksittäiseen osaan.");
	}

	public float tulostaKokoonpano() {
		System.out.println(nimi + " hinta on "+ hinta);
		return hinta;
	}

}
