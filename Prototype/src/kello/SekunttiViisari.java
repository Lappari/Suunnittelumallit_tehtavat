package kello;

public class SekunttiViisari implements Cloneable {

	private int sekuntit;

	public SekunttiViisari() {
		sekuntit = 0;
	}

	public SekunttiViisari(int t) {
		sekuntit = t;
	}

	public int getSekunttit() {
		return sekuntit;
	}

	public void setSekunttit(int sekuntit) {
		this.sekuntit = sekuntit;
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
