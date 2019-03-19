package com.shop.controller;


import com.shop.Do.MissionVo;
import com.shop.model.DealMission;
import com.shop.service.DealMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public void approval(Integer mid){
     dealMissionService.finishMission(mid);
    }
}