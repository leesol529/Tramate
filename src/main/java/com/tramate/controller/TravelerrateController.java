package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.TravelerrateService;

@RestController
public class TravelerrateController {

	@Autowired
	private TravelerrateService service;
}
