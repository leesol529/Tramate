package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.GuideDto;

@Repository
public class GuideDao extends SqlSessionDaoSupport {

	// Guide�� �� ������ �����ϴ� �޼ҵ�
	public int getTotalCount() {

		return getSqlSession().selectOne("GuideTotalCount");
	}

	// Dto�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public void insertGuide(GuideDto dto) {

		getSqlSession().insert("insertGuide", dto);
	}

	// num�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public GuideDto getGuide(int num) {

		return getSqlSession().selectOne("selectGuide", num);
	}

	// Dto�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public void updateGuide(GuideDto dto) {

		getSqlSession().update("updateGuide", dto);
	}

	// num�� ���� �ϳ��� Guide�� ����� �޼ҵ�
	public void deleteGuide(int num) {

		getSqlSession().delete("deleteGuide", num);
	}

	// Spot�� ���õ� Guide�� �� ���� �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return getSqlSession().selectOne("guideCountRelatedSpot", spot);
	}
	
	//Continent와 관련있는 Guide의 총 수를 구하는 메소드
	public int guideCountRelatedContinent(String continent) {
		
		return getSqlSession().selectOne("guideCountRelatedContinent", continent);
	}

	// Spot�� ���õ� Guide�� �������� �������� �޼ҵ�
	public List<GuideDto> guideRandomList(java.util.Map<String, String> map) {

		return getSqlSession().selectList("guideRandomList", map);
	}
	
	//Continent와 관랸 있는 Guide 5명을 랜덤으로 뽑는 메소드
	public List<GuideDto> guideRandomListRelatedContinent(Map<String, String> map){
		
		return getSqlSession().selectList("guideRandomRelatedContinent",map);
	}
	//로그인 가능한 아이디가 있는지 확인하는 메소드
	public int guideLogin(Map<String, String> map) {
		
		return getSqlSession().selectOne("guideLogin",map);
	}

	//id에 해당하는 gnum 가져오기
	public int selectOneGuide(String id) {
		return getSqlSession().selectOne("selectOneGuide", id);
	}
	
	//지역을 paramete로 받아서 가이드들의 pk를 가져오는 메소드
	public List<GuideDto> guideRelatedSpot(String spot){
		
		return getSqlSession().selectList("guideRelatedSpot", spot);
	}
	
}
