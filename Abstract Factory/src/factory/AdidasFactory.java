package factory;

import java.util.ArrayList;
import java.util.List;

import model.IVaate;
import model.Vaate;

public class AdidasFactory implements Factory{
	
	@Override
	public List<IVaate> pueVaatteet() {
		List<IVaate> vaatteet= new ArrayList<IVaate>();
		vaatteet.add(new Vaate("farmarit","Adidas"));
		vaatteet.add(new Vaate("t-paita","Adidas"));
		vaatteet.add(new Vaate("lippis","Adidas"));
		vaatteet.add(new Vaate("kengät","Adidas"));
		return vaatteet;
	}
}
