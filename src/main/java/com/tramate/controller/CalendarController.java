package com.tramate.controller;

import java.util.ArrayList;
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

import com.tramate.dto.CalendarDto;
import com.tramate.dto.GuideAndTravelerDto;
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
	public List<List<GuideAndTravelerDto>> getFixedSchedule(
			@RequestParam int gnum) {
		List<List<GuideAndTravelerDto>> list = new ArrayList<List<GuideAndTravelerDto>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		
		//연결된 tnum 전체 구하기 
		List<Integer> tnums = service.getFixedTnum(gnum);
		List<GuideAndTravelerDto> myList = new ArrayList<>();
		for(int tnum: tnums) {
			map.put("tnum", tnum);
			myList = service.getFixedSchedule(map);
			list.add(myList);
		}
		return list;
	}
	
	//수락 대기중인 스케줄 가져오기 
	@RequestMapping(value="/guide/schedule/new", method=RequestMethod.POST)
	public List<List<GuideAndTravelerDto>> getNewSchedule(
			@RequestParam int gnum) {
		List<List<GuideAndTravelerDto>> list = new ArrayList<List<GuideAndTravelerDto>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		
		//연결된 tnum 전체 구하기 
		List<Integer> tnums = service.getWaitTnum(gnum);
		List<GuideAndTravelerDto> myList = new ArrayList<>();
		for(int tnum: tnums) {
			map.put("tnum", tnum);
			myList = service.getNewSchedule(map);
			list.add(myList);
		}
		return list;
	}
	
	//일정 수락
	@RequestMapping(value="/guide/accept", method=RequestMethod.POST)
	public void acceptSchedule(@RequestParam int num) {
		service.acceptSchedule(num);
	}
	
	//일정 거절
	@RequestMapping(value="/guide/decline", method=RequestMethod.POST)
	public void declineSchedule(@RequestParam int num) {
		service.declineSchedule(num);
	}
	
	//특정 가이드와 특정 여행자의 여행 정보 가져오기 
	@RequestMapping(value="/guide/schedule/detail", method=RequestMethod.POST)
	public List<GuideAndTravelerDto> getSpecificSchedule(
			@RequestParam int gnum,
			@RequestParam int tnum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		map.put("tnum", tnum);
		return service.getSpecificSchedule(map);
	}
	
}






