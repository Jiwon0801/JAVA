package Echo;

import java.io.*;
import java.net.*;

public class ClientEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Socket socket = new Socket("localhost", 10000)) { // 127.0.0.1
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			String str = "Hello Server";
			out.write(str.getBytes()); // 메세지 전송
			out.flush();
			
			byte arr[]= new byte[100]; // 수신 버퍼
			in.read(arr); //메세지 수신
			System.out.println(new String(arr));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
