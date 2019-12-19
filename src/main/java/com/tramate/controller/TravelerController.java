package com.tramate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tramate.dto.GuideDto;
import com.tramate.dto.TravelerDto;
import com.tramate.service.TravelerService;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class TravelerController {

	@Autowired
	private TravelerService service;
	
	@PostMapping(value = "/traveler/join")
	public void joinTraveler(@RequestBody TravelerDto dto) {
		
		service.insertTraveler(dto);
	}
	
	//traveler 가입 시 이미지 업로드 
	@RequestMapping(value = "/traveler/imageupload", method = RequestMethod.POST)
	public @ResponseBody void insertTravelerImage(
			@RequestParam MultipartFile uploadFile, 
			HttpServletRequest request) {
		
		SpringFileWriter fileWriter = new SpringFileWriter();
		// 저장할 path 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save 폴더에 저장해주는메서드
	}
	
	//traveler 에서 해당 num 정보 가져오기
	@RequestMapping(value = "/traveler/select", method = RequestMethod.GET)
	public TravelerDto selecttraveler(@RequestParam int num) {
		return service.getTraveler(num);
	}
	
	
}
