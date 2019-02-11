package edu.autocar.tourguide.command;

import java.util.List;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.view.TourGuideView;

public class RegionListCommand implements Command {
	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuideView view = new TourGuideView();
	
	@Override
	public void execute() throws Exception {
		// 권역 목록 얻기
		List<String> regions = dao.getRegions();
		// 권역 선택
		int sel = Input.selectList(regions);
		
		// 선태 권역의 내용 얻기 
		List<TourGuide> list = dao.getRegionList(regions.get(sel));
		view.printList(list);
	}
}





