package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.TravelerrateDto;

@Repository
public class TravelerrateDao extends SqlSessionDaoSupport{

	//Dto를 통해 하나의 TravelerRate를 생성하는 메소드
	public void insertTravelerRate(TravelerrateDto dto) {
		
		getSqlSession().insert("insertTravelerRate", dto);
	}
	
	//num을 통해 하나의 TravelerRate를 읽는 메소드
	public TravelerrateDto getTravelerRate(int num) {
		
		return getSqlSession().selectOne("selectTravelerRate", num);
	}
	
	//Dto를 통해 하나의 TravelerRate를 업데이트하는 메소드
	public void updateTravelerRate(TravelerrateDto dto) {
		
		getSqlSession().update("updateTravelerRate", dto);
	}
	
	//num을 통해서 하나의 TravelerRate를 삭제하는 메소드
	public void deleteTravelerRate(int num) {
		
		getSqlSession().delete("deleteTravelerRate", num);
	}
}
