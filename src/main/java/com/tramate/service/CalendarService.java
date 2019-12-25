package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.CalendarDao;
import com.tramate.dto.CalendarDto;

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
}
