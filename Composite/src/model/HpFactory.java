package model;

public class HpFactory implements IFactory {

	@Override
	public ILaiteosa giveMuistipiiri() {
		ILaiteosa muistipiiri = new Laiteosa("HP-Muistopiiri",25f);
		return muistipiiri;
	}

	@Override
	public ILaiteosa giveEmolevy() {
		ILaiteosa emolevy = new Laiteosa("HP-Emolevy",250f);
		ILaiteosa emolevyKooste = new Koostekomponentti(emolevy);
		return emolevyKooste;
	}

	@Override
	public ILaiteosa giveProsessori() {
		ILaiteosa prosessori = new Laiteosa("HP-Prosessori",175.50f);
		return prosessori;
	}

	@Override
	public ILaiteosa giveVerkkokortti() {
		ILaiteosa verkkokortti = new Laiteosa("HP-Verkkokortti",50f);
		return verkkokortti;
	}

	@Override
	public ILaiteosa giveNaytonohjain() {
		ILaiteosa naytonohjain = new Laiteosa("HP-Näytönohjain",599.99f);
		return naytonohjain;
	}

	@Override
	public ILaiteosa giveKotelo() {
		ILaiteosa kotelo = new Laiteosa("HP-Kotelo",99f);
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
		ILaiteosa virtalahde = new Laiteosa("HP-Virtalahde",75f);
		return virtalahde;
	}

}
