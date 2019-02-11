package chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BirthDayExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(YYYY-MM-DD) : ");
		String from = scanner.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date to = sdf.parse(from);
			System.out.println(to);
		} catch (ParseException e) {
			System.out.println("ex ) 1900-00-00 �� ���Ŀ� �����ּ���.");
			//e.printStackTrace();
		}

	}
	
}

//Date date = new Date();