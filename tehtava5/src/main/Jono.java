package main;

import java.util.ArrayList;
import java.util.ListIterator;

public class Jono {
	ArrayList<String> list = new ArrayList<String>();
	String data;

	public void push(String data) {
			list.add(data);
	}
	public String pop() {
		ListIterator<String> iterator = list.listIterator();
		if(iterator.hasNext()) {
			data = iterator.next();
			iterator.remove();
			return data;
		}else {
			return null;
		}
		
	}
	public void printItems() {
		ListIterator<String> iterator = list.listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		
	}
	public String amount() {
		return data = ("Jonon alkijoiden määrä: "+list.size());
	}
	
	
}
