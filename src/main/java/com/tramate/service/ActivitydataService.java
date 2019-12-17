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

	// num�� ���� �ϳ��� ActivityData �� ��ȯ�Ѵ�.
	public ActivitydataDto gettActivityData(int num) {

		return dao.gettActivityData(num);
	}

	// ActivityDto�� �Ķ���ͷ� �Է¹޾� insert�� �ϴ� �޼ҵ�
	public void insertActivityData(ActivitydataDto dto) {

		dao.insertActivityData(dto);
	}

	// num�� ���� �ϳ��� ActivityData�� �����ϴ� �޼ҵ�
	public void deleteActivityData(int num) {

		dao.deleteActivityData(num);
	}

	// ActivityDto�� �ĸ����ͷ� �Է¹޾� update�� �ϴ� �޼ҵ�
	public void updateActivityData(ActivitydataDto dto) {

		dao.updateActivityData(dto);
	}

	// ��� ActivityData�� ����Ʈ�� �������� �޼ҵ�
	public List<ActivitydataDto> getActivityDataList() {

		return dao.getActivityDataList();
	}

	// �� ������ �������� �޼ҵ�
	public int getTotalCount() {

		return dao.getTotalCount();
	}

	// Spot�� ���õ� Activity�� �� ������ �������� �޼ҵ�
	public int getTotalCountRelatedSpot(String spot) {

		return dao.getTotalCountRelatedSpot(spot);
	}

	// Spot�� ���õ� Activity�� �������� 6�� �������� �޼ҵ�
	public List<ActivitydataDto> activityRandomList(java.util.Map<String, String> map) {

		return dao.activityRandomList(map);
	}

	// guide와 관련된 activity를 찾는 메소드
	public List<ActivitydataDto> activityRelatedGuid(int gnum) {

		return dao.activityRelatedGuid(gnum);
	}
}
