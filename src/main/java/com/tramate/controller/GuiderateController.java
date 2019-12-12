package com.tramate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.service.GuiderateService;

@RestController
public class GuiderateController {

	@Autowired
	private GuiderateService service;
}
