package com.shop.service;

import com.shop.Do.MissionVo;
import com.shop.Do.RankVO;
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
     * 完成任务(待审核)
     */
    void finishMission(Integer mid);

    /**
     * 任务发起人审核任务
     */
    void approval(DealMission dealMission);

    /**
     * 根据任务id查一条记录（任务评价和评星）
     */
    DealMission queryOne(DealMission dealMission);

    /**
     * 任务完成排行榜
     */
   List<RankVO> queryRank();
}
