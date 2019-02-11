package Chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SenderThread extends Thread {
	
	Socket socket;
	
	SenderThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			Scanner s = new Scanner(System.in);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
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
		}finally {
			try { socket.close(); } // Sender 스레드만 close()
			catch (Exception ignored) { }
		}
	}
	
	

}
