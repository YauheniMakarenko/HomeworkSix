package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import java.util.HashMap;
import java.util.Map;

public class AllActionStrategyForAdmin {
    private Map<Integer, ActionStrategyForAdmin> mapAdmin;

    public AllActionStrategyForAdmin(){
        this.mapAdmin = new HashMap<>();
        mapAdmin.put(1, new ActionForAdminToCreateTaxiPark());
        mapAdmin.put(2, new ActionForAdminPrintCar());
        mapAdmin.put(3, new ActionForAdminPrintOrders());
        mapAdmin.put(4, new ActionForAdminLogInUser());
        mapAdmin.put(5, new isExitActionForAdmin());
    }

    public Map<Integer, ActionStrategyForAdmin> getMapAdmin() {
        return mapAdmin;
    }
}
