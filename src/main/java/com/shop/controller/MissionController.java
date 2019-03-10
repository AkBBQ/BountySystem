package com.shop.controller;

import com.shop.model.Mission;
import com.shop.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("queryAll")
    public String queryAll(Mission mission, Model model){
        try {
            List<Mission> missions = missionService.queryAllMissons(mission);
            model.addAttribute("missions",missions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return "mission.jsp";
    }
}