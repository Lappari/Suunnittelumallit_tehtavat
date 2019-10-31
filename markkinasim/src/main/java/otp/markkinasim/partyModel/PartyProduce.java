package otp.markkinasim.partyModel;

import otp.markkinasim.App;
import otp.markkinasim.model.IProduct;

public class PartyProduce {
	private App app;
	private static PartyProduce pp = null;
	
	private PartyProduce() {}
	
	public static PartyProduce getInstance() {
		if(pp==null) {
			pp = new PartyProduce();
		}
		return pp;
	}
	
	public String produce() {
		app = App.getInstance();
		String logMsg = "";
		float rawmaterialAmount;
		float productionRate;
		float rawmaterialNeeded = 0;
		int employees = 5; //TODO tahon työntekijöiden määrä
		float producedProducts = 0;
		
		
		//Toteuttaa tahojen tuotteiden ja raaka-aineiden tuotannon.
		for(IParty i : app.getPartyList()) {
			employees = i.getEmployees();		
			//erotellaan tuotteiden ja raaka-aineiden tuottajat, jos tahon rawmaterialNeeded on 0 tai suurempi taho tuottaa tuotteita
			if(i.getRawmaterialNeeded()>=0) {
				//jos taholla on 0 raaka-ainetta siirrytään seuraavaan tahoon
				if(i.getProductRawmaterialAmount()==0) {
					logMsg += i.getPartyName() + " taholla on 0 raaka-ainetta \n";
					continue;
				}

				rawmaterialAmount = i.getProductRawmaterialAmount(); //heataan tahon rakka-aine varastan määrä
				productionRate = i.getProductRate();				//heataan tahon tuotanto nopeus

				//heataan oikei tuote tahoon tallennetun tuotettavan tuotteen id:n avulla app antaa kaikki tuotteet sisältävän listan
				for(IProduct p:app.getProductList()) {				
					if(i.getProductToProduce()==p.getId()) {
						rawmaterialNeeded = p.getRawmaterialNeeded();	//oikea tuote löytyy otetaan talteen montako raaka-ainetta yhden tuotteen tuottaminen tarvitsee					
					}
				}

				productionRate = productionRate * employees; //lasketaan tahon kokonaistuotantonopeus kertomalla työntekijöiden määrä ja tahon tuotantonopeus keskenään
				
				//silmukka kiertää niin kauankuin taholla on raaka-aineita tai kun taho on tuottanu tuotantonopeutensa mukaisen määrän tuotteita
				while(rawmaterialAmount>0 && producedProducts < productionRate) { 

					//katsotaan onko taholla raaka-aineita tuotantonopeuden salliman määrän tuottamiseen tuotteita.
					if(rawmaterialAmount >= (productionRate*rawmaterialNeeded)){
						rawmaterialAmount -= productionRate*rawmaterialNeeded;
						producedProducts = productionRate;

						//katsotaan onko taholla raaka-aineita kokonaisen tuotteen tuottamiseen ja onko taho tuottanut jo tuotantonopeutensa mukaisen määrän kokonaisia tuotteita	
					}else if(rawmaterialAmount>=rawmaterialNeeded) {
						rawmaterialAmount -= rawmaterialNeeded; //vähennetään yhden tuotteen tarvitsemat raaka-aineet varastosta
						producedProducts++;						//lisätään valmis tuote
						//tuotetaan keskeneräisiä tuotteita jos mahdollista
					}else if(rawmaterialAmount>0 && producedProducts < productionRate) {
						producedProducts += rawmaterialAmount/rawmaterialNeeded;
						rawmaterialAmount=0;
					}
					
				}
				i.setProductRawmaterialAmount(rawmaterialAmount);
				i.setProductAmount(i.getProductAmount()+producedProducts);
				logMsg += i.getPartyName()+" taho tuotti "+ producedProducts +" tuotetta ja taholle jäi "+rawmaterialAmount+" raaka-ainetta. \n";
			}else if(i.getRawmaterialNeeded()<0) {
				i.setProductAmount(i.getProductAmount()+i.getProductRate()*employees);
				logMsg += i.getPartyName()+" taho tuotti "+(i.getProductRate()*employees)+" raaka-ainetta. \n";
			}
			
		}
		return logMsg;
	}
}
