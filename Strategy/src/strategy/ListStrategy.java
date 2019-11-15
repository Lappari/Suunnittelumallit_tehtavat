package strategy;

import java.util.List;

public class ListStrategy implements IStrategy{

	@Override
	public String ListConverter(List<String> lista) {
		String palautus ="";
		int laskin = 0;
		for(String a:lista) {
			laskin++;
			palautus += a;
			if(laskin%2==0) {
				palautus +="\n";
			}
		}
		return palautus;
	}

}
