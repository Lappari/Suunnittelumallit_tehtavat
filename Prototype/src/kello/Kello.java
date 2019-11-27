package kello;

public class Kello implements Cloneable{
	
	private TuntiViisari tv;
	private MinuuttiViisari mv;
	private SekunttiViisari sv;
	
	public Kello() {
		tv = new TuntiViisari();
		mv = new MinuuttiViisari();
		sv = new SekunttiViisari();
	}
	
	public void tulostaAika() {
		System.out.println(tv.getTunnit()+":"+mv.getMinuutit()+":"+sv.getSekunttit());
	}
	
	public void setTunnit(int t) {
		tv.setTunnit(t);
	}
	
	public void setMinuutit(int m) {
		mv.setMinuutit(m);
	}
	
	public void setSekunnit(int s) {
		sv.setSekunttit(s);
	}
	
	public int getTunnit() {
		return tv.getTunnit();
	}
	
	public int getMinuutit() {
		return mv.getMinuutit();
	}
	
	public int getSekunnit() {
		return sv.getSekunttit();
	}
	
	public Kello clone() {
		//syväkopio
		Kello k = null;
		
		try {
			k=(Kello)super.clone();
			k.tv = (TuntiViisari)tv.clone();
			k.mv = (MinuuttiViisari)mv.clone();
			k.sv = (SekunttiViisari)sv.clone();
		}catch(CloneNotSupportedException e) {}
		
		return k;
	}
}
