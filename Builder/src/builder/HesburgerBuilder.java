package builder;

public class HesburgerBuilder extends ABuilder{
	
	private String burger;
	
	@Override
	public String getBurger() {
		return burger;
	}

	@Override
	public void createNewBurger() {
		this.burger = new String("HeseBurger: ");
	}
	
	@Override
	public void buildSampyla() {
		burger+=("HeseSämpylä, ");		
	}

	@Override
	public void buildPihvi() {
		burger+=("HesePihvi, ");
	}

	@Override
	public void buildSalaatti() {
		burger+=("Jotain vihreetä, ");
	}

	@Override
	public void buildKastike() {
		burger+=("Special kastike");		
	}	
}
