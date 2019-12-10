package main;

public class Valkokangas {
	
	private boolean alhaalla = false;
	
	public boolean ylos() {
		if(alhaalla) {
			alhaalla=false;
			return true;
		}else {
			return false;
		}	
	}

	public boolean alas() {
		if(!alhaalla) {
			alhaalla=true;
			return true;
		}else {
			return false;
		}	
	}

}
