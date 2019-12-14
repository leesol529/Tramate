package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ActivitydataDto;
import com.tramate.service.GuideService;

@RestController
public class GuideController {

	@Autowired
	private GuideService service;

	@GetMapping("/guidetotal")
	public int guideTotalCount() {

		return service.getTotalCount();
	}

	// Spot과 관련된 guide의 총 수를 구하는 메소드
	@GetMapping("/guideTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {

		return service.getTotalCountRelatedSpot("다낭");

	}

	// Spot과 관련된 Guide를 랜덤으로 가져오는 메소드
	//추후 spot, start ,end의 값을 조정해야 한다.
	@GetMapping("/guideRandom")
	public List<ActivitydataDto> guideRandomList() {

		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "다낭");
		map.put("start","0");
		map.put("end","5");
		
		return service.guideRandomList(map);
	}

}
