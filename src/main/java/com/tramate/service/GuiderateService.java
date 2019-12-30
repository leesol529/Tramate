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

	// num占쏙옙 占싱울옙占싹울옙 占싹놂옙占쏙옙 Guiderate占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public GuiderateDto getGuideRate(int num) {

		return dao.getGuideRate(num);
	}

	// Dto占쏙옙 占싱울옙占싹울옙 Guiderate占쏙옙 占쌩곤옙占싹댐옙 占쌨소듸옙
	public void insertGuideRate(GuiderateDto dto) {

		dao.insertGuideRate(dto);
	}

	// Dto占쏙옙 占싱울옙占싹울옙 Guiderate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void updateGuideRate(GuiderateDto dto) {

		dao.updateGuideRate(dto);
	}

	// num占쏙옙 占싱울옙占싹울옙 GuideRate占쏙옙 占쏙옙占쏙옙占� 占쌨소듸옙
	public void deleteGuideRate(int num) {

		dao.deleteGuideRate(num);
	}

	// 占쏙옙占� Guiderate占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public List<GuiderateDto> getGuideRateList() {

		return dao.getGuideRateList();
	}

	// 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// 媛��씠�뱶蹂� �뙎湲� �솗�씤�븯�뒗 硫붿냼�뱶
	public List<GuiderateDto> replyToGuide(int gnum) {

		return dao.replyToGuide(gnum);
	}
	
	//guide 별 댓글 갯수
		public int replyCounttoGuide(int gnum) {
			return dao.replyCounttoGuide(gnum);
		}
}
