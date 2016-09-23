package quki.algorithm.myds.bst;

public class Run {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(0);
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.remove(3);
		bst.remove(1);
		bst.print();
	}

}
