package otp.markkinasim.partyModel;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface IParty {

	int getId();

	StringProperty partyNameProperty();

	String getPartyName();

	void setPartyName(String partyName);

	FloatProperty moneyProperty();

	float getMoney();

	void setMoney(float money);

	IntegerProperty productToProduceProperty();

	int getProductToProduce();

	void setProductToProduce(int productToProduce);

	IntegerProperty rawmaterialNeededProperty();

	int getRawmaterialNeeded();

	void setRawmaterialNeeded(int rawmaterialNeeded);

	FloatProperty productAmountProperty();

	float getProductAmount();

	void setProductAmount(float productAmount);

	FloatProperty productRawmaterialAmountProperty();

	float getProductRawmaterialAmount();

	void setProductRawmaterialAmount(float productRawmaterialAmount);

	void addMoney(float amount);

	FloatProperty productRateProperty();

	float getProductRate();

	void setProductRate(float productRate);

	FloatProperty productPriceProperty();

	float getProductPrice();

	void setProductPrice(float productPrice);

	IntegerProperty employeesNeededProperty();

	int getEmployeesNeeded();

	void setEmployeesNeeded(int employeesNeeded);

	IntegerProperty employeesProperty();

	int getEmployees();

	void setEmployees(int employees);

	FloatProperty defaultSalaryProperty();

	float getDefaultSalary();

	void setDefaultSalary(float defaultSalary);

	FloatProperty productQualityProperty();

	float getProductQuality();

	void setProductQuality(float productQuality);

}