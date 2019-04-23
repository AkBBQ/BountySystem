package com.shop.model;

import lombok.Data;

import java.util.Date;

/**
 * 任务接收人实体类
 */
@Data
public class DealMission {
    /**
     * 主键
     */
    public int id;
    /**
     * 任务id
     */
    public int mid;
    /**
     * 任务发起人id
     */
    public int pid;
    /**
     * 任务接收人id
     */
    public int aid;
    /**
     * 任务接收数量
     */
    private Integer num;
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
    public Date endTime;
    /**
     * 每页查询数量
     */
    public int pagesize;
    /**
     * 第几页
     */
    public int pageNo;
    /**
     * 偏移量
     */
    public int offset;

}