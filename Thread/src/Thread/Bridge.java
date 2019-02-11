package Thread;

public class Bridge {
	
	private int counter = 0;
	private String name = "홍길동";
	private String address = "모름";
	
	public synchronized void across(String name, String address) { // 공유 method
		this.counter++;
		this.name = name;
		this.address = address;
		check(); // lock 걸린 상태
	}
	
	public synchronized String toString() {
		return "이름: " + name + ",출신: " + address + ", 도전 횟수: " + counter;
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("문제 발생!!!!"+ toString());
		}
	}
	


}
