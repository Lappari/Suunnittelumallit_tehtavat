package pizzaModel;

public class JalopenoTayte extends PizzaTayttaja{
	public JalopenoTayte(IPizza taytettavaPizza) {
		super(taytettavaPizza);
	}
	
	@Override
	public float getHinta() {
		return super.getHinta()+1.5f;
	}
	
	@Override
	public String getKuvaus() {
		return super.getKuvaus() + ", jalopeno";
	}
}
