package builder;

import java.util.ArrayList;

public class McDonaldsBuilder extends ABuilder {
	
	private ArrayList<McTayte> burger;
	
	@Override
	public Object getBurger() {
		return burger;
	}

	@Override
	public void createNewBurger() {
		burger = new ArrayList<McTayte>();
	}

	@Override
	public void buildSampyla() {
		burger.add(new McTayte("McSampyla",1));
	}

	@Override
	public void buildPihvi() {
		burger.add(new McTayte("McPihvi",2));		
	}

	@Override
	public void buildSalaatti() {
		burger.add(new McTayte("McSalaatti",1));
	}

	@Override
	public void buildKastike() {
		burger.add(new McTayte("McKastike", 0.5f));
	}

}
