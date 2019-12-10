package main;

public class ValkokangasAlas implements ICommand{
	
	private Valkokangas valkokangas;
	
	public ValkokangasAlas(Valkokangas valkokangas) {
		this.valkokangas = valkokangas;
	}
	
	@Override
	public void execute() {
		if(valkokangas.alas()) {
			System.out.println("Valkokangas lasketaan alas.");
		}else {
			System.out.println("Valkokangas on jo alhaalla.");
		}
	}

}
