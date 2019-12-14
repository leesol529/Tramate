package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.GuiderateDao;
import com.tramate.dto.GuiderateDto;

@Service
public class GuiderateService {

	@Autowired
	private GuiderateDao dao;

	// num을 이용하여 하나의 Guiderate를 가져오는 메소드
	public GuiderateDto getGuideRate(int num) {

		return dao.getGuideRate(num);
	}

	// Dto를 이용하여 Guiderate를 추가하는 메소드
	public void insertGuideRate(GuiderateDto dto) {

		dao.insertGuideRate(dto);
	}

	// Dto를 이용하여 Guiderate를 변경하는 메소드
	public void updateGuideRate(GuiderateDto dto) {

		dao.updateGuideRate(dto);
	}

	// num을 이용하여 GuideRate를 지우는 메소드
	public void deleteGuideRate(int num) {

		dao.deleteGuideRate(num);
	}

	// 모든 Guiderate를 가져오는 메소드
	public List<GuiderateDto> getGuideRateList() {

		return dao.getGuideRateList();
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}
}
