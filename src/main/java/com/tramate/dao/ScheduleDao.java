package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ScheduleDto;

@Repository
public class ScheduleDao extends SqlSessionDaoSupport {
	
	public List<ScheduleDto> getSchedule(Map<String, Integer> map){
		
		
		return getSqlSession().selectList("scheduleGetOneReservation", map);
	}
	
	public void insertSchedule(ScheduleDto dto) {
		getSqlSession().insert("scheduleInsert");
	}
	
}
