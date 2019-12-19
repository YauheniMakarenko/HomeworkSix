package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Menu.UserMenu;

public class FourthActionForAdmin implements ActionStrategyForAdmin {
    @Override
    public void action() {
        new UserMenu().start();
    }
}
