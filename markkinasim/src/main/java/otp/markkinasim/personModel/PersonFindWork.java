package otp.markkinasim.personModel;

import otp.markkinasim.App;
import otp.markkinasim.partyModel.IParty;

public class PersonFindWork {
	private App app = App.getInstance();
	private static PersonFindWork pfw = null;
	
	private PersonFindWork() {}
	
	public static PersonFindWork getInstance() {
		if(pfw == null) {
			pfw = new PersonFindWork();
		}
		return pfw;
	}
	
	public String personGetWork() {
		
		String logMsg = "Person Find Work";
		for(IPerson i:app.getPersonList()) {
			IParty tempParty = null;
			float tempSalary=0;
			
			//tarkistetaan ettei ole kuolleita töissä jos on vapautetaan työpaikka
			if(i.getEmployer()!="työtön" && i.getStatus()=="kuollut") {
				
				//etsitään työnantaja taho
				for(IParty p:app.getPartyList()) {
					if(p.getPartyName()==i.getEmployer()) tempParty=p;
				}
				
				//tehdään kuolleesta työtön ja vapautetaan työpaikka
				i.setEmployer("työtön");
				tempParty.setEmployeesNeeded(tempParty.getEmployeesNeeded()+1);
				tempParty.setEmployees(tempParty.getEmployees()-1);
				
				//kerrotaan käyttäjälle ikävästä tapahtumasta
				logMsg = i.getId()+":RIP person työpaikka vapautettu.\n";
				continue;
			}
			
			//jos personilla töitä seuraavaan tai jos person on kuollut
			if(i.getEmployer()!="työtön" || i.getStatus()=="kuollut")continue;
			
			//etsitään vapaita työpaikkoja tahoilta ja valitaan se jolla on paras palkka
			for(IParty p:app.getPartyList()) {
				if(p.getEmployeesNeeded()>0) {
					if(tempSalary<p.getDefaultSalary()) {
						tempSalary = p.getDefaultSalary();
						tempParty = p;
					}
				}
			}
			
			//tarkistetaan löytyikö töitä
			if(tempParty!=null) {
				//asetetaan personille työpaikka ja päivitetään tahon työntekijä tilanne
				i.setEmployer(tempParty.getPartyName());
				tempParty.setEmployeesNeeded(tempParty.getEmployeesNeeded()-1);
				tempParty.setEmployees(tempParty.getEmployees()+1);
			}

		}
		
		return logMsg;
	}
}
