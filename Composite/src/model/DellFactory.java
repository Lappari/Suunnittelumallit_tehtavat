package model;

public class DellFactory implements IFactory {

	@Override
	public ILaiteosa giveMuistipiiri() {
		ILaiteosa muistipiiri = new Laiteosa("Dell-Muistopiiri",50f);
		return muistipiiri;
	}

	@Override
	public ILaiteosa giveEmolevy() {
		ILaiteosa emolevy = new Laiteosa("Dell-Emolevy",212f);
		ILaiteosa emolevyKooste = new Koostekomponentti(emolevy);
		return emolevyKooste;
	}

	@Override
	public ILaiteosa giveProsessori() {
		ILaiteosa prosessori = new Laiteosa("Dell-Prosessori",199.50f);
		return prosessori;
	}

	@Override
	public ILaiteosa giveVerkkokortti() {
		ILaiteosa verkkokortti = new Laiteosa("Dell-Verkkokortti",10f);
		return verkkokortti;
	}

	@Override
	public ILaiteosa giveNaytonohjain() {
		ILaiteosa naytonohjain = new Laiteosa("Dell-Näytönohjain",499f);
		return naytonohjain;
	}

	@Override
	public ILaiteosa giveKotelo() {
		ILaiteosa kotelo = new Laiteosa("Dell-Kotelo",75f);
		ILaiteosa koteloKooste = new Koostekomponentti(kotelo);
		return koteloKooste;
	}
	
	@Override
	public ILaiteosa giveKoostekomponentti() {
		ILaiteosa koostekomponentti = new Koostekomponentti();
		return koostekomponentti;
	}
	
	@Override
	public ILaiteosa giveVirtalahde() {
		ILaiteosa virtalahde = new Laiteosa("Dell-Virtalahde",35f);
		return virtalahde;
	}

}
