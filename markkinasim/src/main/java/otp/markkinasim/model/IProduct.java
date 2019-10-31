package otp.markkinasim.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface IProduct {

	void setPoductName(String value);

	int getProductNeededId();

	String getProductName();

	IntegerProperty getPrice();

	void setPrice(IntegerProperty price);

	void setProductName(String productName);

	void setProductNeededId(int productNeededId);

	int getId();

	void setId(int id);

	StringProperty productNameProperty();

	FloatProperty rawmaterialNeededProperty();

	float getRawmaterialNeeded();

	void setRawmaterialNeeded(float rawmaterialNeeded);

	StringProperty productCategoryProperty();

	String getProductCategory();

	void setProductCategory(String productCategory);

}