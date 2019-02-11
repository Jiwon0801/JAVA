package edu.autocar.tourguide.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.SearchCategory;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.view.TourGuideView;

public class SearchCommand implements Command {
	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuideView view = new TourGuideView();
	
	@Override
	public void execute() throws Exception {
		System.out.println("검색 영역 선택");

		String[] categories = {
			"이름", "권역", "도시", "주소", "내용" 	
		};
		
		String[] fields = {
				"name", "region", "city", "address", "content" 	
		};
		
		int sel = Input.selectList(categories);
		String category = fields[sel];
		String keyword = Input.getString("검색어 : ");
		
		Map<String,String>map = new HashMap<>();
		map.put("category", category);
		map.put("keyword", keyword);
		
		List<TourGuide> list = dao.search(map);
		view.printList(list);
		
	}

}
