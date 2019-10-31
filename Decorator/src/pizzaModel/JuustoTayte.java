package pizzaModel;

public class JuustoTayte extends PizzaTayttaja{

	public JuustoTayte(IPizza taytettavaPizza) {
		super(taytettavaPizza);
	}
	
	@Override
	public float getHinta() {
		return super.getHinta()+1;
	}
	
	@Override
	public String getKuvaus() {
		return super.getKuvaus() + ", juusto";
	}
}
