package edu.autocar.contact.model;

import edu.autocar.base.Application;
import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.menu.MenuItem;

public class ContactApp extends Application {
	@Override
	protected void createMenu(MenuBar menu) {
		//메뉴 구성
		menu.add(new MenuItem("열기", "o", new OpenCommand()));
		menu.add(new MenuItem("목록", "l", new ContactListCommand()));
		menu.add(new MenuItem("추가", "a", new ContactAddCommand()));
		menu.add(new MenuItem("저장", "s", new SaveCommand()));
		menu.add(new MenuItem("종료", "q", new ExitCommand()));

	}
	public static void main(String[] args) {
		ContactApp app = new ContactApp();
		app.run();
	}
}
