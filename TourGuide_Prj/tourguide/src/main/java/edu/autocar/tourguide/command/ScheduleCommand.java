package edu.autocar.tourguide.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.view.TourGuideView;
import lombok.AllArgsConstructor;

public class ScheduleCommand implements Command {
	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuideView view = new TourGuideView();
	
	@AllArgsConstructor
	class Schedule{
		String title;
		String dates;
		List<TourGuide> list;
		String fileName;	
	}
	
	@Override
	public void execute() throws Exception {
		Schedule schedule = createSchedule();
		save(schedule);
	}
	
	private Schedule createSchedule() throws Exception {
		String title  = Input.getString("제목 : ");
		String dates  = Input.getString("일정 : ");
		String tours = Input.getString("여행지 : ");
		String fileName = Input.getString("파일명 : ");
		
		String [] nums = tours.split(",");
		List<TourGuide> list = getTourGuides(nums);
		
		return new Schedule(title, dates, list, fileName);
	}

	private List<TourGuide> getTourGuides(String[] nums) throws Exception{
		List<TourGuide> list = new ArrayList<>();
		
		for(String numStr : nums) {
			numStr = numStr.trim();
			int num = Integer.parseInt(numStr);
			TourGuide tg = dao.selectOne(num);
			list.add(tg);
		}
		
		return list;
	}
	

	private void save(Schedule schedule) throws Exception{
		File file = new File("c:/temp", schedule.fileName + ".txt");
		try(
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);	
		){
			ps.println("제목 : " + schedule.title);
			ps.println("일정 : " + schedule.dates);
			ps.println();
			for(int i=0 ; i<schedule.list.size(); i++) {
				TourGuide tg = schedule.list.get(i);
				ps.printf("여행지 [%d] --------------------------------------------\r\n", i+1);
				view.printDetail(ps, tg);
				ps.println("-------------------------------------------------------");
				ps.println();
				ps.println();
			}			
		}
	}

}
