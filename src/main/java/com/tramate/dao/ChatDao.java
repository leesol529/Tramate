package com.tramate.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tramate.dto.ChatDto;

@Repository
public class ChatDao extends SqlSessionDaoSupport{

	//chat을 insert하는 메소드
	public void insertChat(ChatDto dto) {
		
		getSqlSession().insert("insertChat",dto);
	}
	
	//gnum과 tnum에 관계된 chatList를 얻는 메소드
	public List<ChatDto> selectChatList(Map<String, Integer> map){
		
		return getSqlSession().selectList("selectChatList",map);
	}
}
