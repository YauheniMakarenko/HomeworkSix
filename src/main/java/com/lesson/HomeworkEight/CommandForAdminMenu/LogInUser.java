package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.Menu.UserMenu;

public class LogInUser implements CommandsForAdmin {
    @Override
    public void action() {
        new UserMenu().start();
    }
}
