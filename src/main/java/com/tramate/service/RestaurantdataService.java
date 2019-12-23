package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.RestaurantdataDao;
import com.tramate.dto.RestaurantdataDto;

@Service
public class RestaurantdataService {

	@Autowired
	private RestaurantdataDao dao;

	// Dto�� ���� Restaurantdata�� �����ϴ� �޼ҵ�
	public void insertRestaurantData(RestaurantdataDto dto) {

		dao.insertRestaurantData(dto);
	}

	// num�� ���� Restaurantdata�� ��� �޼ҵ�
	public RestaurantdataDto getRestaurantData(int num) {

		return dao.getRestaurantData(num);
	}

	// Dto�� ���� Restaurantdata�� ������Ʈ�ϴ� �޼ҵ�
	public void updateRestaurantData(RestaurantdataDto dto) {

		dao.updateRestaurantData(dto);
	}

	// num�� ���� Restaurantdata�� �����ϴ� �޼ҵ�
	public void deleteRestaurantData(int num) {

		dao.deleteRestaurantData(num);
	}

	// �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Spot�� ���õ� Restaurant�� �� ������ �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot�� ���õ� Restaurant�� �������� �������� �޼ҵ�
	public List<RestaurantdataDto> RestaurantRandomList(java.util.Map<String, String> map) {

		return dao.RestaurantRandomList(map);
	}

	// 가이드와 관련된 레스토랑데이터를 찾는 메소드
	public List<RestaurantdataDto> restaurantRelatedGuide(int gnum) {

		return dao.restaurantRelatedGuide(gnum);
	}

	// Continent와 관련있는 Restaurant의 총 수를 구하는 메소드
	public int RestaurantCountRelatedContinent(String continent) {

		return dao.RestaurantCountRelatedContinent(continent);
	}

	// Continent와 관련있는 Restaurant 5개를 랜덤으로 가져오는 메소드
	public List<RestaurantdataDto> restaurantRandomListRealatedContinent(java.util.Map<String, String> map) {

		return dao.restaurantRandomListRealatedContinent(map);
	}
}
