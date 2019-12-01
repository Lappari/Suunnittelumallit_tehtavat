/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

	private int korkeus = 0;
	private Node root;
	public static String found; // findWithPreOrder()-operaation apurakenne
	
	public BinaryTree(String rootValue) {
		setRoot(new Node(rootValue));
	}

	/*
	 * public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){ root
	 * = new Node(rootValue, left, right); }
	 */
	
	//binääri puun tulostus esijärjestyksessä
	public void preOrder() {
		if (getRoot() != null) {
			System.out.println(getRoot().getData() +" "+ korkeus +',');
			if (getRoot().left() != null) // pääseeekö vasemmalle?
				getRoot().left().preOrder();
			if (getRoot().right() != null) // pääseekö oikealle?
				getRoot().right().preOrder();
		}

	}
	
	//lehden/solmun etsintä
	public boolean findOrder(String haku) {
		boolean bFound = false;
		if (getRoot() != null) {
			// System.out.println(root.getData()+',');
			if (getRoot().getData().equals(haku)) {
				found += korkeus+":juuressa";
				bFound = true;
			} else {

				if (getRoot().left() != null && !bFound) {
					found += korkeus+ ":vasen ";
					bFound = getRoot().left().findOrder(haku);// pääseeekö vasemmalle?
				}

				if (getRoot().right() != null && !bFound) { // pääseekö oikealle?
					found += korkeus+":oikea ";
					bFound = getRoot().right().findOrder(haku);
				}
			}

		}
		return bFound;
	}

	//asettaa automaattisestis uuden lehden oikeaan paikkaan stringi vertailua käyttäen
	public void findWithPreOrder(BinaryTree newTree) {

		if (getRoot() != null) {
			//testi string
			//System.out.println(stringCompare(newTree.getRoot().getData(), getRoot().getData())+" "+newTree.getRoot().getData()+" "+korkeus+" "+root.getData());
			if (stringCompare(newTree.getRoot().getData(), getRoot().getData()) < 0) {
				newTree.korkeus++;
				if (getRoot().left() == null) {
					setLeft(newTree);
				} else if (getRoot().left() != null && stringCompare(newTree.getRoot().getData(), getRoot().getData()) < 0) {// pääseekö vasemmalle?
					getRoot().left().findWithPreOrder(newTree);
				}

			}
			if (stringCompare(newTree.getRoot().getData(), getRoot().getData()) > 0) {
				newTree.korkeus++;
				if (getRoot().right() == null) {
					setRight(newTree);
				} else if (getRoot().right() != null && stringCompare(newTree.getRoot().getData(), getRoot().getData()) > 0) {// pääseekö oikealle?
					getRoot().right().findWithPreOrder(newTree);
				}

			}

		}

	}

	public void setNotFound() {
		found = "";
	}

	public static String getFound() {
		return found;
	}

	public void setLeft(BinaryTree tree) {
		getRoot().setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		getRoot().setRight(tree);
	}

	// stringgi vertailu
	public static int stringCompare(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();
		int lmin = Math.min(l1, l2);
		int str1_ch = 0;
		int str2_ch = 0;

		for (int i = 0; i < lmin; i++) {
			str1_ch = (int) str1.charAt(i);
			str2_ch = (int) str2.charAt(i);			
		}

		if (str1_ch != str2_ch) {				
			return str1_ch - str2_ch;
		}
		if (l1 != l2) {
			
			return l1 - l2;
		}

		else {
			return 0;
		}
	}
	
	//etsitään poistettava solmu/lehti lähetetään se menulle ja poistetaan puusta
	public BinaryTree findOrderDelete(String poisto) {
		BinaryTree tFound = null;
		if (getRoot() != null && tFound == null) {
	
			if (root.left() != null && root.left().root.getData().equals(poisto) && tFound == null) {
				tFound = root.left();
				root.setLeft(null);
				return tFound;
			}else if(root.left() != null && tFound == null) {
				tFound = root.left().findOrderDelete(poisto);// pääseeekö vasemmalle?
				
			}
			
			if(root.right() != null && root.right().root.getData().equals(poisto) && tFound == null) { // pääseekö oikealle?
				tFound = root.right();
				root.setRight(null);
				return tFound;
			}else if(root.right() != null && tFound == null) { // pääseekö oikealle?
				tFound = root.right().findOrderDelete(poisto);
			}

		}
		return tFound;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	//etsintä jaoittelulla
		public boolean searchWithPreOrder(String haku) {
			boolean bFound = false;
		
			if (getRoot() != null) {
				//testi string
				//System.out.println(stringCompare(newTree.getRoot().getData(), getRoot().getData())+" "+newTree.getRoot().getData()+" "+korkeus+" "+root.getData());
				if (getRoot().getData().equals(haku)) {
					found += korkeus+":juuressa";
					bFound = true;
				} else {

					//vasemmalle
					if (stringCompare(haku, getRoot().getData()) < 0) {
						if (getRoot().left() != null && !bFound) {
							found += korkeus+ ":vasen ";
							bFound = getRoot().left().findOrder(haku);// pääseeekö vasemmalle?
						}
					}
					//oikealle
					if (stringCompare(haku, getRoot().getData()) > 0) {
						if (getRoot().right() != null && !bFound) { // pääseekö oikealle?
							found += korkeus+":oikea ";
							bFound = getRoot().right().findOrder(haku);
						}
					}
				}

			}
			return bFound;

		}
}
