package com.shop.controller;

import com.shop.Eunm.MissionTypeEunm;
import com.shop.mapper.DealMissionMapper;
import com.shop.model.DealMission;
import com.shop.model.Mission;
import com.shop.model.Users;
import com.shop.service.DealMissionService;
import com.shop.service.MissionService;
import com.shop.service.UsersService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    DealMissionMapper dealMissionMapper;

    /**
     *任务列表多条件查询
     */
    @RequestMapping("queryAll")
    public String queryAll(Mission mission, Model model) {
        try {
            //多条件查询结果
            if (mission.getPageNo() < 1) {
                //初始化查询页码
                mission.setPageNo(1);
            }
            if(!StringUtils.isEmpty(mission.getStatusDesc()) && "未完成".equals(mission.getStatusDesc())){
                mission.setStatus(1);

            }
            if(!StringUtils.isEmpty(mission.getStatusDesc()) && "已完成".equals(mission.getStatusDesc()) ){
                mission.setStatus(2);

            }
            if(!StringUtils.isEmpty(mission.getStatusDesc()) && "待审核".equals(mission.getStatusDesc()) ){
                mission.setStatus(3);

            }
            if(!StringUtils.isEmpty(mission.getLockDesc()) && "锁定".equals(mission.getLockDesc())){
                mission.setLocking(1);

            }
            if(!StringUtils.isEmpty(mission.getLockDesc()) && "可接".equals(mission.getLockDesc())){
                mission.setLocking(2);

            }
            //每页查询几条
            mission.setPagesize(3);
            //偏移量
            mission.setOffset((mission.getPageNo() - 1) * mission.getPagesize() );
            System.out.println("入参mission为 ："+mission.toString());
            List<Mission> missions = missionService.queryAllMissons(mission);
            //java8 stream流的使用
            missions.stream().forEach(one->{
                //根据发布人id查到发布人姓名1
                Users users = usersService.queryOneuser(one.getPid());
                one.setPidName(users.getName());
                //任务状态数字转换为文字
                if(one.getStatus() == 1){
                    one.setStatusDesc("未完成");
                }
                if(one.getStatus() == 2){
                    one.setStatusDesc("完成");
                }
                if(one.getStatus() == 3){
                    one.setStatusDesc("待审核");
                }
                if(one.getStatus() == 4){
                    one.setStatusDesc("审核未通过");
                }
                //是否可接转换
                if(one.getLocking() == 1){
                    one.setLockDesc("锁定");
                }
                if(one.getLocking() == 2){
                    one.setLockDesc("可接");
                }
                //任务类型
                if(!Objects.isNull(one.getType())){
                    one.setTypeDesc(MissionTypeEunm.getEnum(one.getType()).getMsg());
                }


            });
            //多条件查询总计
            Integer count = missionService.count(mission);
            //总共有几页
            Integer pages = count % mission.getPagesize() > 0 ? count/mission.getPagesize() + 1 :count / mission.getPagesize();
            model.addAttribute("missions", missions);
            //总记录数
            model.addAttribute("count", count);
            //总页数
            model.addAttribute("pages", pages);
            //当前的页数
            model.addAttribute("currPage" , mission.getPageNo());
            //回调显示
            model.addAttribute("queryModel" , mission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mission.jsp";
    }

    /**
     *新增一条任务
     */
    @ResponseBody
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
            mission.setLocking(2);
            mission.setStatus(1);
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

    /**
     * 查询当前登陆者的任务
     */
    @RequestMapping("/queryMyMission")
    public String queryMyMissions(HttpSession httpSession,Model model,Mission mission){
        Object userinfo = httpSession.getAttribute("userinfo");
        Users users=new Users();
        users= (Users) userinfo;
        //从session中拿去当前登陆者id
        mission.setPid(users.getId());

        //多条件查询结果
        if (mission.getPageNo() < 1) {
            //初始化查询页码
            mission.setPageNo(1);
        }
        if(!StringUtils.isEmpty(mission.getStatusDesc()) && "未完成".equals(mission.getStatusDesc())){
            mission.setStatus(1);

        }
        if(!StringUtils.isEmpty(mission.getStatusDesc()) && "已完成".equals(mission.getStatusDesc()) ){
            mission.setStatus(2);

        }
        if(!StringUtils.isEmpty(mission.getStatusDesc()) && "待审核".equals(mission.getStatusDesc()) ){
            mission.setStatus(3);

        }
        if(!StringUtils.isEmpty(mission.getStatusDesc()) && "审核未通过".equals(mission.getStatusDesc()) ){
            mission.setStatus(4);

        }
        if(!StringUtils.isEmpty(mission.getLockDesc()) && "锁定".equals(mission.getLockDesc())){
            mission.setLocking(1);

        }
        if(!StringUtils.isEmpty(mission.getLockDesc()) && "可接".equals(mission.getLockDesc())){
            mission.setLocking(2);

        }
        //每页查询几条
        mission.setPagesize(3);
        //偏移量
        mission.setOffset((mission.getPageNo() - 1) * mission.getPagesize() );

        try {
            List<Mission> missions = missionService.queryAllMissons(mission);
            missions.forEach(x->{
                //任务接收人的名字
                DealMission dealMission = dealMissionMapper.queryOne(x.getId());
                if(!Objects.isNull(dealMission) && !Objects.isNull(dealMission.getAid())){
                    Users users1 = usersService.queryOneuser(dealMission.getAid());
                    if(!Objects.isNull(users1)){
                        x.setAidName(users1.getName());
                    }
                }

                //任务发起人名字处理
                Users userss = usersService.queryOneuser(x.getPid());
                x.setPidName(userss.getName());
                //任务状态数字转换为文字
                if(x.getStatus() == 1){
                    x.setStatusDesc("未完成");
                }
                if(x.getStatus() == 2){
                    x.setStatusDesc("完成");
                }
                if(x.getStatus() == 3){
                    x.setStatusDesc("待审核");
                }
                if(x.getStatus() == 4){
                    x.setStatusDesc("审核未通过");
                }
                //是否可接转换
                if(x.getLocking() == 1){
                    x.setLockDesc("锁定");
                }
                if(x.getLocking() == 2){
                    x.setLockDesc("可接");
                }
                //任务类型
                if(!Objects.isNull(x.getType())){

                    x.setTypeDesc(MissionTypeEunm.getEnum(x.getType()).getMsg());
                }
            });
            //多条件查询总计
            Integer count = missionService.count(mission);
            //总共有几页
            Integer pages = count % mission.getPagesize() > 0 ? count/mission.getPagesize() + 1 :count / mission.getPagesize();
            model.addAttribute("missions", missions);
            //总记录数
            model.addAttribute("count", count);
            //总页数
            model.addAttribute("pages", pages);
            //当前的页数
            model.addAttribute("currPage" , mission.getPageNo());
            //回调显示
            model.addAttribute("queryModel" , mission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "my_search_help.jsp";
    }

    /**
     * 任务修改前的查询
     */
    @RequestMapping("/beforeUpdate")
    public String updateMission(Integer id,Model model){
        Mission queryMission=new Mission();
        queryMission.setId(id);
        List<Mission> missions = missionService.queryAllMissons(queryMission);
        Mission mission = missions.get(0);
        mission.setTypeDesc(MissionTypeEunm.getEnum(mission.getType()).getMsg());
        model.addAttribute("Mission",mission);
        return "my_mission_update.jsp";
    }


    /**
     * 任务修改
     */
    @RequestMapping("/updateMission")
    public String updateMission(Mission mission){
        missionService.updateMission(mission);
        return "/queryMyMission";
    }

    /**
     * 删除任务
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        Assert.notNull(id);
        missionService.delete(id);
        return "/mission/queryMyMission";
    }

    /**
     * 审核任务
     */
    @RequestMapping("/approval")
    public String approval(Integer id, Model model){
         model.addAttribute("missionId",id);
        return "my_mission_approval.jsp";
    }
}