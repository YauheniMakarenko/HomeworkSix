package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;

public class ActionForUserSortFullСonsumption implements ActionStrategyForUser {

    @Override
    public void action() {
        AdminMenu.getTaxiPark().sort();
    }
}
