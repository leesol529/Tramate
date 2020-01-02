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

	// Dto占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void insertTravelerRate(TravelerrateDto dto) {

		dao.insertTravelerRate(dto);
	}

	// num占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占싻댐옙 占쌨소듸옙
	public TravelerrateDto getTravelerRate(int num) {

		return dao.getTravelerRate(num);
	}

	// Dto占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占쏙옙트占싹댐옙 占쌨소듸옙
	public void updateTravelerRate(TravelerrateDto dto) {

		dao.updateTravelerRate(dto);
	}

	// num占쏙옙 占쏙옙占쌔쇽옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void deleteTravelerRate(int num) {

		dao.deleteTravelerRate(num);
	}

	// 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// �뿬�뻾�옄蹂� �뙎湲� �솗�씤�븯�뒗 硫붿냼�뱶
	public List<TravelerrateDto> replyToTraveler(int tnum) {

		return dao.replyToTraveler(tnum);
	}
	
	//traveler 별 댓글 갯수 구하기
	public int replyCounttoTraveler(int tnum) {
		return dao.replyCounttoTraveler(tnum);
	}
}
