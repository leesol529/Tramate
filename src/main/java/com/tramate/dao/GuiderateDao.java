package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.GuiderateDto;

@Repository
public class GuiderateDao extends SqlSessionDaoSupport{

	//num을 이용하여 하나의 Guiderate를 가져오는 메소드
	public GuiderateDto getGuideRate(int num) {
		
		return getSqlSession().selectOne("selectGuideRate", num);
	}
	
	//Dto를 이용하여 Guiderate를 추가하는 메소드
	public void insertGuideRate(GuiderateDto dto) {
		
		getSqlSession().insert("insertGuideRate", dto);
	}
	
	//Dto를 이용하여 Guiderate를 변경하는 메소드
	public void updateGuideRate(GuiderateDto dto) {
		
		getSqlSession().update("updateGuideRate", dto);
	}
	
	//num을 이용하여 GuideRate를 지우는 메소드
	public void deleteGuideRate(int num) {
		
		getSqlSession().delete("deleteGuideRate", num);
	}
	
	//모든 Guiderate를 가져오는 메소드
	public List<GuiderateDto> getGuideRateList(){
		
		return getSqlSession().selectList("selectGuideRateList");
	}
}
