package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.SpotdataDto;
import com.tramate.service.SpotdataService;

@RestController
public class SpotdataController {

	@Autowired
	private SpotdataService service;
	
	//Spot�� ���õ� ��������� �� ������ �������� �޼ҵ�
	@GetMapping("/spotTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {
		
		return service.getTotalCountRelatedSpot("�ٳ�");
				
	}
	
	//Spot�� ���õ� ������Ҹ� �������� �������� �޼ҵ�
	//���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	@GetMapping("/spotRandom")
	public List<SpotdataDto> spotRandomList(){
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "�ٳ�");
		map.put("start","0");
		map.put("end","5");
		
		return service.spotRandomList(map);
	}
	
	@PostMapping(value="/guide/choice/attraction_input")
	public void insertAttractionList(@RequestBody List<SpotdataDto> list) {
		for(SpotdataDto dto: list) {
			System.out.println(dto);
			service.insertSpotData(dto);
		}
	}
}
