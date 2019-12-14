package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.GuideDto;

@Repository
public class GuideDao extends SqlSessionDaoSupport {

	// Guide의 총 갯수를 리턴하는 메소드
	public int getTotalCount() {

		return getSqlSession().selectOne("GuideTotalCount");
	}

	// Dto를 통해 하나의 Guide를 생성하는 메소드
	public void insertGuide(GuideDto dto) {

		getSqlSession().insert("insertGuide", dto);
	}

	// num을 통해 하나의 Guide를 선택하는 메소드
	public GuideDto getGuide(int num) {

		return getSqlSession().selectOne("selectGuide", num);
	}

	// Dto를 통해 하나의 Guide를 변경하는 메소드
	public void updateGuide(GuideDto dto) {

		getSqlSession().update("updateGuide", dto);
	}

	// num을 통해 하나의 Guide를 지우는 메소드
	public void deleteGuide(int num) {

		getSqlSession().delete("deleteGuide", num);
	}

	// Spot과 관련된 Guide의 총 수를 가져오는 메소드
	public int getTotalCountRelatedSpot(String spot) {

		return getSqlSession().selectOne("guideCountRelatedSpot", spot);
	}

	// Spot과 관련된 Guide를 랜덤으로 가져오는 메소드
	public List<ActivitydataDto> guideRandomList(java.util.Map<String, String> map) {

		return getSqlSession().selectList("guideRandomList", map);
	}

}
