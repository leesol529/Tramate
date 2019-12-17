package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerDao;
import com.tramate.dto.TravelerDto;

@Service
public class TravelerService {

	@Autowired
	private TravelerDao dao;

	// Traveler table에 정보 insert
	public void insertTraveler(TravelerDto dto) {

		dao.insertTraveler(dto);
	}

	// num에 해당하는 Traveler 정보 가져오기 
	public TravelerDto getTraveler(int num) {

		return dao.getTraveler(num);
	}

	// Traveler정보 update
	public void updateTraveler(TravelerDto dto) {

		dao.updateTraveler(dto);
	}

	// num에 해당하는 Traveler 정보 삭제 
	public void deleteTraveler(int num) {

		dao.deleteTraveler(num);
	}

	// Traveler 전체 명수 count
	public int getTotalCount() {

		return dao.getTotalCount();
	}

}
