package datastructure.list;

public class LinkedList {
	private int size;
	private Node head;
	
	public LinkedList(){ 
		head = new Node();
	}
	
	
	public void add(int value) {
		Node node = new Node(value);

		Node tail = head;
		while(tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(node);
		size++;
	}
	
	public void add(int index, int value) {
		Node node = new Node(value);
		
		Node tail = head;
		for(int i=0; i<index; i++) {
			tail = tail.getNext();
		}	
		
		node.setNext(tail.getNext());	// 以묒슂!
		tail.setNext(node);
		size++;
	}
	
	public int remove(int index) {
		Node tail = head;
		for(int i=0; i<index; i++) {
			tail = tail.getNext();
		}	
		
		// �씠�븣 tail�� 吏곸쟾 Node�뿉 ���븳 李몄“
		int value = tail.getNext().getValue();
		// �젣嫄�
		tail.setNext(tail.getNext().getNext());
		size--;
		return value;
	}
	
	public int getSize() {
		return size;
	}
	
	public int get(int index) {
		Node tail = head.getNext();
		for(int i=0; i<index; i++) {
			tail = tail.getNext();
		}	
		return tail.getValue();
	}
	
	
	
	public void print() {
		Node tail = head;
		while(tail.getNext() != null) {
			tail = tail.getNext();
			System.out.print(tail.getValue() + " ");
		}
		System.out.println();
	}
	
	
}
