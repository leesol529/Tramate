package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.CalendarDao;
import com.tramate.dto.CalendarDto;
import com.tramate.dto.GuideAndTravelerDto;

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
	
	//수락된 tnum 가져오기
	public List<Integer> getFixedTnum(int gnum){
		return dao.getFixedTnum(gnum);
	}
	
	//대기중인 tnum 가져오기 
	public List<Integer> getWaitTnum(int gnum){
		return dao.getWaitTnum(gnum);
	}
	
	//수락한 스케줄 가져오기 
	public List<GuideAndTravelerDto> getFixedSchedule(Map<String, Integer> map) {
		return dao.getFixedSchedule(map);
	}
	
	//수락 대기중인 스케줄 가져오기 
	public List<GuideAndTravelerDto> getNewSchedule(Map<String, Integer> map) {
		return dao.getNewSchedule(map);
	}
}
