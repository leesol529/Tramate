package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerrateDao;
import com.tramate.dto.TravelerrateDto;

@Service
public class TravelerrateService {

	@Autowired
	private TravelerrateDao dao;

	// Dto를 통해 하나의 TravelerRate를 생성하는 메소드
	public void insertTravelerRate(TravelerrateDto dto) {

		dao.insertTravelerRate(dto);
	}

	// num을 통해 하나의 TravelerRate를 읽는 메소드
	public TravelerrateDto getTravelerRate(int num) {

		return dao.getTravelerRate(num);
	}

	// Dto를 통해 하나의 TravelerRate를 업데이트하는 메소드
	public void updateTravelerRate(TravelerrateDto dto) {

		dao.updateTravelerRate(dto);
	}

	// num을 통해서 하나의 TravelerRate를 삭제하는 메소드
	public void deleteTravelerRate(int num) {

		dao.deleteTravelerRate(num);
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}
}
