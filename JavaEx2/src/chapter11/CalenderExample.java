package chapter11;

import java.time.temporal.WeekFields;
import java.util.Calendar;

public class CalenderExample {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);

		int week = now.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		
		Week w = Week.values()[week - 1];
//		System.out.println(w);
//		switch (week) {
//		case Calendar.MONDAY:
//			strWeek = "��";
//			break;
//		case Calendar.TUESDAY:
//			strWeek = "ȭ";
//			break;
//		case Calendar.WEDNESDAY:
//			strWeek = "��";
//			break;
//		case Calendar.THURSDAY:
//			strWeek = "��";
//			break;
//		case Calendar.FRIDAY:
//			strWeek = "��";
//			break;
//		case Calendar.SATURDAY:
//			strWeek = "��";
//			break;
//		default:
//			strWeek = "��";
//		}
		

		int amPm = now.get(Calendar.AM_PM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "����";
		} else {
			strAmPm = "����";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.println(year + "�� " + (month + 1) + "�� " + day + "�� " + w);
	}

}
