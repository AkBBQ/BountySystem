package com.shop.service;

import com.shop.model.Mission;

import java.util.List;


public interface MissionService {

    List<Mission> queryAllMissons(Mission mission);

    Mission queryOne(Integer id);

    Integer count(Mission mission);

    /**
     *发布任务
     */
    void addMission(Mission mission);
    /**
     *修改任务
     */
    void updateMission(Mission mission);
    /**
     *删除任务
     */
    void delete(Integer id);



}
