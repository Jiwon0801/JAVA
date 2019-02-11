package datastructure.list;

public class Stack {
	
	DoubleLinkedList list;
	
	public Stack() {
		list = new DoubleLinkedList();
	}
	
	public void push(int value) {
		list.add(value);
	}
	
	public int pop() {
		return list.remove(list.getSize()-1);
	}
}
