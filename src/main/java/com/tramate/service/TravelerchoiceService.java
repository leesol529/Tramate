package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerchoiceDao;

@Service
public class TravelerchoiceService {

	@Autowired
	private TravelerchoiceDao dao;
}
