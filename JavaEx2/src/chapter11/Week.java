package chapter11;

public enum Week {
	SUNDAY("일요일"),
	MONDAY("월요일"),
	TUESDAY("화요일"),
	WEDNESDAY("수요일"),
	THURSDAY("목요일"),
	FRIDAY("금요일"),
	SATURDAY("토요일");
	
	final private String name;
	
	Week(String name){
		this.name= name;
	}
	String value() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
