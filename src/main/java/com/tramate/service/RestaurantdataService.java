package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.RestaurantdataDao;
import com.tramate.dto.RestaurantdataDto;

@Service
public class RestaurantdataService {

	@Autowired
	private RestaurantdataDao dao;

	// Dto를 통해 Restaurantdata를 생성하는 메소드
	public void insertRestaurantData(RestaurantdataDto dto) {

		dao.insertRestaurantData(dto);
	}

	// num을 통해 Restaurantdata를 얻는 메소드
	public RestaurantdataDto getRestaurantData(int num) {

		return dao.getRestaurantData(num);
	}

	// Dto를 통해 Restaurantdata를 업데이트하는 메소드
	public void updateRestaurantData(RestaurantdataDto dto) {

		dao.updateRestaurantData(dto);
	}

	// num을 통해 Restaurantdata를 삭제하는 메소드
	public void deleteRestaurantData(int num) {

		dao.deleteRestaurantData(num);
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}
}
