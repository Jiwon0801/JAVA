package datastructure.list;

public class DoubleLinkedListEx {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.printf();
		list.add(7);
		list.printf();
		list.add(5);
		list.printf();
		list.add(4);
		list.printf();
		System.out.println(list.getSize());
	}

}
