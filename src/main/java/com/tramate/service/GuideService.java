package com.tramate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.GuideDao;
import com.tramate.dto.GuideDto;

@Service
public class GuideService {

	@Autowired
	private GuideDao dao;

	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Dto를 통해 하나의 Guide를 생성하는 메소드
	public void insertGuide(GuideDto dto) {

		dao.insertGuide(dto);
	}

	// num을 통해 하나의 Guide를 선택하는 메소드
	public GuideDto getGuide(int num) {

		return dao.getGuide(num);
	}

	// Dto를 통해 하나의 Guide를 변경하는 메소드
	public void updateGuide(GuideDto dto) {

		dao.updateGuide(dto);
	}

	// num을 통해 하나의 Guide를 지우는 메소드
	public void deleteGuide(int num) {

		dao.deleteGuide(num);
	}

	
}
