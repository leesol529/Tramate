package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sun.javafx.collections.MappingChange.Map;
import com.tramate.dto.ActivitydataDto;

@Repository
public class ActivitydataDao extends SqlSessionDaoSupport {

	//num�� ���� �ϳ��� ActivityData �� ��ȯ�Ѵ�.
	public ActivitydataDto gettActivityData(int num) {
		
		return getSqlSession().selectOne("activityDataSelect",num);
	}
	
	//ActivityDto�� �Ķ���ͷ� �Է¹޾� insert�� �ϴ� �޼ҵ�
	public void insertActivityData(ActivitydataDto dto) {
		
		getSqlSession().insert("activityDataInsert", dto);
	}
	
	//num�� ���� �ϳ��� ActivityData�� �����ϴ� �޼ҵ�
	public void deleteActivityData(int num) {
		
		getSqlSession().delete("activityDataDelete", num);
	}
	
	//ActivityDto�� �ĸ����ͷ� �Է¹޾� update�� �ϴ� �޼ҵ�
	public void updateActivityData(ActivitydataDto dto) {
		
		getSqlSession().update("activityDataUpdate", dto);
	}
	
	//��� ActivityData�� ����Ʈ�� �������� �޼ҵ�
	public List<ActivitydataDto> getActivityDataList(){
		
		return getSqlSession().selectList("activityDataSelectList");
	}
	
	//ActivityData�� �� ������ �������� �޼ҵ�
	public int getTotalCount() {
		
		return getSqlSession().selectOne("activityTotalCount");
	}
	
	//Spot�� ���õ� Activity�� �� ������ �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {
		
		return getSqlSession().selectOne("activityCountRelatedSpot",spot);
	}
	
	//Spot�� ���õ� Activity�� �������� 6�� �������� �޼ҵ�
	public List<ActivitydataDto> activityRandomList(java.util.Map<String, String> map){
		
		return getSqlSession().selectList("activityRandomList",map);
	}
	
	//guide와 관련된 activity를 찾는 메소드
	public List<ActivitydataDto> activityRelatedGuid(int gnum){
		
		return getSqlSession().selectList("activityRelatedGuide",gnum);
	}
}
