package edu.autocar.iotmonitior;

import java.util.StringTokenizer;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import edu.autocar.iotmonitior.dao.SensorDao;
import edu.autocar.iotmonitior.dao.SensorDaoImpl;
import edu.autocar.iotmonitior.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SimpleMqttCallBack implements MqttCallback{
	
	public void connectionLost(Throwable throwable) {
		System.out.println("Connection to MQTT broker lost!");
		}

	@Override
	public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(topic, "/");
		
		String owner = st.nextToken();
		String place = st.nextToken();
		String sensorType = st.nextToken();
		double value = Double.parseDouble(new String(mqttMessage.getPayload()));
		
		//System.out.println("Message received:\t"+ value);
		
		Sensor sensor = Sensor.builder().sensorType(sensorType)
										.owner(owner)
										.place(place)
										.value(value)
										.build();
		
		SensorDao dao = SensorDaoImpl.getDao();
		
		dao.insert(sensor);
		
		ConnectionProvider.getSqlSession().commit();
		
		System.out.println("====================");
		System.out.println("owner: " + owner);
		System.out.println("place: " + place);
		System.out.println("sensorType: " + sensorType);
		System.out.println("value: " + value);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
		// TODO Auto-generated method stub
		
	}
	
	

}
