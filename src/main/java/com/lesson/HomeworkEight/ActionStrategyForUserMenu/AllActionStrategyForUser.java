package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import java.util.HashMap;
import java.util.Map;

public class AllActionStrategyForUser {
    Map<Integer, ActionStrategyForUser> map;

    public AllActionStrategyForUser(){
        this.map = new HashMap<>();
        map.put(1, new ActionForUserTopCars());
        map.put(2, new ActionForUserSortFullСonsumption());
        map.put(3, new ActionForUserSearch());
        map.put(4, new ActionForUserOrderCar());
        map.put(5, new isExitActionForUser());
    }

    public Map<Integer, ActionStrategyForUser> getMap() {
        return map;
    }
}
