package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

public class ActionForUserOrderCar implements CommandForUser {
    @Override
    public void action() {
        TaxiPark.getInstance().addClient();
    }
}
