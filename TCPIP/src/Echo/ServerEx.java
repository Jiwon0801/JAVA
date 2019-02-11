package Echo;

import java.io.*;
import java.net.*;

public class ServerEx {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Socket socket = null;
		
		// 서버 소켓 생성
		try(ServerSocket serverSocket = new ServerSocket(10000);) {
			socket = serverSocket.accept(); // 접속 대기
			
			//수신 스트림
			InputStream in = socket.getInputStream();
			
			// 전송 스트림
			OutputStream out = socket.getOutputStream();
			
			byte arr[]= new byte[100]; // 수신 버퍼
			in.read(arr); //메세지 수신
			System.out.println(new String(arr));
			
			
			String str = "Hello Client";
			out.write(str.getBytes()); // 메세지 전송
			out.flush();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {socket.close();} catch (Exception e) {}
		}
		
		

	}

}




