package chapter11;

import java.util.Arrays;
import java.util.Comparator;

public class SortExample {
	public static void main(String[] args) {
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		int ix = Arrays.binarySearch(scores, 99);
		System.out.println("Ã£Àº ÀÎµ¦½º : " + ix);

		String[] names = { "È«±æµ¿", "¹Úµ¿¼ö", "±è¹Î¼ö" };
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		ix = Arrays.binarySearch(names, "È«±æµ¿");
		System.out.println("Ã£Àº ÀÎµ¦½º : " + ix);

//		Member1[] members = { new Member1("È«±æµ¿", 28), new Member1("¹Úµ¿¼ö", 30), new Member1("±è¹Î¼ö", 19) };

//		Comparator<Member1> comp = new Comparator<Member1>() {
//			@Override
//			public int compare(Member1 o1, Member1 o2) {
//				return o1.age - o2.age;
//			}
//		};

//		Arrays.sort(members);
//		Arrays.sort(members, comp);
		
		Member1 m1 = new Member1("È«±æµ¿", 28);
		Member1 m2 = new Member1("¹Úµ¿¼ö", 30);
		Member1 m3 = new Member1("±è¹Î¼ö", 17);
		
		Member1[] members = { m1,m2,m3 };
		
		Arrays.sort(members, new Comparator<Member1>() {
			@Override
			public int compare(Member1 o1, Member1 o2) {
				return o1.age-o2.age;
			}
		});

		System.out.println(Arrays.toString(members));
		
		ix = Arrays.binarySearch(members, m3);
		System.out.println("Ã£Àº ÀÎµ¦½º : " + ix);
	}
}
