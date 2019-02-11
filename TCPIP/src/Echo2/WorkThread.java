package Echo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkThread extends Thread {

	private Socket socket;

	public WorkThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			// 수신용 Reader 만들기
			BufferedReader r = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			// 전송용 Writer 만들기
			PrintWriter w = new PrintWriter(socket.getOutputStream());

			// 메세지 수신
			String line = r.readLine(); // 개행 문자 단위로 수신
			System.out.println("수신 메세지> " + line);

			// 메세지 전송
			w.println(line); // 개행문자까지 읽기
			w.flush();

			//socket.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally { try {socket.close();} catch(Exception e) {System.out.println(e);} }
	}
}
