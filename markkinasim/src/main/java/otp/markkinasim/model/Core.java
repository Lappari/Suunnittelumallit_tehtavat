package otp.markkinasim.model;

import otp.markkinasim.partyModel.PartyBuyRawmaterial;
import otp.markkinasim.partyModel.PartyProduce;
import otp.markkinasim.personModel.PersonFindWork;
import otp.markkinasim.personModel.PersonHunger;
import otp.markkinasim.view.IView;
import otp.markkinasim.view.View;

public class Core implements ICore {
	//SINGLETON PATTERN//////////////////
	//mahdollistaa vain yhden Core-olion olemassaolon!
	private static ICore core = null;
	private IView view;
	private PartyProduce partyProduce;
	private PartyBuyRawmaterial partyBuyRawmaterial;
	private PersonFindWork personFindWork;
	private PersonHunger personHunger;
	
	private Core() {}
	public static ICore getInstance() {
		//kutsu tätä funktiota luodaksesi Core olion!
		if (core == null) {
			core = new Core();
			core.init();
		}
		return core;
	}
	
	private int day = 0;
	
	@Override
	public void init() {
		
		view = View.getInstance();
		partyProduce= PartyProduce.getInstance();
		partyBuyRawmaterial = PartyBuyRawmaterial.getInstance();
		personFindWork = PersonFindWork.getInstance();
		personHunger = PersonHunger.getInstance();
	}
	
	@Override
	public void start() {
		//Scanner scan = new Scanner(System.in);
		//while(true) {
			day++;
			System.out.println("Day: " + day);
			view.writeSimulationLog("Day: " + day +"\n");
			view.writeSimulationLog(partyProduce.produce());
			view.writeSimulationLog(partyBuyRawmaterial.partyBuy());
			view.writeSimulationLog(personFindWork.personGetWork());
			view.writeSimulationLog(personHunger.raiseHunger());
			
	}
	}
//}
