package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.SpotdataDto;

@Repository
public class SpotdataDao extends SqlSessionDaoSupport {

	// Dto�� ���� �ϳ��� SpotData�� �����ϴ� �޼ҵ�
	public void insertSpotData(SpotdataDto dto) {

		getSqlSession().insert("insertSpotData", dto);
	}

	// num�� ���� �ϳ��� SpotData�� �д� �޼ҵ�
	public SpotdataDto getSpotData(int num) {

		return getSqlSession().selectOne("selectSpotData", num);
	}

	// Dto�� ���� �ϳ��� SpotData�� ������Ʈ�ϴ� �޼ҵ�
	public void updateSpotData(SpotdataDto dto) {

		getSqlSession().update("updateSpotData", dto);
	}

	// num�� ���� �ϳ��� SpotData�� �����ϴ� �޼ҵ�
	public void deleteSpotData(int num) {

		getSqlSession().delete("deleteSpotData", num);
	}

	// Spotdata�� �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return getSqlSession().selectOne("spotTotalCount");
	}

	// Spot�� ���õ� �������� �� ���� �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return getSqlSession().selectOne("spotCountRelatedSpot", spot);
	}

	// Continent와 관련있는 Spot의 총 수를 구하는 메소드
	public int SpotCountRelatedContinent(String continent) {

		return getSqlSession().selectOne("spotCountRelatedContinent", continent);
	}
	
	// Continent와 관련있는 Spot 랜덤 5개를 구하는 메소드
	public List<SpotdataDto> spotRandomListRealatedContinent(Map<String, String> map){
		
		return getSqlSession().selectList("spotRandomListRealatedContinent", map);
	}

	// Spot�� ���õ� �������� �������� �������� �޼ҵ�
	public List<SpotdataDto> spotRandomList(Map<String, String> map) {

		return getSqlSession().selectList("spotRandomList", map);
	}

	// 가이드와 관련된 관광명소를 찾는 메소드
	public List<SpotdataDto> spotRelatedGuide(int gnum) {

		return getSqlSession().selectList("spotRelatedGuide", gnum);

	}
	
	//관광명소를 중복없이 String으로 던지는 메소드
	public List<String> spotDistinct(){
		
		return getSqlSession().selectList("spotDistinct");
	}
}
