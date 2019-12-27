package com.tramate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ScheduleDto;
import com.tramate.service.ScheduleService;

@RestController
@CrossOrigin
public class ScheduleController {

	@Autowired
	ScheduleService service;
	
	//(해당 gnum과 tnum이 묶인) 해당 가이드와 여행자의 schedule 가져오기 
	@RequestMapping(value="/guide/profile/mySchedule", method=RequestMethod.POST)
	public List<ScheduleDto> getSchedule(
			@RequestParam int gnum,
			@RequestParam int tnum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		map.put("tnum", tnum);
		
		return service.getSchedule(map);
	}
	
	//schedule 테이블에 정보 입력하기 
	@RequestMapping(value="/traveler/choice", method=RequestMethod.POST)
	public void insertSchedule(@RequestBody List<ScheduleDto> list) {
		//System.out.println(list);
		for(ScheduleDto dto: list) {
			service.insertSchedule(dto);
		}
	}
	
}









