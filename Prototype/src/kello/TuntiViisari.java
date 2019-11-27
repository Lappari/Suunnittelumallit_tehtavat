package kello;

public class TuntiViisari implements Cloneable {

	private int tunnit;

	public TuntiViisari() {
		tunnit = 0;
	}

	public TuntiViisari(int t) {
		tunnit = t;
	}
	
	
	public int getTunnit() {
		return tunnit;
	}

	public void setTunnit(int tunnit) {
		this.tunnit = tunnit;
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
