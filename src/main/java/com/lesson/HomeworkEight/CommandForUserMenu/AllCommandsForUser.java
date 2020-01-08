package com.lesson.HomeworkEight.CommandForUserMenu;

import java.util.HashMap;
import java.util.Map;

public class AllCommandsForUser {
    Map<Integer, CommandsForUser> map;

    public AllCommandsForUser(){
        this.map = new HashMap<>();
        map.put(1, new ActionForUserTopCars());
        map.put(2, new ActionForUserSortFullСonsumption());
        map.put(3, new ActionForUserSearch());
        map.put(4, new ActionForUserOrderCar());
        map.put(5, new isExitActionForUser());
    }

    public Map<Integer, CommandsForUser> getMap() {
        return map;
    }
}
