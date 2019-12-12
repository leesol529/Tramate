package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.RestaurantdataService;

@RestController
public class RestaurantdataController {

	@Autowired
	private RestaurantdataService service;
}
