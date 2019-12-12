package com.tramate.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class GuideDao extends SqlSessionDaoSupport {

	public int getTotalCount() {
		
		return getSqlSession().selectOne("GuideTotalCount");
	}

}
