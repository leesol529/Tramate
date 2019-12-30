package com.tramate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.tramate.dto.ActivitydataDto;
import com.tramate.dto.GuideDto;
import com.tramate.service.GuideService;
import com.tramate.service.TravelerService;
import com.tramate.upload.SpringFileWriter;

@RestController
@CrossOrigin
public class GuideController {

	@Autowired
	private GuideService service;

	@Autowired
	private TravelerService tservice;

	@GetMapping("/guidetotal")
	public int guideTotalCount() {

		return service.getTotalCount();
	}

	// Spot占쏙옙 占쏙옙占시듸옙 guide占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占싹댐옙 占쌨소듸옙
	@GetMapping("/guideTotalCountRelatedSpot")
	public int guideTotalCountRelatedSpot(String spot) {

		return service.getTotalCountRelatedSpot(spot);

	}

	// spot怨� 愿��젴�맂 guide瑜� 5紐� �옖�뜡�쑝濡� 戮묐뒗 硫붿냼�뱶 ex) �떎�궘怨� 愿��젴�맂 guide �옖�뜡 5紐�
	@PostMapping("/guideRandomRelatedSpot")
	public List<GuideDto> guideRandomList(@RequestParam String spot) {

		java.util.Map<String, String> map = new HashMap<String, String>();
		int guideTotalCount = service.getTotalCountRelatedSpot(spot);
		System.out.println(spot + "�쓽 珥� 媛��씠�뱶 �닔 : " + guideTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(guideTotalCount) + 1;
		if (startNum >= guideTotalCount - 4 && guideTotalCount >= 4)
			startNum = guideTotalCount - 4;
		System.out.println("startNum :" + startNum);
		map.put("spot", spot);
		map.put("start", "" + startNum);
		map.put("end", "" + (startNum + 4));

		return service.guideRandomList(map);
	}

	// Continent�� 愿��왆 �엳�뒗 Guide 5紐낆쓣 �옖�뜡�쑝濡� 戮묐뒗 硫붿냼�뱶
	@PostMapping("/guide/randomlist/continent")
	public List<GuideDto> guideRandomListRelatedContinent(@RequestParam String continent) {

		java.util.Map<String, String> map = new HashMap<String, String>();
		int guideTotalCount = service.guideCountRelatedContinent(continent);
		System.out.println(continent + "�쓽 珥� 媛��씠�뱶 �닔 : " + guideTotalCount);
		Random rd = new Random();
		int startNum = rd.nextInt(guideTotalCount) + 1;
		if (startNum >= guideTotalCount - 4 && guideTotalCount >= 4)
			startNum = guideTotalCount - 4;
		System.out.println("startNum :" + startNum);
		map.put("continent", continent);
		map.put("start", "" + startNum);
		map.put("end", "" + (startNum + 4));
		System.out.println(service.guideRandomListRelatedContinent(map));

		return service.guideRandomListRelatedContinent(map);

	}

	// React濡� 遺��꽣 json�쓣 諛쏆븘�꽌 guide瑜� �벑濡앺븳�떎.

	@RequestMapping(value = "/guide/join", method = RequestMethod.POST)
	public void insertGuideData(@RequestBody GuideDto dto) {

		service.insertGuide(dto);
	}

	// num媛믪쓣 諛쏆븘�꽌 �븯�굹�쓽 Guide�쓽 �젙蹂대�� �뼸�뒗 硫붿냼�뱶
	@RequestMapping(value = "/guide/select", method = RequestMethod.POST)
	public GuideDto selectguide(@RequestParam int num) {

		return service.getGuide(num);
	}

	// �씠誘몄�瑜� save �뤃�뜑�뿉 ���옣�빐二쇰뒗 硫붿냼�뱶
	@RequestMapping(value = "/guide/imageupload", method = RequestMethod.POST)
	public void insertGuideImage(@RequestParam MultipartFile uploadFile, HttpServletRequest request) {
		SpringFileWriter fileWriter = new SpringFileWriter();
		// ���옣�븷 path 援ы븯湲�
		String path = request.getSession().getServletContext().getRealPath("/save");
		System.out.println("path:" + path);
		fileWriter.writeFile(uploadFile, path);// save �뤃�뜑�뿉 ���옣�빐二쇰뒗硫붿꽌�뱶
	}

	// �븘�씠�뵒�� 鍮꾨�踰덊샇媛� 留욌뒗 �쑀��媛� 議댁옱�븯�뒗吏� 李얠븘�궡�뒗 硫붿냼�뱶
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public int guideLogin(@RequestParam String id, @RequestParam String pass) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);

		// �븘�씠�뵒�뿉 留욌뒗 媛��씠�뱶媛� 議댁옱�븯�뒗媛�?
		int guideok = service.guideLogin(map);
		int travelerok = tservice.travelerLogin(map);

		// guide �뀒�씠釉붿뿉�꽌 �젙蹂� �씪移� �떆 1, traveler �뀒�씠釉붿뿉�꽌 �젙蹂� �씪移� �떆 2, �씪移� �젙蹂� �뾾�쓣 �븣 0 諛섑솚
		if (guideok == 1)
			return 1;
		else if (travelerok == 1)
			return 2;
		else
			return 0;

	}

	// id�뿉 �빐�떦�븯�뒗 gnum 媛��졇�삤湲�
	@RequestMapping(value = "/guide/choice/gnum", method = RequestMethod.POST)
	public int selectOneGuide(@RequestParam String id) {
		return service.selectOneGuide(id);
	}

	// spot�뿉 �빐�떦�븯�뒗 媛��씠�뱶�뱾�쓽 pk媛믪쓣 �꽆寃⑥＜�뒗 硫붿냼�뱶
	@RequestMapping(value = "/guide/related/spot", method = RequestMethod.POST)
	public List<GuideDto> guideRelatedSpot(@RequestParam String spot) {

		return service.guideRelatedSpot(spot);
	}
}
