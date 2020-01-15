package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

public class ActionForUserSortFullСonsumption implements CommandForUser {

    @Override
    public void action() {
        TaxiPark.getInstance().sort();
    }
}
