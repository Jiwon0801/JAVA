package edu.autocar.goodsinfo.app;

import edu.autocar.base.Application;
import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.menu.MenuItem;
import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.command.ExitCommand;
import edu.autocar.goodsinfo.command.MemberAddCommand;
import edu.autocar.goodsinfo.command.MemberDeleteCommand;
import edu.autocar.goodsinfo.command.MemberEditCommand;
import edu.autocar.goodsinfo.command.MemberListCommand;
import edu.autocar.goodsinfo.dao.MemberDao;
import edu.autocar.goodsinfo.domain.Member;

public class MemberApp extends Application {

	@Override
	protected void createMenu(MenuBar menu) {
		menu.add(new MenuItem("목록", "l", new MemberListCommand()));
		menu.add(new MenuItem("추가", "a", new MemberAddCommand()));
		menu.add(new MenuItem("수정", "e", new MemberEditCommand()));
		menu.add(new MenuItem("삭제", "d", new MemberDeleteCommand()));
		menu.add(new MenuItem("종료", "q", new ExitCommand()));
	}

	private void login() throws Exception {
		String userId = Input.getString("아이디 : ");
		String password = Input.getString("비밀번호 : ");

		MemberDao dao = MemberDao.getInstance();
		Member m = dao.selectOne(userId);
		if (m == null) {
			throw new Exception(userId + " 가 존재하지 않습니다.");
		}
		if (!password.equals(m.getPassword())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}	
	}

	@Override
	public void run() {
		try {
			login();
			super.run(); 
		} catch (Exception e) {
			System.out.println("로그인 실패");
			System.out.println(e.getMessage());
		}
			
	}

	public static void main(String[] args) {
		Application app = new MemberApp();
		app.run();
	}

}
