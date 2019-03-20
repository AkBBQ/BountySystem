package com.shop.mapper;


import com.shop.model.DealMission;

import java.util.List;

/**
 * 任务处理Mapper
 */
public interface DealMissionMapper {

    /**
     * 接收一条任务
     */
    void add(DealMission dealMission);

    /**
     * show 当前登陆者接到的任务列表
     */
     List<DealMission> queryAll(DealMission dealMission);
    /**
     * 统计条数
     */
    Integer count(DealMission dealMission);
    /**
     * 删除任务
     */
    void delete(Integer mid);
    /**
     * 完成任务(更新任务状态)
     */
    void update(DealMission dealMission);
    /**
     * 根据任务id找任务
     */
    DealMission queryOne(Integer mid);
}