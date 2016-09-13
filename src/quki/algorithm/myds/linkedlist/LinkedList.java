package quki.algorithm.myds.linkedlist;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	public class Node {

		private Object data;
		private Node next;

		Node(Object input) {
			this.data = input;
			this.next = null;
		}

	}

}
