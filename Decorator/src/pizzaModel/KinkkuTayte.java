package pizzaModel;

public class KinkkuTayte extends PizzaTayttaja{

	public KinkkuTayte(IPizza taytettavaPizza) {
		super(taytettavaPizza);
	}
	
	@Override
	public float getHinta() {
		return super.getHinta() + 1.50f;
	}
	
	@Override
	public String getKuvaus() {
		return super.getKuvaus() + ", kinkku";
	}
}
