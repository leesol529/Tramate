package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.SpotdataDto;

@Repository
public class SpotdataDao extends SqlSessionDaoSupport {

	// Dto을 통해 하나의 SpotData를 생성하는 메소드
	public void insertSpotData(SpotdataDto dto) {

		getSqlSession().insert("insertSpotData", dto);
	}

	// num을 통해 하나의 SpotData를 읽는 메소드
	public SpotdataDto getSpotData(int num) {

		return getSqlSession().selectOne("selectSpotData", num);
	}

	// Dto를 통해 하나의 SpotData를 업데이트하는 메소드
	public void updateSpotData(SpotdataDto dto) {

		getSqlSession().update("updateSpotData", dto);
	}

	// num을 통해 하나의 SpotData를 삭제하는 메소드
	public void deleteSpotData(int num) {

		getSqlSession().delete("deleteSpotData", num);
	}

	// Spotdata의 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return getSqlSession().selectOne("spotTotalCount");
	}

	// Spot과 관련된 관광지의 총 수를 가져오는 메소드
	public int getTotalCountRelatedSpot(String spot) {

		return getSqlSession().selectOne("spotCountRelatedSpot", spot);
	}
	
	//Spot과 관련된 관광지를 랜덤으로 가져오는 메소드
	public List<SpotdataDto> spotRandomList(Map<String, String> map){
		
		return getSqlSession().selectList("spotRandomList", map);
	}
}
