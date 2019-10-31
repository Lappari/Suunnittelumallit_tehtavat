package otp.markkinasim.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import otp.markkinasim.partyModel.IParty;
import otp.markkinasim.partyModel.Party;



public class Secretary {
	
	SessionFactory factory = null;
	final StandardServiceRegistry registry = null;
	
	public Secretary() {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try{
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		}
		catch(Exception e){
			System.out.println("Creating sessionfactory failed. Exiting program.");
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public int getNextIdProduct() {
		
	//TODODODODO
		return 0;
		
	}
	
	public boolean createProduct(IProduct product) {
		boolean done = false;
		Transaction transaktio = null;
		try (Session istunto = factory.openSession()) {
			transaktio = istunto.beginTransaction();
			IProduct result = istunto.get(Product.class, product.getId());
			if (result == null) {
				istunto.saveOrUpdate(product);
				transaktio.commit();
				done = true;
			}
		} catch (Exception e) {
			if (transaktio != null) transaktio.rollback();
			throw e;
		}
		return done;
	}
	
	public boolean createParty(IParty party) {
		boolean done = false;
		Transaction transaktio = null;
		try (Session istunto = factory.openSession()) {
			transaktio = istunto.beginTransaction();
			IParty result = istunto.get(Party.class, party.getId());
			if (result == null) {
				istunto.saveOrUpdate(party);
				transaktio.commit();
				done = true;
			}
		} catch (Exception e) {
			if (transaktio != null) transaktio.rollback();
			throw e;
		}
		return done;
	}
	
	@SuppressWarnings("unchecked")
	public ObservableList<Product> getAllProductsFromDB() {
		Transaction transaktio = null;
		List<Product> result = new ArrayList<Product>();
				
		try (Session istunto = factory.openSession()) {
			transaktio = istunto.beginTransaction();
			result = istunto.createQuery("from Product").getResultList();
			transaktio.commit();
		} catch (Exception e) {
			if (transaktio != null) transaktio.rollback();
			throw e;
		}
		
		ObservableList<Product> returnArray = FXCollections.observableArrayList(result);
		
		return returnArray;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ObservableList<Party> getAllPartysFromDB() {
		Transaction transaktio = null;
		List<Party> result = new ArrayList<Party>();
				
		try (Session istunto = factory.openSession()) {
			transaktio = istunto.beginTransaction();
			result = istunto.createQuery("from Party").getResultList();
			transaktio.commit();
		} catch (Exception e) {
			if (transaktio != null) transaktio.rollback();
			throw e;
		}
		
		ObservableList<Party> returnArray = FXCollections.observableArrayList(result);
		
		return returnArray;
		
		
	}

}
