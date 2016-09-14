package quki.algorithm.myds.linkedlist;


public class Run {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addFirst(10);
		linkedList.addLast(30);
		linkedList.add(1, 100);
		System.out.println(linkedList.removeLast());
		System.out.println(linkedList.toString());
		System.out.println(linkedList.size());
	}

}
