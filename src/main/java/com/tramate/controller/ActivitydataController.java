package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.javafx.collections.MappingChange.Map;
import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.SpotdataDto;
import com.tramate.service.ActivitydataService;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class ActivitydataController {

	@Autowired
	private ActivitydataService service;

	//Spot�� ���õ� Activity�� �� ������ �������� �޼ҵ�
	
	@GetMapping("/activityTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot() {

		return service.getTotalCountRelatedSpot("�ٳ�");

	}

	// Spot�� ���õ� Activity�� �������� 6�� �������� �޼ҵ�
	//���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	
	@GetMapping("/activityRandom")
	public List<ActivitydataDto> activityRandomList() {
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "�ٳ�");
		map.put("start","0");
		map.put("end","5");
		
		return service.activityRandomList(map);
	}
	
	//activityform에 이미지 업로드 시 서버에 이미지 저장 
	@RequestMapping(value = "/guide/choice/activity_img", method = RequestMethod.POST)
	public @ResponseBody void insertTravelerImage(
		   @RequestParam MultipartFile uploadFile, 
		   HttpServletRequest request) {
		
		SpringFileWriter fileWriter = new SpringFileWriter();
		// 저장할 path 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save 폴더에 저장해주는메서드
	}
	
	@RequestMapping(value="/guide/choice/activity_input", method=RequestMethod.POST)
	public void insertAttractionList(@RequestBody List<ActivitydataDto> data) {
		for(ActivitydataDto dto: data) {
			System.out.println(dto);
			service.insertActivityData(dto);
		}
	}
}
