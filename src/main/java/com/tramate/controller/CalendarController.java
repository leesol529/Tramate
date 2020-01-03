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
	
	
	//calendar table�뿉 insert
	@RequestMapping(value="/calendar/insert", method=RequestMethod.POST)
	public void insertSchedule(@RequestBody CalendarDto dto) {
		service.insertSchedule(dto);
	}
	
	//�닔�씫�븳 �뒪耳�以� 媛��졇�삤湲� 
	@RequestMapping(value="/guide/schedule/fixed", method=RequestMethod.POST)
	public List<List<GuideAndTravelerDto>> getFixedSchedule(
			@RequestParam int gnum) {
		List<List<GuideAndTravelerDto>> list = new ArrayList<List<GuideAndTravelerDto>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		
		//�뿰寃곕맂 tnum �쟾泥� 援ы븯湲� 
		List<Integer> tnums = service.getFixedTnum(gnum);
		List<GuideAndTravelerDto> myList = new ArrayList<GuideAndTravelerDto>();
		for(int tnum: tnums) {
			map.put("tnum", tnum);
			myList = service.getFixedSchedule(map);
			list.add(myList);
		}
		return list;
	}
	
	//�닔�씫 ��湲곗쨷�씤 �뒪耳�以� 媛��졇�삤湲� 
	@RequestMapping(value="/guide/schedule/new", method=RequestMethod.POST)
	public List<List<GuideAndTravelerDto>> getNewSchedule(
			@RequestParam int gnum) {
		List<List<GuideAndTravelerDto>> list = new ArrayList<List<GuideAndTravelerDto>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum", gnum);
		
		//�뿰寃곕맂 tnum �쟾泥� 援ы븯湲� 
		List<Integer> tnums = service.getWaitTnum(gnum);
		List<GuideAndTravelerDto> myList = new ArrayList<>();
		for(int tnum: tnums) {
			map.put("tnum", tnum);
			myList = service.getNewSchedule(map);
			list.add(myList);
		}
		return list;
	}
	
	//�씪�젙 �닔�씫
	@RequestMapping(value="/guide/accept", method=RequestMethod.POST)
	public void acceptSchedule(@RequestParam int num) {
		service.acceptSchedule(num);
	}
	
	//�씪�젙 嫄곗젅
	@RequestMapping(value="/guide/decline", method=RequestMethod.POST)
	public void declineSchedule(@RequestParam int num) {
		service.declineSchedule(num);
	}
	
	//�듅�젙 媛��씠�뱶�� �듅�젙 �뿬�뻾�옄�쓽 �뿬�뻾 �젙蹂� 媛��졇�삤湲� 
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






