package edu.autocar.tourguide.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.TourGuide;

public class TourGuideDaoImpl implements TourGuideDao {
	static final String namespace=
			"edu.autocar.tourguide.dao.TourGuideDao.";

	SqlSession sqlSession;
	
	public TourGuideDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}


	@Override
	public List<TourGuide> selectList() throws Exception {
		return sqlSession.selectList(namespace + "selectList");
	}

	@Override
	public TourGuide selectOne(Integer k) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", k);
	}

	@Override
	public int insert(TourGuide t) throws Exception {
		return sqlSession.insert(namespace + "insert", t);
	}


	@Override
	public int update(TourGuide t) throws Exception {
		return sqlSession.update(namespace + "update", t);
	}

	@Override
	public int delete(Integer k) throws Exception {
		return sqlSession.delete(namespace + "delete", k);

	}

	@Override
	public int getCount() throws Exception {
		return sqlSession.selectOne(namespace + "getCount");
	}

	@Override
	public List<TourGuide> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		return sqlSession.selectList(namespace + "getPage", map);
	}


	@Override
	public List<String> getRegions() throws Exception {
		return sqlSession.selectList(namespace + "getRegions");
	}


	@Override
	public List<TourGuide> search(Map<String, String> map) throws Exception {
		return sqlSession.selectList(namespace + "search", map);
	}


	@Override
	public List<TourGuide> getRegionList(String region) throws Exception {
		return sqlSession.selectList(namespace + "getRegionList", region);
	}
}
