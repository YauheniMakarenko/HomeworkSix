package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.Menu.UserMenu;

public class LogInUser implements CommandForAdmin {

    @Override
    public void action() {
        new UserMenu().start();
    }
}
