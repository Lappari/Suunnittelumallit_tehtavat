package main;

public class SeinaPainike {
	
	ICommand cmd;
	
	public SeinaPainike(ICommand cmd) {
		this.cmd = cmd;
	}
	
	public void paina() {
		cmd.execute();
	}
}
