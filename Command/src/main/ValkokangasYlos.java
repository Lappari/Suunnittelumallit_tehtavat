package main;

public class ValkokangasYlos implements ICommand{
	
	private Valkokangas valkokangas;
	
	public ValkokangasYlos(Valkokangas valkokangas) {
		this.valkokangas = valkokangas;
	}
	
	@Override
	public void execute() {
		if(valkokangas.ylos()) {
			System.out.println("Valkokangas nostetaan ylös.");
		}else {
			System.out.println("Valkokangas on jo ylhäällä.");
		}
	}
}
