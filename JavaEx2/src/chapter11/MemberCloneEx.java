package chapter11;

public class MemberCloneEx {
	public static void main(String[] args) {
		MemberClone original = new MemberClone("blue","ȫ�浿", "12345",25,true);
		
		MemberClone cloned = original.getMember();
		cloned.passward = "67890";
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println(cloned.passward);
		System.out.println();
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println(original.passward);
	}
}
