package com.shop.mapper;


import com.shop.model.Mission;

import java.util.List;

public interface MissionMapper {

  List<Mission> queryAllMissions(Mission mission);
  
}