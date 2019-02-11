package chapter11;

public class Member1 implements Comparable<Member1>{
	String name;
	int age;
	
	Member1(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Member1 o) {
		//return name.compareTo(o.name);
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return name;
	}

}
