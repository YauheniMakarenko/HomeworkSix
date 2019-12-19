package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Menu.Admin;

public class ThirdActionForAdmin implements ActionStrategyForAdmin {
    @Override
    public void action() {
        Admin.getTaxiPark().printOrders();
    }
}
