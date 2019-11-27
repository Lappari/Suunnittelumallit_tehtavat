package kello;

public class MinuuttiViisari implements Cloneable {
	
	private int minuutit;
	
	public MinuuttiViisari() {
		minuutit = 0;
	}

	public MinuuttiViisari(int t) {
		minuutit = t;
	}
	
	
	public int getMinuutit() {
		return minuutit;
	}

	public void setMinuutit(int minuutit) {
		this.minuutit = minuutit;
	}
	
	public Object clone() {
		// matalakopio:
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
