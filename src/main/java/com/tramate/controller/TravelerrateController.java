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

	// �뿬�뻾�옄蹂� �뙎湲� �솗�씤�븯�뒗 硫붿냼�뱶

	@RequestMapping(value = "reply/to/traveler", method = RequestMethod.POST)
	public List<TravelerrateDto> replyToTraveler(@RequestParam int tnum) {

		return service.replyToTraveler(tnum);
	}

	// �뿬�뻾�옄�뿉 ���븳 �룊媛�瑜� �엯�젰�븯�뒗 硫붿냼�뱶
	@RequestMapping(value = "/traveler/rate", method = RequestMethod.POST)
	public void insertTravelerRate(@RequestBody TravelerrateDto dto) {

		service.insertTravelerRate(dto);
	}
	
	@RequestMapping(value="/travelerrate/select", method = RequestMethod.POST)
	public int replyCounttoTraveler(@RequestParam int tnum) {
		return service.replyCounttoTraveler(tnum);
	}

}
