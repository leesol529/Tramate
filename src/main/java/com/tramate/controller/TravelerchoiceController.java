package com.tramate.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.RestaurantdataDto;
import com.tramate.dto.SpotdataDto;
import com.tramate.service.ActivitydataService;
import com.tramate.service.RestaurantdataService;
import com.tramate.service.SpotdataService;
import com.tramate.service.TravelerchoiceService;

@RestController
@CrossOrigin
public class TravelerchoiceController {

	@Autowired
	private TravelerchoiceService service;
	@Autowired
	private ActivitydataService aservice;
	@Autowired
	private RestaurantdataService rservice;
	@Autowired
	private SpotdataService sservice;

	// 가이드와 관련된 activity를 json으로 보내는 메소드
	@RequestMapping(value = "/traveler/choice/activity")
	public List<ActivitydataDto> activityRelatedGuide(@RequestParam int gnum) {

		System.out.println(gnum + "이 출력되었음");
		return aservice.activityRelatedGuid(gnum);
	}

	// 가이드와 관련된 restaurant를 json으로 보내는 메소드
	@RequestMapping(value = "/traveler/choice/restaurant")
	public List<RestaurantdataDto> restaurantRelatedGuide(@RequestParam int gnum) {

		return rservice.restaurantRelatedGuide(gnum);
	}

	// 가이드와 관련된 apot을 json으로 보내는 메소드
	@RequestMapping(value = "/traveler/choice/spot")
	public List<SpotdataDto> spotRelatedGuide(@RequestParam int gnum) {

		return sservice.spotRelatedGuide(gnum);
	}

}
