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
		root = new Node(rootValue);
	}

	/*
	 * public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){ root
	 * = new Node(rootValue, left, right); }
	 */

	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ',');
			if (root.left() != null) // pääseeekö vasemmalle?
				root.left().preOrder();
			if (root.right() != null) // pääseekö oikealle?
				root.right().preOrder();
		}

	}

	public boolean findOrder(String haku) {
		boolean bFound =false;
		if (root != null) {
			// System.out.println(root.getData()+',');
			if (root.getData().equals(haku)) {
				found += "juuressa ";
				bFound = true;
			} else {

				if (root.left() != null) {
					found += "vasen ";
					bFound = root.left().findOrder(haku);// pääseeekö vasemmalle?
				}
					
				if (root.right() != null && !bFound) { // pääseekö oikealle?
					found += "oikea ";
					bFound = root.right().findOrder(haku);
				}				
			}

		}
		return bFound;
	}

	// löydetty alipuu asetetaan staattiseen muuttujaan found
	public void findWithPreOrder(BinaryTree newTree) {

		if (root != null) {
			// System.out.print(root.getData()+ ": muokkaatko tätä?");
			if (stringCompare(newTree.root.getData(), root.getData()) < 0) {
				if (root.left() == null) {
					setLeft(newTree);
				} else if (root.left() != null) {// pääseekö vasemmalle?
					root.left().findWithPreOrder(newTree);
				}

			} else if (stringCompare(newTree.root.getData(), root.getData()) > 0) {
				if (root.right() == null) {
					setRight(newTree);
				} else if (root.right() != null) {// pääseekö oikealle?
					root.right().findWithPreOrder(newTree);
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
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
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
}
