package edu.autocar.tourguide;

import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class SelectTest {
	public static void main(String[] args) {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			TourGuide tg =  dao.selectOne(1);
			System.out.println(tg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
