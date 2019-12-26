package com.tramate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tramate.dao.ChatDao;
import com.tramate.dto.ChatDto;

@Service
public class ChatService {

	@Autowired
	private ChatDao dao;

	// chat을 insert하는 메소드
	public void insertChat(ChatDto dto) {

		dao.insertChat(dto);
	}

	// gnum과 tnum에 관계된 chatList를 얻는 메소드
	public List<ChatDto> selectChatList(Map<String, Integer> map) {

		return dao.selectChatList(map);
	}
}
