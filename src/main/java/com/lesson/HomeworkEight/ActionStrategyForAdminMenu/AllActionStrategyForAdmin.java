package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import java.util.HashMap;
import java.util.Map;

public class AllActionStrategyForAdmin {
    private Map<Integer, ActionStrategyForAdmin> mapAdmin;

    public AllActionStrategyForAdmin(){
        this.mapAdmin = new HashMap<>();
        mapAdmin.put(1, new CreateTaxiPark());
        mapAdmin.put(2, new AddCarInTaxoPark());
        mapAdmin.put(3, new PrintCar());
        mapAdmin.put(4, new PrintOrders());
        mapAdmin.put(5, new LogInUser());
        mapAdmin.put(6, new isExit());
    }

    public Map<Integer, ActionStrategyForAdmin> getMapAdmin() {
        return mapAdmin;
    }
}
