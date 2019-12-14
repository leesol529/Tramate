package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.TravelerchoiceDto;

@Repository
public class TravelerchoiceDao extends SqlSessionDaoSupport {

	// Dto를 통해 하나의 TravelerChoice를 생성하는 메소드
	public void insertTravelerChoice(TravelerchoiceDto dto) {

		getSqlSession().insert("insertTravelerChoice", dto);
	}

	// num을 통해 하나의 TravelerChoice를 읽는 메소드
	public TravelerchoiceDto getTravelerChoice(int num) {

		return getSqlSession().selectOne("selectTravelerChoice", num);
	}

	// Dto를 통해 하나의 TravelerChoice를 업데이트하는 메소드
	public void updateTravelerChoice(TravelerchoiceDto dto) {

		getSqlSession().update("updateTravelerChoice", dto);
	}

	// num을 통해 하나의 TravelerChoice를 삭제하는 메소드
	public void deleteTravelerChoice(int num) {

		getSqlSession().delete("deleteTravelerChoice", num);
	}

	// TravelerChoice의 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return getSqlSession().selectOne("travelerChoiceTotalCount");
	}
}
