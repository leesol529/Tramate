package com.tramate.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.TravelerrateDto;

@Repository
public class TravelerrateDao extends SqlSessionDaoSupport {

	// Dto占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void insertTravelerRate(TravelerrateDto dto) {

		getSqlSession().insert("insertTravelerRate", dto);
	}

	// num占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占싻댐옙 占쌨소듸옙
	public TravelerrateDto getTravelerRate(int num) {

		return getSqlSession().selectOne("selectTravelerRate", num);
	}

	// Dto占쏙옙 占쏙옙占쏙옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占쏙옙트占싹댐옙 占쌨소듸옙
	public void updateTravelerRate(TravelerrateDto dto) {

		getSqlSession().update("updateTravelerRate", dto);
	}

	// num占쏙옙 占쏙옙占쌔쇽옙 占싹놂옙占쏙옙 TravelerRate占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨소듸옙
	public void deleteTravelerRate(int num) {

		getSqlSession().delete("deleteTravelerRate", num);
	}

	// Travelerrate占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public int getTotalCount() {

		return getSqlSession().selectOne("travelerrateTotalCount");
	}
	
	//�뿬�뻾�옄蹂� �뙎湲� �솗�씤�븯�뒗 硫붿냼�뱶
	public List<TravelerrateDto> replyToTraveler(int tnum){
		
		return getSqlSession().selectList("replyToTraveler",tnum);
	}
	
	//traveler 별 댓글 갯수
	public int replyCounttoTraveler(int tnum) {
		return getSqlSession().selectOne("replyCounttoTraveler", tnum);
	}
}
