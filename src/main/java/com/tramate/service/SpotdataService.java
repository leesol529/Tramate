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

	// Dto을 통해 하나의 SpotData를 생성하는 메소드
	public void insertSpotData(SpotdataDto dto) {

		dao.insertSpotData(dto);
	}

	// num을 통해 하나의 SpotData를 읽는 메소드
	public SpotdataDto getSpotData(int num) {

		return dao.getSpotData(num);
	}

	// Dto를 통해 하나의 SpotData를 업데이트하는 메소드
	public void updateSpotData(SpotdataDto dto) {

		dao.updateSpotData(dto);
	}

	// num을 통해 하나의 SpotData를 삭제하는 메소드
	public void deleteSpotData(int num) {

		dao.deleteSpotData(num);
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Spot과 관련된 Spot의 총 갯수를 가져오는 메소드
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot과 관련된 관광지를 랜덤으로 가져오는 메소드
	public List<SpotdataDto> spotRandomList(Map<String, String> map) {

		return dao.spotRandomList(map);
	}
}
