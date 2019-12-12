package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.ActivitydataService;

@RestController
public class ActivitydataController {

	@Autowired
	private ActivitydataService service;
}
