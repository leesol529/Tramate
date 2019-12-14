package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerchoiceDao;
import com.tramate.dto.TravelerchoiceDto;

@Service
public class TravelerchoiceService {

	@Autowired
	private TravelerchoiceDao dao;

	// Dto를 통해 하나의 TravelerChoice를 생성하는 메소드
	public void insertTravelerChoice(TravelerchoiceDto dto) {

		dao.insertTravelerChoice(dto);
	}

	// num을 통해 하나의 TravelerChoice를 읽는 메소드
	public TravelerchoiceDto getTravelerChoice(int num) {

		return dao.getTravelerChoice(num);
	}

	// Dto를 통해 하나의 TravelerChoice를 업데이트하는 메소드
	public void updateTravelerChoice(TravelerchoiceDto dto) {

		dao.updateTravelerChoice(dto);
	}

	// num을 통해 하나의 TravelerChoice를 삭제하는 메소드
	public void deleteTravelerChoice(int num) {

		dao.deleteTravelerChoice(num);
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}
}
