package pizzaModel;

public class AnanasTayte extends PizzaTayttaja{
	public AnanasTayte(IPizza taytettavaPizza) {
		super(taytettavaPizza);
	}
	
	@Override
	public float getHinta() {
		return super.getHinta()+0.5f;
	}
	
	@Override
	public String getKuvaus() {
		return super.getKuvaus() + ", ananas";
	}
}
