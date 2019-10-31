package otp.markkinasim.partyModel;

import otp.markkinasim.App;
import otp.markkinasim.model.IProduct;

public class PartyBuyRawmaterial {
	private App app = App.getInstance();
	private static PartyBuyRawmaterial pbr = null;
	
	private PartyBuyRawmaterial() {}
	
	public static PartyBuyRawmaterial getInstance() {
		if(pbr==null) {
			pbr= new PartyBuyRawmaterial();
		}
		return pbr;
	}
	
	public String partyBuy() {

		boolean tradeComplete = false;
		String logMsg = "";
		float rawmaterialNeededAmount;
		IProduct tempRawmaterial = null;
		IProduct tempProduct = null;
		int employees = 5; // TODO
		IParty sellerParty; // tallennetaan parhaan hinnan omaavan myyjän viite.

		for (IParty i : app.getPartyList()) {
			// katsotaan tarvitseeko taho raaka-ainetta hakemalla tarvittavan raaka-aineen
			// id taholta jos id on pienempi kuin 0 niin taho on raaka-aine tuottaja ja
			// siirrytään seuraavaan.
			if (i.getRawmaterialNeeded() < 0)
				continue;

			for (IProduct p : app.getProductList()) {
				// Haetaan tahon tuotteen tiedot
				if (i.getProductToProduce() == p.getId()) {
					tempProduct = p;
				}
				// Haetaan tahon tarvitseman raaka-aineen tiedot
				if (i.getRawmaterialNeeded() == p.getId()) {
					tempRawmaterial = p;
				}
			}

			// katsotaan onko taholla tarpeeksi raaka-aineita seuraavan kierroksen tuotantoa
			// varten.
			// lasketaan tuote tiedoista montako raaka-ainetta per tuote * tuotantonopeus *
			// työntekijöiden määrä.
			if (i.getProductRawmaterialAmount() >= tempProduct.getRawmaterialNeeded() * i.getProductRate()
					* employees) {
				logMsg += i.getPartyName() + " taholla on tarpeeksi raaka-aineita. \n";
				continue; // taholla tarpeeksi raaka-aineita ei osteta lisää
			} else {
				logMsg += i.getPartyName() + " taholla ei ole tarpeeksi raaka-aineita. \n";
				// lasketaan paljonko taho tarvitsee raaka-ainetta yhdelle kierokselle ja
				// vähennetään nykyisen varaston määrä
				rawmaterialNeededAmount = (tempProduct.getRawmaterialNeeded() * i.getProductRate() * employees)
						- i.getProductRawmaterialAmount();
			}

			do {
				// verrataan eri raaka-aine tuottajia ja valitaan se joka tarjoaa parhaan hinnan
				// ja jolla on varastoa
				sellerParty = findSeller(i);

				// tarkistetaan onko ostajalla varaa yhteenkään tuotteeseen.
				if (sellerParty.getProductPrice() <= i.getMoney()) {
					// katsotaan onko myyjällä tarpeeksi tuotetta jos on yritetään ostaa
					if (sellerParty.getProductAmount() >= rawmaterialNeededAmount) {

						// katsotaan onko ostajalla tarpeeksi rahaa. Myyjän yksittäisen tuotteen
						// hinta*ostajan tarvitsema määrä.
						if (i.getMoney() >= sellerParty.getProductPrice() * rawmaterialNeededAmount) {

							// suoretetaan kaupankäynti
							completeTransaction(i, sellerParty, rawmaterialNeededAmount);
							tradeComplete = true;
							logMsg += i.getPartyName() + " taho osti " + sellerParty.getPartyName() + " taholta "
									+ rawmaterialNeededAmount + ":" + tempRawmaterial.getProductName() + "\n";
							
							// Jos ostajalla ei ole tarpeeksi rahaa ostaa tarvittua määrää ostetaan niin
							// paljon kun voidaan
						} else {

							// alustetaan rawmaterialNeededAmountin arvoksi se kuinka moneen raaka-aineeseen
							// ostajalla on varaa. ostajan rahat / raaka-aineen hinta
							rawmaterialNeededAmount = i.getMoney() / sellerParty.getProductPrice();

							// jaetaan tulos vielä yhdellä ja vähennetään jakojäännös, koska myydään vain
							// kokonaisia raaka-aineita
							rawmaterialNeededAmount -= rawmaterialNeededAmount % 1;

							// suoretetaan kaupankäynti
							completeTransaction(i, sellerParty, rawmaterialNeededAmount);
							tradeComplete = true;
							logMsg += i.getPartyName() + " taho osti " + sellerParty.getPartyName() + " taholta "
									+ rawmaterialNeededAmount + ":" + tempRawmaterial.getProductName() + "\n";
						}

						// jos raaka-aine tuottajalle ei ole tarvittua määrää raaka-aineita mutta
						// varasto ei ole 0
					} else if (sellerParty.getProductAmount() > 0) {
						
						// katsotaan onko ostajalla varaa ostaa kaikki tuotteet myyjältä
						if (i.getMoney() >= sellerParty.getProductPrice() * sellerParty.getProductAmount()) {
							
							// vähennetään ostettavat raaka-aineet tarvituista raaka-aineista
							rawmaterialNeededAmount -= sellerParty.getProductAmount();
							logMsg += i.getPartyName() + " taho osti " + sellerParty.getPartyName() + " taholta "
									+ sellerParty.getProductAmount() + ":" + tempRawmaterial.getProductName() + " taho tarvitsee vielä "+ rawmaterialNeededAmount +" raaka-ainetta \n";
							// suoritetaan kauppa rawmaterialNeededAmountin sijasta lähetetään myyjän
							// varaston koko joka on pienempi kuin tarvittu raaka-aine määrä
							completeTransaction(i, sellerParty, sellerParty.getProductAmount());
							
						}else {
							// alustetaan rawmaterialNeededAmountin arvoksi se kuinka moneen raaka-aineeseen
							// ostajalla on varaa. ostajan rahat / raaka-aineen hinta
							rawmaterialNeededAmount = i.getMoney() / sellerParty.getProductPrice();

							// jaetaan tulos vielä yhdellä ja vähennetään jakojäännös, koska myydään vain
							// kokonaisia raaka-aineita
							rawmaterialNeededAmount -= rawmaterialNeededAmount % 1;

							// suoretetaan kaupankäynti
							completeTransaction(i, sellerParty, rawmaterialNeededAmount);
							
							tradeComplete = true;
							
							logMsg += i.getPartyName() + " taho osti " + sellerParty.getPartyName() + " taholta "
									+ rawmaterialNeededAmount + ":" + tempRawmaterial.getProductName() + "\n";
						}
					}
				} else {
					logMsg += i.getPartyName() + " taholla ei ole varaa raaka-aineisiin. " + sellerParty.getPartyName()
							+ " tuotteen hinta on: " + sellerParty.getProductPrice() + "\n";
					tradeComplete = true;
				}
			} while (rawmaterialNeededAmount != 0 && !tradeComplete);
		}
		return logMsg;
	}

	private IParty findSeller(IParty buyer) {
		float tempPrice = 0;
		IParty seller = null;
		// verrataan eri raaka-aine tuottajia ja valitaan se joka tarjoaa parhaan hinnan
		for (IParty p : app.getPartyList()) {
			if (p.getProductToProduce() == buyer.getRawmaterialNeeded()) {
				if (tempPrice == 0 && p.getProductAmount() > 0) {
					tempPrice = p.getProductPrice();
					seller = p;
					continue;
				} // alustetaan ensimmäisen raaka-aine myyjän hinta aloitus hinnaksi jonka varasto
					// ei ole tyhjä.
				if (tempPrice > p.getProductPrice() && p.getProductAmount() > 0) {
					tempPrice = p.getProductPrice();
					seller = p;
				} // verrataan aikasemman myyjän hintaa seuraavaan vaihdetaan myyjää jos hinta
					// halvempi ja varasto ei nolla
			}
		}
		return seller; // palautetaan parhaan hinnan omaava myyjä
	}

	private void completeTransaction(IParty buyer, IParty seller, float rawmaterialNeededAmount) {

		// vähennetään ostajalta ostohinnan verran rahaa
		buyer.setMoney(buyer.getMoney() - (seller.getProductPrice() * rawmaterialNeededAmount));
		// lisätään ostajalle ostetut raaka-aineet
		buyer.setProductRawmaterialAmount(buyer.getProductRawmaterialAmount() + rawmaterialNeededAmount);
		// lisätään myyjälle rahaa
		seller.setMoney(seller.getMoney() + seller.getProductPrice() * rawmaterialNeededAmount);
		// vähännetään myyjän varastosta myydyt tuotteet
		seller.setProductAmount(seller.getProductAmount() - rawmaterialNeededAmount);

	}
}
