package chapter11;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		System.out.println("������ �Է��ϼ���.[����� END]");
		while (true) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("END"))
				break;
			sb.append(line + "\n");
		}

		System.out.println("-----���-----");
		String result = sb.toString();
		System.out.println(result);

	}

}
