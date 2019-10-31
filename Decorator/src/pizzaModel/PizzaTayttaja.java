package pizzaModel;

public abstract class PizzaTayttaja implements IPizza{
	private final IPizza taytettavaPizza;
	
	public PizzaTayttaja(IPizza taytettavaPizza) {
		this.taytettavaPizza = taytettavaPizza;
	}
	
	@Override
	public float getHinta() {
		return taytettavaPizza.getHinta();
	}
	
	@Override
	public String getKuvaus() {
		return taytettavaPizza.getKuvaus();
	}
}
