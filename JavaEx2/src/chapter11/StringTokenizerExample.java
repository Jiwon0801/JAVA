package chapter11;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String text = "È«±æµ¿/ÀÌ¼öÈ«//.¹Ú¿¬¼ö";
		
		//how1
		StringTokenizer st = new StringTokenizer(text, "/.");
		int count = st.countTokens();
		for (int i = 0; i < count; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		
		//how2
		st = new StringTokenizer(text, "/.", true);
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		
		String str = "12+32*152-7";
		StringTokenizer tk = new StringTokenizer(str, "+*/-",true);
		while(tk.hasMoreTokens()) {
			String token1 = tk.nextToken();
			System.out.println(token1);
		}
	}

}
