package com.tramate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramate.dto.ChatDto;
import com.tramate.service.ChatService;

@RestController
@CrossOrigin
public class ChatController {

	@Autowired
	private ChatService service;

	// chat을 insert하는 메소드
	@RequestMapping(value="/chat/insert", method = RequestMethod.POST)
	public void insertChat(@RequestBody ChatDto dto) {

		service.insertChat(dto);
	}
	
	@RequestMapping(value="/chat/list", method= RequestMethod.POST)
	public List<ChatDto> selectChatList(@RequestParam int gnum, @RequestParam int tnum){
	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("gnum",gnum);
		map.put("tnum",tnum);
		
		return service.selectChatList(map);
	}
}
