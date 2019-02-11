package Chat;

import java.net.Socket;

public class ChattingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket = null;
		try {
			socket = new Socket ("70.12.112.149", 9001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
