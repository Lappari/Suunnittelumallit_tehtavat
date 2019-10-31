package otp.markkinasim.personModel;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

public interface IPerson {

	StringProperty employerProperty();

	String getEmployer();

	void setEmployer(String employer);

	FloatProperty moneyProperty();

	float getMoney();

	void setMoney(float money);

	FloatProperty salaryProperty();

	float getSalary();

	void setSalary(float salary);

	FloatProperty hungerProperty();

	float getHunger();

	void setHunger(float hunger);

	int getId();

	StringProperty statusProperty();

	String getStatus();

	void setStatus(String status);

}