/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.LinkedList;

/**
 *
 * @author kamaj
 */
public class Stack {

	private LinkedList<String> list;

	public Stack() {
		list = new LinkedList<String>();
	}

	//lisätään data listaan viimeiselle paikalle
	public void push(String aData) {
		list.add(aData);
	}

	// poistetaan ja palautetaan alkio listan pohjalta, jos listassa on alkioita
	public String pop() {
		if(!list.isEmpty()) {
			return list.removeLast();
		}else {
			return null;
		}
		
	}

	// palautetaan pinottujen alkioiden lukumäärä
	public int amount() {
		return list.size();
	}

	// listataan sisältö
	public void printItems() {
		/*
		for(String s:list) {
			System.out.println(s);
		}*/
		for(int i = list.size()-1;i>=0;i--) {
			System.out.println(list.get(i));
		}
	}
}
