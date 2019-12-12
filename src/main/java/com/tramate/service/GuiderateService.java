package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.GuiderateDao;

@Service
public class GuiderateService {

	@Autowired
	private GuiderateDao dao;
}
