package otp.markkinasim.view;

import javafx.collections.ObservableList;
import javafx.stage.Window;
import otp.markkinasim.model.IProduct;
import otp.markkinasim.model.Product;
import otp.markkinasim.partyModel.IParty;
import otp.markkinasim.partyModel.Party;
import otp.markkinasim.personModel.Person;

public interface IView {

	public abstract ObservableList<Person> getPersonData();

	public abstract void setScene(int i);

	public abstract Window getPrimaryStage();

	public abstract ObservableList<Party> getPartyData();

	public boolean showPartyEditDialog(IParty party);

	public boolean showProductEditDialog(IProduct product);

	public boolean showRawmaterialEditDialog(IProduct product);

	public abstract ObservableList<Product> getAllProductData();

	public abstract void writeSimulationLog(String msg);

}
