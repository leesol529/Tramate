package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.TravelerService;

@RestController
public class TravelerController {

	@Autowired
	private TravelerService service;
}
