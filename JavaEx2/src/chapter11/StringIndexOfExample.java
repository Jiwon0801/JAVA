package chapter11;

public class StringIndexOfExample {
public static void main(String[] args) {
	String subject = "자바 프로그래밍, 프로그래밍을 배우자";
	
	int location = subject.lastIndexOf("프로그래밍");
	System.out.println(location);
	
	if(location != -1) {
		System.out.println("자바와 관련된 책이군요");
	}else {
		System.out.println("자바와 관련없는 책이군요");
	}
	
	location = subject.lastIndexOf("프로그래밍", location-1);
	System.out.println(location);
}
}
