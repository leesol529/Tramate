package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.RestaurantdataDto;

@Repository
public class RestaurantdataDao extends SqlSessionDaoSupport {

	//Dto를 통해 Restaurantdata를 생성하는 메소드
	public void insertRestaurantData(RestaurantdataDto dto) {
		
		getSqlSession().insert("insertRestaurantData", dto);
	}
	
	//num을 통해 Restaurantdata를 얻는 메소드
	public RestaurantdataDto getRestaurantData(int num) {
		
		return getSqlSession().selectOne("selectRestaurantData", num);
	}
	
	//Dto를 통해 Restaurantdata를 업데이트하는 메소드
	public void updateRestaurantData(RestaurantdataDto dto) {
		
		getSqlSession().update("updateRestaurantData", dto);
	}
	
	//num을 통해 Restaurantdata를 삭제하는 메소드
	public void deleteRestaurantData(int num) {
		
		getSqlSession().delete("deleteRestaurantData", num);
	}
	
	//RestaurantData의 총 갯수를 가져오는 메소드
		public int getTotalCount() {
			
			return getSqlSession().selectOne("restaurantTotalCount");
		}
}
