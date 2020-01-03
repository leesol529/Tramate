package com.tramate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tramate.dto.RestaurantdataDto;
import com.tramate.service.RestaurantdataService;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class RestaurantdataController {

	@Autowired
	private RestaurantdataService service;

	// Spot�� ���õ� Restaurant�� �� ������ �������� �޼ҵ�
	@GetMapping("/restaurantTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot(String spot) {

		return service.getTotalCountRelatedSpot(spot);

	}

	// Spot�� ���õ� Restaurant�� �������� �������� �޼ҵ�
	//���� spot, start ,end�� ���� �����ؾ� �Ѵ�.
	@PostMapping("/restaurantRandomRelatedSpot")
	public List<RestaurantdataDto> RestaurantRandomList(@RequestParam String spot) {

		java.util.Map<String, String> map = new HashMap<String, String>();
		int guideTotalCount = service.getTotalCountRelatedSpot(spot);
		System.out.println(spot+"의 총 restaurant 갯수 : "+guideTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(guideTotalCount)+1;
		if(startNum >= guideTotalCount-4 && guideTotalCount >=4) startNum = guideTotalCount-4;
		System.out.println("startNum :" +startNum);
		map.put("spot", spot);
		map.put("start", ""+startNum);
		map.put("end", ""+(startNum+4));
		
		return service.RestaurantRandomList(map);
	}
	
	//Continent와 관련있는 Restaurant 5개를 랜덤으로 가져오기
	@PostMapping("/restaurant/randomlist/continent")
	public List<RestaurantdataDto> restaurantRandomListRelatedContinent(@RequestParam String continent){
		
		java.util.Map<String, String> map = new HashMap<String, String>();
		int restaurantTotalCount = service.RestaurantCountRelatedContinent(continent);
		
		System.out.println(continent+"의 총 restaurant 갯수 : "+restaurantTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(restaurantTotalCount)+1;
		if(startNum >= restaurantTotalCount-4 && restaurantTotalCount >=4) startNum = restaurantTotalCount-4;
		System.out.println("startNum :" +startNum);
		map.put("continent", continent);
		map.put("start", ""+startNum);
		map.put("end", ""+(startNum+4));
		
		return service.restaurantRandomListRealatedContinent(map);
		
	}
	
	//restaurantform에 이미지 업로드 시 서버에 이미지 저장 
	@RequestMapping(value = "/guide/choice/restaurant_img", method = RequestMethod.POST)
	public @ResponseBody void insertTravelerImage(
		   @RequestParam MultipartFile uploadFile, 
		   HttpServletRequest request) {
		
		SpringFileWriter fileWriter = new SpringFileWriter();
		// 저장할 path 구하기
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save 폴더에 저장해주는메서드
	}
	
	@RequestMapping(value="/guide/choice/restaurant_input", method=RequestMethod.POST)
	public void insertAttractionList(@RequestBody List<RestaurantdataDto> data) {
		for(RestaurantdataDto dto: data) {
			service.insertRestaurantData(dto);
		}
	}
	
	//해당 num의 data 반환
	@RequestMapping(value="/restaurant/data", method=RequestMethod.POST)
	public RestaurantdataDto getActivityData(@RequestParam int num){
		return service.getRestaurantData(num);
	}
}









