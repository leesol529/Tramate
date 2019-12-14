package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.SpotdataDto;
import com.tramate.service.SpotdataService;

@RestController
public class SpotdataController {

	@Autowired
	private SpotdataService service;
	
	//Spot과 관련된 관광명소의 총 갯수를 가져오는 메소드
	@GetMapping("/spotTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {
		
		return service.getTotalCountRelatedSpot("다낭");
				
	}
	
	//Spot과 관련된 관광명소를 랜덤으로 가져오는 메소드
	//추후 spot, start ,end의 값을 조정해야 한다.
	@GetMapping("/spotRandom")
	public List<SpotdataDto> spotRandomList(){
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "다낭");
		map.put("start","0");
		map.put("end","5");
		
		return service.spotRandomList(map);
	}
}
