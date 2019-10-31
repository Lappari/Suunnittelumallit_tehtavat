package otp.markkinasim.view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import otp.markkinasim.model.Core;
import otp.markkinasim.model.ICore;
import otp.markkinasim.model.IProduct;
import otp.markkinasim.partyModel.Party;
import otp.markkinasim.personModel.Person;

public class SimulationController{

	private IView view;
	private ICore core;
	
	@FXML
	private TextArea simulationLog;
	@FXML
	private TableView<Party> partyTable;
	@FXML
	private TableColumn<Party, String> partyName;
	@FXML
	private TableColumn<Party, String> partyProduct;
	@FXML
	private TableColumn<Party, Number> partyProductAmount;
	@FXML
	private TableColumn<Party, String> partyRawmaterial;
	@FXML
	private TableColumn<Party, Number> partyRawmaterialAmount;
	@FXML
	private TableColumn<Party, Number> partyMoney;
	
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, Number> personCount;
	@FXML
	private TableColumn<Person, String> personWork;
	@FXML
	private TableColumn<Person, Number> personMoney;
	@FXML
	private TableColumn<Person, String> personStatus;
	@FXML
	private TableColumn<Person, Number> personHunger;
	
	public SimulationController(View view) {
		this.view = view;
		core = Core.getInstance();
	
	}
	
	@FXML
	private void initialize() {
		 // Party taulukko alustus
		partyName.setCellValueFactory(
                cellData -> cellData.getValue().partyNameProperty());	
		partyProduct.setCellValueFactory(new Callback<CellDataFeatures<Party, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Party, String> p) {
		    	 for(IProduct i:view.getAllProductData()) {
		    		 if(p.getValue().getProductToProduce()==i.getId()) {
		    			 return i.productNameProperty();
		    		 }
		    	 }
		    	 return null;
		     }
		  });
		partyProductAmount.setCellValueFactory(
				cellData -> cellData.getValue().productAmountProperty());
		
		partyRawmaterial.setCellValueFactory(new Callback<CellDataFeatures<Party, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Party, String> p) {
		         // p.getValue() returns the Party instance for a particular TableView row
		    	 if(p.getValue().getRawmaterialNeeded()>=0) {
		    		 for(IProduct i:view.getAllProductData()) {
		    			 if(p.getValue().getRawmaterialNeeded()==i.getId()) {
		    				 return i.productNameProperty();
		    			 }
		    		 }
		    	 }return null;
		     }
		  });
		partyRawmaterialAmount.setCellValueFactory(
				cellData -> cellData.getValue().productRawmaterialAmountProperty());
		partyMoney.setCellValueFactory(
                cellData -> cellData.getValue().moneyProperty());
		partyTable.setItems(view.getPartyData());
		
		personCount.setCellValueFactory(new Callback<CellDataFeatures<Person, Number>, ObservableValue<Number>>() {
		     public ObservableValue<Number> call(CellDataFeatures<Person, Number> p) {
		    	 IntegerProperty fill = new SimpleIntegerProperty(p.getValue().getId());	
		    	 return fill;
		     }
		  });
		personWork.setCellValueFactory(
                cellData -> cellData.getValue().employerProperty());	
		personMoney.setCellValueFactory(
                cellData -> cellData.getValue().moneyProperty());
		personStatus.setCellValueFactory(
                cellData -> cellData.getValue().statusProperty());
		personHunger.setCellValueFactory(
                cellData -> cellData.getValue().hungerProperty());
		personTable.setItems(view.getPersonData());
	}
	
	@FXML
	private void nextRound() {	
		core.start();
		partyTable.refresh();
		personTable.refresh();
	}
	@FXML
	private void backToMenu() {
		view.setScene(0);
	}
	
	public void printText(String msg) {
		simulationLog.appendText(msg);
	}
}
