package com.tramate.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ImageController {

	//관련 이미지를 보내는 메소드
		//evernote에서 이미지 return 을 검색해보자.
		@GetMapping(value = "/image/{imageName}.{extension}", produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] getImageWithMediaType(
				@PathVariable(name = "imageName") String imageName,
				@PathVariable(name = "extension", required = false) String extension,
				HttpServletRequest request) throws IOException {
			
			String path = request.getSession().getServletContext().getRealPath("/save/"+ imageName + "." + extension);
			InputStream imageStream = new FileInputStream(path);
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
			
			
			return imageByteArray;
		}
	
	
}