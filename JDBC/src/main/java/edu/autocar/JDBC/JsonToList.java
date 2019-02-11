package edu.autocar.JDBC;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String json = FileUtil.readAll("c:/Temp/json_array.json");
			
			Gson gson = new Gson();
			
			Type collectionType =
					(new TypeToken<ArrayList<Sensor>>() {}).getType();
			
			List<Sensor> list= gson.fromJson(json, collectionType);
			
			System.out.println(list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}

}
