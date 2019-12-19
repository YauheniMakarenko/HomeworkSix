package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.ActionStrategyForUserMenu.ActionStrategyForUser;
import com.lesson.HomeworkEight.Menu.Admin;

public class SecondActionForAdmin implements ActionStrategyForAdmin {

    @Override
    public void action() {
        Admin.getTaxiPark().printCar();
    }
}
