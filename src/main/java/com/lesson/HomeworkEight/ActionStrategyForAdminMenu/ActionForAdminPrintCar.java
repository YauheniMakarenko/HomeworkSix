package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;

public class ActionForAdminPrintCar implements ActionStrategyForAdmin {

    @Override
    public void action() {
        AdminMenu.getTaxiPark().printCar();
    }
}
