package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ActivitydataDto;

@Repository
public class ActivitydataDao extends SqlSessionDaoSupport {

	//num을 통해 하나의 ActivityData 를 반환한다.
	public ActivitydataDto gettActivityData(int num) {
		
		return getSqlSession().selectOne("activityDataSelect",num);
	}
	
	//ActivityDto를 파라미터로 입력받아 insert를 하는 메소드
	public void insertActivityData(ActivitydataDto dto) {
		
		getSqlSession().insert("activityDataInsert", dto);
	}
	
	//num을 통해 하나의 ActivityData를 삭제하는 메소드
	public void deleteActivityData(int num) {
		
		getSqlSession().delete("activityDataDelete", num);
	}
	
	//ActivityDto를 파마미터로 입력받아 update를 하는 메소드
	public void updateActivityData(ActivitydataDto dto) {
		
		getSqlSession().update("activityDataUpdate", dto);
	}
	
	//모든 ActivityData를 리스트로 가져오는 메소드
	public List<ActivitydataDto> getActivityDataList(){
		
		return getSqlSession().selectList("activityDataSelectList");
	}
}
