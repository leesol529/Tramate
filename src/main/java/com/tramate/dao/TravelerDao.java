package com.tramate.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.TravelerDto;

@Repository
public class TravelerDao extends SqlSessionDaoSupport {

	// Traveler table에 정보 insert
	public void insertTraveler(TravelerDto dto) {

		getSqlSession().insert("insertTraveler", dto);
	}

	// num에 해당하는 Traveler 정보 가져오기 
	public TravelerDto getTraveler(int num) {

		return getSqlSession().selectOne("selectTraveler", num);
	}

	// Traveler정보 update
	public void updateTraveler(TravelerDto dto) {

		getSqlSession().update("updateTraveler", dto);
	}

	// num에 해당하는 Traveler 정보 삭제 
	public void deleteTraveler(int num) {

		getSqlSession().delete("deleteTraveler", num);
	}

	// Traveler 전체 명수 count
	public int getTotalCount() {

		return getSqlSession().selectOne("travelerTotalCount");
	}
	
	//아이디와 비밀전호에 맞는 여행객이 존재하는지 찾는 메소드
	public int travelerLogin(Map<String, String> map) {
		
		return getSqlSession().selectOne("travelerLogin", map);
	}
	
	//아이디에 해당하는 Traveler pk가져오는 메소드
	public int getTravelerNumById(String id) {
		
		return getSqlSession().selectOne("getTravelerNumById",id);
	}
}
