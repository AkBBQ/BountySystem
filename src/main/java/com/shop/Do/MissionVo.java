package com.shop.Do;

import lombok.Data;

import java.util.Date;

/**
 * 我接的任务查询vo对象 前端交互用的对象
 */
@Data
public class MissionVo {
    /**
     * 主键id
     */
    public Integer id;
    /**
     * 任务类型
     */
    public Integer type;
    /**
     * 任务类型描述
     */
    public String typeDesc;
    /**
     * 详细说明
     */
    public String content;
    /**
     * 创建时间
     */
    public Date creatTime;
    /**
     * 任务开始时间
     */
    public Date startTime;
    /**
     * 任务结束时间
     */
    public Date endTime;
    /**
     * 地点
     */
    public String place;
    /**
     * 任务状态(1,未完成;2,完成)
     */
    public Integer status;
    /**
     * 任务状态描述
     */
    public String statusDesc;
    /**
     * 是否锁定(1,锁定；2:可接)
     */
    public Integer locking;
    /**
     * 锁定描述
     */
    public String lockDesc;
    /**
     * 任务发起人id
     */
    public Integer pid;
    /**
     * 任务发起人姓名
     */
    public String pidName;
    /**
     * 任务主题
     */
    public String title;
    /**
     * 任务接收人id
     */
    public int aid;
    /**
     * 任务评分
     */
    public int star;
    /**
     * 任务评价
     */
    public String starDesc;
    /**
     * 接任务时间
     */
    public Date takeTime;
    /**
     * 任务完成时间
     */
    public Date finishTime;

}