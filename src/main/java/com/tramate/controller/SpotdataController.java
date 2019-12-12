package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.SpotdataService;

@RestController
public class SpotdataController {

	@Autowired
	private SpotdataService service;
}
