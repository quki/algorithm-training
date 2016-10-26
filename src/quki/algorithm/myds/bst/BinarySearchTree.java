package quki.algorithm.myds.bst;

public class BinarySearchTree {

	public Node root; // key 역할

	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * 탐색
	 */
	public boolean find(int toFind) {
		Node current = root; // current와 root는 같은 곳을 보고있음
		while (current != null) {

			if (current.getData() == toFind)
				return true;

			if (current.getData() > toFind)
				current = current.getLeft(); // 이제는 current와 root는 다른 곳을 보고 있음

			if (current.getData() < toFind)
				current = current.getRight();

		}
		return false;
	}

	/**
	 * 삽입
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root; // 시작!
		Node parent = null; // 중요! java에서 reference
		while (true) {
			parent = current; // current가 가리키는 것을 parent도 가리킴, 이따가 current는 다른 것을 가리킴
			if (data < current.getData()) {
				current = current.getLeft(); // current만 child를 가리킴
				if (current == null) {
					parent.setLeft(newNode); // parent가 가리키는 객체에 setLeft!, 즉,
												// root도 처음에 update
					return;
				}
			} else {
				current = current.getRight();
				if (current == null) {
					parent.setRight(newNode);
					return;
				}
			}
		}
	}

	/**
	 * 삭제
	 */
	public Node remove(int toBeRemoved) {
		Node current = root;
		Node parent = null;

		if (!find(toBeRemoved)) {
			System.out.println("그런 원소 없습니다");
		}

		boolean isLeftChild = false; // 지워져야하는 node가 부모에 대해 왼쪽에 있는가
		while (current.getData() != toBeRemoved) {
			parent = current; // 부모 update!
			if (current.getData() < toBeRemoved) {
				current = current.getRight();
				isLeftChild = false;
			}

			if (current.getData() > toBeRemoved) {
				current = current.getLeft();
				isLeftChild = true;
			}

		}

			// 1. sub tree가 하나도 없는 경우
		if (current.getLeft() == null && current.getRight() == null) {

			if (current == root)
				root = null;

			if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}

			// 2. sub tree가 둘다 있는 경우
		} else if (current.getLeft() != null && current.getRight() != null) {
			
			Node replacingNode = getReplaceNode(current);
			if (current == root) { // root인 경우
				root = replacingNode;
			} else if (isLeftChild) {
				parent.setLeft(replacingNode);
			} else {
				parent.setRight(replacingNode);
			}
			
			// sub tree 달아주기
			replacingNode.setLeft(current.getLeft());
			replacingNode.setRight(current.getRight());
			
			// 3. sub tree가 하나만 있는 경우
		} else if (current.getLeft() != null) {

			if (current == root) { // root인 경우
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}

		} else if (current.getRight() != null) {

			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		return current;
	}
	/**
	 * 지워지는 node의 오른쪽에 있는 가장 작은 값을 찾는다
	 * 열혈 자료구조 책 참고
	 */
	private Node getReplaceNode(Node current){
		Node parent = null;
		current = current.getRight();
		while(current != null){
			parent = current;
			current = current.getLeft();
		}
		
		//  parent의 parent의 left 삭제하는 부분 구현해라!
		return parent;
	}
	/**
	 * 순회 (Traverse) 
	 * 왼쪽에서부터 순회
	 */
	private void inorder(Node node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}
	}

	public void print() {
		inorder(root);
		System.out.println();
	}

	/**
	 * getter, setter
	 *
	 */
	public class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.setData(data);
			setLeft(null);
			setRight(null);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

}
