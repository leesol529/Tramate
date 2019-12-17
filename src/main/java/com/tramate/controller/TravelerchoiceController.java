package com.tramate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.RestaurantdataDto;
import com.tramate.dto.SpotdataDto;
import com.tramate.service.ActivitydataService;
import com.tramate.service.RestaurantdataService;
import com.tramate.service.SpotdataService;
import com.tramate.service.TravelerchoiceService;

@RestController
public class TravelerchoiceController {

	@Autowired
	private TravelerchoiceService service;
	@Autowired
	private ActivitydataService aservice;
	@Autowired
	private RestaurantdataService rservice;
	@Autowired
	private SpotdataService sservice;

	
	//가이드와 관련된 activity를 json으로 보내는 메소드
	@RequestMapping(value="/traveler/choice/activity")
	public List<ActivitydataDto> activityRelatedGuide(@RequestParam int gnum){
		
		return aservice.activityRelatedGuid(gnum);
	}
	
	//가이드와 관련된 restaurant를 json으로 보내는 메소드
	@RequestMapping(value="/traveler/choice/restaurant")
	public List<RestaurantdataDto> restaurantRelatedGuide(@RequestParam int gnum){
		
		return rservice.restaurantRelatedGuide(gnum);
	}
	
	//가이드와 관련된 apot을 json으로 보내는 메소드
	@RequestMapping(value="/traveler/choice/spot")
	public List<SpotdataDto> spotRelatedGuide(@RequestParam int gnum){
		
		return sservice.spotRelatedGuide(gnum);
	}
}
