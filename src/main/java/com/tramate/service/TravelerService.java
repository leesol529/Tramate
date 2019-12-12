package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerDao;

@Service
public class TravelerService {

	@Autowired
	private TravelerDao dao;
	
}
