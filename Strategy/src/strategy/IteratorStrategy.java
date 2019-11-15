package strategy;

import java.util.List;
import java.util.ListIterator;

public class IteratorStrategy implements IStrategy{

	@Override
	public String ListConverter(List<String> lista) {
		ListIterator<String> iterator = lista.listIterator();
		String palautus ="";
		
		while(iterator.hasNext()) {
			palautus += iterator.next()+"\n";
		}
		
		return palautus;
	}

}
