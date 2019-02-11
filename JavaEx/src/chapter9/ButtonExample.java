package chapter9;

import chapter9.Button.OnclickListener;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();

		btn.setOnClickListener(new CallListener());
		btn.touch();
		btn.setOnClickListener(new MessageListener());
		btn.touch();

		// �͸� ���� ��ü�� ���ø����̼��� ����
		btn.setOnClickListener(new OnclickListener() {

			@Override
			public void onClick() {
				System.out.println("���ø����̼��� �����մϴ�.");
				System.exit(0);
			}
		});
		btn.touch();

		// �͸� ���� ��ü�� �ѽ� ������
		btn.setOnClickListener(new OnclickListener() {

			@Override
			public void onClick() {
				System.out.println("�ѽ��� �����ϴ�.");
			}
		});
		btn.touch();

	}
}
