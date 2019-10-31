package otp.markkinasim.personModel;

import javafx.beans.property.*;

public class Person implements IPerson {
	
	//private FloatProperty money;
	private static int nextId;

	private int id;
	private StringProperty status;
	private StringProperty employer;
	private FloatProperty money;
	private FloatProperty salary;
	private FloatProperty hunger; //Test idea
	
	public Person() {
		this.money = new SimpleFloatProperty(100);
		this.salary = new SimpleFloatProperty(0);
		this.employer = new SimpleStringProperty("työtön");
		this.status = new SimpleStringProperty("elossa");
		this.hunger = new SimpleFloatProperty(0);
		this.id=nextId;
		nextId++;
	}

	@Override
	public final StringProperty employerProperty() {
		return this.employer;
	}
	

	@Override
	public final String getEmployer() {
		return this.employerProperty().get();
	}
	

	@Override
	public final void setEmployer(final String employer) {
		this.employerProperty().set(employer);
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
	public final FloatProperty salaryProperty() {
		return this.salary;
	}
	

	@Override
	public final float getSalary() {
		return this.salaryProperty().get();
	}
	

	@Override
	public final void setSalary(final float salary) {
		this.salaryProperty().set(salary);
	}
	

	@Override
	public final FloatProperty hungerProperty() {
		return this.hunger;
	}
	

	@Override
	public final float getHunger() {
		return this.hungerProperty().get();
	}
	

	@Override
	public final void setHunger(final float hunger) {
		this.hungerProperty().set(hunger);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public final StringProperty statusProperty() {
		return this.status;
	}
	

	@Override
	public final String getStatus() {
		return this.statusProperty().get();
	}
	

	@Override
	public final void setStatus(final String status) {
		this.statusProperty().set(status);
	}
	
	
	

	
	
}
