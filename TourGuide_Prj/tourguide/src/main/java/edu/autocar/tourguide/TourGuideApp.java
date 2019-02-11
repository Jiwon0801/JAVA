package edu.autocar.tourguide;

import edu.autocar.base.Application;
import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.menu.MenuItem;
import edu.autocar.tourguide.command.DetailViewCommand;
import edu.autocar.tourguide.command.ExitCommand;
import edu.autocar.tourguide.command.PaginationCommand;
import edu.autocar.tourguide.command.RegionListCommand;
import edu.autocar.tourguide.command.ScheduleCommand;
import edu.autocar.tourguide.command.SearchCommand;

public class TourGuideApp extends Application {

	@Override
	protected void createMenu(MenuBar menu) {
		// 메뉴 구성
		menu.add(new MenuItem("목록", "l", new PaginationCommand()));
		menu.add(new MenuItem("보기", "v", new DetailViewCommand()));
		menu.add(new MenuItem("권역별", "r", new RegionListCommand()));
		menu.add(new MenuItem("검색", "s", new SearchCommand()));
		menu.add(new MenuItem("스케줄", "h", new ScheduleCommand()));
		menu.add(new MenuItem("종료", "q", new ExitCommand()));
	}
		
	public static void main(String[] args) {
		TourGuideApp app = new TourGuideApp();
		app.run();
	}
}
