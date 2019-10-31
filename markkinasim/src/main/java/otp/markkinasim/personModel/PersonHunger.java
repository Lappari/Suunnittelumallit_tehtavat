package otp.markkinasim.personModel;

import otp.markkinasim.App;

public class PersonHunger {
	
	private App app = App.getInstance();
	private PersonBuyProduct pbp = PersonBuyProduct.getInstance();
	private static PersonHunger ph = null;
	
	private PersonHunger() {}
	
	public static PersonHunger getInstance() {
		if(ph==null) {
			ph = new PersonHunger();
		}
		return ph;
	}
	
	public String raiseHunger() {
		String logMsg = "Person Hunger\n";
		//käydään kaikki personit läpi jos töissä nälkä kasvaa 20 jos työtön nälkä kasvaa 10
		for(IPerson i: app.getPersonList()) {
			
			//jos kuollut seuraava
			if(i.getStatus()=="kuollut") continue;
			
			if(i.getEmployer()!="työtön" && i.getStatus()!="kuollut") {
				i.setHunger(i.getHunger()+20);
			}else if(i.getEmployer()=="työtön" && i.getStatus()!="kuollut") {
				i.setHunger(i.getHunger()+10);
			}
			
			//katsotaan personien nälkä tilanne jos nälkä >= 50 yritetään ostaa ruokaa
			if(i.getHunger()>=50) {
				logMsg += pbp.findProduct("Food",i);
			}
			
			//person kuolee jos nälkä > 100
			if(i.getHunger()>100) {
				i.setStatus("kuollut");
			}
		}
		return logMsg;
	}
}
