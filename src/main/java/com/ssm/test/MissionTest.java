package com.ssm.test;

import com.shop.mapper.MissionMapper;
import com.shop.model.Mission;
import com.shop.service.MissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.ssm.test
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/14 9:19 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MissionTest {
    @Autowired
    MissionMapper missionMapper;
    @Autowired
    MissionService missionService;

    @Test
    public void testMissionQuery(){
        Mission mission = new Mission();
        mission.setPagesize(10);
//        mission.setLocking(0);
        mission.setStatus(1);
        //mission.setPid(1);
//        mission.setType(3);
        List<Mission> missions = missionMapper.queryAllMissions(mission);
        missions.stream().forEach(x->{
            System.out.println(x.toString());
        });
    }

    @Test
    public void test2(){
        Mission mission = new Mission();
        mission.setPagesize(10);
//        mission.setLocking(0);
        List<Mission> missions = missionService.queryAllMissons(mission);
        missions.stream().forEach(x->{
            System.out.println(x.toString());
        });
    }

    @Test
    public void queryOneMission(){
        Mission mission = missionMapper.queryOneMission(11);
        System.out.println(mission.toString());
    }
}