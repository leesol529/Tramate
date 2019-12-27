package com.tramate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.CalendarDto;
import com.tramate.dto.ScheduleDto;
import com.tramate.service.CalendarService;

@RestController
@CrossOrigin
public class CalendarController {

	@Autowired
	CalendarService service;
	
	@RequestMapping(value="/guide/getSchedule", method=RequestMethod.GET)
	public List<CalendarDto> getSchedule(@RequestParam int num){
		return service.getSchedule(num);
	}
	
	
	//calendar table에 insert
	@RequestMapping(value="/calendar/insert", method=RequestMethod.POST)
	public void insertSchedule(@RequestBody CalendarDto dto) {
		service.insertSchedule(dto);
	}
	
	//수락한 스케줄 가져오기 
	@RequestMapping(value="/guide/schedule/fixed", method=RequestMethod.POST)
	public List<ScheduleDto> getFixedSchedule(@RequestParam int gnum) {
		return service.getFixedSchedule(gnum);
	}
	
	//수락 대기중인 스케줄 가져오기 
	@RequestMapping(value="/guide/schedule/new", method=RequestMethod.POST)
	public List<ScheduleDto> getNewSchedule(@RequestParam int gnum) {
		return service.getNewSchedule(gnum);
	}
}






