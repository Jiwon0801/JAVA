package datastructure.list;

public class StackEx {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		//stack.printf();
		
		System.out.println("pop : " + stack.pop());
		//stack.printf();
		System.out.println("pop : " + stack.pop());
		//stack.printf();
		System.out.println("pop : " + stack.pop());		
		//stack.printf();
		System.out.println("pop : " + stack.pop());
		//stack.printf();
	}
}
