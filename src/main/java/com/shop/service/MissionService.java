package com.shop.service;

import com.shop.model.Mission;

import java.util.List;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.shop.service
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/10 5:18 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
public interface MissionService {

    List<Mission> queryAllMissons(Mission mission);


    Integer count(Mission mission);

    /**
     *发布任务
     */
    void addMission(Mission mission);
}
