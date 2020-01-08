package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.TaxiPark;

public class ActionForUserSortFullСonsumption implements CommandsForUser {

    @Override
    public void action() {
        TaxiPark.createSingletonTaxiPark().sort();
    }
}
