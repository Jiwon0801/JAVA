package Thread;

public class BridgeTest {
	
	//메인 스레드

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시뮬레이션 시작");
		Bridge bridge = new Bridge();
		
		new Knight(bridge,"홍길동", "홍천").start();
		new Knight(bridge,"임꺽정", "임실").start();
		new Knight(bridge,"일지매", "일산").start();
		new Knight(bridge,"장보고", "장흥").start();
		new Knight(bridge,"이순신", "이천").start();
		// 작업스레드 5개, main 스레드 1개
		
		
	
	}

}
