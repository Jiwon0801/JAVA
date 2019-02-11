package edu.autocar.contact;

public class ContactEx {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();

		list.add(new Contact("ȫ�浿", "hong@naver.com", "010-1111-1111", "Korea"));
		list.add(new Contact("�Ѹ�", "dooly@naver.com", "010-1111-2222", "France"));
		list.add(new Contact("������", "micol@naver.com", "010-1111-3333", "Brazil"));
		list.add(new Contact("�����", "do@naver.com", "010-1111-4444", "Canada"));
		list.add(new Contact("��浿", "go@naver.com", "010-1111-5555", "China"));

		Contact c = find(list);
		if (c != null) {
			System.out.println(c.toString());
		} else {
			System.out.println("�������� �ʽ��ϴ�.");
		}
	}

	public static Contact find(DoubleLinkedList list) {
		String name = Input.getString("�̸� : ");
		for (int i = 0; i < list.getSize(); i++) {
			Contact c = list.get(i);
			if (name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}
}
