package MultiChat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread {
	
	Socket socket;
	String name;
	
	SenderThread (Socket socket, String name) {
		this.socket = socket;
		this.name = name;
			
	}
	
	public void run() {
		try {
			Scanner s = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(name);
			writer.flush();
			
			while(true) {
				String str = s.nextLine();
				if(str.equals("bye"))
					break;
				writer.println(str);
				writer.flush();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try { socket.close(); } // Sender 스레드만 close()
			catch (Exception ignored) { }
		}
	}

}
