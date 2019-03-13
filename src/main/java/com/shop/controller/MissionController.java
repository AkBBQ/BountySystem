package com.shop.controller;

import com.shop.Eunm.MissionTypeEunm;
import com.shop.model.Mission;
import com.shop.model.Users;
import com.shop.service.MissionService;
import com.shop.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.shop.controller
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/3/10 10:29 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
@RequestMapping("/mission")
@Controller
public class MissionController {

    @Autowired
    MissionService missionService;

    @Autowired
    UsersService usersService;

    /**
     *任务列表多条件查询
     */
    @RequestMapping("queryAll")
    public String queryAll(Mission mission, Model model) {
        try {
            //多条件查询结果
            if (mission.getPageNo() == 0) {
                //初始化查询页码
                mission.pageNo = 1;
            }
            List<Mission> missions = missionService.queryAllMissons(mission);
            missions.stream().forEach(one->{
                //根据发布人id查到发布人姓名
                Users users = usersService.queryOneuser(one.getPid());
                one.setPidName(users.getName());
                //任务状态数字转换为文字
                if(one.getStatus() == 0){
                    one.setStatusDesc("未完成");
                }
                if(one.getStatus() == 1){
                    one.setStatusDesc("完成");
                }
                //是否可接转换
                if(one.getLock() == 0){
                    one.setLockDesc("锁定");
                }
                if(one.getLock() == 1){
                    one.setLockDesc("可接");
                }


            });
            //多条件查询总计
            Integer count = missionService.count(mission);
            model.addAttribute("missions", missions);
            model.addAttribute("count", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mission.jsp";
    }

    /**
     *新增一条任务
     */
    @RequestMapping("/addMission")
    public String addMission(Mission mission, HttpSession httpSession){
        try {
            //获取当前session中的用户信息
            Users users=new Users();
            Object userinfo = httpSession.getAttribute("userinfo");
            users= (Users) userinfo;
            //发布任务的人是当前登陆者
            mission.setPid( users.getId());
            //新建任务的状态可接，未完成
            mission.setLock(1);
            mission.setStatus(0);
            //任务当前创建时间
            mission.setCreatTime(new Date());
            missionService.addMission(mission);
        } catch (Exception e) {
            System.out.println("出错了! ");
            e.printStackTrace();
        }
       return "";
    }

    /**
     *任务类型枚举展示,用户前台展示
     */
    @ResponseBody
    @RequestMapping("/missionTypeQuery")
    public Map<Integer,String> queryMissionType(){
        Map<Integer,String> map=new HashMap<>();
        MissionTypeEunm[] typeEunms =  MissionTypeEunm.values();
        for (MissionTypeEunm missionTypeEunm : typeEunms) {
            map.put(missionTypeEunm.getCode(),missionTypeEunm.getMsg());
        }
        return map;
    }
}