package com.shop.service;

import com.shop.mapper.MissionMapper;
import com.shop.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *任务处理服务
 * @author angtai
 */
@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
    MissionMapper missionMapper;


	public List<Mission> queryAllMissons(Mission mission) {
		return missionMapper.queryAllMissions(mission);
	}

	public Integer count(Mission mission) {
		return missionMapper.count(mission);
	}

	@Override
	public void addMission(Mission mission) {
		missionMapper.addMission(mission);

	}
}
