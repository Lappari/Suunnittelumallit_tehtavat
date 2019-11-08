package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import factory.AdidasFactory;
import factory.BossFactory;
import factory.Factory;
import model.IVaate;

public class Main2 {

	public static void main(String[] args) {
		Class c = null;
		Factory tehdas = null;
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("factory.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
//luetaan toteuttava tehdas properties-tiedostosta 
			c = Class.forName(properties.getProperty("tehdas"));
			tehdas = (Factory) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	List<IVaate> vaatteet= new ArrayList<IVaate>();

	vaatteet=tehdas.pueVaatteet();

	System.out.println("Jasperin vaatteet opiskeluaikana:");

	mitaPaalla(vaatteet);
}


	private static void mitaPaalla(List<IVaate> vaatteet) {
		for(IVaate i:vaatteet) {
			System.out.println(i.toString());
		}
	}
}
