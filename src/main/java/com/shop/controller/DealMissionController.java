package com.shop.controller;


import com.shop.Do.MissionVo;
import com.shop.model.DealMission;
import com.shop.model.Mission;
import com.shop.service.DealMissionService;
import com.shop.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 接任务处理类
 */
@Controller
@RequestMapping("/deal")
public class DealMissionController {
    @Autowired
    DealMissionService dealMissionService;

    @Autowired
    MissionService missionService;

    /**
     * 接收一条发布的任务
     * @param dealMission
     * @return
     */
    @ResponseBody
    @RequestMapping("pick")
    public void pickOneMission(DealMission dealMission, HttpSession httpSession){
        dealMissionService.addOneDealMission(dealMission,httpSession);
    }

    /**
     * 查询我接收的任务列表
     */
    @RequestMapping("query")
    public String queryMyPickMission(Model model,DealMission dealMission, HttpSession httpSession){
        List<MissionVo> missionVos = dealMissionService.queryAll(dealMission, httpSession);
        //总记录数
        Integer count = dealMissionService.count(dealMission);
        Integer pages = count % dealMission.getPagesize() > 0 ? count / dealMission.getPagesize() + 1:count / dealMission.getPagesize();
        //查询结果
        model.addAttribute("Results",missionVos);
        //总条数
        model.addAttribute("count",count);
        //总页数
        model.addAttribute("pages",pages);
        //当前的页数
        model.addAttribute("currPage" , dealMission.getPageNo());
        //回调显示
        model.addAttribute("queryModel" , dealMission);
        return "my_help.jsp";
    }

    /**
     * 放弃当前接收到的任务
     */
    @ResponseBody
    @RequestMapping("/abandon")
    public void abandon(Integer mid){
        dealMissionService.abandonMission(mid);
    }

    /**
     * 任务接收发完成任务提起审批
     */
    @ResponseBody
    @RequestMapping("/approval")
    public void approval(Integer mid) {
        dealMissionService.finishMission(mid);
    }
    /**
     * 任发起人审批任务
     */
    @RequestMapping("/doApproval")
    public String doApproval(Integer mid,String isPass,String star,String starDesc){
        if(StringUtils.isEmpty(isPass)){
           throw new RuntimeException("是否通过参数不能为空");
        }
        //因为radio value传来的是String类型 无法用Integer接收 得做一次转换
        Integer starr = null;
        if("一星".equals(star)){
            starr = 1;
        }
        if("二星".equals(star)){
            starr = 2;
        }
        if("三星".equals(star)){
            starr = 3;
        }
        if("四星".equals(star)){
            starr = 4;
        }
        if("五星".equals(star)){
            starr = 5;
        }

        DealMission dealMission = new DealMission();
        dealMission.setMid(mid);
        dealMission.setStar(starr);
        if(!StringUtils.isEmpty(starDesc)){
        dealMission.setStarDesc(starDesc);
        }

        dealMissionService.approval(dealMission);

        //处理misson表的数据
        Mission mission = new Mission();
        mission.setId(mid);

        if("通过".equals(isPass)){
            //将任务状态置为已完成
            mission.setStatus(2);
        }
        if("不通过".equals(isPass)){
            //任务状态为未通过
            mission.setStatus(4);
        }
        //更新任务表中的任务状态
        missionService.updateMission(mission);

        return "./query";
    }

    /**
     * 查看评价
     */
    @RequestMapping("evaluate")
    public String showEvaluate(Integer id,Model model){
        DealMission dealMission = new DealMission();
        dealMission.setMid(id);
        DealMission dealMission1 = dealMissionService.queryOne(dealMission);
        model.addAttribute("result",dealMission1);
        return "evaluate.jsp";

    }
}