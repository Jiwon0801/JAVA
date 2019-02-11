package edu.autocar.JDBC;

import com.google.gson.Gson;

public class JsonToObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//문자열 수신
			String json = FileUtil.readAll("c:/temp/sensor.json");
			
			Gson gson = new Gson();
			
			//단일 객체 복원
			Sensor sensor = gson.fromJson(json, Sensor.class);
			System.out.println(sensor);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
