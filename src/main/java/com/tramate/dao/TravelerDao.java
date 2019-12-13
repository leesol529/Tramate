package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.TravelerDto;

@Repository
public class TravelerDao extends SqlSessionDaoSupport {

	//Dto를 통해 하나의 Traveler를 생성하는 메소드
	public void insertTraveler(TravelerDto dto) {
		
		getSqlSession().insert("insertTraveler",dto);
	}
	
	//num을 통해 하나의 Traveler를 읽는 메소드
	public TravelerDto getTraveler(int num) {
		
		return getSqlSession().selectOne("selectTraveler",num);
	}
	
	//Dto를 통해 하나의 Traveler를 업데이트하는 메소드
	public void updateTraveler(TravelerDto dto) {
		
		getSqlSession().update("updateTraveler", dto);
	}
	
	//num을 통해 하나의 Traveler를 삭제하는 메소드
	public void deleteTraveler(int num) {
		
		getSqlSession().delete("deleteTraveler", num);
	}
}
