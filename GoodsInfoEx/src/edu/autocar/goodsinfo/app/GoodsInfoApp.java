package edu.autocar.goodsinfo.app;

import edu.autocar.base.Application;
import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.menu.MenuItem;
import edu.autocar.goodsinfo.command.AddCommand;
import edu.autocar.goodsinfo.command.DeleteCommand;
import edu.autocar.goodsinfo.command.EditCommand;
import edu.autocar.goodsinfo.command.ListCommand;
import edu.autocar.goodsinfo.command.ExitCommand;

public class GoodsInfoApp extends Application {
	@Override
	protected void createMenu(MenuBar menu) {
		menu.add(new MenuItem("목록", "l", new ListCommand()));
		menu.add(new MenuItem("추가", "a", new AddCommand()));
		menu.add(new MenuItem("수정", "e", new EditCommand()));
		menu.add(new MenuItem("삭제", "d", new DeleteCommand()));
		menu.add(new MenuItem("종료", "q", new ExitCommand()));
	}
	
	public static void main(String[] args) {
		Application app = new GoodsInfoApp();
		app.run();
	}
	
}
