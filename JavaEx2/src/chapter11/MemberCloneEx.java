package chapter11;

public class MemberCloneEx {
	public static void main(String[] args) {
		MemberClone original = new MemberClone("blue","홍길동", "12345",25,true);
		
		MemberClone cloned = original.getMember();
		cloned.passward = "67890";
		
		System.out.println("[복제 객체의 필드값]");
		System.out.println(cloned.passward);
		System.out.println();
		
		System.out.println("[원본 객체의 필드값]");
		System.out.println(original.passward);
	}
}
