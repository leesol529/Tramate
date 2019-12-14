package com.tramate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.javafx.collections.MappingChange.Map;
import com.tramate.dao.ActivitydataDao;
import com.tramate.dto.ActivitydataDto;

@Service
public class ActivitydataService {

	@Autowired
	private ActivitydataDao dao;

	// num을 통해 하나의 ActivityData 를 반환한다.
	public ActivitydataDto gettActivityData(int num) {

		return dao.gettActivityData(num);
	}

	// ActivityDto를 파라미터로 입력받아 insert를 하는 메소드
	public void insertActivityData(ActivitydataDto dto) {

		dao.insertActivityData(dto);
	}

	// num을 통해 하나의 ActivityData를 삭제하는 메소드
	public void deleteActivityData(int num) {

		dao.deleteActivityData(num);
	}

	// ActivityDto를 파마미터로 입력받아 update를 하는 메소드
	public void updateActivityData(ActivitydataDto dto) {

		dao.updateActivityData(dto);
	}

	// 모든 ActivityData를 리스트로 가져오는 메소드
	public List<ActivitydataDto> getActivityDataList() {

		return dao.getActivityDataList();
	}

	// 총 갯수를 가져오는 메소드
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Spot과 관련된 Activity의 총 갯수를 가져오는 메소드
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot과 관련된 Activity를 랜덤으로 6개 가져오는 메소드
	public List<ActivitydataDto> activityRandomList(java.util.Map<String, String> map) {

		return dao.activityRandomList(map);
	}
}
