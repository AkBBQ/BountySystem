package com.shop.Do;

import lombok.Data;

/**
 * 任务达人排行榜
 */

@Data
public class RankVO {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 任务接收数量
     */
    private Integer num;
}