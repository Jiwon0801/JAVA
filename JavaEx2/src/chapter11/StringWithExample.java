package chapter11;

public class StringWithExample {

	public static void main(String[] args) {
		String s = "abc";
		
		boolean b1 = s.startsWith("ab");
		boolean b2 = s.startsWith("a");
		boolean b3 = s.startsWith("bc");
		
		boolean b4 = s.endsWith("bc");
		boolean b5 = s.endsWith("c");
		boolean b6 = s.endsWith("a");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);

	}

}
