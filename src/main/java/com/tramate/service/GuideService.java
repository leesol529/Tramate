package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.GuideDao;

@Service
public class GuideService {

	@Autowired
	private GuideDao dao;
	
	public int getTotalCount() {
		
		return dao.getTotalCount();
	}
}
