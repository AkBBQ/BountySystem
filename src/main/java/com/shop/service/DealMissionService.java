package com.shop.service;

import com.shop.Do.MissionVo;
import com.shop.model.DealMission;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 任务处理
 */
public interface DealMissionService {
    /**
     * 新加一条任务
     */
    void addOneDealMission(DealMission dealMission, HttpSession httpSession);

    /**
     * 查找全部
     */
    List<MissionVo> queryAll(DealMission dealMission, HttpSession session);

    /**
     * 数量统计
     */
    Integer count(DealMission dealMission);

    /**
     * 放弃任务
     */
    void abandonMission(Integer mid);

    /**
     * 完成任务(审核)
     */
    void finishMission(Integer mid);
}
