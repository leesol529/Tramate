package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.RestaurantdataDao;

@Service
public class RestaurantdataService {

	@Autowired
	private RestaurantdataDao dao;
}
