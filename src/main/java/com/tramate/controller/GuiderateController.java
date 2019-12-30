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
import com.tramate.service.GuiderateService;

@RestController
@CrossOrigin
public class GuiderateController {

	@Autowired
	private GuiderateService service;
	
	//媛��씠�뱶�뿉 ���븳 �룊媛�瑜� �엯�젰�븯�뒗 硫붿냼�뱶
	@RequestMapping(value="/guide/rate", method=RequestMethod.POST)
	public void insertGuideRate(@RequestBody GuiderateDto dto) {
		
		service.insertGuideRate(dto);
	}
	
	@RequestMapping(value="reply/to/guide",method=RequestMethod.POST)
	public List<GuiderateDto> replyToGuide(@RequestParam int gnum){
		
		return service.replyToGuide(gnum);
	}
	
	@RequestMapping(value = "/guiderate/select", method=RequestMethod.POST)
	public int replyCounttoGuide(@RequestParam int gnum) {
		return service.replyCounttoGuide(gnum);
	}
}
