package chapter11;

public enum Week {
	SUNDAY("�Ͽ���"),
	MONDAY("������"),
	TUESDAY("ȭ����"),
	WEDNESDAY("������"),
	THURSDAY("�����"),
	FRIDAY("�ݿ���"),
	SATURDAY("�����");
	
	final private String name;
	
	Week(String name){
		this.name= name;
	}
	String value() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
