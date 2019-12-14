package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.GuideDto;
import com.tramate.service.GuideService;

@RestController
@CrossOrigin
public class GuideController {

	@Autowired
	private GuideService service;

	@GetMapping("/guidetotal")
	public int guideTotalCount() {

		return service.getTotalCount();
	}

	// Spot�� ���õ� guide�� �� ���� ���ϴ� �޼ҵ�
	@GetMapping("/guideTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {

		return service.getTotalCountRelatedSpot("�ٳ�");

	}

	// Spot�� ���õ� Guide�� �������� �������� �޼ҵ�
	//���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	@GetMapping("/guideRandom")
	public List<ActivitydataDto> guideRandomList() {

		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "�ٳ�");
		map.put("start","0");
		map.put("end","5");
		
		return service.guideRandomList(map);
	}
	
	@RequestMapping(value = "/guide/inputdata", method = RequestMethod.POST)
	public @ResponseBody void insertGuideData(@RequestBody GuideDto dto) {
		
		System.out.println(dto);
		service.insertGuide(dto);
	}

}
