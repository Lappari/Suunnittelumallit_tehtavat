/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

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
		char select, select1;
		BinaryTree tree = null, upDated = null;
		String data;
		String haku;
		
		tree = new BinaryTree("juurisolmu");
		tree.findWithPreOrder(new BinaryTree("lehti"));
		tree.findWithPreOrder(new BinaryTree("lehti1"));
		tree.findWithPreOrder(new BinaryTree("lehti2"));
		tree.findWithPreOrder(new BinaryTree("lehti3"));
		tree.findWithPreOrder(new BinaryTree("l1"));
		tree.findWithPreOrder(new BinaryTree("l12"));
		tree.findWithPreOrder(new BinaryTree("l123"));
		tree.findWithPreOrder(new BinaryTree("l1234"));
		tree.findWithPreOrder(new BinaryTree("lehtipuuuuuuuu"));
		tree.findWithPreOrder(new BinaryTree("lehtipuuuuuuuuu"));
		tree.findWithPreOrder(new BinaryTree("lehtipuuuuuuuuuu"));
		tree.findWithPreOrder(new BinaryTree("lehtipuuuuuuuuuuu"));
		do {

			System.out.println("\n\t\t\t1. Luo juurisolmu.");
			System.out.println("\t\t\t2. Päivitä uusi solmu.");
			System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
			System.out.println("\t\t\t4. Etsi solmu.");
			System.out.println("\t\t\t5. Poista solmu.");
			System.out.println("\t\t\t6. Jaoittelu haku.");
			System.out.println("\t\t\t7. lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna juuren sisältö (merkkijono)");
				data = new String(Lue.rivi());
				tree = new BinaryTree(data);
				break;
			case '2':
				if (tree == null)
					System.out.println("Et ole muodostanut juurisolmua.");
				else {
					System.out.println("Anna solmun sisältö (merkkijono)");
					BinaryTree newTree = new BinaryTree(new String(Lue.rivi()));
					tree.findWithPreOrder(newTree);

				}
				break;
			case '3':
				tree.preOrder();
				char h = Lue.merkki(); // pysäytetään kontrolli
				break;
			case '4':
				System.out.println("Anna haettavan solmun sisältö (merkkijono)");
				haku = Lue.rivi();
				tree.setNotFound();
				if (tree.findOrder(haku)) {
					System.out.println(tree.getFound());
				} else {
					System.out.println("Ei löydy.");
					System.out.println(tree.getFound());
				}

				break;
			case '5':
				System.out.println("Anna poistettavan solmun sisältö (merkkijono)");
				String poisto = Lue.rivi();
				upDated = tree.findOrderDelete(poisto);
				if (upDated != null) {
					System.out.println("Solu poistettu.");
					if (upDated.getRoot().left() != null) {
						tree.findWithPreOrder(upDated.getRoot().left());
					}

					if (upDated.getRoot().right() != null) {
						tree.findWithPreOrder(upDated.getRoot().right());
					}

				} else {
					System.out.println("Solua ei löydy.");
				}

				break;
			case '6':
				System.out.println("Anna haettavan solmun sisältö (merkkijono)");
				haku = Lue.rivi();
				tree.setNotFound();
				if (tree.searchWithPreOrder(haku)) {
					System.out.println(tree.getFound());
				} else {
					System.out.println("Ei löydy.");
					System.out.println(tree.getFound());
				}
				break;
			case '7':
				break;
			}
		} while (select != '7');
	}
//printMenu loppuu ----------------------------------------------------------------
}
