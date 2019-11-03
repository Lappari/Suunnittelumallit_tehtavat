package main;

import java.util.ArrayList;
import java.util.List;

import factory.AdidasFactory;
import factory.BossFactory;
import factory.Factory;
import model.IVaate;

public class Main {
	
	public static void main(String[] args) {
		
	Factory vaatekomero = new AdidasFactory();
	List<IVaate> vaatteet= new ArrayList<IVaate>();
	
	vaatteet = vaatekomero.pueVaatteet();
	
	System.out.println("Jasperin vaatteet opiskeluaikana:");
	mitaPaalla(vaatteet);
	
	vaatekomero = new BossFactory();
	
	vaatteet = vaatekomero.pueVaatteet();
	System.out.println("\nJasperin vaatteet insinöörinä:");
	mitaPaalla(vaatteet);
}
	
	private static void mitaPaalla(List<IVaate> vaatteet) {
		for(IVaate i:vaatteet) {
			System.out.println(i.toString());
		}
	}
}
