package view;

import java.util.Scanner;

import model.DellFactory;
import model.HpFactory;
import model.IFactory;
import model.ILaiteosa;

public class Client {
	
	 public static void main(String[] args) {
		 
		//Luodaan kaikki komponentit sisältävä koostekomponentti
		 ILaiteosa kaikkiOsat;
		 
		 //täytetään osalista dell tehtaan osilla ja tuolostetaan osian hinta, sekä kokonaishinta
		 kaikkiOsat = giveOsalista(new DellFactory());
		 System.out.println("Osien kokonais hinta: " + kaikkiOsat.tulostaKokoonpano());
		 System.out.println("\n-----------------------------------\n");
		 
		 //vaihdetaan osalistan sisältö hp tehtaan osiin ja tulostetaan osien hinta, sekä kokonaishinta
		 kaikkiOsat = giveOsalista(new HpFactory());
		 System.out.println("Osien kokonais hinta: " + kaikkiOsat.tulostaKokoonpano());
		 
	 }
	 
	 private static ILaiteosa giveOsalista(IFactory newFactory) {
		 
		 //Luodaan osia tuottava tehdas
		 IFactory factory = newFactory;
		 
		 //Luodaan kaikki komponentit sisältävä koostekomponentti
		 ILaiteosa kaikkiOsat = factory.giveKoostekomponentti();
		 
		 //Luodaan emolevy koostekomponentti
		 ILaiteosa emolevy = factory.giveEmolevy();
		 
		 //Lisätään emolevyyn sen sisältämät osat
		 emolevy.addLaiteosa(factory.giveProsessori());
		 emolevy.addLaiteosa(factory.giveMuistipiiri());
		 
		 //Listään emolevy osakokonaisuuteen
		 kaikkiOsat.addLaiteosa(emolevy);
		 
		 //Luodaan kotelo koostekomponentti
		 ILaiteosa kotelo = factory.giveKotelo();
		
		 //Lisätään koteloon sen sisältämät osat
		 kotelo.addLaiteosa(factory.giveVirtalahde());
		 
		 //Lisätään kotelo osakokonaisuuteen
		 kaikkiOsat.addLaiteosa(kotelo);
		 
		 //Lisätään loput osat osakokonaisuuteen
		 kaikkiOsat.addLaiteosa(factory.giveNaytonohjain());
		 kaikkiOsat.addLaiteosa(factory.giveVerkkokortti());
		 
		 return kaikkiOsat;
	 }
	
}
