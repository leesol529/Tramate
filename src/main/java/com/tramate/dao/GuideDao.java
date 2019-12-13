package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.GuideDto;

@Repository
public class GuideDao extends SqlSessionDaoSupport {

	//Guide의 총 갯수를 리턴하는 메소드
	public int getTotalCount() {
		
		return getSqlSession().selectOne("GuideTotalCount");
	}
	
	//Dto를 통해 하나의 Guide를 생성하는 메소드
	public void insertGuide(GuideDto dto) {
		
		getSqlSession().insert("insertGuide", dto);
	}
	
	//num을 통해 하나의 Guide를 선택하는 메소드
	public GuideDto getGuide(int num) {
		
		return getSqlSession().selectOne("selectGuide", num);
	}
	
	//Dto를 통해 하나의 Guide를 변경하는 메소드
	public void updateGuide(GuideDto dto) {
		
		getSqlSession().update("updateGuide", dto);
	}
	
	//num을 통해 하나의 Guide를 지우는 메소드
	public void deleteGuide(int num) {
		
		getSqlSession().delete("deleteGuide", num);
	}

}
