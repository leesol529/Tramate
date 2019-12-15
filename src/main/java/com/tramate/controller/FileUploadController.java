package com.tramate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tramate.dto.GuideDto;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class FileUploadController {

//	@RequestMapping("/guide/inputdata")
//	public @ResponseBody void result1(@RequestBody GuideDto dto, @RequestParam MultipartFile picture, HttpServletRequest request) {
//		SpringFileWriter fileWriter = new SpringFileWriter();
//		// 저장할 path 구하기
//		String path = request.getSession().getServletContext().getRealPath("/save");
//		System.out.println("path:" + path);
//		fileWriter.writeFile(picture, path);// save 폴더에 저장해주는메서드
//	}
	
	
}