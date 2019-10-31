package otp.markkinasim.partyModel;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import otp.markkinasim.model.IProduct;


public class Party implements IParty {
	
	//party elikkä kaupankäyntiä harrastava taho

		public static int nextId;
		private int id;
		
		private StringProperty partyName;
		private FloatProperty money;
		private IntegerProperty employeesNeeded;
		private IntegerProperty employees;	//TODO TODO
		private IntegerProperty productToProduce;		//TUOTETTAVA TUOTE. TÄLLÄ HETKELLÄ PARTYT TUOTTAVAT VAIN YHTÄ TUOTETTA
		private IntegerProperty rawmaterialNeeded; // JOS tuote tarvitsee raaka-ainetta.
		private FloatProperty defaultSalary;	//daily salaary
		private FloatProperty productAmount;
		private FloatProperty productRawmaterialAmount;
		private FloatProperty productRate;
		private FloatProperty productPrice;
		private FloatProperty productQuality;

		public Party(String partyName, float money, IProduct productToProduce) {
			id = nextId;
			nextId++;
			this.employeesNeeded = new SimpleIntegerProperty(5);
			this.employees = new SimpleIntegerProperty(0);
			this.partyName = new SimpleStringProperty(partyName);
			this.money = new SimpleFloatProperty(money);
			this.productToProduce = new SimpleIntegerProperty(productToProduce.getId());
			this.defaultSalary = new SimpleFloatProperty(5f);
			this.productAmount = new SimpleFloatProperty(0);
			this.productRawmaterialAmount = new SimpleFloatProperty(0);
			this.rawmaterialNeeded = new SimpleIntegerProperty(productToProduce.getProductNeededId());
			this.productRate = new SimpleFloatProperty(1f);
			this.productPrice = new SimpleFloatProperty(2f);
			this.productQuality = new SimpleFloatProperty(20f);
		}
		public Party() {
			id = nextId;
			nextId++;
			this.employeesNeeded = new SimpleIntegerProperty(5);
			this.employees = new SimpleIntegerProperty(0);
			this.partyName = new SimpleStringProperty();
			this.money = new SimpleFloatProperty(1000);
			this.productToProduce =  new SimpleIntegerProperty();
			this.rawmaterialNeeded = new SimpleIntegerProperty(-1);
			this.defaultSalary = new SimpleFloatProperty(5f);
			this.productAmount = new SimpleFloatProperty(0);
			this.productRawmaterialAmount = new SimpleFloatProperty(0);
			this.productRate = new SimpleFloatProperty(1);
			this.productPrice = new SimpleFloatProperty(2);
			this.productQuality = new SimpleFloatProperty(20);
		}
		
		@Override
		public int getId() {
			return id;
		}
		@Override
		public final StringProperty partyNameProperty() {
			return this.partyName;
		}
		
		@Override
		public final String getPartyName() {
			return this.partyNameProperty().get();
		}
		
		@Override
		public final void setPartyName(final String partyName) {
			this.partyNameProperty().set(partyName);
		}
		
		@Override
		public final FloatProperty moneyProperty() {
			return this.money;
		}
		
		@Override
		public final float getMoney() {
			return this.moneyProperty().get();
		}
		
		@Override
		public final void setMoney(final float money) {
			this.moneyProperty().set(money);
		}
		
		@Override
		public final IntegerProperty productToProduceProperty() {
			return this.productToProduce;
		}
		
		@Override
		public final int getProductToProduce() {
			return this.productToProduceProperty().get();
		}
		
		@Override
		public final void setProductToProduce(final int productToProduce) {
			this.productToProduceProperty().set(productToProduce);
		}
		@Override
		public final IntegerProperty rawmaterialNeededProperty() {
			return this.rawmaterialNeeded;
		}
		
		@Override
		public final int getRawmaterialNeeded() {
			return this.rawmaterialNeededProperty().get();
		}
		
		@Override
		public final void setRawmaterialNeeded(final int rawmaterialNeeded) {
			this.rawmaterialNeededProperty().set(rawmaterialNeeded);
		}
		
		@Override
		public final FloatProperty productAmountProperty() {
			return this.productAmount;
		}
		
		@Override
		public final float getProductAmount() {
			return this.productAmountProperty().get();
		}
		
		@Override
		public final void setProductAmount(final float productAmount) {
			this.productAmountProperty().set(productAmount);
		}
		
		@Override
		public final FloatProperty productRawmaterialAmountProperty() {
			return this.productRawmaterialAmount;
		}
		
		@Override
		public final float getProductRawmaterialAmount() {
			return this.productRawmaterialAmountProperty().get();
		}
		
		@Override
		public final void setProductRawmaterialAmount(final float productRawmaterialAmount) {
			this.productRawmaterialAmountProperty().set(productRawmaterialAmount);
		}
		
		@Override
		public void addMoney(float amount) {
			money.add(amount);
		}
		@Override
		public final FloatProperty productRateProperty() {
			return this.productRate;
		}
		
		@Override
		public final float getProductRate() {
			return this.productRateProperty().get();
		}
		
		@Override
		public final void setProductRate(final float productRate) {
			this.productRateProperty().set(productRate);
		}
		@Override
		public final FloatProperty productPriceProperty() {
			return this.productPrice;
		}
		
		@Override
		public final float getProductPrice() {
			return this.productPriceProperty().get();
		}
		
		@Override
		public final void setProductPrice(final float productPrice) {
			this.productPriceProperty().set(productPrice);
		}
		@Override
		public final IntegerProperty employeesNeededProperty() {
			return this.employeesNeeded;
		}
		
		@Override
		public final int getEmployeesNeeded() {
			return this.employeesNeededProperty().get();
		}
		
		@Override
		public final void setEmployeesNeeded(final int employeesNeeded) {
			this.employeesNeededProperty().set(employeesNeeded);
		}
		
		@Override
		public final IntegerProperty employeesProperty() {
			return this.employees;
		}
		
		@Override
		public final int getEmployees() {
			return this.employeesProperty().get();
		}
		
		@Override
		public final void setEmployees(final int employees) {
			this.employeesProperty().set(employees);
		}
		
		@Override
		public final FloatProperty defaultSalaryProperty() {
			return this.defaultSalary;
		}
		
		@Override
		public final float getDefaultSalary() {
			return this.defaultSalaryProperty().get();
		}
		
		@Override
		public final void setDefaultSalary(final float defaultSalary) {
			this.defaultSalaryProperty().set(defaultSalary);
		}
		@Override
		public final FloatProperty productQualityProperty() {
			return this.productQuality;
		}
		
		@Override
		public final float getProductQuality() {
			return this.productQualityProperty().get();
		}
		
		@Override
		public final void setProductQuality(final float productQuality) {
			this.productQualityProperty().set(productQuality);
		}
		
		
		
		
		
}
