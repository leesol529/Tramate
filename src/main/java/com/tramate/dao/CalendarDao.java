package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.CalendarDto;
import com.tramate.dto.ScheduleDto;

@Repository
public class CalendarDao extends SqlSessionDaoSupport{
	
	public List<CalendarDto> getSchedule(int num){
		return getSqlSession().selectOne("calendarGuideSchedule");
	}
	
	public void insertSchedule(CalendarDto dto) {
		getSqlSession().insert("calendarInsert", dto);
	}
	
	//수락한 스케줄 가져오기 
	public List<ScheduleDto> getFixedSchedule(int gnum) {
		return getSqlSession().selectList("calendarGetFixed", gnum);
	}
	
	//수락 대기중인 스케줄 가져오기 
	public List<ScheduleDto> getNewSchedule(int gnum) {
		return getSqlSession().selectList("calendarGetNew", gnum);
	}
}
