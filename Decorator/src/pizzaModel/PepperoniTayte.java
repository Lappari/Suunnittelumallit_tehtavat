package pizzaModel;

public class PepperoniTayte extends PizzaTayttaja{
	public PepperoniTayte(IPizza taytettavaPizza) {
		super(taytettavaPizza);
	}
	
	@Override
	public float getHinta() {
		return super.getHinta()+2;
	}
	
	@Override
	public String getKuvaus() {
		return super.getKuvaus() + ", pepperoni";
	}
}
