package edu.autocar.tourguide.view;

import java.io.PrintStream;
import java.util.List;

import edu.autocar.tourguide.domain.TourGuide;

public class TourGuideView {

	public void printPage(int total, int page, List<TourGuide> list) {
		// 목록 출력
		printList(list);
		
		// 페이지 번호 출력
		for(int i=1; i<=total ; i++) {
			if(i== page) {
				System.out.print("[" + i + "] ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	public void printList(List<TourGuide> list) {
		System.out.println("----------------------------------");
		for(TourGuide tg : list) {
			System.out.printf("[%3d] %s | %s | %s\n",
					tg.getNum(), tg.getRegion(), tg.getCity(), tg.getName());
		}
		
		System.out.println("----------------------------------");
	}

	public void printDetail(TourGuide tg) {
		System.out.println("----------------------------------");
		printDetail(System.out, tg);	
		System.out.println("----------------------------------");
	}
	
	public void printDetail(PrintStream ps, TourGuide tg) {
		ps.println("관광지명 : " + tg.getName());
		ps.println("시도 : " + tg.getRegion());
		ps.println("지역 : " + tg.getCity());
		ps.println("위치 : " + tg.getAddress());
		ps.println("홈페이지 : "  + tg.getHomepage());
		ps.println("내용 : " + tg.getContent());		
	}
}
