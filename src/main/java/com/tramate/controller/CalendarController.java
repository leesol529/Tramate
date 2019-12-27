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
}






