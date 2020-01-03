package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.CalendarDao;
import com.tramate.dto.CalendarDto;
import com.tramate.dto.GuideAndTravelerDto;

@Service
public class CalendarService {

	@Autowired
	CalendarDao dao;

	public List<CalendarDto> getSchedule(int num) {
		return dao.getSchedule(num);
	}

	public void insertSchedule(CalendarDto dto) {
		dao.insertSchedule(dto);
	}

	// 수락된 tnum 가져오기
	public List<Integer> getFixedTnum(int gnum) {
		return dao.getFixedTnum(gnum);
	}

	// 대기중인 tnum 가져오기
	public List<Integer> getWaitTnum(int gnum) {
		return dao.getWaitTnum(gnum);
	}

	// 수락한 스케줄 가져오기
	public List<GuideAndTravelerDto> getFixedSchedule(Map<String, Integer> map) {
		return dao.getFixedSchedule(map);
	}

	// 수락 대기중인 스케줄 가져오기
	public List<GuideAndTravelerDto> getNewSchedule(Map<String, Integer> map) {
		return dao.getNewSchedule(map);
	}

	// 일정 수락
	public void acceptSchedule(int num) {
		dao.acceptSchedule(num);
	}

	// 일정 거절
	public void declineSchedule(int num) {
		dao.declineSchedule(num);
	}

	// 특정 가이드와 특정 여행자의 여행 정보 가져오기
	public List<GuideAndTravelerDto> getSpecificSchedule(Map<String, Integer> map) {
		return dao.getSpecificSchedule(map);
	}

	// 거절 이유 업데이트 하기
	public void calendarReasonUpdate(Map<String, String> map) {

		dao.calendarReasonUpdate(map);
	}
}
