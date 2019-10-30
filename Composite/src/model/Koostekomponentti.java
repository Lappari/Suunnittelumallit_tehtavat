package model;

import java.util.ArrayList;
import java.util.List;

public class Koostekomponentti implements ILaiteosa{
	
	private List<ILaiteosa> laiteosaList = new ArrayList <ILaiteosa>();
	
	public Koostekomponentti() {}
	
	//Emolevyn ja kopan luontia varten
	public Koostekomponentti(ILaiteosa koostekomponentti) {	
		addLaiteosa(koostekomponentti);
	}
	
	@Override
	public float tulostaKokoonpano() {
		float kokonaisHinta = 0;
		for(ILaiteosa i: laiteosaList) {
			kokonaisHinta += i.tulostaKokoonpano();
		}
		return kokonaisHinta;
	}

	@Override
	public void addLaiteosa(ILaiteosa lisattavaLaiteosa) {
		laiteosaList.add(lisattavaLaiteosa);		
	}

}
