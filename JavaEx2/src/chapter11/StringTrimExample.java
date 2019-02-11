package chapter11;

public class StringTrimExample {
	public static void main(String[] args) {
		String tel1 = "	02";
		String tel2 = "123    ";
		String tel3 = "	12 34	";

		String tel = tel1.trim() + tel2.trim() + tel3.trim();

		System.out.println(tel);
		
		String str = "(12 + 4 ) * 5";
		str = str.replace(" ", "");
		System.out.println(str);
	}
}
