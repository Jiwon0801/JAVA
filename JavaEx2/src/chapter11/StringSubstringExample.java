package chapter11;

public class StringSubstringExample {
	public static void main(String[] args) {
		String ssn = "880815-1234567";
		String firstNum = ssn.substring(0, 6);
		String secondNum = ssn.substring(7);

		System.out.println(firstNum);
		System.out.println(secondNum);

		String str = "c:/temp/test/a.txt";
		int location = str.lastIndexOf("/");
		String dir = str.substring(0, location);
		String fileName = str.substring(location + 1);
		System.out.println(dir);
		System.out.println(fileName);
		
		int location1 = str.lastIndexOf(".");
		String fileName2 = str.substring(location+1, location1);
		String fileName3 = str.substring(location1+1);
		
		System.out.println(fileName2);
		System.out.println(fileName3);
	}
}
