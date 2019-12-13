package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.SpotdataDto;

@Repository
public class SpotdataDao extends SqlSessionDaoSupport{

	//Dto을 통해 하나의 SpotData를 생성하는 메소드
	public void insertSpotData(SpotdataDto dto) {
		
		getSqlSession().insert("insertSpotData", dto);
	}
	
	//num을 통해 하나의 SpotData를 읽는 메소드
	public SpotdataDto getSpotData(int num) {
		
		return getSqlSession().selectOne("selectSpotData",num);
	}
	
	//Dto를 통해 하나의 SpotData를 업데이트하는 메소드
	public void updateSpotData(SpotdataDto dto) {
		
		getSqlSession().update("updateSpotData", dto);
	}
	
	//num을 통해 하나의 SpotData를 삭제하는 메소드
	public void deleteSpotData(int num) {
		
		getSqlSession().delete("deleteSpotData", num);
	}
}
