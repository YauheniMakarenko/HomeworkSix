package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import java.util.HashMap;
import java.util.Map;

public class AllActionStrategyForUser {
    Map<Integer, ActionStrategyForUser> map;

    public AllActionStrategyForUser(){
        this.map = new HashMap<>();
        map.put(1, new FirstActionForUser());
        map.put(2, new SecondActionForUser());
        map.put(3, new ThirdActionForUser());
        map.put(4, new FourtActionForUser());
        map.put(5, new isExitActionForUser());
    }

    public Map<Integer, ActionStrategyForUser> getMap() {
        return map;
    }
}
