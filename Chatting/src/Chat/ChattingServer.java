package Chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();
			
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			
			thread1.start();
			thread2.start();
			
			/*
			 * main 처음부터 catch 전
			 * 
			 * try(ServerSocket serverSocket = new ServerSocket(9001);) {
			 * 		Socket socket = serverSocket.accept();
			 *		 new SenderThread(socket).start();
			 * 		 new ReceiverThread(socket).start();
			 * }
			
			 */
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
