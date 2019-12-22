package com.tramate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public int guideTotalCountRelatedSpot(@RequestParam String spot) {

		return service.getTotalCountRelatedSpot(spot);

	}

	// Spot�� ���õ� Activity�� �������� 6�� �������� �޼ҵ�
	//���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	
	@PostMapping("/activityRandomRelatedSpot")
	public List<ActivitydataDto> activityRandomList(@RequestParam String spot) {
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		int guideTotalCount = service.getTotalCountRelatedSpot(spot);
		System.out.println(spot+"의 총 Activity 갯수 : "+guideTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(guideTotalCount)+1;
		if(startNum >= guideTotalCount-4 && guideTotalCount>=4) startNum = guideTotalCount-4;
		System.out.println("startNum :" +startNum);
		map.put("spot", spot);
		map.put("start", ""+startNum);
		map.put("end", ""+(startNum+4));
		
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
