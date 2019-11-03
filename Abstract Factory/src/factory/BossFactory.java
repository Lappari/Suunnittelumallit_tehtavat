package factory;

import java.util.ArrayList;
import java.util.List;

import model.IVaate;
import model.Vaate;


public class BossFactory implements Factory{

	@Override
	public List<IVaate> pueVaatteet() {
		List<IVaate> vaatteet= new ArrayList<IVaate>();
		vaatteet.add(new Vaate("farmarit","Boss"));
		vaatteet.add(new Vaate("t-paita","Boss"));
		vaatteet.add(new Vaate("lippis","Boss"));
		vaatteet.add(new Vaate("kengät","Boss"));
		return vaatteet;
	}

}
