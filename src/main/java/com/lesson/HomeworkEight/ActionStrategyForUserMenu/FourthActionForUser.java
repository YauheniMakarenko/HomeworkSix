package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import com.lesson.HomeworkEight.Menu.Admin;

public class FourthActionForUser implements ActionStrategyForUser {
    @Override
    public void action() {
        Admin.getTaxiPark().addClient();
    }
}
