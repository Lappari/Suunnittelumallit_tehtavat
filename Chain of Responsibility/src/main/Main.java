package main;

import handlers.Handler;
import handlers.LahiEsimies;
import handlers.Toimitusjohtaja;
import handlers.YksikonPaallikko;

public class Main {

	public static void main(String[] args) {
		
		Handler toimitusjohtaja = new Toimitusjohtaja(null);
		Handler yksikonPaallikko = new YksikonPaallikko(toimitusjohtaja);
		Handler lahiEsimies = new LahiEsimies(yksikonPaallikko);
		
		Boolean onnistuikoKasittely;
		
		float oldPay,newPay;
		
		//kokeillaan alle 2% palkankorotusta
		oldPay = 1000;
		newPay = 1150;
		
		onnistuikoKasittely = lahiEsimies.handleRase(oldPay, newPay);
		
		if(onnistuikoKasittely) {
			System.out.println("Lähiesimies hyväksyi korotuksen.\n");
		}
		
		//kokeillaan alle 5% palkankorotusta
		oldPay = 1000;
		newPay = 1450;
		
		onnistuikoKasittely = lahiEsimies.handleRase(oldPay, newPay);
		
		if(onnistuikoKasittely) {
			System.out.println("Yksikönpäällikkö eväsi korotuksen.\n");
		}
		
		//kokeillaan yli 5% palkankorotusta
		oldPay = 1000;
		newPay = 1800;
		
		onnistuikoKasittely = lahiEsimies.handleRase(oldPay, newPay);
		
		if(onnistuikoKasittely) {
			System.out.println("Toimitusjohtaja hyväksyi korotyksen.");
		}
		
	}

}
