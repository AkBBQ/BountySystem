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


	@Override
	public List<Mission> queryAllMissons(Mission mission) {
		return missionMapper.queryAllMissions(mission);
	}

	@Override
	public Integer count(Mission mission) {
		return missionMapper.count(mission);
	}

	@Override
	public void addMission(Mission mission) {
		missionMapper.addMission(mission);

	}

	@Override
	public void updateMission(Mission mission) {
		try {
			missionMapper.updateMission(mission);
		} catch (Exception e) {
			System.out.println("修改出错了！");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			missionMapper.delete(id);
		} catch (Exception e) {
			throw new RuntimeException("删除失败");
		}
	}
}
