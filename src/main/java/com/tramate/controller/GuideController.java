package com.tramate.controller;

import java.util.HashMap;
import java.util.List;

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
import com.tramate.dto.GuideDto;
import com.tramate.service.GuideService;
import com.tramate.upload.SpringFileWriter;

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
	// ���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	@GetMapping("/guideRandom")
	public List<ActivitydataDto> guideRandomList() {

		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("spot", "다낭");
		map.put("start", "0");
		map.put("end", "5");

		return service.guideRandomList(map);
	}

	// React로 부터 json을 받아서 guide를 등록한다.

	@RequestMapping(value = "/guide/join", method = RequestMethod.POST)
	public void insertGuideData(@RequestBody GuideDto dto) {

		service.insertGuide(dto);
	}

	// num값을 받아서 하나의 Guide의 정보를 얻는 메소드
	@RequestMapping(value = "/guide/select", method = RequestMethod.GET)
	public GuideDto selectguide(@RequestParam int num) {

		return service.getGuide(num);
	}

	@RequestMapping(value = "/guide/imageupload", method = RequestMethod.POST)
	public void insertGuideImage(@RequestParam MultipartFile uploadFile, HttpServletRequest request) {
		SpringFileWriter fileWriter = new SpringFileWriter();
		// 저장할 path 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save 폴더에 저장해주는메서드
	}
}
