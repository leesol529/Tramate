package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.TravelerchoiceService;

@RestController
public class TravelerchoiceController {

	@Autowired
	private TravelerchoiceService service;
}
