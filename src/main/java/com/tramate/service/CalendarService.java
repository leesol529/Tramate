package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.CalendarDao;
import com.tramate.dto.CalendarDto;
import com.tramate.dto.ScheduleDto;

@Service
public class CalendarService {

	@Autowired
	CalendarDao dao;
	
	public List<CalendarDto> getSchedule(int num){
		return dao.getSchedule(num);
	}
	
	public void insertSchedule(CalendarDto dto) {
		dao.insertSchedule(dto);
	}
	
	//수락한 스케줄 가져오기 
	public List<ScheduleDto> getFixedSchedule(int gnum) {
		return dao.getFixedSchedule(gnum);
	}
	
	//수락 대기중인 스케줄 가져오기 
	public List<ScheduleDto> getNewSchedule(int gnum) {
		return dao.getNewSchedule(gnum);
	}
}
