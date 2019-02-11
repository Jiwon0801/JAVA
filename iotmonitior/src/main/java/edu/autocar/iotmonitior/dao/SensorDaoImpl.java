package edu.autocar.iotmonitior.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.iotmonitior.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SensorDaoImpl implements SensorDao {
	
	static final String namespace = "edu.autocar.iotmonitor.dao.SensorDao.";
	SqlSession sqlSession;
	
	private static SensorDao dao = new SensorDaoImpl();
	
	public SensorDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}
	
	//싱글톤으로 dao 객체
	public static SensorDao getDao( ) {
		return dao;
	}

	public List<Sensor> selectList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectList");
		
	}

	public Sensor selectOne(Long sensorId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOne", sensorId);
	}

	public int insert(Sensor member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "insert", member);
	}

	public int update(Sensor member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "update", member);
	}

	public int delete(Long member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "delete", member);
	}

}
