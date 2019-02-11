package edu.autocar.iotmonitior;

import java.util.List;

import edu.autocar.iotmonitior.dao.SensorDao;
import edu.autocar.iotmonitior.dao.SensorDaoImpl;
import edu.autocar.iotmonitior.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SensorDaoTest {
	
	public static void main(String[] args) {
		selectListTest();
		ConnectionProvider.getSqlSession().close();
	}
	
	public static void selectListTest() {
		//SensorDao dao = new SensorDaoImpl();
		
		SensorDao dao = SensorDaoImpl.getDao();
		
		try {
			List<Sensor> list = dao.selectList();
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
