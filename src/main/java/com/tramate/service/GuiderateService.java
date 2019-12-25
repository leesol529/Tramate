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

	// num�� �̿��Ͽ� �ϳ��� Guiderate�� �������� �޼ҵ�
	public GuiderateDto getGuideRate(int num) {

		return dao.getGuideRate(num);
	}

	// Dto�� �̿��Ͽ� Guiderate�� �߰��ϴ� �޼ҵ�
	public void insertGuideRate(GuiderateDto dto) {

		dao.insertGuideRate(dto);
	}

	// Dto�� �̿��Ͽ� Guiderate�� �����ϴ� �޼ҵ�
	public void updateGuideRate(GuiderateDto dto) {

		dao.updateGuideRate(dto);
	}

	// num�� �̿��Ͽ� GuideRate�� ����� �޼ҵ�
	public void deleteGuideRate(int num) {

		dao.deleteGuideRate(num);
	}

	// ��� Guiderate�� �������� �޼ҵ�
	public List<GuiderateDto> getGuideRateList() {

		return dao.getGuideRateList();
	}

	// �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// 가이드별 댓글 확인하는 메소드
	public List<GuiderateDto> replyToGuide(int gnum) {

		return dao.replyToGuide(gnum);
	}
}
