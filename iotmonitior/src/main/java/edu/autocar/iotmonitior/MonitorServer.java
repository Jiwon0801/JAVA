package edu.autocar.iotmonitior;

import java.net.ServerSocket;
import java.net.Socket;


public class MonitorServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// serverSocket = null;
		
		try (ServerSocket serverSocket = new ServerSocket(9002);)
		{
			while(true) {
				Socket socket = serverSocket.accept();
				MonitorThread monitor = new MonitorThread(socket);
				monitor.start();
							}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
