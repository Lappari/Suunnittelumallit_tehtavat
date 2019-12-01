/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
	public static void main(String[] args) {

		printMenu();

	}

//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
	private static void printMenu() {
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
		
		char select;
		int data;
		
		pQueue.add(10);
		pQueue.add(4);
		pQueue.add(16);
		pQueue.add(27);
		pQueue.add(5757);
		
		
		do {

			System.out.println("\n\t\t\t1. Insert.");
			System.out.println("\t\t\t2. deleteMin.");
			System.out.println("\t\t\t3. Tulosta kasa.");
			System.out.println("\t\t\t4. lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna sisältö (numero)");
				data = Lue.kluku();
				pQueue.add(data);
				break;
			case '2':
				System.out.println(pQueue.poll());
				break;
			case '3':
				System.out.println("Priority kasan elementit:"); 
		        Iterator itr = pQueue.iterator(); 
		        while (itr.hasNext()) 
		            System.out.println(itr.next()); 
				break;
			case '4':
				break;
			}
		} while (select != '4');
	}
//printMenu loppuu ----------------------------------------------------------------
}
