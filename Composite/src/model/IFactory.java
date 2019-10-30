package model;

public interface IFactory {
	
	public ILaiteosa giveKoostekomponentti();
	public ILaiteosa giveMuistipiiri();
	public ILaiteosa giveEmolevy();
	public ILaiteosa giveProsessori();
	public ILaiteosa giveVerkkokortti();
	public ILaiteosa giveNaytonohjain();
	public ILaiteosa giveKotelo();
	public ILaiteosa giveVirtalahde();
	
}
