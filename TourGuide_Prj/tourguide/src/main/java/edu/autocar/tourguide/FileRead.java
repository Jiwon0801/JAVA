package edu.autocar.tourguide;

import java.io.BufferedReader;
import java.io.FileReader;

import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.TourGuide;

public class FileRead {
	public static void main(String[] args) {
		String line=null;
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try(
			FileReader fr = new FileReader("c:/temp/tour100.txt");
			BufferedReader br = new BufferedReader(fr);
		){
			
			br.readLine();	// 첫 줄 스킵
			while((line=br.readLine())!=null) {
				line = line.replace("\"", "");		// 큰 따움표 제거
				String[] tokens = line.split("\t");
				TourGuide tg = TourGuide.builder()
									.name(tokens[0])
									.region(tokens[1])
									.city(tokens[2])
									.content(tokens[3])
									.address(tokens[4])
									.homepage(tokens[5])
									.build();
				
				dao.insert(tg);
			}
			ConnectionProvider.getSqlSession().commit();
			System.out.println("작업완료");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
