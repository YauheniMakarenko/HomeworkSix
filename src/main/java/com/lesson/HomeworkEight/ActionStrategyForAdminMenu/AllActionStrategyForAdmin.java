package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import java.util.HashMap;
import java.util.Map;

public class AllActionStrategyForAdmin {
    private Map<Integer, ActionStrategyForAdmin> mapAdmin;

    public AllActionStrategyForAdmin(){
        this.mapAdmin = new HashMap<>();
        mapAdmin.put(1, new FirstActionForAdmin());
        mapAdmin.put(2, new SecondActionForAdmin());
        mapAdmin.put(3, new ThirdActionForAdmin());
        mapAdmin.put(4, new FourthActionForAdmin());
        mapAdmin.put(5, new isExitActionForAdmin());
    }

    public Map<Integer, ActionStrategyForAdmin> getMapAdmin() {
        return mapAdmin;
    }
}
