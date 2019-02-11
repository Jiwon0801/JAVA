package edu.autocar.JDBC;

import java.util.Arrays;

import com.google.gson.Gson;

public class JsonToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String json = FileUtil.readAll("c:/Temp/json_array.json");
			
			Gson gson = new Gson();
			
			//배열로 복원하기
			Sensor[] arr = gson.fromJson(json, Sensor[].class);
			System.out.println(Arrays.toString(arr));
			
			//배열을 JSON으로 변환
			String json_arr = gson.toJson(arr);
			System.out.println(json_arr);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
