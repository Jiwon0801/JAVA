package chapter11;

public class StringIndexOfExample {
public static void main(String[] args) {
	String subject = "�ڹ� ���α׷���, ���α׷����� �����";
	
	int location = subject.lastIndexOf("���α׷���");
	System.out.println(location);
	
	if(location != -1) {
		System.out.println("�ڹٿ� ���õ� å�̱���");
	}else {
		System.out.println("�ڹٿ� ���þ��� å�̱���");
	}
	
	location = subject.lastIndexOf("���α׷���", location-1);
	System.out.println(location);
}
}
