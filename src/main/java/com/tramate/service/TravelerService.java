package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerDao;
import com.tramate.dto.TravelerDto;

@Service
public class TravelerService {

	@Autowired
	private TravelerDao dao;
	
	//Dto를 통해 하나의 Traveler를 생성하는 메소드
		public void insertTraveler(TravelerDto dto) {

			dao.insertTraveler(dto);
		}
		
		//num을 통해 하나의 Traveler를 읽는 메소드
		public TravelerDto getTraveler(int num) {

			return dao.getTraveler(num);
		}
		
		//Dto를 통해 하나의 Traveler를 업데이트하는 메소드
		public void updateTraveler(TravelerDto dto) {

			dao.updateTraveler(dto);
		}
		
		//num을 통해 하나의 Traveler를 삭제하는 메소드
		public void deleteTraveler(int num) {

			dao.deleteTraveler(num);
		}
	
}
