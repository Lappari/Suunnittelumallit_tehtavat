package peli;

import java.util.Random;

public class Arvuuttaja {
	
	private int arpa;
	
	Random r = new Random();
	
	public synchronized Object liityPeliin() {
		this.arpa = r.nextInt(10)+1;
		return new Memento(this.arpa);		
	}
	
	public Boolean tarkistus(Object o, int arvaus) {
		Memento memento = (Memento) o;
		this.arpa = memento.arpa;

		return this.arpa == arvaus;
	}
	
	private class Memento{
		private int arpa;
		
		public Memento(int arpa) {
			//System.out.println("Salainen vastaus "+arpa);
			this.arpa = arpa;
		}
	}
}
