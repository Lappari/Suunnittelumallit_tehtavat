package strategy;

import java.util.List;

public class TableStrategy implements IStrategy{

	@Override
	public String ListConverter(List<String> lista) {
		String palautus ="";
		int koko = lista.size();
		String[] taulukko = new String[koko];
		//täytetään string lista arraylistin sisällöllä
		for(int i = 0;i<koko;i++) {
			taulukko[i]=lista.get(i);
		}
		
		for(int i=0;i<taulukko.length;i++) {
			palautus+=taulukko[i];
			if((i+1)%3==0) {
				palautus+="\n";
			}
		}
		return palautus;
	}

}
