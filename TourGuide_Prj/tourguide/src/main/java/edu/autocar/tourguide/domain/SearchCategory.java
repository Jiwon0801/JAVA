package edu.autocar.tourguide.domain;

public enum SearchCategory {
	REGION("권역"), 
	NAME("권역"),
	CITY("도시"),
	CONTENT("내용"),
	ADDRESS("주소");
	
	private String value;
	private SearchCategory(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
	
	public static String[] toArray() {
		SearchCategory[] categories = SearchCategory.values();
		String[] arr = new String[categories.length];
		for(int i=0;i<categories.length; i++)
			arr[i] = categories[i].value();
			
		return arr;
	}
}
