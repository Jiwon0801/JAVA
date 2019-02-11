package MultiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {
	
	// static으로 한 벌을 만든다.
	// 동기화 리스트를 통해 공유 자원 받기
	static List<PrintWriter> list = Collections.synchronizedList(
								new ArrayList<PrintWriter>());
	
	Socket socket;
	PrintWriter writer;
	
	
	public PerClientThread (Socket socket) {
		this.socket = socket;
		try {
			writer= new PrintWriter(socket.getOutputStream());
			list.add(writer);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public void run() {
		
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			name = reader.readLine();
			sendAll("#" + name  + "님이 들어오셨습니다.");
			
			while(true) {
				String str = reader.readLine();
				if(str==null)
					break;
				sendAll(name + ">" + str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer);
			sendAll("#" + name  + "님이 나가셨습니다.");
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	// 접속한 모든 사용자에게 메세지 포워딩	
	public void sendAll(String str) {
		for(PrintWriter writer : list) { // 동일한 writer가 들어왔을 때
			writer.println(str);
			writer.flush();
		}
	}

}
