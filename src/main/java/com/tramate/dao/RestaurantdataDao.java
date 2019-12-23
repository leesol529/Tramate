package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.RestaurantdataDto;

@Repository
public class RestaurantdataDao extends SqlSessionDaoSupport {

	// Dto�� ���� Restaurantdata�� �����ϴ� �޼ҵ�
	public void insertRestaurantData(RestaurantdataDto dto) {

		getSqlSession().insert("insertRestaurantData", dto);
	}

	// num�� ���� Restaurantdata�� ��� �޼ҵ�
	public RestaurantdataDto getRestaurantData(int num) {

		return getSqlSession().selectOne("selectRestaurantData", num);
	}

	// Dto�� ���� Restaurantdata�� ������Ʈ�ϴ� �޼ҵ�
	public void updateRestaurantData(RestaurantdataDto dto) {

		getSqlSession().update("updateRestaurantData", dto);
	}

	// num�� ���� Restaurantdata�� �����ϴ� �޼ҵ�
	public void deleteRestaurantData(int num) {

		getSqlSession().delete("deleteRestaurantData", num);
	}

	// RestaurantData�� �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return getSqlSession().selectOne("restaurantTotalCount");
	}

	// Spot�� ���õ� Restaurant�� �� ���� �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return getSqlSession().selectOne("restaurantCountRelatedSpot", spot);
	}

	// Continent와 관련있는 Restaurant의 총 수를 구하는 메소드
	public int RestaurantCountRelatedContinent(String continent) {

		return getSqlSession().selectOne("restaurantCountRelatedContinent", continent);
	}
	
	//Continent와 관련있는 Restaurant 5개를 랜덤으로 가져오는 메소드
	public List<RestaurantdataDto> restaurantRandomListRealatedContinent (java.util.Map<String, String> map){
		
		return getSqlSession().selectList("restaurantRandomListRealatedContinent",map);
	}

	// Spot�� ���õ� Restaurant�� �������� �������� �޼ҵ�
	public List<RestaurantdataDto> RestaurantRandomList(java.util.Map<String, String> map) {

		return getSqlSession().selectList("restaurantRandomList", map);
	}

	// 가이드와 관련된 레스토랑데이터를 찾는 메소드
	public List<RestaurantdataDto> restaurantRelatedGuide(int gnum) {

		return getSqlSession().selectList("restaurantRelatedGuide", gnum);
	}
}
