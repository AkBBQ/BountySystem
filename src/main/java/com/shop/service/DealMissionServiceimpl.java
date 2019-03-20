package com.shop.service;

import com.shop.Do.MissionVo;
import com.shop.Eunm.MissionTypeEunm;
import com.shop.mapper.DealMissionMapper;
import com.shop.model.DealMission;
import com.shop.model.Mission;
import com.shop.model.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * 任务接收处理
 */
@Service
public class DealMissionServiceimpl implements DealMissionService {
    @Autowired
    DealMissionMapper dealMissionMapper;
    @Autowired
    MissionService missionService;
    @Autowired
    UsersService usersService;

    @Override
    public void addOneDealMission(DealMission dealMission, HttpSession httpSession) {

        //获得当前session中得用户id
        Object userinfo = httpSession.getAttribute("userinfo");
        Users users = (Users) userinfo;
        dealMission.setAid(users.getId());
        //接去任务时间为当前系统时间
        dealMission.setTakeTime(new Date());
        //将任务表中的对应任务状态置为锁定
        Mission mission = new Mission();
        mission.setId(dealMission.getMid());
        mission.setLocking(1);
        missionService.updateMission(mission);

        try {
            dealMissionMapper.add(dealMission);
        } catch (Exception e) {
            throw new RuntimeException("抢任务失败!");
        }

    }

    /**
     * 查看当前登陆者所接取的任务信息
     *
     * @param dealMission
     * @param session
     * @return
     */

    @Override
    public List<MissionVo> queryAll(DealMission dealMission, HttpSession session) {
        //return对象
        List<MissionVo> result = new ArrayList<>();

        //查找session中登陆者的id作为查询条件
        Object userinfo = session.getAttribute("userinfo");
        Users users = (Users) userinfo;
        dealMission.setAid(users.getId());

        //设置查询页数和查询条数
        if (dealMission.getPageNo() < 1 || Objects.isNull(dealMission.getPageNo())) {
            dealMission.setPageNo(1);
        }
        dealMission.setPagesize(3);
        dealMission.setOffset((dealMission.getPageNo() - 1) * dealMission.getPagesize());

        try {
            //查询任务处理表
            List<DealMission> dealMissions = dealMissionMapper.queryAll(dealMission);
            dealMissions.stream().forEach(one -> {
                //查找任务表(一个任务id只能查找到一条任务记录)
                Mission missionQuery = new Mission();
                missionQuery.setId(one.getMid());
                List<Mission> missions = missionService.queryAllMissons(missionQuery);
                Mission missionResult = new Mission();
                if(!CollectionUtils.isEmpty(missions)){
                 missionResult = missions.get(0);
                }
                //A = B + C(vo对象是二个do对象加起来的)
                MissionVo missionVo = new MissionVo();
                BeanUtils.copyProperties(missionResult, missionVo);
                //根据发起人id查找发起人姓名
                if (null != missionVo.getPid()) {
                    Users users1 = usersService.queryOneuser(missionVo.getPid());
                    if (!Objects.isNull(users1)) {
                        missionVo.setPidName(users1.getName());
                    }
                }
                //任务类型转描述
                if(!Objects.isNull(missionVo.getType())){
                missionVo.setTypeDesc(MissionTypeEunm.getEnum(missionVo.getType()).getMsg());
                }
                //任务状态转描述
                if (!Objects.isNull(missionVo.getStatus()) && missionVo.getStatus() == 1) {
                    missionVo.setStatusDesc("未完成");
                }
                if (!Objects.isNull(missionVo.getStatus()) && missionVo.getStatus() == 2) {
                    missionVo.setStatusDesc("已完成");
                }
                if (!Objects.isNull(missionVo.getStatus()) && missionVo.getStatus() == 3) {
                    missionVo.setStatusDesc("待审核");
                }
                //任务接收人id
                missionVo.setAid(one.getAid());
                //任务评星
                missionVo.setStar(one.getStar());
                //任务评价
                missionVo.setStarDesc(one.getStarDesc());
                //任务完成时间
                missionVo.setFinishTime(one.getEndTime());
                //任务接取时间
                missionVo.setTakeTime(one.getTakeTime());
                result.add(missionVo);

            });

        } catch (Exception e) {
            throw new RuntimeException("查询失败!");
        }
        return result;
    }

    @Override
    public Integer count(DealMission dealMission) {
        return dealMissionMapper.count(dealMission);
    }

    @Override
    public void abandonMission(Integer mid) {
        Mission mission = new Mission();
        mission.setId(mid);
        mission.setLocking(2);
        try {
            //将任务置为锁定状态
            missionService.updateMission(mission);
            //同时删除任务用户表中的数据
            dealMissionMapper.delete(mid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("出错啦!");
        }
    }

    @Override
    public void finishMission(Integer mid) {
        Assert.notNull(mid,"任务id不能为空");
        Mission mission = new Mission();
        mission.setId(mid);
        //3 为待审核
        mission.setStatus(3);
        //将任务用户表中的任务状态置为待审核
        try {
            missionService.updateMission(mission);
        } catch (Exception e) {
            throw new RuntimeException("任务置为待审核失败",e);
        }

    }

    @Override
    public void approval(DealMission dealMission) {

        //更新该任务的评价与评星
        dealMissionMapper.update(dealMission);

    }
}