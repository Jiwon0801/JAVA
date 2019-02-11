package MultiChat;

import java.net.Socket;
import java.util.Scanner;



public class MultiChattingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("user name > ");
		String userName = s.nextLine();
		
		try {
			Socket socket = new Socket ("70.12.112.149", 9002);
			new SenderThread(socket, userName).start();
			new ReceiverThread(socket).start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
