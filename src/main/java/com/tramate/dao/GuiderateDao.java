package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.GuiderateDto;

@Repository
public class GuiderateDao extends SqlSessionDaoSupport {

	// num占쏙옙 占싱울옙占싹울옙 占싹놂옙占쏙옙 Guiderate占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public GuiderateDto getGuideRate(int num) {

		return getSqlSession().selectOne("selectGuideRate", num);
	}

	// Dto占쏙옙 占싱울옙占싹울옙 Guiderate占쏙옙 占쌩곤옙占싹댐옙 占쌨소듸옙
	public void insertGuideRate(GuiderateDto dto) {

		getSqlSession().insert("insertGuideRate", dto);
	}

	// Dto占쏙옙 占싱울옙占싹울옙 Guiderate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void updateGuideRate(GuiderateDto dto) {

		getSqlSession().update("updateGuideRate", dto);
	}

	// num占쏙옙 占싱울옙占싹울옙 GuideRate占쏙옙 占쏙옙占쏙옙占� 占쌨소듸옙
	public void deleteGuideRate(int num) {

		getSqlSession().delete("deleteGuideRate", num);
	}

	// 占쏙옙占� Guiderate占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public List<GuiderateDto> getGuideRateList() {

		return getSqlSession().selectList("selectGuideRateList");
	}

	// ActivityData占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public int getTotalCount() {

		return getSqlSession().selectOne("guideRateTotalCount");
	}
	
	//媛��씠�뱶蹂� �뙎湲� �솗�씤�븯�뒗 硫붿냼�뱶
	public List<GuiderateDto> replyToGuide(int gnum){
		
		return getSqlSession().selectList("replyToGuide",gnum);
	}
	
	//guide 별 댓글 갯수
	public int replyCounttoGuide(int gnum) {
		return getSqlSession().selectOne("replyCounttoGuide",gnum);
	}
}
