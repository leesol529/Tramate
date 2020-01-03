package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.CalendarDto;
import com.tramate.dto.GuideAndTravelerDto;
import com.tramate.dto.ScheduleDto;

@Repository
public class CalendarDao extends SqlSessionDaoSupport{
	
	public List<CalendarDto> getSchedule(int num){
		return getSqlSession().selectOne("calendarGuideSchedule");
	}
	
	public void insertSchedule(CalendarDto dto) {
		getSqlSession().insert("calendarInsert", dto);
	}
	
	//수락된 tnum 가져오기
	public List<Integer> getFixedTnum(int gnum){
		return getSqlSession().selectList("calendarFixedTnum", gnum);
	}
	
	//대기중인 tnum 가져오기 
	public List<Integer> getWaitTnum(int gnum){
		return getSqlSession().selectList("calendarWaitTnum", gnum);
	}
	
	//수락한 스케줄 가져오기 
	public List<GuideAndTravelerDto> getFixedSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarGetFixed", map);
	}
	
	//수락 대기중인 스케줄 가져오기 
	public List<GuideAndTravelerDto> getNewSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarGetNew", map);
	}
	
	//일정 수락
	public void acceptSchedule(int num) {
		getSqlSession().update("calendarAccept", num);
	}
	
	//일정 거절
	public void declineSchedule(int num) {
		getSqlSession().update("calendarDecline", num);
	}
	
	//특정 가이드와 특정 여행자의 여행 정보 가져오기 
	public List<GuideAndTravelerDto> getSpecificSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarSpecificSchedule", map);
	}
}
