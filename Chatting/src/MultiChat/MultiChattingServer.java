package MultiChat;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiChattingServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (ServerSocket serverSocket = new ServerSocket(9002)){
			while(true) {
				Socket socket = serverSocket.accept();
				new PerClientThread(socket).start();
							}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
