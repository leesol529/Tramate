package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.ScheduleDao;
import com.tramate.dto.ScheduleDto;

@Service
public class ScheduleService {

	@Autowired
	ScheduleDao dao;
	
	public List<ScheduleDto> getSchedule(Map<String, Integer> map){
		
		return dao.getSchedule(map);
	}
	
	public void insertSchedule(ScheduleDto dto) {
		dao.insertSchedule(dto);
	}
}
