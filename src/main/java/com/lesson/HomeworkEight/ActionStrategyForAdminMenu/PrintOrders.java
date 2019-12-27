package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;

public class PrintOrders implements ActionStrategyForAdmin {
    @Override
    public void action() {
        AdminMenu.getTaxiPark().printOrders();
    }
}
