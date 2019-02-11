package edu.autocar.tourguide.command;

import java.util.List;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.view.TourGuideView;

public class PaginationCommand implements Command {
	final static int NUM_PER_PAGE = 10;	// 1 페이지당 출력 건수 
	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuideView view = new TourGuideView();
	
	@Override
	public void execute() throws Exception {
		int total = (int)Math.ceil(dao.getCount()/NUM_PER_PAGE);
		int page = 1;
		while(true) {
			List<TourGuide> list = getPage(page);
			view.printPage(total, page, list);
			page = getPageNum(page);
			if(page==-1) {	// 페이지네이션 종료
				System.out.println("\n\n");
				break;
			}
			if(page==0) page = 1;
			if(page>total) page=total;
		}
	}
	
	public int getPageNum(int page) {
		String sel = Input.getString("선택(p,n,숫자,q) : ");
		switch(sel) {
		case "n": page++; break;
		case "p": page--; break;
		case "q": page = -1; break;
		default :
			page = Integer.parseInt(sel);
		}
		return page;
	}
	
	public List<TourGuide> getPage(int page) throws Exception {
		int start = (page-1)*NUM_PER_PAGE;
		int end = start + NUM_PER_PAGE-1;		
		return dao.getPage(start, end);
	}
}
