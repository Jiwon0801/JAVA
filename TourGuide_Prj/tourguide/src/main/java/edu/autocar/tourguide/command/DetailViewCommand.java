package edu.autocar.tourguide.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.view.TourGuideView;

public class DetailViewCommand implements Command {
	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuideView view = new TourGuideView();
	
	@Override
	public void execute() throws Exception {
		int num = Input.getInt("항목 선택 : ");
		TourGuide tg = dao.selectOne(num);
		if(tg!=null) {
			view.printDetail(tg);
		} else {
			System.out.println(num + "이 존재하지 않습니다.");
		}
	}
}
