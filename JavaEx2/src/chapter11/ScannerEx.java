package chapter11;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		System.out.println("문장을 입력하세요.[종료는 END]");
		while (true) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("END"))
				break;
			sb.append(line + "\n");
		}

		System.out.println("-----결과-----");
		String result = sb.toString();
		System.out.println(result);

	}

}
