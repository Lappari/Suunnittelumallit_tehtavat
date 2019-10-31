package otp.markkinasim;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import otp.markkinasim.model.IProduct;
import otp.markkinasim.model.Product;
import otp.markkinasim.partyModel.IParty;
import otp.markkinasim.partyModel.Party;

public class PartyTest {

	//TODO TESTAA INVENTORY OMANA MODUULINAAN!!!!!
	
	Product productNeeded = new Product("productneeded");
	IProduct productToProduce = new Product("testproduct", productNeeded.id);
	IParty party = new Party("Testparty", 100, new Product("Testproduct"));
	
	@Test
	public void testInventoryAdd() {
		assertThrows(InvalidParameterException.class, () -> {
			party.addToInventory(productNeeded, 0);
		});
	}
	
	@Test
	public void testInventoryAdd2() {
		assertThrows(InvalidParameterException.class, () -> {
			party.addToInventory(productNeeded, -100);
		});
	}
}
