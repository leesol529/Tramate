package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.CalendarDto;
import com.tramate.dto.GuideAndTravelerDto;
import com.tramate.dto.ScheduleDto;

@Repository
public class CalendarDao extends SqlSessionDaoSupport {

	public List<CalendarDto> getSchedule(int num) {
		return getSqlSession().selectOne("calendarGuideSchedule");
	}

	public void insertSchedule(CalendarDto dto) {
		getSqlSession().insert("calendarInsert", dto);
	}

	// 수락된 tnum 가져오기
	public List<Integer> getFixedTnum(int gnum) {
		return getSqlSession().selectList("calendarFixedTnum", gnum);
	}

	// 대기중인 tnum 가져오기
	public List<Integer> getWaitTnum(int gnum) {
		return getSqlSession().selectList("calendarWaitTnum", gnum);
	}

	// 수락한 스케줄 가져오기
	public List<GuideAndTravelerDto> getFixedSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarGetFixed", map);
	}

	// 수락 대기중인 스케줄 가져오기
	public List<GuideAndTravelerDto> getNewSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarGetNew", map);
	}

	// 일정 수락
	public void acceptSchedule(int num) {
		getSqlSession().update("calendarAccept", num);
	}

	// 일정 거절
	public void declineSchedule(int num) {
		getSqlSession().update("calendarDecline", num);
	}

	// 특정 가이드와 특정 여행자의 여행 정보 가져오기
	public List<GuideAndTravelerDto> getSpecificSchedule(Map<String, Integer> map) {
		return getSqlSession().selectList("calendarSpecificSchedule", map);
	}

	// 거절 이유 업데이트 하기
	public void calendarReasonUpdate(Map<String, String> map) {

		getSqlSession().update("calendarReasonUpdate", map);
	}
	
	//수락한 gnum 가져오기
	public List<Integer> getFixedGnum(int tnum){
		return getSqlSession().selectList("calendarFixedGnum", tnum);
	}
	
	//대기중인 gnum 가져오기 
	public List<Integer> getWaitGnum(int tnum){
		return getSqlSession().selectList("calendarWaitGnum", tnum);
	}
	
	//거절한 gnum 가져오기 
	public List<Integer> getNoGnum(int tnum){
		return getSqlSession().selectList("calendarNoGnum", tnum);
	}
	//가이드가 수락한 스케줄 가져오기 for traveler
		public List<GuideAndTravelerDto> getFixedScheduleForT(Map<String, Integer> map) {
			return getSqlSession().selectList("calendarGetFixedForTraveler", map);
		}
		
		//가이드의 수락을 기다리는 스케줄 가져오기 for traveler
		public List<GuideAndTravelerDto> getWaitScheduleForT(Map<String, Integer> map) {
			return getSqlSession().selectList("calendarGetWaitForTraveler", map);
		}
		
		//가이드가 거절한 스케줄 가져오기 for traveler
		public List<GuideAndTravelerDto> getNoScheduleForT(Map<String, Integer> map) {
			return getSqlSession().selectList("calendarGetNoForTraveler", map);
		}
}
