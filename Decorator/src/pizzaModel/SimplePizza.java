package pizzaModel;

public class SimplePizza implements IPizza{
		
	@Override
	public float getHinta() {
		return 2f;
	}

	@Override
	public String getKuvaus() {
		return "Täytteet pizza pohja";
	}
	
	
}
