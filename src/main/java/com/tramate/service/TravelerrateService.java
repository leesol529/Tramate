package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.TravelerrateDao;
import com.tramate.dto.TravelerrateDto;

@Service
public class TravelerrateService {

	@Autowired
	private TravelerrateDao dao;

	// Dto�� ���� �ϳ��� TravelerRate�� �����ϴ� �޼ҵ�
	public void insertTravelerRate(TravelerrateDto dto) {

		dao.insertTravelerRate(dto);
	}

	// num�� ���� �ϳ��� TravelerRate�� �д� �޼ҵ�
	public TravelerrateDto getTravelerRate(int num) {

		return dao.getTravelerRate(num);
	}

	// Dto�� ���� �ϳ��� TravelerRate�� ������Ʈ�ϴ� �޼ҵ�
	public void updateTravelerRate(TravelerrateDto dto) {

		dao.updateTravelerRate(dto);
	}

	// num�� ���ؼ� �ϳ��� TravelerRate�� �����ϴ� �޼ҵ�
	public void deleteTravelerRate(int num) {

		dao.deleteTravelerRate(num);
	}

	// �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// 여행자별 댓글 확인하는 메소드
	public List<TravelerrateDto> replyToTraveler(int tnum) {

		return dao.replyToTraveler(tnum);
	}
}
