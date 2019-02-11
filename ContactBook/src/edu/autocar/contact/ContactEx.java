package edu.autocar.contact;

public class ContactEx {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();

		list.add(new Contact("홍길동", "hong@naver.com", "010-1111-1111", "Korea"));
		list.add(new Contact("둘리", "dooly@naver.com", "010-1111-2222", "France"));
		list.add(new Contact("마이콜", "micol@naver.com", "010-1111-3333", "Brazil"));
		list.add(new Contact("도우너", "do@naver.com", "010-1111-4444", "Canada"));
		list.add(new Contact("고길동", "go@naver.com", "010-1111-5555", "China"));

		Contact c = find(list);
		if (c != null) {
			System.out.println(c.toString());
		} else {
			System.out.println("존재하지 않습니다.");
		}
	}

	public static Contact find(DoubleLinkedList list) {
		String name = Input.getString("이름 : ");
		for (int i = 0; i < list.getSize(); i++) {
			Contact c = list.get(i);
			if (name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}
}
