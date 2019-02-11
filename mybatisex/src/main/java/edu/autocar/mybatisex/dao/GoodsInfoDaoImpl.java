package edu.autocar.mybatisex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.GoodsInfo;

public class GoodsInfoDaoImpl implements GoodsInfoDao {
	static final String namespace = "edu.autocar.mybatisex.dao.GoodsInfoDao.";
	SqlSession sqlSession;

	public GoodsInfoDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}
	@Override
	public List<GoodsInfo> selectList() throws Exception {
		return sqlSession.selectList(namespace + "selectList");		
	}

	@Override
	public GoodsInfo selectOne(String k) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", k);
	}

	@Override
	public int insert(GoodsInfo t) throws Exception {
		return sqlSession.insert(namespace + "insert", t);
	}

	@Override
	public int update(GoodsInfo t) throws Exception {
		return sqlSession.update(namespace + "update", t);
	}

	@Override
	public int delete(String k) throws Exception {
		return sqlSession.delete(namespace + "delete", k);
	}

	@Override
	public int getCount() throws Exception {
		return sqlSession.selectOne(namespace + "getCount");
	}

	@Override
	public List<GoodsInfo> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace + "getPage", map);
	}
	
}
