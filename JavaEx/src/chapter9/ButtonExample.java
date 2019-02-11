package chapter9;

import chapter9.Button.OnclickListener;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();

		btn.setOnClickListener(new CallListener());
		btn.touch();
		btn.setOnClickListener(new MessageListener());
		btn.touch();

		// 익명 구현 객체로 어플리케이션을 종료
		btn.setOnClickListener(new OnclickListener() {

			@Override
			public void onClick() {
				System.out.println("어플리케이션을 종료합니다.");
				System.exit(0);
			}
		});
		btn.touch();

		// 익명 구현 객체로 팩스 보내기
		btn.setOnClickListener(new OnclickListener() {

			@Override
			public void onClick() {
				System.out.println("팩스를 보냅니다.");
			}
		});
		btn.touch();

	}
}
