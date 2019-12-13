package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.SpotdataDao;
import com.tramate.dto.SpotdataDto;

@Service
public class SpotdataService {

	@Autowired
	private SpotdataDao dao;
	
	//Dto을 통해 하나의 SpotData를 생성하는 메소드
		public void insertSpotData(SpotdataDto dto) {

			dao.insertSpotData(dto);
		}
		
		//num을 통해 하나의 SpotData를 읽는 메소드
		public SpotdataDto getSpotData(int num) {

			return dao.getSpotData(num);
		}
		
		//Dto를 통해 하나의 SpotData를 업데이트하는 메소드
		public void updateSpotData(SpotdataDto dto) {

			dao.updateSpotData(dto);
		}
		
		//num을 통해 하나의 SpotData를 삭제하는 메소드
		public void deleteSpotData(int num) {

			dao.deleteSpotData(num);
		}
}
