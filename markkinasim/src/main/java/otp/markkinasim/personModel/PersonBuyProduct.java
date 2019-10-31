package otp.markkinasim.personModel;

import java.util.ArrayList;
import java.util.List;

import otp.markkinasim.App;
import otp.markkinasim.model.IProduct;
import otp.markkinasim.partyModel.IParty;

public class PersonBuyProduct {
	private App app = App.getInstance();
	private static PersonBuyProduct pbp;
	
	private PersonBuyProduct() {}
	
	public static PersonBuyProduct getInstance() {
		//kutsu tätä funktiota luodaksesi PersonBuyProduct olion!
		if (pbp == null) {
			pbp = new PersonBuyProduct();
		}
		return pbp;
	}
	
	public String findProduct(String category, IPerson buyer) {
		String logMsg = "";
		float tempPrice = 0;
		IParty tempParty = null;
		List<Integer> productIds = new ArrayList<Integer>();
		
		//haetaan mitkä tuotteet kuuluvat annettuu kategoriaan selaamalla tuotelista läpi. Sopivien tuotteiden id tallennetaan productIds listaan.
		for(IProduct i:app.getProductList()) {
			if(i.getProductCategory()==category) {
				productIds.add(i.getId());
			}
		}
		
		//etsitään mikä taho myy halutun kategorian tuotetta halvimmalla
		for(IParty i:app.getPartyList()) {
			//katsotaan onko taholla myynnissä oikeaa tuotetta
			for(int n:productIds) {
				//katsotaan onko tahon myymän tuotteen id oikea ja samalla katsotaan onko taholla kokonaisia tuotteita varastossa
				if(i.getProductToProduce() == n && i.getProductAmount()>=1) {
					//alustetaan temparvoiksi ensimmäinen sopiva taho
					if(tempParty==null) {
						tempPrice = i.getProductPrice();
						tempParty = i;
					
					//jos temp arvot on jo alustettu verrataan onko nyt kierroksessa oleva party halvempi myyjä	
					}else if(i.getProductPrice()<tempPrice) {
						tempPrice = i.getProductPrice();
						tempParty = i;
					}
				}
			}
		}
		
		//jos tuote löytyi yritetään ostaa tuote
		if(tempParty!=null) {
			//katsotaan onko personille rahaa
			if(buyer.getMoney()>=tempPrice) {
				//suoritetaan transactioni
				buyer.setMoney(buyer.getMoney()-tempPrice);
				tempParty.setMoney(tempParty.getMoney()+tempPrice);
				tempParty.setProductAmount(tempParty.getProductAmount()-1);
				
				//TODO PERSON CONSUME nyt person ostaa vain ruokaa ja syösen heti oli hunger mittari laskee tuotteen laatutason verran
				buyer.setHunger(buyer.getHunger()-tempParty.getProductQuality());
				
				//kerrotaan käyttäjälle ostotapahtumasta
				logMsg = buyer.getId()+": person osti "+category+" taholta "+tempParty.getPartyName()+"\n";
				
			}else { //jos personilla ei ole tarpeeksi rahaa kerrotaan se käyttäjälle
				logMsg = buyer.getId()+": person rahat: "+buyer.getMoney()+" Halusi ostaa "+category+" taholta "+tempParty.getPartyName()+" tuotten hinta: "+tempParty.getProductPrice()+"\n";
			}
		}else {
			//jos yhtään myyjää halutulle tuotteelle ei löytynyt kerrotaan se käyttäjälle
			logMsg =buyer.getId()+":person halusi "+category+" mutta tällä tuotekategorialla ei löytynyt tuotteita.\n";
		}
		return logMsg;
	}
}
