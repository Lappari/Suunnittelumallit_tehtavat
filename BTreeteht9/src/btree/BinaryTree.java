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

	private Node root;
	public static String found; // findWithPreOrder()-operaation apurakenne

	public BinaryTree(String rootValue) {
		setRoot(new Node(rootValue));
	}

	/*
	 * public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){ root
	 * = new Node(rootValue, left, right); }
	 */

	public void preOrder() {
		if (getRoot() != null) {
			System.out.println(getRoot().getData() + ',');
			if (getRoot().left() != null) // pääseeekö vasemmalle?
				getRoot().left().preOrder();
			if (getRoot().right() != null) // pääseekö oikealle?
				getRoot().right().preOrder();
		}

	}

	public boolean findOrder(String haku) {
		boolean bFound = false;
		if (getRoot() != null) {
			// System.out.println(root.getData()+',');
			if (getRoot().getData().equals(haku)) {
				found += "juuressa ";
				bFound = true;
			} else {

				if (getRoot().left() != null && !bFound) {
					System.out.println(getRoot().left().getRoot().getData());
					found += "vasen ";
					bFound = getRoot().left().findOrder(haku);// pääseeekö vasemmalle?
				}

				if (getRoot().right() != null && !bFound) { // pääseekö oikealle?
					found += "oikea ";
					bFound = getRoot().right().findOrder(haku);
				}
			}

		}
		return bFound;
	}

	// löydetty alipuu asetetaan staattiseen muuttujaan found
	public void findWithPreOrder(BinaryTree newTree) {

		if (getRoot() != null) {
			// System.out.print(root.getData()+ ": muokkaatko tätä?");
			if (stringCompare(newTree.getRoot().getData(), getRoot().getData()) < 0) {
				if (getRoot().left() == null) {
					setLeft(newTree);
				} else if (getRoot().left() != null) {// pääseekö vasemmalle?
					getRoot().left().findWithPreOrder(newTree);
				}

			} else if (stringCompare(newTree.getRoot().getData(), getRoot().getData()) > 0) {
				if (getRoot().right() == null) {
					setRight(newTree);
				} else if (getRoot().right() != null) {// pääseekö oikealle?
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

		for (int i = 0; i < lmin; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch != str2_ch) {
				return str1_ch - str2_ch;
			}
		}

		if (l1 != l2) {
			return l1 - l2;
		}

		else {
			return 0;
		}
	}

	public BinaryTree findOrderDelete(String poisto) {
		BinaryTree tFound = null;
		if (getRoot() != null && tFound == null) {
			/*
			 * if (root.getData().equals(poisto)) { tFound = this; }
			 */

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
}
