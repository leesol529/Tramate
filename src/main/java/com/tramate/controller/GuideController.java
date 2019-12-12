package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.GuideService;

@RestController
public class GuideController {

	@Autowired
	private GuideService service;
	
	@GetMapping("/guidetotal")
	public int guideTotalCount() {
		
		return service.getTotalCount();
	}
}
