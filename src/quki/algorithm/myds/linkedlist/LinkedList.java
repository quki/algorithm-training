package quki.algorithm.myds.linkedlist;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	/**
	 * 가장 첫번째 위치에 node를 추가함
	 * 
	 * @param input
	 */
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head; // 이전에 만들어진 node를 가리켜야함, 정보는 head에 담겨있다
		head = newNode; // head 변수가 새로 만들어진 node를 가리킴
		size++;
		if (head.next == null) { // head.next는 head 변수가 가리키고 있는 node의 다음 node
			tail = head;
		}
	}

	/**
	 * 가장 마지막 위치에 node를 추가함
	 * 
	 * @param input
	 */
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if (size == 0) { // node가 하나도 없을 경우
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	/**
	 * 특정 index에 node 추가
	 * 
	 * @param index
	 * @param input
	 */
	public void add(int index, Object input) {

		if (index == 0) {
			addFirst(input);
		} else {
			Node prev = getNode(index - 1);
			Node newNode = new Node(input);
			newNode.next = prev.next;
			prev.next = newNode;
			size++;

			if (newNode.next == null) { // 마지막에 추가된다면, tail 갱신
				tail = newNode;
			}
		}

	}

	/**
	 * 첫번째 node 삭제
	 * 
	 * @return 삭제된 node가 갖고있던 data 리턴
	 */
	public Object removeFirst() {
		Node tobeRemoved = head;
		Object returnData = tobeRemoved.data;
		head = tobeRemoved.next;
		tobeRemoved = null;
		size--;
		return returnData;
	}

	/**
	 * 특정 index node 삭제
	 * 
	 * @param index
	 * @return 삭제된 node가 갖고있던 data 리턴
	 */
	public Object remove(int index) {
		if (index == 0)
			return removeFirst();

		Node prev = getNode(index - 1); // 지워져야하는 앞의 node
		Node tobeRemoved = prev.next; // 지워져야하는 node를 가리키고있다
		Object returnData = tobeRemoved.data; // data 저장
		prev.next = tobeRemoved.next;

		// 변수가 가리키고 있던 instance의 주소값이 없으므로
		// Garbage collector가 instance 회수
		tobeRemoved = null;

		size--;
		if (prev.next == null)
			tail = prev;

		return returnData;
	}

	/**
	 * 최악의 경우임! 차례로 끝 까지 검색해야함! 왜냐하면 tail 앞의 node도 알고 있어야 하기 때문.
	 * 
	 * @return
	 */
	public Object removeLast() {
		return remove(size - 1);
	}

	public Object get(int index) {
		Node temp = getNode(index);
		return temp.data;
	}

	public int size() {
		return size;
	}

	/**
	 * 특정 index의 node 찾기. 차례로 검사해야하므로 마지막 node에 접근하면 최악의 경우. 내부에서 쓰는 Node 객체를
	 * 외부에 보여서는 안됨.
	 */
	private Node getNode(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * 출력
	 */
	public String toString() {
		if (head == null) {
			return "[]";
		}

		Node temp = head;
		String str = "[";
		// 다음 노드가 없을 때까지 반복문을 실행
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
		while (temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		// 마지막 노드를 출력결과에 포함.
		str += temp.data + "]";
		return str;
	}

	/**
	 * 내부에서 만든 class는 통상적으로 외부에서 보이면 안됨.
	 *
	 */
	private class Node {

		private Object data;
		private Node next;

		Node(Object input) {
			this.data = input;
			this.next = null;
		}

		// 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		public String toString() {
			return String.valueOf(this.data);
		}

	}

}
