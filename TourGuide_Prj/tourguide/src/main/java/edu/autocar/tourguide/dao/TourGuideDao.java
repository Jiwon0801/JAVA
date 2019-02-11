package edu.autocar.tourguide.dao;

import java.util.List;
import java.util.Map;

import edu.autocar.base.database.CrudDao;
import edu.autocar.base.database.PaginationDao;
import edu.autocar.tourguide.domain.TourGuide;

public interface TourGuideDao 
	extends CrudDao<TourGuide, Integer>, PaginationDao<TourGuide> {
	
	List<String> getRegions() throws Exception;
	List<TourGuide> getRegionList(String region) throws Exception;
	List<TourGuide> search(Map<String, String> map) throws Exception;
}
