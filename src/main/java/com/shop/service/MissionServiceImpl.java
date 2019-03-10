package com.shop.service;

import com.shop.mapper.MissionMapper;
import com.shop.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
    MissionMapper missionMapper;


	public List<Mission> queryAllMissons(Mission mission) {
		return missionMapper.queryAllMissions(mission);
	}
}
