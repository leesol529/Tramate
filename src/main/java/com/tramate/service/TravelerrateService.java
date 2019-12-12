package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerrateDao;

@Service
public class TravelerrateService {

	@Autowired
	private TravelerrateDao dao;
}
