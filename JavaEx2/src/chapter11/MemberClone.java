package chapter11;

public class MemberClone implements Cloneable{
	public String id;
	public String name;
	public String passward;
	public int age;
	public boolean adult;
	
	public MemberClone(String id, String name, String passward, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.passward = passward;
		this.age = age;
		this.adult = adult;
	}
	
	public MemberClone getMember() {
		MemberClone cloned = null;
		try {
			cloned = (MemberClone) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}
