package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.SpotdataDao;
import com.tramate.dto.RestaurantdataDto;
import com.tramate.dto.SpotdataDto;

@Service
public class SpotdataService {

	@Autowired
	private SpotdataDao dao;

	// Dto�� ���� �ϳ��� SpotData�� �����ϴ� �޼ҵ�
	public void insertSpotData(SpotdataDto dto) {

		dao.insertSpotData(dto);
	}

	// num�� ���� �ϳ��� SpotData�� �д� �޼ҵ�
	public SpotdataDto getSpotData(int num) {

		return dao.getSpotData(num);
	}

	// Dto�� ���� �ϳ��� SpotData�� ������Ʈ�ϴ� �޼ҵ�
	public void updateSpotData(SpotdataDto dto) {

		dao.updateSpotData(dto);
	}

	// num�� ���� �ϳ��� SpotData�� �����ϴ� �޼ҵ�
	public void deleteSpotData(int num) {

		dao.deleteSpotData(num);
	}

	// �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Spot�� ���õ� Spot�� �� ������ �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot�� ���õ� �������� �������� �������� �޼ҵ�
	public List<SpotdataDto> spotRandomList(Map<String, String> map) {

		return dao.spotRandomList(map);
	}

	// 가이드와 관련된 관광명소를 찾는 메소드
	public List<SpotdataDto> spotRelatedGuide(int gnum) {

		return dao.spotRelatedGuide(gnum);
	}
}
