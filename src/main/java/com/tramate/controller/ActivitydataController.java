package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.javafx.collections.MappingChange.Map;
import com.tramate.dto.ActivitydataDto;
import com.tramate.service.ActivitydataService;

@RestController
public class ActivitydataController {

	@Autowired
	private ActivitydataService service;

	//Spot과 관련된 Activity의 총 갯수를 가져오는 메소드
	
	@GetMapping("/activityTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {

		return service.getTotalCountRelatedSpot("다낭");

	}

	// Spot과 관련된 Activity를 랜덤으로 6개 가져오는 메소드
	//추후 spot, start ,end의 값을 조정해야 한다.
	
	@GetMapping("/activityRandom")
	public List<ActivitydataDto> activityRandomList() {
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "다낭");
		map.put("start","0");
		map.put("end","5");
		
		return service.activityRandomList(map);
	}
}
