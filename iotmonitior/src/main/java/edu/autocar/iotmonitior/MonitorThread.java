package edu.autocar.iotmonitior;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;

import edu.autocar.iotmonitior.dao.SensorDao;
import edu.autocar.iotmonitior.dao.SensorDaoImpl;
import edu.autocar.iotmonitior.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class MonitorThread extends Thread {
	Socket socket;

	public MonitorThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 수신용 Reader 만들기
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String msg = r.readLine();
			Gson gson = new Gson();
			Sensor[] sensors = gson.fromJson(msg, Sensor[].class);

			
			SensorDao dao = SensorDaoImpl.getDao();
			for (Sensor sensor : sensors) {
				System.out.println(sensor);
				dao.insert(sensor);
			}
			
			ConnectionProvider.getSqlSession().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
