package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.ActivitydataDao;
import com.tramate.dto.ActivitydataDto;

@Service
public class ActivitydataService {

	@Autowired
	private ActivitydataDao dao;
}
