package otp.markkinasim.model;

import javafx.beans.property.*;
import javax.persistence.*;

@Entity
@Table(name="Product")
@Access(AccessType.FIELD)


public class Product implements IProduct {
	public static int nextId = 0;	//ID JÄRJESTELMÄ AINA OLIOTA ILMENNETTÄESSÄ. KTS. CONSTRUCTOR.
	protected int id;
	private StringProperty productCategory;
	private StringProperty productName;
	private IntegerProperty productNeededId;
	private FloatProperty rawmaterialNeeded;
	private IntegerProperty price;
	
	

	public Product() {
		this.productName = new SimpleStringProperty();
		this.productNeededId = new SimpleIntegerProperty(-1); //SAATTAA AIHEUTTAA ONGELMIA!!
		this.rawmaterialNeeded = new SimpleFloatProperty(1);
		this.productCategory = new SimpleStringProperty("Food");
		id = nextId;
		nextId++;
	}
	public Product(String productName) {
		
		this.productName = new SimpleStringProperty(productName);
		this.productNeededId = new SimpleIntegerProperty(-1); //SAATTAA AIHEUTTAA ONGELMIA!!
		this.rawmaterialNeeded = new SimpleFloatProperty(1);
		this.productCategory = new SimpleStringProperty("Food");
		id = nextId;
		nextId++;
	}
	
	public Product(String productName, int productNeededId) {
		
		this.productName = new SimpleStringProperty(productName);
		//productNeeded = new ArrayList<Product>();
		this.productNeededId = new SimpleIntegerProperty(productNeededId); //SAATTAA AIHEUTTAA ONGELMIA!!
		this.rawmaterialNeeded = new SimpleFloatProperty(1);
		this.productCategory = new SimpleStringProperty("Food");
		id = nextId;
		nextId++;
	}
	
	@Override
	public void setPoductName(String value ) {
		productName.set(value);
	}
	
	@Override
	@Access(AccessType.PROPERTY)
	@Column(name="product_needed_id")
	public int getProductNeededId() {
		return productNeededId.get();
	}
	@Override
	@Access(AccessType.PROPERTY)
	@Column(name="product_name")
	public String getProductName() {
		return productName.get();
	}
	@Override
	public IntegerProperty getPrice() {
		return price;
	}
	@Override
	public void setPrice(IntegerProperty price) {
		this.price = price;
	}
	@Override
	public void setProductName(String productName) {
		this.productName.set(productName);
	}
	@Override
	public void setProductNeededId(int productNeededId) {
		this.productNeededId.set(productNeededId);
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public StringProperty productNameProperty() {

		return productName;
	}
	@Override
	public final FloatProperty rawmaterialNeededProperty() {
		return this.rawmaterialNeeded;
	}
	
	@Override
	public final float getRawmaterialNeeded() {
		return this.rawmaterialNeededProperty().get();
	}
	
	@Override
	public final void setRawmaterialNeeded(final float rawmaterialNeeded) {
		this.rawmaterialNeededProperty().set(rawmaterialNeeded);
	}
	@Override
	public final StringProperty productCategoryProperty() {
		return this.productCategory;
	}
	
	@Override
	public final String getProductCategory() {
		return this.productCategoryProperty().get();
	}
	
	@Override
	public final void setProductCategory(final String productCategory) {
		this.productCategoryProperty().set(productCategory);
	}
	
		
}
