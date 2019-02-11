package chapter9;

public class Button {
	OnclickListener listener;

	void setOnClickListener(OnclickListener listener) {
		this.listener = listener;
	}

	void touch() {
		listener.onClick();
	}

	interface OnclickListener {
		void onClick();
	}
}
