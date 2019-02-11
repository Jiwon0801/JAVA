package edu.autocar.JDBC;

import com.google.gson.Gson;

public class ObjectToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Gson gson = new Gson();
			
			/*			
			 * // 전송
			Sensor sensor = new Sensor("humi", 10.2);
			System.out.println(sensor);
			String json = gson.toJson(sensor);
			
			System.out.println(json);
			*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
