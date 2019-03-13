package com.shop.model;

import lombok.Data;

import java.util.Date;

@Data
public class Mission {
    /**
     * 主键id
     */
    public int id;
    /**
     * 任务类型
     */
    public int type;
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
     * 任务状态(0,未完成;1,完成)
     */
    public int status;
    /**
     * 任务状态描述
     */
    public String statusDesc;
    /**
     * 是否锁定(0,锁定；1:可接)
     */
    public int lock;
    /**
     * 锁定描述
     */
    public String lockDesc;
    /**
     * 任务发起人id
     */
    public int pid;
    /**
     * 任务发起人姓名
     */
    public String pidName;
    /**
     * 任务主题
     */
    public String title;
    /**
     * 每页查询数量
     */
    public int pagesize = 10;
    /**
     * 第几页
     */
    public int pageNo;
    /**
     * 偏移量
     */
    public int offset;


    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = (pageNo - 1) * pagesize;
    }
}