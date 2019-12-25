package com.tramate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.GuiderateDto;
import com.tramate.dto.TravelerrateDto;
import com.tramate.service.TravelerrateService;

@RestController
@CrossOrigin
public class TravelerrateController {

	@Autowired
	private TravelerrateService service;

	// 여행자별 댓글 확인하는 메소드

	@RequestMapping(value = "reply/to/traveler", method = RequestMethod.POST)
	public List<TravelerrateDto> replyToTraveler(@RequestParam int tnum) {

		return service.replyToTraveler(tnum);
	}

	// 여행자에 대한 평가를 입력하는 메소드
	@RequestMapping(value = "/traveler/rate", method = RequestMethod.POST)
	public void insertTravelerRate(@RequestBody TravelerrateDto dto) {

		service.insertTravelerRate(dto);
	}

}
