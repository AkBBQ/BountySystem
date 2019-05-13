package com.shop.mapper;


import com.shop.model.Mission;

import java.util.List;

public interface MissionMapper {

  /**
   *多条件查询任务列表
   */
  List<Mission> queryAllMissions(Mission mission);

    /**
     *  查找一条任务
     */
  Mission queryOneMission(Integer id);

  /**
   *多条件查询任务列表对应的统计数量
   */
  Integer count(Mission mission);

  /**
   *新增一条任务
   */
  void addMission(Mission mission);

  /**
   * 修改一条任务
   */
   void updateMission(Mission mission);

   /**
    * 删除任务
    */
   void delete(Integer id);

}