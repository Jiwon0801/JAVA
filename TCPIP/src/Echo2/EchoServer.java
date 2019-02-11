package Echo2;


import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket = null;
		
		try (ServerSocket server = new ServerSocket(10000)){
			
			while(true) {
				socket = server.accept();
				
				WorkThread work = new WorkThread(socket);
				work.start();
				
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
