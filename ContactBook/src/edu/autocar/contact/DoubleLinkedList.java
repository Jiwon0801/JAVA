package edu.autocar.contact;

public class DoubleLinkedList {
	private Node head;
	private int size;

	private class Node {
		//int value;
		Contact value;
		Node next;
		Node prev;

		Node(Contact c) {
			this.value = c;
		}
	}

	public DoubleLinkedList() {
		clear();
	}

	public void clear() {
		head = new Node(null);
		head.next = head;
		head.prev = head;
		size = 0;
	}

	public void add(Contact c) {
		Node node = new Node(c);
		node.prev = head.prev;
		node.next = head;
		head.prev.next = node;
		head.prev = node;

		size++;
	}

	public void add(int ix, Contact c) {
		Node t = getNode(ix);
		Node node = new Node(c);

		node.prev = t.prev;
		node.next = t;
		t.prev.next = node;
		t.prev = node;

		size++;
	}

	public Contact get(int ix) {
		Node node = getNode(ix);
		return node.value;
	}

	public Contact remove(int ix) {
		Node t = getNode(ix);
		t.next.prev = t.prev;
		t.prev.next = t.next;

		size--;

		return t.value;
	}

	public int getSize() {
		return size;
	}

	public void set(int ix, Contact c) {
		Node t = getNode(ix);
		t.value = c;
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
}
