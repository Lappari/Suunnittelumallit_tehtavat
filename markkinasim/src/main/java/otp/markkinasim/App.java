package otp.markkinasim;

import java.security.InvalidParameterException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import otp.markkinasim.model.Product;
import otp.markkinasim.partyModel.Party;
import otp.markkinasim.personModel.Person;
import otp.markkinasim.view.View;


public class App 
{
	private static App app;
	private static ObservableList<Person> personList;
	private static ObservableList<Party> partyList;
	private static ObservableList<Product> productList;
	public App() {app = this;}
    public static void main( String[] args )
    {
    	 	
    	personList = FXCollections.observableArrayList();
    	partyList = FXCollections.observableArrayList();
    	productList = FXCollections.observableArrayList();
		
    	//TULEVAISUUDEN RATKAISU
    	//Secretary secretary = new Secretary();
    	//partyList = secretary.getAllPartysFromDB();
    	//productList = secretary.getAllProductsFromDB();
    	//personList = secretary.getAllPersonsFromDB();
    	for(int i=0;i<30;i++) {
    		personList.add(new Person());
    	}
		
		productList.add(new Product("Cow"));
		productList.add(new Product("Beef patty", 0));	//INDEX????
		productList.get(0).setProductCategory("Rawmaterial");

		partyList.add(new Party("Jimbo's Beef", 1000.0f, productList.get(1)));
		partyList.add(new Party("Cowman", 100, productList.get(0)));
		partyList.add(new Party("Pirkka Cows", 100, productList.get(0)));
		
		try {
			partyList.get(0).setProductRate(2f);
			partyList.get(0).setProductRawmaterialAmount(10);;
			partyList.get(1).setProductAmount(100);
			partyList.get(1).setProductPrice(10);
			partyList.get(2).setProductPrice(5);
			partyList.get(1).setProductPrice(10);
			partyList.get(2).setProductPrice(5);
			partyList.get(2).setEmployeesNeeded(1);
		} catch (InvalidParameterException e) {
			System.out.println(e.getMessage());
		}
		
    	 Application.launch(View.class, args);
    }
    
	public static App getInstance() {
		//kutsu tätä funktiota luodaksesi App olion!
		if (app == null) {
			app = new App();
		}
		return app;
	}
	
	public ObservableList<Party> getPartyList(){
		return partyList;
	}
	
	public ObservableList<Product> getProductList(){
		return productList;
	}
	
	public ObservableList<Person> getPersonList(){
		return personList;
	}
}
