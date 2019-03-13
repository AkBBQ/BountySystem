package com.shop.Eunm;

/**
 * 任务类型枚举
 */
public enum MissionTypeEunm {
    WAIMAI(0 ,"代拿外卖"),
    KUAIDI(1,"代拿快递"),
    XUEXI(2,"组队学习"),
    YOUXI(3,"游戏开黑"),
    QINGGANZIXUN(4,"情感咨询"),
    JOB(5,"就业指导"),
    SKILL(6,"技能培训"),
    DUIXIANG(7,"寻找真爱");


    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MissionTypeEunm(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MissionTypeEunm getEnum(Integer code) {
        MissionTypeEunm[] enums = values();
        for (MissionTypeEunm item : enums) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
