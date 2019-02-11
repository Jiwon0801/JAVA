package Thread;

// 작업 스레드

public class Knight extends Thread {
	private final Bridge bridge; // 공유객체
	
	private final String name;
	private final String address;
	
	public Knight (Bridge bridge, String name, String address) {
		this.bridge = bridge;
		this.name = name;
		this.address = address;
	}
	
	public void run() { // java의  상속받은 thread에 대한 run
		System.out.println(name + "기사가 도전한다.");
		while(true) {
			bridge.across(name, address);
		}
	}
	

}
