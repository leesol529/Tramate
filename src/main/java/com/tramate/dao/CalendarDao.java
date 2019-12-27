package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.CalendarDto;

@Repository
public class CalendarDao extends SqlSessionDaoSupport{
	
	public List<CalendarDto> getSchedule(int num){
		return getSqlSession().selectOne("calendarGuideSchedule");
	}
	
	public void insertSchedule(CalendarDto dto) {
		getSqlSession().insert("calendarInsert", dto);
	}
}
