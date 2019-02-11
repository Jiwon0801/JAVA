package datastructure.list;

public class DoubleLinkedList implements Queue{

	private Node head;
	private int size;
	
	private class Node {
		int value;
		Node next;
		Node prev;

		Node(int value) {
			this.value = value;
		}
	}

	public DoubleLinkedList() {
		clear();
	}
	
	public void clear() {
		head = new Node(0);
		head.next = head;
		head.prev = head;
		size = 0;
	}

	public void add(int value) {
		Node node = new Node(value);
		node.prev = head.prev;
		node.next = head;
		head.prev.next = node;
		head.prev = node;
		
		size++;
	}

	public void add(int ix, int value) {
		Node t = getNode(ix);
		Node node = new Node(value);

		node.prev = t.prev;
		node.next = t;
		t.prev.next = node;
		t.prev = node;
		
		size++;
	}

	public int get(int ix) {
		Node node = getNode(ix);
		return node.value;
	}

	public int remove(int ix) {
		Node t = getNode(ix);
		t.next.prev = t.prev;
		t.prev.next = t.next;

		size--;
		
		return t.value;
	}
	
	public int getSize() {
		return size;
	}

	public void set(int ix, int value) {
		Node t = getNode(ix);
		t.value = value;
	}

	private Node getNode(int ix) {
		Node t = head.next;
		for (int i = 0; i < ix; i++) {
			t = t.next;
		}
		return t;
	}

	public void printf() {
		Node t = head.next;
		while (t != head) {
			System.out.print(t.value + " ");
			t = t.next;
		}
		System.out.println();
	}

	@Override
	public void enqueue(int value) {
		add(value);
		
	}

	@Override
	public int dequeue() {
		return remove(0);
	}

}
