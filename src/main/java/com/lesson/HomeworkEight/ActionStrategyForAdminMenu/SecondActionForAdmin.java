package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Menu.UserMenu;

public class SecondActionForAdmin implements ActionStrategyForAdmin {
    @Override
    public void action() {
        new UserMenu().start();
    }
}
