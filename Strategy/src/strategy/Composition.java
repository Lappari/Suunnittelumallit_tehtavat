package strategy;

import java.util.List;

public class Composition {
	
	IStrategy strategy;
	
	public void selectStrategy(IStrategy strategy) {
		this.strategy=strategy;
	}
	
	public String ListConverter(List<String> lista) {
		String palautus = strategy.ListConverter(lista);
		return palautus;		
	}
}
