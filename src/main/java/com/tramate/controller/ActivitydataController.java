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

import com.tramate.dto.ActivitydataDto;
import com.tramate.service.ActivitydataService;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class ActivitydataController {

	@Autowired
	private ActivitydataService service;

	// Spot�� ���õ� Activity�� �� ������ �������� �޼ҵ�

	@GetMapping("/activityTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot(String spot) {

		return service.getTotalCountRelatedSpot(spot);

	}

	// Spot�� ���õ� Activity�� �������� 6�� �������� �޼ҵ�
	// ���� spot, start ,end�� ���� �����ؾ� �Ѵ�.

	@PostMapping("/activityRandomRelatedSpot")
	public List<ActivitydataDto> activityRandomList(@RequestParam String spot) {

		java.util.Map<String, String> map = new HashMap<String, String>();
		int guideTotalCount = service.getTotalCountRelatedSpot(spot);
		System.out.println(spot + "의 총 Activity 갯수 : " + guideTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(guideTotalCount) + 1;
		if (startNum >= guideTotalCount - 4 && guideTotalCount >= 4)
			startNum = guideTotalCount - 4;
		System.out.println("startNum :" + startNum);
		map.put("spot", spot);
		map.put("start", "" + startNum);
		map.put("end", "" + (startNum + 4));

		return service.activityRandomList(map);
	}

	// Continent와 관랸 있는 Activity 5개를 랜덤으로 뽑는 메소드
	@PostMapping("/activity/randomlist/continent")
	public List<ActivitydataDto> ActivityRandomListRelatedContinent(@RequestParam String continent) {

		java.util.Map<String, String> map = new HashMap<String, String>();
		int ActivityTotalCount = service.ActivityCountRelatedContinent(continent);
		System.out.println(continent + "의 총 가이드 수 : " + ActivityTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(ActivityTotalCount) + 1;
		if (startNum >= ActivityTotalCount - 4 && ActivityTotalCount >= 4)
			startNum = ActivityTotalCount - 4;
		System.out.println("startNum :" + startNum);
		map.put("continent", continent);
		map.put("start", "" + startNum);
		map.put("end", "" + (startNum + 4));

		return service.activityRandomListRelatedContinent(map);

	}

	// activityform에 이미지 업로드 시 서버에 이미지 저장
	@RequestMapping(value = "/guide/choice/activity_img", method = RequestMethod.POST)
	public @ResponseBody void insertTravelerImage(@RequestParam MultipartFile uploadFile, HttpServletRequest request) {

		SpringFileWriter fileWriter = new SpringFileWriter();
		// 저장할 path 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save 폴더에 저장해주는메서드
	}

	@RequestMapping(value = "/guide/choice/activity_input", method = RequestMethod.POST)
	public void insertAttractionList(@RequestBody List<ActivitydataDto> data) {
		for (ActivitydataDto dto : data) {
			System.out.println(dto);
			service.insertActivityData(dto);
		}
	}
	
	//해당 num의 data 반환
	@RequestMapping(value="/activity/data", method=RequestMethod.POST)
	public ActivitydataDto getActivityData(@RequestParam int num){
		return service.gettActivityData(num);
	}
}
