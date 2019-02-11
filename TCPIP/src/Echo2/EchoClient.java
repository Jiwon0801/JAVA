package Echo2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Socket socket = new Socket ("70.12.112.149", 10000)) {
			// 수신용 Reader 만들기
			BufferedReader r = new BufferedReader (
					new InputStreamReader(socket.getInputStream()));
			
			// 전송용 Writer 만들기
			PrintWriter w = new PrintWriter(
					socket.getOutputStream());
			
			Scanner s = new Scanner(System.in);
			System.out.println("문자열 입력> ");
			String line = s.nextLine(); // 전송 문자열 입력
			
			// 메세지 전송
			w.println(line); // 개행문자까지 읽기
			w.flush();
			
			// 메세지 수신
			String receiveLine = r.readLine();
			System.out.println("수신 메세지> " + receiveLine);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}

	}

}
