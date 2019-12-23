package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.GuideDao;
import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.GuideDto;

@Service
public class GuideService {

	@Autowired
	private GuideDao dao;

	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Dto�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public void insertGuide(GuideDto dto) {

		dao.insertGuide(dto);
	}

	// num�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public GuideDto getGuide(int num) {

		return dao.getGuide(num);
	}

	// Dto�� ���� �ϳ��� Guide�� �����ϴ� �޼ҵ�
	public void updateGuide(GuideDto dto) {

		dao.updateGuide(dto);
	}

	// num�� ���� �ϳ��� Guide�� ����� �޼ҵ�
	public void deleteGuide(int num) {

		dao.deleteGuide(num);
	}

	// Spot�� ���õ� Guide�� �� ���� �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot�� ���õ� Guide�� �������� �������� �޼ҵ�
	public List<GuideDto> guideRandomList(java.util.Map<String, String> map) {

		return dao.guideRandomList(map);
	}

	// Continent와 관랸 있는 Guide 5명을 랜덤으로 뽑는 메소드
	public List<GuideDto> guideRandomListRelatedContinent(Map<String, String> map) {

		return dao.guideRandomListRelatedContinent(map);
	}

	// 로그인 가능한 아이디가 있는지 확인하는 메소드
	public int guideLogin(Map<String, String> map) {

		return dao.guideLogin(map);
	}

	// id에 해당하는 gnum 가져오기
	public int selectOneGuide(String id) {
		return dao.selectOneGuide(id);
	}

	// 지역을 paramete로 받아서 가이드들의 pk를 가져오는 메소드
	public List<GuideDto> guideRelatedSpot(String spot) {

		return dao.guideRelatedSpot(spot);
	}

	// Continent와 관련있는 Guide의 총 수를 구하는 메소드
	public int guideCountRelatedContinent(String continent) {

		return dao.guideCountRelatedContinent(continent);
	}
}
